import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;

/**
 * Created by egonzale on 3/3/17.
 */
public class BoardTest {

    private PrintStream printStream;
    private BufferedReader in;
    private Board board;
    private ArrayList<String> fields;

    @Before
    public void setUp() throws Exception {
        in = mock(BufferedReader.class);
        printStream = mock(PrintStream.class);
        fields = new ArrayList<>(Arrays.asList("1","2","3","4","5","6","7","8","9"));
        board = new Board(printStream, in, fields);
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
    @Test
    public void shouldRetryInputWhenUserSelectsSelectedField() throws IOException {
        ArrayList<String> modifiedState = new ArrayList<>(Arrays.asList("X","2", "3","4", "5", "6", "7", "8", "9"));
        Board modifiedBoard = new Board(printStream, in, modifiedState);
        when(in.readLine()).thenReturn("1", "2");

        modifiedBoard.makeMove("0");

        verify(in, times(2)).readLine();
    }

    @Test
    public void shouldKnowBoardIsFilled() {
        ArrayList<String> filledStated = new ArrayList<>(Arrays.asList("X","X","X","X","X","X","X","X","X"));
        Board filledBoard = new Board(printStream, in, filledStated);

        boolean full = filledBoard.isFull();

        assertThat(full, is(true));
    }

    @Test
    public void shouldKnowWhenBoardIsNotFull() {
        ArrayList<String> notFullState = new ArrayList<>(Arrays.asList("X","X","X","X","X","X","X","X","9"));
        Board unfilledBoard = new Board(printStream, in, notFullState);

        boolean notFull = unfilledBoard.isFull();

        assertThat(notFull, is(false));
    }

    @Test
    public void shouldDisplayGameIsDrawWhenBoardIsInDrawState() {
        ArrayList<String> drawState = new ArrayList<>(Arrays.asList("X","O","X","O","O","X","X","X","O"));
        Board drawBoard = new Board(printStream, in, drawState);

        drawBoard.annouceFinished();

        verify(printStream).println("Game is draw");
    }
}