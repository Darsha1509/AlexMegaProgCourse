package com.example.dasha.homework1;

import android.app.ActivityManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

public class TableLayoutActivity extends SplashScreenActivity implements View.OnClickListener {

    final String LOG_TAG = "myLogs";
    List<ActivityManager.RunningTaskInfo> list;
    ActivityManager am;

    Button btnTableLayoutActivity;
    Button btnMainActivity;
    Button btnInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null) {
            finish();
        }

        setContentView(R.layout.activity_table_layout);
        am = (ActivityManager) getSystemService(ACTIVITY_SERVICE);

        Toast.makeText(this, "TableLayoutActivity is created", Toast.LENGTH_LONG).show();

        btnTableLayoutActivity = (Button) findViewById(R.id.btnTableLayoutActivity);
        btnMainActivity = (Button) findViewById(R.id.btnMainActivity);
        btnInfo = (Button) findViewById(R.id.btnInfo);

        btnTableLayoutActivity.setOnClickListener(this);
        btnMainActivity.setOnClickListener(this);
        btnInfo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch(v.getId()){
            case R.id.btnTableLayoutActivity:
                intent = new Intent(this, TableLayoutActivity.class);
                startActivity(intent);
                break;
            case R.id.btnMainActivity:
                intent = new Intent(this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            case R.id.btnInfo:
                list = am.getRunningTasks(10);
                for(ActivityManager.RunningTaskInfo task : list){
                    if(task.baseActivity.flattenToShortString().startsWith("com.example.dasha.homework1")){
                        Log.d(LOG_TAG, "_ _ _ _ _ _ _ _ _ _ _ _ _ _");
                        //количество Activity
                        Log.d(LOG_TAG, "Count: " + task.numActivities);
                        //корневое Activity
                        Log.d(LOG_TAG, "Root: " + task.baseActivity.flattenToShortString());
                        //верхнее Activity
                        Log.d(LOG_TAG, "Top: " + task.topActivity.flattenToShortString());
                    }
                }
                break;
        }

    }

    @Override
    protected void onStop(){
        super.onStop();
        finish();
    }

}
