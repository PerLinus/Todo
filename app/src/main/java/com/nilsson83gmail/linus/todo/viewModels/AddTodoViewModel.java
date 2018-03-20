package com.nilsson83gmail.linus.todo.viewModels;


import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.nilsson83gmail.linus.todo.models.Todo;
import com.nilsson83gmail.linus.todo.sqlite.TodoRoomDatabase;

/**
 * Created by s060qm on 3/20/2018.
 */

public class AddTodoViewModel extends AndroidViewModel {

    private TodoRoomDatabase todoRoomDatabase;

    public AddTodoViewModel(@NonNull Application application) {
        super(application);

        todoRoomDatabase = TodoRoomDatabase.getDatabase(this.getApplication());
    }

    public void addTodo(final Todo todo) {
        new AddAsyncTask(todoRoomDatabase).execute(todo);
    }

    private static class AddAsyncTask extends AsyncTask<Todo, Void, Void> {

        private TodoRoomDatabase db;

        AddAsyncTask(TodoRoomDatabase db) {
            this.db = db;
        }

        @Override
        protected Void doInBackground(Todo... todos) {
            db.todoModel().addTodo(todos[0]);
            return null;
        }
    }

}
