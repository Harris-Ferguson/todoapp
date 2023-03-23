import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {

    static private ArrayList<Todo> user_todo_list = new ArrayList<>();

    public static void list_options_to_console(){
        System.out.println("Select an operation");
        System.out.print("1. Add A TODO");
        System.out.print("2. List all TODOS");
        System.out.print("3. List all completed TODOS");
        System.out.print("3. List all uncompleted TODOS");
    }
    public static int get_collection_from_console(){
        Scanner scanner = new Scanner(System.in);
        int selection = Integer.parseInt(scanner.nextLine());
        return selection;
    }
    public static void add_new_todo(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input a new todo description");
        String newTodoDescription = scanner.nextLine();
        System.out.println("Due date? Leave blank for none");
        String input = scanner.nextLine();

        String[] allowed = AllowableDateTimes.getDateTimes();

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
        Main.user_todo_list.add(newTodo);
        for (Todo todo : user_todo_list) {
            System.out.println(todo);
        }
    }
    public static void list_all_todos(){
        for (Todo todo : user_todo_list) {
            System.out.println(todo.getDescription());
        }
    }
    public static void list_completed_todos(){
        for (Todo todo : user_todo_list) {
            if(todo.isCompleted()){
                System.out.println(todo.getDescription() + "Due" + todo.getDueDate());
            }
        }
    }
    public static void list_incomplete_todos(){
        for (Todo todo : user_todo_list) {
            if(!todo.isCompleted()){
                System.out.println(todo.getDescription() + "Due at:  " + todo.getDueDate());
            }
        }
    }
    public static void main(String[] args) {
        System.out.println("Welcome to the Todo App!");

        for(;;){
            Main.list_options_to_console();
            int selection = Main.get_collection_from_console();
            if(selection == 1){
                Main.add_new_todo();
            }
            if (selection == 2) {
                Main.list_all_todos();
            }
            if(selection == 3) {
                Main.list_completed_todos();
            }
            if(selection == 4) {
                Main.list_incomplete_todos();
            }
        }
    }
}