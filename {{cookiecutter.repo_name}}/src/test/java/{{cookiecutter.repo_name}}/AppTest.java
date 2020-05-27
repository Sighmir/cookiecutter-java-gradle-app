package {{cookiecutter.repo_name}};

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.io.PrintStream;

import org.junit.Test;

public class AppTest {
    @Test
    public void testAppSum() {
        App app = new App();
        assertTrue(app.sum(2, 3) == 5);
    }

    @Test
    public void testAppPrintSum() {
        PrintStream out = System.out;
        PrintStream outMock = mock(PrintStream.class);
        System.setOut(outMock);
        App.main(new String[] { "2", "3" });
        verify(outMock).println("5");
        System.setOut(out);
    }
}
