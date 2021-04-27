import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RangeParserShould {

    @Test
    void allow_for_null_token() {
        assertArrayEquals(new RangeParser().rangeParser(null), new int[]{});
    }

    @Test
    void allow_for_empty_token() {
        assertArrayEquals(new RangeParser().rangeParser(""), new int[]{});
    }

    @Test
    void allow_for_single_integer_token() {
        assertArrayEquals(new RangeParser().rangeParser("2"), new int[]{2});
    }

    @Test
    void allow_for_single_range_token() {
        assertArrayEquals(new RangeParser().rangeParser("1-10"), new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
    }

    @Test
    void allow_for_single_range_each_factor_token() {
        assertArrayEquals(new RangeParser().rangeParser("1-10:2"), new int[]{1, 3, 5, 7, 9});
    }
}
