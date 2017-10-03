import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by stanislav on 02.10.17.
 */
public class PrintMessage {

   private ReaderFile readerFile = new ReaderFile("answers.txt");
   private ArrayList<String> answers = readerFile.getAnswers();
   private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
   Logger logger = new Logger();

   public boolean goodbye(String message) throws IOException{
       logger.log(message);
       if ( message.equals("\"Goodbye\"")) {
           printParting();
           return false;
       }
       else {
           getAnswer(message);
           return true;
       }
   }


    public void getAnswer(String message) throws IOException {

        if (message.equals("\"Stop talking\"")) {
            System.out.println("Видеть тебя больше не хочу, тварь... Не пиши мне больше");
            while (true) {
                String s1 = bufferedReader.readLine();
                if (s1.equals("\"Start talking\"")) break;
            }
            System.out.println("Ну хорошо, попроси прощения и возможно я тебе отвечу...");
            return;
        }
        if (message.contains("\"Use another file:")) {
            changeFile(message.substring(18, message.length() - 1));
            System.out.println("Теперь отвечать будет " + message.substring(18, message.length() - 1));
            System.out.println(message.substring(18, message.length() - 1) + ": " + answers.get(0));
            return;
        }
        int m = (int) (Math.random() * (answers.size() - 2)) + 1;
        System.out.println(answers.get(m));
        logger.log(answers.get(m));
    }

    public void printGreeting() throws IOException {
        System.out.println(answers.get(0));
        logger.log(answers.get(0));
    }

    public void printParting() throws IOException {
        System.out.println(answers.get(answers.size() - 1));
        logger.log(answers.get(answers.size() - 1));
    }

    public void changeFile(String filepath) {
        this.readerFile = new ReaderFile(filepath);
        answers = readerFile.getAnswers();
    }
}
