import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by egonzale on 3/3/17.
 */
public class GameTest {

    private Board board;
    private BufferedReader in;

    @Before
    public void setUp() throws Exception {
        board = mock(Board.class);
        in = mock(BufferedReader.class);
    }

    @Test
    public void shouldTellBoardToPrintBoardWhenStarting() {
        Game game = new Game(in, board);

        game.start();

        verify(board).drawBoard();
    }

    @Test
    public void shouldPromptUserForInput() throws IOException {
        when(in.readLine()).thenReturn("1");
        Game game = new Game(in, board);

        game.makeMove();

        verify(in).readLine();
    }
}