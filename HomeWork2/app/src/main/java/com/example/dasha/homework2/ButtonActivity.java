package com.example.dasha.homework2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.Toast;

public class ButtonActivity extends AppCompatActivity implements View.OnClickListener,
        SeekBar.OnSeekBarChangeListener, CompoundButton.OnCheckedChangeListener {
    Button btn1;
    Button btn2;
    Button btn3;

    CheckBox cbFirst;
    CheckBox cbSecond;

    SeekBar seekBar;

    Switch swch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);
        setTitle(getResources().getString(R.string.app_name) + " : " + getLocalClassName());

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);

        cbFirst = (CheckBox) findViewById(R.id.cbFirst);
        cbSecond = (CheckBox) findViewById(R.id.cbSecond);

        cbFirst.setOnClickListener(this);

        seekBar = (SeekBar) findViewById(R.id.seekBar);

        seekBar.setOnSeekBarChangeListener(this);

        swch = (Switch) findViewById(R.id.swch);
        swch.setOnCheckedChangeListener(this);

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btn1:
                if(btn2.getVisibility() == View.INVISIBLE) {
                    btn2.setVisibility(View.VISIBLE);
                } else {
                    btn2.setVisibility(View.INVISIBLE);
                }
                break;
            case R.id.btn2:
                if(btn3.getVisibility() == View.GONE) {
                    btn3.setVisibility(View.VISIBLE);
                } else {
                    btn3.setVisibility(View.GONE);
                }
                break;
            case R.id.cbFirst:
                if(!cbSecond.isChecked()){
                    cbSecond.setChecked(true);
                }else {
                    cbSecond.setChecked(false);
                }

        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        Toast.makeText(this, String.valueOf(seekBar.getProgress()), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if(swch.isChecked()){
            Toast.makeText(this, "On", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Off", Toast.LENGTH_SHORT).show();
        }
    }
}
