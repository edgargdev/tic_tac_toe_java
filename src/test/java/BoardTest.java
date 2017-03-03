import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Mockito.*;

/**
 * Created by egonzale on 3/3/17.
 */
public class BoardTest {

    private PrintStream printStream;
    private BufferedReader in;
    private Board board;

    @Before
    public void setUp() throws Exception {
        in = mock(BufferedReader.class);
        printStream = mock(PrintStream.class);
        board = new Board(printStream, in);
    }

    @Test
    public void shouldPrintBoard() {
        board.drawBoard();

        verify(printStream).println("1|2|3\n" +
                "-----\n" +
                "4|5|6\n" +
                "-----\n" +
                "7|8|9");

    }

    @Test
    public void shouldPromptUserForInput() throws IOException {
        when(in.readLine()).thenReturn("1");

        board.makeMove("O");

        verify(in).readLine();
    }

    @Test
    public void shouldRedrawBoardWhenGivenNewMove() throws IOException {
        when(in.readLine()).thenReturn("1");

        board.makeMove("X");

        verify(printStream).println("X|2|3\n" +
                "-----\n" +
                "4|5|6\n" +
                "-----\n" +
                "7|8|9");
    }
// this should be handled by the game class
//    @Test
//    public void shouldRetryInputWhenUserSelectsSelectedField() throws IOException {
//        when(in.readLine()).thenReturn("1","1", "2");
//
//        board.makeMove("X");
//
//        verify(in, times(3)).readLine();
//    }
}