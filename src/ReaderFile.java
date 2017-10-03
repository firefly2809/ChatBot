import java.io.*;
import java.util.ArrayList;

/**
 * Created by stanislav on 30.09.17.
 */
public class ReaderFile {

    private String fileName;

    public ReaderFile(String fileName) {
        this.fileName = fileName;
    }


    public ArrayList<String> getAnswers() {

        ArrayList<String> arrayList = new ArrayList<>();

        try {
            FileInputStream fileInputStream = new FileInputStream(fileName);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                arrayList.add(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return arrayList;
    }
}

