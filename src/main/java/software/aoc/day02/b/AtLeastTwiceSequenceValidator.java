package software.aoc.day02.b;

import software.aoc.day02.IdValidator;

public class AtLeastTwiceSequenceValidator implements IdValidator {
    @Override
    public boolean isInvalid(long id) {
        String idStr = String.valueOf(id);
        int totalLength = idStr.length();

        for (int seqLen = 1; seqLen <= totalLength / 2; seqLen++) {
            if (totalLength % seqLen == 0) {
                String pattern = idStr.substring(0, seqLen);
                int repetitions = totalLength / seqLen;
                if (pattern.repeat(repetitions).equals(idStr)) { return true; }
            }
        }
        return false;
    }
}
