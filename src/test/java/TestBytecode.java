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

    /**
     * Petit test pour voir comment javac gère les lambdas avec utilisation d'une variable
     */
    private static void lambdaAvecVariable(double s0) {
        Stream.of("dzq").forEach(s -> System.out.println(s+s0));
    }
}
