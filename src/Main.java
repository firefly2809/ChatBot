import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * Created by stanislav on 30.09.17.
 */
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        PrintMessage printMessage = new PrintMessage();
        printMessage.printGreeting();

        while (true) {
            String s = bufferedReader.readLine();
            if (printMessage.goodbye(s) == false) break;
        }
    }
}
