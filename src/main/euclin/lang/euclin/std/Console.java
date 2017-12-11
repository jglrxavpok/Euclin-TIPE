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
            int val = System.in.read();
            if(val == -1)
                return '\0';
            return (char)val;
        } catch (IOException e) {
            e.printStackTrace();
            return '\0';
        }
    }
}
