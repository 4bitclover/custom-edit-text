package com.example.customedittext;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText username;
    private EditText email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        email = findViewById(R.id.email);

        email.addTextChangedListener(new EmailInputChangedHandler(email));
        username.addTextChangedListener(new UsernameInputChangeHandler(username));

    }

    private void updateInputIconInView(Drawable drawable, View view) {
        ((EditText) view).setCompoundDrawables(drawable, null, null, null);
    }

    private class EmailInputChangedHandler implements TextWatcher {
        private View view;

        public EmailInputChangedHandler(View view){
            this.view = view;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if(s.length() < 6)
                updateInputIconInView(
                        IconManager.getEmailIcon(
                                getApplicationContext(), IconManager.Colors.RED),
                        this.view);

            if(s.length() == 0)
                updateInputIconInView(
                        IconManager.getEmailIcon(
                                getApplicationContext(), IconManager.Colors.BLACK),
                        this.view);

            if(isEmail(s))
                updateInputIconInView(
                        IconManager.getEmailIcon(
                                getApplicationContext(), IconManager.Colors.GREEN),
                        this.view);
        }

        private boolean isEmail(CharSequence s) {
            return String.valueOf(s).contains("@");
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    }

    private class UsernameInputChangeHandler implements TextWatcher {
        private View view;
        public UsernameInputChangeHandler(View view) {
            this.view = view;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if(s.length() < 3)
                updateInputIconInView(
                        IconManager.getProfileIcon(
                                getApplicationContext(), IconManager.Colors.RED),
                        this.view);
            if(s.length() == 0)
                updateInputIconInView(
                        IconManager.getProfileIcon(
                                getApplicationContext(), IconManager.Colors.BLACK),
                        this.view);
            if(verifiedUsername(s))
                updateInputIconInView(
                        IconManager.getProfileIcon(
                                getApplicationContext(), IconManager.Colors.GREEN),
                        this.view);
        }

        private boolean verifiedUsername(CharSequence s) {
            String usernameInDatabase = "fourbitclover";
            return String.valueOf(s).trim().equals(usernameInDatabase);
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    }
}
