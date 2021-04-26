import java.util.ArrayList;
import java.util.List;

public class RangeParser {

    public int[] rangeParser(String tokensInput) {
        String[] tokens = tokensInput.split(", |,");

        List<Integer> output = new ArrayList<>();
        for (String token : tokens) {
            if (token.indexOf(':') != -1) {
                String[] values = token.split("[-:]");
                for (int i = Integer.parseInt(values[0]); i <= Integer.parseInt(values[1]); i += Integer.parseInt(values[2])) {
                    output.add(i);
                }
            } else if (token.indexOf('-') != -1) {
                String[] values = token.split("-");
                for (int i = Integer.parseInt(values[0]); i <= Integer.parseInt(values[1]); i++) {
                    output.add(i);
                }
            } else {
                output.add(Integer.valueOf(token));
            }
        }

        return output.stream().mapToInt(Integer::intValue).toArray();
    }
}
