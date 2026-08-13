package software.aoc.day06;

public class Day06Solver {
    private final WorksheetReader reader;

    public Day06Solver(WorksheetReader reader) {
        this.reader = reader;
    }

    public long execute(String input) {
        Worksheet worksheet = reader.read(input);
        return worksheet.calculateTotal();
    }
}
