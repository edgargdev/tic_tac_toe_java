import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by egonzale on 3/3/17.
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<String> fields = new ArrayList<>(Arrays.asList("1","2","3","4","5","6","7","8","9"));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Board board = new Board(System.out, in, fields);
        Game game = new Game(board);
        game.start();
    }
}
