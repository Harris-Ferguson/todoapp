public class Todo {
    private String description;
    private String created;
    private String dueDate;
    private boolean completed;

    public Todo(String description, String created, String dueDate, boolean completed) {
        this.description = description;
        this.created = created;
        this.dueDate = dueDate;
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "description='" + description + '\'' +
                ", created='" + created + '\'' +
                ", dueDate='" + dueDate + '\'' +
                ", completed=" + completed +
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
}
