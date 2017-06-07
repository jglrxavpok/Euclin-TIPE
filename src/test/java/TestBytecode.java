import java.math.BigDecimal;
import java.util.Arrays;
import java.util.stream.Stream;

public class TestBytecode {

    private static double somefunc(double _) {

        return Math.sin(new BigDecimal(4.5).doubleValue());
    }

    private static void someother() {
        Stream.of("dzd", "dzd").forEach(s -> Math.sin(Float.parseFloat(s)));
    }
}
