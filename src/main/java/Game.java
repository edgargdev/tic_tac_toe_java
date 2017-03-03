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
        int turn = 1;
        String token = "";
        while(!board.isFull() && turn < 12) {
            if (turn % 2 == 0) {
                token = "0";
            } else {
                token = "X";
            }
            turn++;
            board.makeMove(token);
        }
        board.announceFinished(token);
    }
}
