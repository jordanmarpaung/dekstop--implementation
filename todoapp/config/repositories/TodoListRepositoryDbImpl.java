package todoapp.repositories;

import todoapp.config.Database;
import todoapp.entities.TodoList;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TodoListRepositoryDbImpl implements TodoListRepository {
    private final Database database;

    public TodoListRepositoryDbImpl(Database database) {
        this.database = database;
    }

    @Override
    public TodoList[] getAll() {
        List<TodoList> todoLists = new ArrayList<>();
        String sql = "SELECT * FROM todo_list";

        try (Connection connection = database.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                TodoList todoList = new TodoList();
                todoList.setId(resultSet.getInt("id"));
                todoList.setTodo(resultSet.getString("todo"));
                todoLists.add(todoList);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return todoLists.toArray(new TodoList[0]);
    }

    @Override
    public void add(TodoList todolist) {
        String sql = "INSERT INTO todo_list(todo) VALUES (?)";

        try (Connection connection = database.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, todolist.getTodo());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Boolean remove(Integer id) {
        String sql = "DELETE FROM todo_list WHERE id = ?";

        try (Connection connection = database.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);
            int affectedRows = statement.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean edit(TodoList todolist) {
        String sql = "UPDATE todo_list SET todo = ? WHERE id = ?";

        try (Connection connection = database.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, todolist.getTodo());
            statement.setInt(2, todolist.getId());
            int affectedRows = statement.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
