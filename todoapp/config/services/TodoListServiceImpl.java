package todoapp.services;

import todoapp.entities.TodoList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import todoapp.repositories.TodoListRepository;

@Component
public class TodoListServiceImpl implements TodoListService {
    private final TodoListRepository todoListRepository;

    @Autowired
    public TodoListServiceImpl(TodoListRepository todoListRepository) {
        this.todoListRepository = todoListRepository;
    }

    /**
     * Mengambil seluruh daftar TodoList dari repository.
     *
     * @return array TodoList
     */
    @Override
    public TodoList[] getTodoList() {
        return todoListRepository.getAll();
    }

    /**
     * Menambahkan item baru ke dalam TodoList.
     *
     * @param todo teks item baru
     */
    @Override
    public void addTodoList(final String todo) {
        if (todo.isBlank() || todo.isEmpty()) {
            System.out.println("Masukkan todo dengan benar.");
            return;
        }
        TodoList todoList = new TodoList();
        todoList.setTodo(todo);
        todoListRepository.add(todoList);
    }

    /**
     * Menghapus item dari TodoList berdasarkan nomor.
     *
     * @param number nomor item yang akan dihapus
     * @return true jika penghapusan berhasil, false jika gagal
     */
    @Override
    public Boolean removeTodoList(final Integer number) {
        return todoListRepository.remove(number);
    }

    /**
     * Mengedit item pada TodoList berdasarkan nomor.
     *
     * @param number nomor item yang akan diedit
     * @param todo teks baru untuk item tersebut
     * @return true jika pengeditan berhasil, false jika gagal
     */
    @Override
    public Boolean editTodoList(final Integer number, final String todo) {
        if (todo.isBlank() || todo.isEmpty()) {
            System.out.println("Teks baru tidak boleh kosong.");
            return false;
        }

        TodoList todoList = new TodoList();
        todoList.setTodo(todo);
        todoList.setId(number);
        return todoListRepository.edit(todoList);
    }
}
