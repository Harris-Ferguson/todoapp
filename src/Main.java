import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        TodoApp app = new TodoApp(new ArrayList<>());
        app.runTodoApp();
    }

}