package com.tecsol.taskmanager.repository;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.tecsol.taskmanager.DetailTask;
import com.tecsol.taskmanager.R;
import com.tecsol.taskmanager.model.Task;

import java.util.List;

/**
 * Created by Aaditya on 9/7/2015.
 */
public class CustomTaskAdapter extends ArrayAdapter<Task> {

    private Context context;
    private Task task =  new Task();
    private List<Task> tasks;

    public CustomTaskAdapter(Context context, int resource, List<Task> tasks) {
        super(context, resource, tasks);

        this.context = context;
        this.tasks = tasks;

    }

    public View getView (int position, View view, ViewGroup parent) {

        final Task task = tasks.get(position);

        LayoutInflater inflater =(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View taskView=inflater.inflate(R.layout.custom_layout, null, false);

        TextView title = (TextView) taskView.findViewById(R.id.textView);
        ImageView image = (ImageView)taskView.findViewById(R.id.imageView);

        title.setText("Task :" + task.getTitle() + "ID :" + task.getId());
        image.setImageResource(R.drawable.imgage);

        title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getContext(), DetailTask.class);
                intent.putExtra("Title", task.getTitle());
                intent.putExtra("Id", task.getId());
                intent.putExtra("Location", task.getLocation());
                intent.putExtra("Description", task.getDescription());
                intent.putExtra("Date", task.getDate());
                intent.putExtra("Time", task.getTime());
                context.startActivity(intent);
                Toast.makeText(getContext(), "started", Toast.LENGTH_SHORT).show();

            }
        });

        return taskView;
    }

}

