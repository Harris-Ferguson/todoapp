import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {

    static private Todos todos = new Todos();

    public static void completeATodo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(todos.getAllIncompleteTodosAsAPrettyPrintableString());
        System.out.println("Which incomplete by id todo would you like to mark complete?");
        int selection = scanner.nextInt();
        todos.completeTodo(selection);
    }

    public static void addATodo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input a new todo description");
        String newTodoDescription = scanner.nextLine();
        System.out.println("Due date? Leave blank for none");
        String[] allowed =
                {
                        "yyyy.MM.dd G 'at' HH:mm:ss z",
                        "EEE, MMM d, ''yy",
                        "h:mm a",
                        "hh 'o''clock' a, zzzz",
                        "K:mm a, z",
                        "yyyyy.MMMMM.dd GGG hh:mm aaa",
                        "EEE, d MMM yyyy HH:mm:ss Z",
                        "yyMMddHHmmssZ",
                        "yyyy-MM-dd'T'HH:mm:ss.SSSZ",
                        "yyyy-MM-dd'T'HH:mm:ss.SSSXXX",
                        "YYYY-'W'ww-u",
                        "EEE, dd MMM yyyy HH:mm:ss z",
                        "EEE, dd MMM yyyy HH:mm zzzz",
                        "yyyy-MM-dd'T'HH:mm:ssZ",
                        "yyyy-MM-dd'T'HH:mm:ss.SSSzzzz",
                        "yyyy-MM-dd'T'HH:mm:sszzzz",
                        "yyyy-MM-dd'T'HH:mm:ss z",
                        "yyyy-MM-dd'T'HH:mm:ssz",
                        "yyyy-MM-dd'T'HH:mm:ss",
                        "yyyy-MM-dd'T'HHmmss.SSSz",
                        "yyyy-MM-dd",
                        "yyyyMMdd",
                        "dd/MM/yy",
                        "dd/MM/yyyy"
                };
        String input = scanner.nextLine();
        Date date = new Date();
        for (String format : allowed) {
            SimpleDateFormat simpleFormat = new SimpleDateFormat(format);
            try {
                date = simpleFormat.parse(input);
            } catch (ParseException e) {

            }
        }
        Todo newTodo = new Todo(
                newTodoDescription,
                (new Date()).toString(),
                date.toString(),
                false
        );
        Main.todos.addTodo(newTodo);
        System.out.println(todos.getAllTodosAsAPrettyPrintableString());
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the Todo App!");
        for(;;){
            System.out.println("Select an operation");
            System.out.print("1. Add A TODO");
            System.out.print("2. List all TODOS");
            System.out.print("3. List all completed TODOS");
            System.out.print("3. List all uncompleted TODOS");
            System.out.println("4. Mark a TODO as completed");
            Scanner scanner = new Scanner(System.in);
            int selection = Integer.parseInt(scanner.nextLine());
            if(selection == 1){
                Main.addATodo();
            }
            if (selection == 2) {
                System.out.println(todos.getAllTodosAsAPrettyPrintableString());
            }
            if(selection == 3) {
                System.out.println(todos.getAllCompletedTodosAsAPrettyPrintableString());
            }
            if(selection == 3) {
                System.out.println(todos.getAllIncompleteTodosAsAPrettyPrintableString());
            }
            if(selection == 4){
                Main.completeATodo();
            }
        }
    }
}