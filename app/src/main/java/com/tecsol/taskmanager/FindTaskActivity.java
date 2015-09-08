package com.tecsol.taskmanager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FindTaskActivity extends AppCompatActivity {

    private Button buttonFind;
    private TextView textId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_task);

        buttonFind = (Button)findViewById(R.id.button_find);
        textId = (TextView)findViewById(R.id.text_id);

        buttonFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               // Task.find(textId);
            }
        });

    }

}
