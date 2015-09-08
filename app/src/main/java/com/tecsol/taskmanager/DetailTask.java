package com.tecsol.taskmanager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.tecsol.taskmanager.repository.RepositoryFactory;
import com.tecsol.taskmanager.repository.TaskRepositoryInterface;

/**
 * Created by Sibi on 08/09/15.
 */
public class DetailTask extends Activity{

    private Button delete;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_task);

        Intent intent = getIntent();

        String title = intent.getStringExtra("Title");
        final int id  = intent.getIntExtra("Id" ,0);
        String location = intent.getStringExtra("Location");
        String description = intent.getStringExtra("Description");
        String date = intent.getStringExtra("Date");
        String time = intent.getStringExtra("Time");

        TextView textTitle = (TextView)findViewById(R.id.text_title);
        TextView textId = (TextView)findViewById(R.id.text_id);
        TextView textLocation = (TextView)findViewById(R.id.text_location);
        TextView textDescription = (TextView)findViewById(R.id.text_description);
        TextView textDate = (TextView)findViewById(R.id.text_date);
        TextView textTime = (TextView)findViewById(R.id.text_time);

        textTitle.setText("Title :" + title);
        textId.setText("Id :" + id);
        textDate.setText("Date :" + date);
        textDescription.setText("Description :" + description);
        textLocation.setText("Location :" + location);
        textTime.setText("Time :" + time);

        delete = (Button)findViewById(R.id.button_delete);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                TaskRepositoryInterface taskRepo = RepositoryFactory.getTaskRepo();

              //  taskRepo.delete();

              //  Toast.makeText(getApplicationContext(), "Task Deleted & id:" + task.getId(), Toast.LENGTH_LONG).show();
                finish();
            }
        });






    }
}
