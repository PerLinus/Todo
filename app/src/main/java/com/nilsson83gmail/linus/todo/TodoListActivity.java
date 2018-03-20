package com.nilsson83gmail.linus.todo;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.nilsson83gmail.linus.todo.adapters.TodoListAdapter;
import com.nilsson83gmail.linus.todo.models.Todo;
import com.nilsson83gmail.linus.todo.viewModels.TodoListViewModel;

import java.util.ArrayList;
import java.util.List;

public class TodoListActivity extends AppCompatActivity implements View.OnClickListener {

    private TodoListViewModel viewModel;
    private RecyclerView mRecyclerView;
    private TodoListAdapter mTodoListAdapter;

    private TextView mErrorMessageDisplay;

    private ProgressBar mLoadingIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_list);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_todolist);

        mTodoListAdapter = new TodoListAdapter(new ArrayList<Todo>(), this);


        //mErrorMessageDisplay = (TextView) findViewById(R.id.tv_todo_list_error_message);

        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        mRecyclerView.setLayoutManager(layoutManager);

        mRecyclerView.setHasFixedSize(true);

        mRecyclerView.setAdapter(mTodoListAdapter);

        mLoadingIndicator = (ProgressBar) findViewById(R.id.pb_loading_indicator);

        viewModel = ViewModelProviders.of(this).get(TodoListViewModel.class);

        viewModel.getTodoList().observe(TodoListActivity.this, new Observer<List<Todo>>() {
            @Override
            public void onChanged(@Nullable List<Todo> todos) {
                mTodoListAdapter.addItems(todos);
            }
        });
    }

    @Override
    public void onClick(View view) {
        Todo todo = (Todo) view.getTag();
        Intent intent = new Intent(TodoListActivity.this, TodoActivity.class);
        intent.putExtra("name", todo.getName());
        intent.putExtra("content", todo.getTodos());
        startActivity(intent);
    }
}
