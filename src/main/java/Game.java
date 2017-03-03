import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by egonzale on 3/3/17.
 */
public class Game {
    private final Board board;

    public Game(Board board) {
        this.board = board;
    }

    public void start() {
        board.drawBoard();
        beginTurns();
    }

    public void beginTurns() {
        board.makeMove("X");
        board.makeMove("O");
    }
}
