package com.tecsol.taskmanager;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TimePicker;
import android.widget.Toast;

import com.tecsol.taskmanager.model.Task;
import com.tecsol.taskmanager.repository.RepositoryFactory;
import com.tecsol.taskmanager.repository.TaskRepositoryInterface;

import java.util.Calendar;

public class AddTaskActivity extends AppCompatActivity {

    private EditText edtTitle;
    private EditText edtDescription;
    private EditText edtId;
    private EditText edtLocation;
    private EditText edtDate;
    private EditText edtTime;
    private Button btSave;
    private static int id = 1;
    private ImageButton dateButton;
    private ImageButton timeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        edtTitle = ((EditText) findViewById(R.id.text_title));
        edtDescription = (EditText) findViewById(R.id.text_description);
        //edtId           = (EditText)findViewById(R.id.text_id);
        edtDate = (EditText) findViewById(R.id.text_date);
        edtLocation = (EditText) findViewById(R.id.text_location);
        edtTime = (EditText) findViewById(R.id.text_time);

        btSave = (Button) findViewById(R.id.button_save);

        dateButton = (ImageButton) findViewById(R.id.image_button1);
        timeButton = (ImageButton) findViewById(R.id.image_button2);

        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                alertDialogDatePicker();
            }
        });

        timeButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                alertDialogTimePicker();
            }
        });


        btSave.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                saveTask();
            }
        });
    }

    private void saveTask() {
        if (isDateValid() && isTimeValid()) {

            String title = edtTitle.getText().toString();
            String description = edtDescription.getText().toString();
            //String id = edtId.getText().toString();
            String date = edtDate.getText().toString();
            String location = edtLocation.getText().toString();
            String time = edtTime.getText().toString();


            Task task = new Task();
            task.setTitle(title);
            task.setDate(date);
            task.setDescription(description);
            task.setTime(time);
            task.setLocation(location);
            task.setId(id++);


            TaskRepositoryInterface taskRepo = RepositoryFactory.getTaskRepo();

            taskRepo.insert(task);

            Toast.makeText(AddTaskActivity.this, "Task saved", Toast.LENGTH_LONG).show();

        } else alertDialogError();
    }

    private void alertDialogDatePicker() {

        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.date_picker, null, false);

        final DatePicker myDatePicker = (DatePicker) view.findViewById(R.id.myDatePicker);

        myDatePicker.setCalendarViewShown(false);

        new AlertDialog.Builder(AddTaskActivity.this).setView(view)
                .setTitle("Set Date")
                .setPositiveButton("Go", new DialogInterface.OnClickListener() {
                    @TargetApi(22)
                    public void onClick(DialogInterface dialog, int id) {

                        int month = myDatePicker.getMonth() + 1;
                        int day = myDatePicker.getDayOfMonth();
                        int year = myDatePicker.getYear();

                        edtDate.setText(day + "-" + month + "-" + year);

                        Toast.makeText(AddTaskActivity.this, "Date Selected", Toast.LENGTH_LONG).show();

                        dialog.cancel();

                    }

                }).show();
    }

    private void alertDialogTimePicker() {

        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.time_picker, null, false);

        final TimePicker myTimePicker = (TimePicker) view
                .findViewById(R.id.myTimePicker);

        new AlertDialog.Builder(AddTaskActivity.this).setView(view).setTitle("Set Time").setPositiveButton("Go", new DialogInterface.OnClickListener() {
            @TargetApi(22)
            public void onClick(DialogInterface dialog, int id) {

                int hourText = myTimePicker.getHour();

                int minuteText = myTimePicker.getMinute();

                edtTime.setText(hourText + ":" + minuteText);


                Toast.makeText(AddTaskActivity.this, "Time Selected", Toast.LENGTH_LONG).show();

                dialog.cancel();

            }

        }).show();
    }

    private boolean isDateValid() {

        boolean isNotValid = edtDate.getText() == null || edtDate.getText().equals("");

        return !isNotValid;
    }

    private boolean isTimeValid() {

        boolean isNotValid = edtTime.getText() == null || edtTime.getText().equals("");

        return !isNotValid;
    }

    public void alertDialogError() {

        new AlertDialog.Builder(AddTaskActivity.this).setTitle("Error").setMessage("Please Enter valid Details").setPositiveButton("Try Again", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        }).show();
    }
}

