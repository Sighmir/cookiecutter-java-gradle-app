package {{cookiecutter.repo_name}};

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ApiTest {
  @Test
  public void testApiGreeting() {
    assertEquals("Hello, World!", Api.getGreeting());
  }
}