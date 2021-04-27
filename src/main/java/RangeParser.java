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
        int lowerBoundIndex = 0;
        int upperBoundIndex = 1;
        int increaseFactorIndex = 2;

        IntStream output = IntStream.empty();

        if (tokensInput.matches(intPattern)) {
            output = IntStream.concat(output, IntStream.of(Integer.parseInt(tokensInput)));

        } else if (tokensInput.matches(rangePattern)) {
            int[] items = Arrays.stream(tokensInput.split(rangeSeparatorPattern))
                    .mapToInt(Integer::parseInt).toArray();

            IntStream range = IntStream.range(items[lowerBoundIndex], items[upperBoundIndex]+1);
            output = IntStream.concat(output, range);

        } else if (tokensInput.matches(rangeWithJumpsPattern)) {
            int[] items = Arrays.stream(tokensInput.split(rangeWithJumpsSeparatorsPattern))
                    .mapToInt(Integer::parseInt).toArray();

            IntStream range = IntStream.iterate(items[lowerBoundIndex], n -> n <= items[upperBoundIndex],
                    n -> n + items[increaseFactorIndex]);
            output = IntStream.concat(output, range);

        }

        return output.toArray();
    }
}
