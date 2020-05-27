package {{cookiecutter.repo_name}};

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.PrintStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Api.class)
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

    @Test
    public void testAppGreeting() {
        PrintStream out = System.out;
        PrintStream outMock = mock(PrintStream.class);
        System.setOut(outMock);

        PowerMockito.mockStatic(Api.class);
        when(Api.getGreeting()).thenReturn("Hello, Test!");

        App app = new App();
        app.greet();

        verify(outMock).println("Hello, Test!");
        System.setOut(out);
    }
}
