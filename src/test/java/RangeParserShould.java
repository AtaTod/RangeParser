import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RangeParserShould {

    @Test
    void allow_for_null_or_empty_token() {
        assertArrayEquals(new RangeParser().rangeParser(""), new int[]{});
        assertArrayEquals(new RangeParser().rangeParser(null), new int[]{});
    }
}
