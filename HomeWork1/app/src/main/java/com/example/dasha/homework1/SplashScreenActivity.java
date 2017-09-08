package com.example.dasha.homework1;

import android.app.ActivityManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class SplashScreenActivity extends AppCompatActivity implements View.OnClickListener{

    final String LOG_TAG = "myLogs";
    List<ActivityManager.RunningTaskInfo> list;
    ActivityManager am;


    Button btnMainActivity;
    Button btnInfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.splash_screen_activity);
        setTitle(getResources().getString(R.string.app_name) + " : " + getLocalClassName());
        am = (ActivityManager) getSystemService(ACTIVITY_SERVICE);

        btnMainActivity = (Button)findViewById(R.id.btnMainActivity);
        btnInfo = (Button) findViewById(R.id.btnInfo);

        btnMainActivity.setOnClickListener(this);
        btnInfo.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btnMainActivity:
                Intent intent = new Intent(this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                break;
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
}


