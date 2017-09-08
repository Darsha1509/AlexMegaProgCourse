package com.example.dasha.homework2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnEditText;
    Button btnTextView;
    Button btnButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(getResources().getString(R.string.app_name) + " : " + getLocalClassName());

        btnEditText = (Button) findViewById(R.id.btnEditText);
        btnTextView = (Button) findViewById(R.id.btnTextView);
        btnButton = (Button) findViewById(R.id.btnButton);

        btnEditText.setOnClickListener(this);
        btnTextView.setOnClickListener(this);
        btnButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent;

        switch (view.getId()) {
            case R.id.btnEditText:
                intent = new Intent(this, EditTextActivity.class);
                startActivity(intent);
                break;

            case R.id.btnTextView:
                intent = new Intent(this, TextViewActivity.class);
                startActivity(intent);
                break;

            case R.id.btnButton:
                intent = new Intent(this, ButtonActivity.class);
                startActivity(intent);
                break;
        }
    }
}
