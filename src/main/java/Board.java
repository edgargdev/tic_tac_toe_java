import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by egonzale on 3/3/17.
 */
public class Board {
    private final PrintStream out;
    private ArrayList<String> fields = new ArrayList<>(Arrays.asList("1","2","3","4","5","6","7","8","9"));

    public Board(PrintStream printStream) {
        this.out = printStream;
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

    public void makeMove(String input) {
        int choice = Integer.parseInt(input) - 1;
        if (choice < 9 && choice >= 0) {
            fields.set(choice, "X");
        }
        drawBoard();
    }
}
