package euclin.std;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IO {

    // code assez moche mais c'est juste pour que ça fonctionne
    public static final String readFile(String name) {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(ClassLoader.getSystemClassLoader().getResourceAsStream(name)))) {
            return reader.lines().reduce((acc, s) -> acc+"\n"+s).get();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
