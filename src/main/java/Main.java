import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by egonzale on 3/3/17.
 */
public class Main {
    public static void main(String[] args) {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Board board = new Board(System.out, in);
        Game game = new Game(board);
        game.start();
    }
}
