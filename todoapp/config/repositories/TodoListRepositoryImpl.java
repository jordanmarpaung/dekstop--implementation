package todoapp.repositories;

import todoapp.entities.TodoList;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TodoListRepositoryImpl implements TodoListRepository {
    private final List<TodoList> todoLists = new ArrayList<>();
    private int nextId = 1;

    @Override
    public TodoList[] getAll() {
        return todoLists.toArray(new TodoList[0]);
    }

    @Override
    public void add(TodoList todolist) {
        todolist.setId(nextId++);
        todoLists.add(todolist);
    }

    @Override
    public Boolean remove(Integer id) {
        return todoLists.removeIf(todoList -> todoList.getId().equals(id));
    }

    @Override
    public Boolean edit(TodoList todolist) {
        for (int i = 0; i < todoLists.size(); i++) {
            if (todoLists.get(i).getId().equals(todolist.getId())) {
                todoLists.set(i, todolist);
                return true;
            }
        }
        return false;
    }
}
