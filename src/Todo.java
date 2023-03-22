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

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    protected void setId(int id) {
        this.id = id;
    }

    protected Todo clone() {
        Todo clone = new Todo(
                this.description,
                this.created,
                this.dueDate,
                this.completed
        );
        clone.setId(this.id);
        return clone;
    }
}
