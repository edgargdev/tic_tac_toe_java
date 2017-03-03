import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by egonzale on 3/3/17.
 */
public class Board {
    private final PrintStream out;
    private BufferedReader in;
    private ArrayList<String> fields = new ArrayList<>(Arrays.asList("1","2","3","4","5","6","7","8","9"));

    public Board(PrintStream printStream, BufferedReader in) {
        this.out = printStream;
        this.in = in;
    }

    public void drawBoard() {
        String str = "";
        for (int i = 0; i < fields.size(); i++) {
            if(i % 3 == 0 && i != 0) {
                str += "\n-----\n";
            } else if (i % 1 == 0 && i != 0) {
                str += "|";
            }
            str += fields.get(i);
        }
            out.println(str);
    }

    public void makeMove(String token) {
        try {
            boolean validPosition = false;
            while (!validPosition) {
                String input = in.readLine();
                int choice = Integer.parseInt(input) - 1;
                boolean validInput = choice < 9 && choice >= 0;
                validPosition = fields.contains(input);

                if (validInput && validPosition) {
                    fields.set(choice, token);
                }
                drawBoard();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
