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

import java.util.List;

/**
 * Created by s060qm on 3/13/2018.
 */

public class TodoListAdapter extends RecyclerView.Adapter<TodoListAdapter.TodoListAdapterViewHolder> {

    private List<Todo> todos;

    //private final TodoListAdapterOnclickHandler clickHandler;
    private View.OnClickListener clickHandler;

   /* public interface TodoListAdapterOnClickHandler {
        void onClick(String chosenTodo);
    }*/

    public TodoListAdapter(List<Todo> todos, View.OnClickListener clickHandler) {

        this.todos = todos;
        this.clickHandler = clickHandler;
    }

    @NonNull
    @Override
    public TodoListAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        return new TodoListAdapterViewHolder(LayoutInflater.from(viewGroup.getContext())
                                            .inflate(R.layout.todo_list_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull TodoListAdapter.TodoListAdapterViewHolder holder, int position) {
        Todo todo = todos.get(position);
        holder.tvTodoListItem.setText(todo.getName());
        holder.itemView.setTag(todo);
        holder.itemView.setOnClickListener(clickHandler);
    }

    @Override
    public int getItemCount() {
        if (todos == null) {
            return 0;
        }
        return todos.size();
    }

    public void addItems(List<Todo> todos) {
        this.todos = todos;
        notifyDataSetChanged();
    }

    public class TodoListAdapterViewHolder extends RecyclerView.ViewHolder {

        private TextView tvTodoListItem;

        TodoListAdapterViewHolder(View itemView) {
            super(itemView);
            tvTodoListItem = (TextView) itemView.findViewById(R.id.tv_todo_list_item);
        }
    }
}
