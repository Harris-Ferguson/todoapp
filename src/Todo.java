import java.util.concurrent.atomic.AtomicInteger;

public class Todo {
    private static final AtomicInteger id_counter = new AtomicInteger(0);
    private String description;
    private String created;
    private String dueDate;
    private boolean completed;
    private int id;

    public Todo(String description, String created, String dueDate, boolean completed) {
        this.description = description;
        this.created = created;
        this.dueDate = dueDate;
        this.completed = completed;
        this.id = id_counter.incrementAndGet();
    }

    @Override
    public String toString() {
        return "Todo{" +
                "description='" + description + '\'' +
                ", created='" + created + '\'' +
                ", dueDate='" + dueDate + '\'' +
                ", completed=" + completed +
                ", id=" + id +
                '}';
    }

    public String getDescription() {
        return description;
    }

    public String getCreated() {
        return created;
    }

    public String getDueDate() {
        return dueDate;
    }

    public boolean isCompleted() {
        return completed;
    }

    public int getId() {
        return id;
    }
}
