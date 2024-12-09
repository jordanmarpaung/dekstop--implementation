package todoapp.services;

import todoapp.entities.TodoList;

public interface TodoListService {

    /**
     * Mengambil daftar semua TodoList.
     *
     * @return array dari TodoList
     */
    TodoList[] getTodoList();

    /**
     * Menambahkan item baru ke TodoList.
     *
     * @param todo item yang akan ditambahkan
     */
    void addTodoList(String todo);

    /**
     * Menghapus item dari TodoList berdasarkan nomor.
     *
     * @param number nomor item yang akan dihapus
     * @return true jika penghapusan berhasil, false jika gagal
     */
    Boolean removeTodoList(Integer number);

    /**
     * Mengedit item pada TodoList.
     *
     * @param number nomor item yang akan diedit
     * @param todo teks baru untuk item tersebut
     * @return true jika pengeditan berhasil, false jika gagal
     */
    Boolean editTodoList(Integer number, String todo);
}
