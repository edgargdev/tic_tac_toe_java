import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by egonzale on 3/3/17.
 */
public class BoardTest {
    @Test
    public void shouldPrintBoard() {
        PrintStream printStream = mock(PrintStream.class);
        Board board = new Board(printStream);

        board.drawBoard();

        verify(printStream).println("1|2|3\n" +
                "-----\n" +
                "4|5|6\n" +
                "-----\n" +
                "7|8|9");

    }

}