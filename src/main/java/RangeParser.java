import java.util.ArrayList;
import java.util.List;

public class RangeParser {

    public int[] rangeParser(String tokensInput) {
        if (tokensInput == null) {
            return new int[]{};
        }

        List<Integer> output = new ArrayList<>();

        if (tokensInput.matches("\\d"))
            output.add(Integer.parseInt(tokensInput));

        return output.stream().mapToInt(Integer::intValue).toArray();
    }
}
