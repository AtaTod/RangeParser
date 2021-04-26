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
}
