import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by egonzale on 3/3/17.
 */
public class Game {
    private final BufferedReader in;
    private final Board board;

    public Game(BufferedReader in, Board board) {
        this.in = in;
        this.board = board;
    }

    public void start() {
        board.drawBoard();
        makeMove();
    }

    public void makeMove() {
        try {
            String input = in.readLine();
            board.makeMove(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
