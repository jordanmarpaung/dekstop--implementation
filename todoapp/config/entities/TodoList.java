package todoapp.entities;

public class TodoList {
    private Integer id;
    private String todo;

    public TodoList() {
    }

    public TodoList(Integer id, String todo) {
        this.id = id;
        this.todo = todo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getTodo() {
        return todo;
    }

    public void setTodo(final String todo) {
        this.todo = todo;
    }

    @Override
    public String toString() {
        return "Todo ID: " + id + ", Task: " + todo;
    }
}
