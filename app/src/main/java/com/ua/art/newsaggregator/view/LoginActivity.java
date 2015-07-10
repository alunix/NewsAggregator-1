package com.ua.art.newsaggregator.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.ua.art.newsaggregator.R;

public class LoginActivity extends ActionBarActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    private EditText mLogin_editText;
    private EditText mPassword_editText;

    public static final String APP_PREFERENCES = "mySettings";
    public static final String APP_PREFERENCES_LOGIN = "login";
    public static final String APP_PREFERENCES_PASSWORD = "password";
    private SharedPreferences mSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);
        getSupportActionBar().hide();

        mLogin_editText = (EditText) findViewById(R.id.login_edit);
        mPassword_editText = (EditText) findViewById(R.id.password_edit);
        ((CheckBox) findViewById(R.id.show_password_check)).setOnCheckedChangeListener(this);
        findViewById(R.id.login_button).setOnClickListener(this);

        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_button: {
                onLoginButton();
            }
        }
    }

    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    private boolean isFieldsValid() {
        if (mLogin_editText.getText().toString().isEmpty()) {
            mLogin_editText.setError(getString(R.string.error_fill_field));
            return false;
        }
        if (mPassword_editText.getText().toString().isEmpty()) {
            mPassword_editText.setError(getString(R.string.error_fill_field));
            return false;
        }
        return true;
    }

    private void onLoginButton() {
        if (isFieldsValid()) {
            String login = mLogin_editText.getText().toString();
            String password = mPassword_editText.getText().toString();

            // add preferences login and pass
            if (!mSettings.contains(APP_PREFERENCES_LOGIN)){
                SharedPreferences.Editor editor = mSettings.edit();
                editor.putString(APP_PREFERENCES_LOGIN, String.valueOf(mLogin_editText));
                editor.putString(APP_PREFERENCES_PASSWORD, String.valueOf(mPassword_editText));
                editor.apply();

                Toast toast = Toast.makeText(getApplicationContext(), "save login", Toast.LENGTH_SHORT);
                toast.show();
                setResult(RESULT_OK);
            }
            else {
                if (mSettings.contains(APP_PREFERENCES_PASSWORD)){
                    Toast toast = Toast.makeText(getApplicationContext(), "input login", Toast.LENGTH_SHORT);
                    toast.show();
                    setResult(RESULT_OK);
//                    finish();
                }
                else {
                    mPassword_editText.setError(getString(R.string.error_fill_field));
                    Toast toast = Toast.makeText(getApplicationContext(), "error password", Toast.LENGTH_SHORT);
                    return;
                }
            }
        //    try {
              //  new LoginService(LoginActivity.this, Constants.LOGIN, login, password).authorization();
//            setResult(RESULT_OK);
            finish();
//            } catch (JSONException | NoSuchAlgorithmException | IOException e) {
//                e.printStackTrace();
//            }
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        String temporary_stored_text = mPassword_editText.getText().toString().trim();
        if (isChecked) {
            mPassword_editText.setText(temporary_stored_text);
            mPassword_editText.setTransformationMethod(null);
        } else {
            mPassword_editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }
}
