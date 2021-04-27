import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RangeParserShould {

    RangeParser rangeParser;

    @BeforeEach
    void setUp() {
        rangeParser = new RangeParser();
    }

    @Test
    void allow_for_null_token() {
        int[] expectedOutput = {};
        String token = null;

        assertArrayEquals(expectedOutput, rangeParser.rangeParser(token));
    }

    @Test
    void allow_for_empty_token() {
        int[] expectedOutput = {};
        String token = "";

        assertArrayEquals(expectedOutput, rangeParser.rangeParser(token));
    }

    @Test
    void allow_for_single_integer_token() {
        int[] expectedOutput = {2};
        String token = "2";

        assertArrayEquals(expectedOutput, rangeParser.rangeParser(token));
    }

    @Test
    void allow_for_single_range_token() {
        int[] expectedOutput = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        String token = "1-10";

        assertArrayEquals(expectedOutput, rangeParser.rangeParser(token));
    }

    @Test
    void allow_for_single_range_each_factor_token() {
        int[] expectedOutput = {1, 3, 5, 7, 9};
        String token = "1-10:2";

        assertArrayEquals(expectedOutput, rangeParser.rangeParser(token));
    }

    @Test
    void allow_fow_multiple_tokens() {
        int[] expectedOutput = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 14, 20, 22, 24};
        String tokens = "1-10,14, 20-25:2";

        assertArrayEquals(expectedOutput, rangeParser.rangeParser(tokens));
    }
}
