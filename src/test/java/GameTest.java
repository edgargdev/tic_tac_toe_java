import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;

import static org.mockito.Mockito.*;

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

        game.beginTurns();

        verify(in).readLine();
    }

    @Test
    public void shouldTellBoardNewMoveWasMadeWhenUserMakesMove() throws IOException {
        String input = "1";
        when(in.readLine()).thenReturn(input);

        game.beginTurns();

        verify(board).makeMove(input);
    }

    @Test
    public void shouldLetSecondPlayerMakeMoveAfterFirstPlayerMakesMove() throws IOException {
        when(in.readLine()).thenReturn("1","3");

        game.beginTurns();

        verify(board).makeMove("3");
    }
}