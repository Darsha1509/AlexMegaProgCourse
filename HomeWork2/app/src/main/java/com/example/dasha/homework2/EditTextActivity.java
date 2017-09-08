package com.example.dasha.homework2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class EditTextActivity extends AppCompatActivity implements View.OnKeyListener, TextWatcher{

    EditText etThree;
    EditText etFive;
    EditText etFour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text);
        setTitle(getResources().getString(R.string.app_name) + " : " + getLocalClassName());

        etThree = (EditText) findViewById(R.id.etThree);
        etFive = (EditText) findViewById(R.id.etFive);
        etFour = (EditText) findViewById(R.id.etFour);

        etFive.setOnKeyListener(this);
        etFour.addTextChangedListener(this);

        //EditText 3 фильтр на первую букву
        InputFilter filter = new InputFilter() {
            public CharSequence filter(CharSequence source, int start, int end,
                                       Spanned dest, int dstart, int dend) {
                for (int i = start; i < end; i++) {
                    if (Character.isDigit(source.charAt(i)) && dstart == 0) {
                        Toast.makeText(EditTextActivity.this, "Invalid Input", Toast.LENGTH_SHORT).show();
                        return "";
                    }
                }
                return null;
            }
        };
        etThree.setFilters(new InputFilter[] { filter });

    }




    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        switch (v.getId()) {
            case R.id.etFour:


            case R.id.etFive:
            if (event.getAction() == KeyEvent.ACTION_DOWN &&
                    (keyCode == KeyEvent.KEYCODE_ENTER)) {
                // сохраняем текст, введенный до нажатия Enter в переменную
                String strFive = etFive.getText().toString();
                Toast.makeText(this, strFive, Toast.LENGTH_SHORT).show();
                return true;

            }
                break;
        }
        return false;
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {
        String strFour = etFour.getText().toString();
        Toast.makeText(this, strFour, Toast.LENGTH_SHORT).show();
    }
}

