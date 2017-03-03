import java.io.PrintStream;

/**
 * Created by egonzale on 3/3/17.
 */
public class Board {
    private final PrintStream out;

    public Board(PrintStream printStream) {
        this.out = printStream;
    }

    public void drawBoard() {
        out.println("1|2|3\n" + "-----\n" + "4|5|6\n" + "-----\n" + "7|8|9");
    }
}
