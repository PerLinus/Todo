package com.nilsson83gmail.linus.todo.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nilsson83gmail.linus.todo.R;
import com.nilsson83gmail.linus.todo.models.Todo;

/**
 * Created by s060qm on 3/13/2018.
 */

public class TodoListAdapter extends RecyclerView.Adapter<TodoListAdapter.TodoListAdapterViewHolder> {

    private String[] toDos;

    private final TodoListAdapterOnClickHandler clickHandler;

    public interface TodoListAdapterOnClickHandler {
        void onClick(String chosenTodo);
    }

    public TodoListAdapter(TodoListAdapterOnClickHandler clickHandler) {
        this.clickHandler = clickHandler;
        this.toDos = new String[Todo.toDos.length];
        for (int i = 0; i < Todo.toDos.length; i++) {
            this.toDos[i] = Todo.toDos[i].getName();
        }
    }

    @NonNull
    @Override
    public TodoListAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.todo_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, viewGroup, shouldAttachToParentImmediately);
        return new TodoListAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TodoListAdapter.TodoListAdapterViewHolder holder, int position) {
        String todoTest = toDos[position];
        holder.tvTodoListItem.setText(todoTest);
    }

    @Override
    public int getItemCount() {
        if (toDos == null) {
            return 0;
        }
        return toDos.length;
    }

    public class TodoListAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public final TextView tvTodoListItem;

        public TodoListAdapterViewHolder(View itemView) {
            super(itemView);
            tvTodoListItem = (TextView) itemView.findViewById(R.id.tv_todo_list_item);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int adapterPosition = getAdapterPosition();
            String todoItem = toDos[adapterPosition];
            clickHandler.onClick(todoItem);
        }
    }



}
