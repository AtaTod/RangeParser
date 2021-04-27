import java.util.Arrays;
import java.util.stream.IntStream;

public class RangeParser {

    public int[] rangeParser(String tokensInput) {
        if (tokensInput == null) {
            return new int[]{};
        }

        String intPattern = "\\d+";
        String rangePattern = "\\d+-\\d+";
        String rangeWithJumpsPattern = "\\d+-\\d+:\\d+";
        String rangeSeparatorPattern = "-";
        String rangeWithJumpsSeparatorsPattern = "[-:]";
        String tokenSeparatorsPattern = ", |,";
        int lowerBoundIndex = 0;
        int upperBoundIndex = 1;
        int increaseFactorIndex = 2;

        IntStream output = IntStream.empty();

        String[] tokens = tokensInput.split(tokenSeparatorsPattern);

        for (String token : tokens) {
            IntStream values;

            if (token.matches(intPattern)) {
                values = IntStream.of(Integer.parseInt(token));


            } else if (token.matches(rangePattern)) {
                int[] items = Arrays.stream(token.split(rangeSeparatorPattern))
                        .mapToInt(Integer::parseInt).toArray();

                values = IntStream.range(items[lowerBoundIndex], items[upperBoundIndex] + 1);

            } else if (token.matches(rangeWithJumpsPattern)) {
                int[] items = Arrays.stream(token.split(rangeWithJumpsSeparatorsPattern))
                        .mapToInt(Integer::parseInt).toArray();

                values = IntStream.iterate(items[lowerBoundIndex], n -> n <= items[upperBoundIndex],
                        n -> n + items[increaseFactorIndex]);

            } else {
                output = IntStream.empty();
                break;
            }

            output = IntStream.concat(output, values);
        }

        return output.toArray();
    }
}
