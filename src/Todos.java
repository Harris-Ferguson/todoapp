import java.util.ArrayList;

public class Todos {

    private ArrayList<Todo> todos;

    public Todos() {
        this.todos = new ArrayList<>();
    }

    public Todos(ArrayList<Todo> todos) {
        this.todos = todos;
    }

    public void addTodo(Todo todo) {
        todos.add(todo);
    }
}
