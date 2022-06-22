package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.todolist.Utils.DatabaseHelper;

public class EditActivity extends AppCompatActivity {

    EditText task;
    Button btnUpdate;
    DatabaseHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        task = findViewById(R.id.task);
        btnUpdate = findViewById(R.id.btnUpdate);

        getSupportActionBar().setTitle("Edit Task");

        task.setText(getIntent().getStringExtra("TASK"));

        myDB = new DatabaseHelper(getApplicationContext());

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDB.updateTask(getIntent().getIntExtra("ID", 0), task.getText().toString());

                Toast.makeText(getApplicationContext(), "Task berhasil diubah",
                        Toast.LENGTH_SHORT).show();

                finish();
            }
        });
    }
}