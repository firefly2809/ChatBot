import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by stanislav on 03.10.17.
 */
    public class Logger {

    String n = System.getProperty("line.separator");
    Date date = new Date();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy_MM_dd_hh-mm-ss");

    public void log(String message) throws IOException {
        FileWriter fileWriter = new FileWriter(simpleDateFormat.format(date) + ".log", true);
        fileWriter.write(message + n);
        fileWriter.close();
    }
}
