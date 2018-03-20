package com.nilsson83gmail.linus.todo.dataAccessObjects;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.nilsson83gmail.linus.todo.models.Todo;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

/**
 * Created by s060qm on 3/19/2018.
 */


@Dao
public interface TodoDao {

    @Query("SELECT * FROM Todo")
    LiveData<List<Todo>> getAllTodoItems();

    @Insert(onConflict = REPLACE)
    void addTodo(Todo todo);
}
