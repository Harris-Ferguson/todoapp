import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class TodoApp {
    private ArrayList<Todo> todos;

    public TodoApp(ArrayList<Todo> todos) {
        this.todos = todos;
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
            if(selection == 1){
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
                for (Todo todo : todos) {
                    System.out.println(todo);
                }
            }
            if (selection == 2) {
                for (Todo todo : todos) {
                    System.out.println(todo.getDescription());
                }
            }
            if(selection == 3) {
                for (Todo todo : todos) {
                    if(todo.isCompleted()){
                        System.out.println(todo.getDescription() + "Due" + todo.getDueDate());
                    }
                }
            }
            if(selection == 3) {
                for (Todo todo : todos) {
                    if(!todo.isCompleted()){
                        System.out.println(todo.getDescription() + "Due at:  " + todo.getDueDate());
                    }
                }
            }
        }
    }
}
