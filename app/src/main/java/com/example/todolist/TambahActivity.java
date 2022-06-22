package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.todolist.Model.ToDoModel;
import com.example.todolist.Utils.DatabaseHelper;

public class TambahActivity extends AppCompatActivity {

    DatabaseHelper myDb;
    EditText etTask;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);

        etTask = findViewById(R.id.task);
        btnSave = findViewById(R.id.btnSave);

        getSupportActionBar().setTitle("Tambah Task");

        myDb = new DatabaseHelper(getApplicationContext());

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToDoModel item = new ToDoModel();
                item.setTask(etTask.getText().toString());
                item.setStatus(0);
                myDb.insertTask(item);

                Toast.makeText(getApplicationContext(), "Task berhasil ditambahkan",
                        Toast.LENGTH_SHORT).show();

                finish();
            }
        });
    }
}