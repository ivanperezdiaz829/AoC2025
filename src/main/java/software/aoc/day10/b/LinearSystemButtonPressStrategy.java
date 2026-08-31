package software.aoc.day10.b;

import software.aoc.day10.Button;
import software.aoc.day10.ButtonPressStrategy;
import software.aoc.day10.Machine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LinearSystemButtonPressStrategy implements ButtonPressStrategy {

    @Override
    public long findMinimumPresses(Machine machine) {
        List<Button> buttons = machine.buttons();
        int[] target = machine.joltages().stream().mapToInt(Integer::intValue).toArray();
        int m = target.length;
        int n = buttons.size();

        Rational[][] a = new Rational[m][n];
        Rational[] b = new Rational[m];
        for (int i = 0; i < m; i++) {
            b[i] = Rational.of(target[i]);
            for (int j = 0; j < n; j++) {
                a[i][j] = ((buttons.get(j).toggleMask() & (1 << i)) != 0) ? Rational.ONE : Rational.ZERO;
            }
        }

        int[] pivotColOfRow = new int[m];
        Arrays.fill(pivotColOfRow, -1);
        int row = 0;

        for (int col = 0; col < n && row < m; col++) {
            int sel = -1;
            for (int r = row; r < m; r++) {
                if (!a[r][col].isZero()) { sel = r; break; }
            }
            if (sel == -1) continue;

            Rational[] tmpRow = a[sel]; a[sel] = a[row]; a[row] = tmpRow;
            Rational tmpB = b[sel]; b[sel] = b[row]; b[row] = tmpB;

            Rational pivot = a[row][col];
            for (int c = col; c < n; c++) a[row][c] = a[row][c].div(pivot);
            b[row] = b[row].div(pivot);

            for (int r = 0; r < m; r++) {
                if (r == row) continue;
                Rational factor = a[r][col];
                if (factor.isZero()) continue;
                for (int c = col; c < n; c++) {
                    a[r][c] = a[r][c].sub(factor.mul(a[row][c]));
                }
                b[r] = b[r].sub(factor.mul(b[row]));
            }
            pivotColOfRow[row] = col;
            row++;
        }
        int rank = row;

        for (int r = rank; r < m; r++) {
            if (!b[r].isZero()) {
                throw new IllegalStateException("Sistema sin solución para la máquina");
            }
        }

        boolean[] isPivotCol = new boolean[n];
        for (int r = 0; r < rank; r++) isPivotCol[pivotColOfRow[r]] = true;

        List<Integer> freeCols = new ArrayList<>();
        for (int c = 0; c < n; c++) if (!isPivotCol[c]) freeCols.add(c);

        if (freeCols.isEmpty()) {
            long total = 0;
            for (int r = 0; r < rank; r++) {
                Rational value = b[r];
                if (!value.isInteger() || value.signum() < 0) {
                    throw new IllegalStateException("Solución no entera o negativa para la máquina");
                }
                total += value.toBigIntegerExact().longValueExact();
            }
            return total;
        }
        return solveUnderdetermined(a, b, rank, freeCols, buttons, target);
    }

    private long solveUnderdetermined(Rational[][] a, Rational[] b, int rank,
                                      List<Integer> freeCols, List<Button> buttons, int[] target) {
        int f = freeCols.size();
        long[] upperBounds = new long[f];

        for (int idx = 0; idx < f; idx++) {
            int col = freeCols.get(idx);
            Button btn = buttons.get(col);
            long bound = Long.MAX_VALUE;
            for (int i = 0; i < target.length; i++) {
                if ((btn.toggleMask() & (1 << i)) != 0) {
                    bound = Math.min(bound, target[i]);
                }
            }
            upperBounds[idx] = (bound == Long.MAX_VALUE) ? 0 : bound;
        }

        long[] best = { Long.MAX_VALUE };
        long[] freeValues = new long[f];
        dfsFree(0, freeValues, upperBounds, a, b, rank, freeCols, best, 0L);

        if (best[0] == Long.MAX_VALUE) {
            throw new IllegalStateException("No fue posible alcanzar los voltajes objetivo.");
        }
        return best[0];
    }

    private void dfsFree(int idx, long[] freeValues, long[] upperBounds,
                         Rational[][] a, Rational[] b, int rank,
                         List<Integer> freeCols, long[] best, long partialSum) {
        if (partialSum >= best[0]) return;

        if (idx == freeValues.length) {
            long total = partialSum;
            for (int r = 0; r < rank; r++) {
                Rational value = b[r];
                for (int j = 0; j < freeCols.size(); j++) {
                    value = value.sub(a[r][freeCols.get(j)].mul(Rational.of(freeValues[j])));
                }
                if (!value.isInteger() || value.signum() < 0) return;
                total += value.toBigIntegerExact().longValueExact();
            }
            if (total < best[0]) best[0] = total;
            return;
        }

        for (long v = 0; v <= upperBounds[idx]; v++) {
            if (partialSum + v >= best[0]) break;
            freeValues[idx] = v;
            dfsFree(idx + 1, freeValues, upperBounds, a, b, rank, freeCols, best, partialSum + v);
        }
    }
}