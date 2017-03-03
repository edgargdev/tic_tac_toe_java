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
    private Game game;

    @Before
    public void setUp() throws Exception {
        board = mock(Board.class);
        in = mock(BufferedReader.class);
        game = new Game(in, board);
    }

    @Test
    public void shouldTellBoardToPrintBoardWhenStarting() {

        game.start();

        verify(board).drawBoard();
    }

    @Test
    public void shouldPromptUserForInput() throws IOException {
        when(in.readLine()).thenReturn("1");

        game.makeMove();

        verify(in).readLine();
    }

    @Test
    public void shouldTellBoardNewMoveWasMadeWhenUserMakesMove() throws IOException {
        String input = "1";
        when(in.readLine()).thenReturn(input);

        game.makeMove();

        verify(board).makeMove(input);
    }
}