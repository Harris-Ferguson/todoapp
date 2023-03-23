import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TodoApp {
    private ArrayList<Todo> todos;

    public TodoApp(ArrayList<Todo> todos) {
        this.todos = todos;
    }

    private void prettyPrintListOfTodos(List<Todo> todosToPrint)
    {
        for(Todo todo : todosToPrint)
        {
            System.out.println(todo);
        }
    }

    private List<Todo> getCompletedTodos()
    {
        return todos.stream().filter(Todo::isCompleted).collect(Collectors.toList());
    }
    private List<Todo> getIncompleteTodos()
    {
        return todos.stream().filter(Predicate.not(Todo::isCompleted)).collect(Collectors.toList());
    }

    public void runTodoApp()
    {
        System.out.println("Welcome to the Todo App!");
        for(;;){
            System.out.println("Select an operation");
            System.out.print("1. Add A TODO");
            System.out.print("2. List all TODOS");
            System.out.print("3. List all completed TODOS");
            System.out.print("3. List all uncompleted TODOS");
            Scanner scanner = new Scanner(System.in);
            int selection = Integer.parseInt(scanner.nextLine());
            if (selection == 1){
                System.out.println("Input a new todo description");
                String newTodoDescription = scanner.nextLine();
                System.out.println("Due date? Leave blank for none");

                String input = scanner.nextLine();
                Date dueDate = DateTimeUtils.smartParseDate(input);
                Todo newTodo = new Todo(
                        newTodoDescription,
                        (new Date()).toString(),
                        dueDate.toString(),
                        false
                );
                todos.add(newTodo);
                prettyPrintListOfTodos(todos);
            }
            if (selection == 2) {
                prettyPrintListOfTodos(todos);
            }
            if (selection == 3) {
                prettyPrintListOfTodos(getCompletedTodos());
            }
            if (selection == 4) {
                prettyPrintListOfTodos(getIncompleteTodos());
            }
        }
    }
}
