package euclin.std;

import java.io.IOException;

public class Console {

    public static void writeln(String text) {
        System.out.println(text);
    }

    public static void write(String text) {
        System.out.print(text);
    }

    public static void writeChar(char c) {
        System.out.print(c);
    }

    public static char readChar() {
        try {
            return (char) System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
            return '\0';
        }
    }
}
