package software.aoc.day02.a;

import software.aoc.day02.IdValidator;

public class RepeatedSequenceValidator implements IdValidator {
    @Override
    public boolean isInvalid(long id) {
        String idStr = String.valueOf(id);
        if (idStr.length() % 2 != 0) {
            return false;
        }

        int mid = idStr.length() / 2;
        String firstHalf = idStr.substring(0, mid);
        String secondHalf = idStr.substring(mid);

        return firstHalf.equals(secondHalf);
    }
}
