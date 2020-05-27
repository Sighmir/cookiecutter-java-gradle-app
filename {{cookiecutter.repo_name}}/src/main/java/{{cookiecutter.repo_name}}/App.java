package {{cookiecutter.repo_name}};

public class App {
    public Integer sum(Integer a, Integer b) {
        return a + b;
    }

    public void greet() {
        System.out.println(Api.getGreeting());
    }

    public static void main(String[] args) {
        Integer a = Integer.parseInt(args[0]);
        Integer b = Integer.parseInt(args[1]);
        System.out.println(new App().sum(a, b).toString());
    }
}
