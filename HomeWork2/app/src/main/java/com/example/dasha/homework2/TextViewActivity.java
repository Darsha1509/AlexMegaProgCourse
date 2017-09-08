package com.example.dasha.homework2;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ImageSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class TextViewActivity extends AppCompatActivity {
    TextView tvSpan;
    TextView tvLink;
    TextView tvValid;
    TextView tvImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view);
        setTitle(getResources().getString(R.string.app_name) + " : " + getLocalClassName());

        // 1. TextView отображает подчеркнутый и жирный текст
        tvSpan = (TextView) findViewById(R.id.tvSpan);

        Spannable text = new SpannableString("This is underline and bold text.");
        text.setSpan(new UnderlineSpan(), 8, 17, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        text.setSpan(new StyleSpan(Typeface.BOLD), 22, 26, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        tvSpan.setText(text);


        //2. TextView ссылка вызывает Toast c текстом в TextView
        tvLink = (TextView) findViewById(R.id.tvLink);

        SpannableString ss = new SpannableString("It's a link");


        ClickableSpan clickableSpan = new ClickableSpan() {

            @Override
            public void onClick(View textView) {
                String str = tvLink.getText().toString();
                Toast.makeText(TextViewActivity.this, str, Toast.LENGTH_LONG).show();
            }
            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setUnderlineText(false);
            }
        };

        ss.setSpan(clickableSpan, 7, 11, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(new UnderlineSpan(), 7, 11, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);



        tvLink.setText(ss);
        tvLink.setMovementMethod(LinkMovementMethod.getInstance());
        tvLink.setHighlightColor(Color.TRANSPARENT);

        //3. TextView прверяет на валидность почтового адреса введенный контент в TextView
        tvValid = (TextView) findViewById(R.id.tvValid);
        String email = tvValid.getText().toString();
        String isValidEmail = isValidEmail(email);
        tvValid.setError(isValidEmail);

        //Toast.makeText(this, isValidEmail, Toast.LENGTH_LONG).show();

        //4.TextView вставляем иконку в середину текста
        SpannableString imageText = new SpannableString(getResources().getString(R.string.image_text));
        insertSmiles(imageText , 0, 1);
        tvImage = (TextView) findViewById(R.id.tvImage);
        tvImage.setText(imageText);

        //5.TextView

    }

    //проверяет email на валидность
    public final static String isValidEmail(CharSequence target) {
        if (!TextUtils.isEmpty(target) && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches()){
            return null;
        }
        return "It's not a valid email";
    }

    //вставляет иконку в SpannableString текст
    void insertSmiles(SpannableString text, int pos, int len) {
        ImageSpan is = new ImageSpan(this, R.drawable.bicycle,
                ImageSpan.ALIGN_BASELINE);
        text.setSpan(is, pos, pos+len, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
    }
}
