import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class RangeParserTest {

    @Test
    void is_correct() {
        assertArrayEquals(new RangeParser().rangeParser("1-10,14, 20-25:2"), new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 14, 20, 22, 24});
        assertArrayEquals(new RangeParser().rangeParser("5-10"), new int[]{5, 6, 7, 8, 9, 10});
        assertArrayEquals(new RangeParser().rangeParser("2"), new int[]{2});
    }
}
