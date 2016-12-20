package org.esiea.chhuon.schedule;

//import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
//import android.widget.CheckBox;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.view.View;
import android.app.DialogFragment;

import org.esiea.chhuon.schedule.db.TaskContract;
import org.esiea.chhuon.schedule.db.TaskDbHelper;

import java.util.ArrayList;

/**
 * Created by admin on 19/11/2016.
 */

public class CreateTaskActivity extends AppCompatActivity {

    /*private TaskDbHelper mHelper;
    private ListView mTaskListView;
    private ArrayAdapter<String> mAdapter;*/
    private SeekBar seekBar;
    private TextView textView;
    private TextView task_title;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_task);
        initializeVariables();

        /*
        mHelper = new TaskDbHelper(this);
        mTaskListView = (ListView) findViewById(R.id.list_todo);
        updateUI();*/

        Toolbar toolbar =   (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);

        //On affiche l'état de la scroll bar
        textView.setText("Vous allouez: " + seekBar.getProgress()*5 + "mn");

        seekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            int progress = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) {
                progress = progresValue;
                //Toast.makeText(getApplicationContext(), "Changing seekbar's progress", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //Toast.makeText(getApplicationContext(), "Started tracking seekbar", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                textView.setText("Vous allouez: " + progress*5 + "mn");
                Toast.makeText(getApplicationContext(), "Modification complete", Toast.LENGTH_SHORT).show();
            }
        });
    }
    // A private method to help us initialize our variables.
    private void initializeVariables() {
        seekBar = (SeekBar) findViewById(R.id.seekBar4);
        textView = (TextView) findViewById(R.id.textView5);
        task_title = (TextView) findViewById(R.id.task_title);
    }

    public void onButtonStartClicked(View v){
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getFragmentManager(),"TimePicker");
    }

    /*
    public void onButtonDoneClicked(View v){
        SQLiteDatabase db = mHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        String task = task_title.getText().toString();
        values.put(TaskContract.TaskEntry.COL_TASK_TITLE, task);
        //values.put()
        db.insertWithOnConflict(TaskContract.TaskEntry.TABLE,
                null,
                values,
                SQLiteDatabase.CONFLICT_REPLACE);
        db.close();
        //updateUI();
    }
    */


    public void onButtonCancelClicked(View v){
        this.finish();
    }
    /*private void updateUI() {
        ArrayList<String> taskList = new ArrayList<>();
        SQLiteDatabase db = mHelper.getReadableDatabase();
        Cursor cursor = db.query(TaskContract.TaskEntry.TABLE,
                new String[]{TaskContract.TaskEntry._ID, TaskContract.TaskEntry.COL_TASK_TITLE},
                null, null, null, null, null);
        while (cursor.moveToNext()) {
            int idx = cursor.getColumnIndex(TaskContract.TaskEntry.COL_TASK_TITLE);
            taskList.add(cursor.getString(idx));
        }

        if (mAdapter == null) {
            mAdapter = new ArrayAdapter<>(this,
                    R.layout.item_todo,
                    R.id.task_title,
                    taskList);
            mTaskListView.setAdapter(mAdapter);
        } else {
            mAdapter.clear();
            mAdapter.addAll(taskList);
            mAdapter.notifyDataSetChanged();
        }

        cursor.close();
        db.close();
    }*/

    //Reading titlefield
        //final EditText titleField = (EditText) findViewById(R.id.editText);
        //String title = titleField.getText().toString();

        //Reading Checkbox
        //final CheckBox responseCheckbox = (CheckBox) findViewById(R.id.checkBox);
        //boolean bRequiresResponse = responseCheckbox.isChecked();
}
