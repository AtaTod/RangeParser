import java.util.ArrayList;
import java.util.List;

public class RangeParser {

    public int[] rangeParser(String tokensInput) {
        if (tokensInput == null) {
            return new int[]{};
        }

        List<Integer> output = new ArrayList<>();

        if (tokensInput.matches("\\d+"))
            output.add(Integer.parseInt(tokensInput));

        if (tokensInput.matches("\\d+-\\d+")) {
            String[] rangeBounds = tokensInput.split("-");

            for (int i = Integer.parseInt(rangeBounds[0]); i <= Integer.parseInt(rangeBounds[1]); i++) {
                output.add(i);
            }
        }

        if (tokensInput.matches("\\d+-\\d+:\\d+")) {
            String[] rangeBounds = tokensInput.split("[-:]");

            for (int i = Integer.parseInt(rangeBounds[0]); i <= Integer.parseInt(rangeBounds[1]); i += Integer.parseInt(rangeBounds[2])) {
                output.add(i);
            }
        }

        return output.stream().mapToInt(Integer::intValue).toArray();
    }
}
