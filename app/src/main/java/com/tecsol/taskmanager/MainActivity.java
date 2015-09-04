package com.tecsol.taskmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn_add, btn_list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_add=(Button)findViewById(R.id.button_add);
        btn_list=(Button)findViewById(R.id.button_list);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent fp=new Intent(getApplicationContext(),AddTaskActivity.class);
                startActivity(fp);
            }
        });

        btn_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent fp=new Intent(getApplicationContext(),ListTaskActivity.class);
                startActivity(fp);
            }
        });
    }


}
