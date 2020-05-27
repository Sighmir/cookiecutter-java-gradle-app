package {{cookiecutter.repo_name}};

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AppTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void testAppSum() {
        App classUnderTest = new App();
        assertTrue(classUnderTest.sum(2, 3) == 5);
    }

    @Test
    public void testAppPrintSum() {
        App.main(new String[] { "2", "3" });
        String lineSeparator = System.getProperty("line.separator");
        String sumString = new App().sum(2, 3).toString().concat(lineSeparator);
        assertEquals(sumString, outContent.toString());
    }
}
