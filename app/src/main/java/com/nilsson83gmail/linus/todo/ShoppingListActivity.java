package com.nilsson83gmail.linus.todo;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.nilsson83gmail.linus.todo.models.Todo;
import com.nilsson83gmail.linus.todo.viewModels.AddTodoViewModel;

public class ShoppingListActivity extends AppCompatActivity {

    private EditText name;
    private EditText text;

    private AddTodoViewModel addTodoViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_list);

        name = findViewById(R.id.etName);
        text = findViewById(R.id.etText);

        addTodoViewModel = ViewModelProviders.of(this).get(AddTodoViewModel.class);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (name.getText() == null || text.getText() == null) {
                    Toast.makeText(ShoppingListActivity.this, "Missing fields!", Toast.LENGTH_SHORT).show();
                } else {
                    addTodoViewModel.addTodo(new Todo(
                            name.getText().toString(),
                            text.getText().toString()
                    ));
                    finish();
                }
            }
        });

    }
}
