package com.nilsson83gmail.linus.todo;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nilsson83gmail.linus.todo.models.Todo;
import com.nilsson83gmail.linus.todo.viewModels.TodoListViewModel;


public class EditAndViewTodoFragment extends Fragment {

    private TodoListViewModel viewModel;
    private TextView tvName;
    private TextView tvContent;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = ViewModelProviders.of(this).get(TodoListViewModel.class);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_edit_and_view_todo, container, false);

    }

    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        if (view != null) {
            Todo todo = (Todo) view.getTag();
            tvName = view.findViewById(R.id.text);
            tvContent = view.findViewById(R.id.textView);

            tvName.setText(todo.getName());
            tvContent.setText(todo.getTodos());
        }
    }
}

