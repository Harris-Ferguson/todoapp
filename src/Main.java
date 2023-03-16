import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static private ArrayList<String> todos = new ArrayList<String>();
    public static void main(String[] args) {
        System.out.println("Welcome to the Todo App!");
        for(;;){
            System.out.println("Select an operation");
            System.out.print("1. Add A TODO");
            System.out.print("2. List all TODOS");
            // TODO ADD THE REST LOL
            Scanner scanner = new Scanner(System.in);
            int selection = Integer.parseInt(scanner.nextLine());
            if(selection == 1){
                System.out.println("Input a new todo");
                String newTodo = scanner.nextLine();
                Main.todos.add(newTodo);
            }
            if (selection == 2) {
                System.out.println(todos);
            }
        }
    }
}