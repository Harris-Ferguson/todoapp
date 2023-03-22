import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class Todos {

    private List<Todo> todos;

    public Todos() {
        this.todos = new ArrayList<>();
    }

    public Todos(ArrayList<Todo> todos) {
        this.todos = todos;
    }

    public void addTodo(Todo todo) {
        todos.add(todo);
    }

    public void removeTodo(int id) {
        todos.removeIf(todo -> todo.getId() == id);
    }

    public Todo lookupTodo(int id) {
        Optional<Todo> foundTodo = todos.stream().filter(todo -> todo.getId() == id).findFirst();
        if(foundTodo.isPresent()){
            return foundTodo.get();
        }
        throw new NoSuchElementException();
    }

    public void completeTodo(int id) {
        todos.stream().filter(todo -> todo.getId() == id).forEach(todo -> todo.setCompleted(true));
    }

    public String getAllTodosAsAPrettyPrintableString() {
        StringBuilder stringBuilder = new StringBuilder();
        todos.stream().forEach(stringBuilder::append);
        return stringBuilder.toString();
    }

    public String getAllCompletedTodosAsAPrettyPrintableString() {
        StringBuilder stringBuilder = new StringBuilder();
        todos.stream().filter(Todo::isCompleted).forEach(stringBuilder::append);
        return stringBuilder.toString();
    }

    public String getAllIncompleteTodosAsAPrettyPrintableString() {
        StringBuilder stringBuilder = new StringBuilder();
        todos.stream().filter(todo -> !todo.isCompleted()).forEach(stringBuilder::append);
        return stringBuilder.toString();
    }

}
