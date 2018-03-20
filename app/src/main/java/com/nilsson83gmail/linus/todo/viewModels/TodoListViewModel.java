package com.nilsson83gmail.linus.todo.viewModels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.nilsson83gmail.linus.todo.models.Todo;
import com.nilsson83gmail.linus.todo.sqlite.TodoRoomDatabase;

import java.util.List;

/**
 * Created by s060qm on 3/19/2018.
 */

public class TodoListViewModel extends AndroidViewModel {

    private final LiveData<List<Todo>> todoList;

    private TodoRoomDatabase todoRoomDatabase;

    public TodoListViewModel(@NonNull Application application) {
        super(application);

        todoRoomDatabase = TodoRoomDatabase.getDatabase(this.getApplication());

        todoList = todoRoomDatabase.todoModel().getAllTodoItems();
    }

    public LiveData<List<Todo>> getTodoList() {
        return todoList;
    }


}
