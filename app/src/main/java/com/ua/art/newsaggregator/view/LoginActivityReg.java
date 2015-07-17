package com.ua.art.newsaggregator.view;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.ua.art.newsaggregator.Preferences;
import com.ua.art.newsaggregator.R;

import org.w3c.dom.Text;

public class LoginActivityReg extends ActionBarActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    private EditText mLogin_editText_Reg;
    private EditText mEmail_editText_Reg;
    private EditText mPassword_editText_Reg;
    private Text mLogin_inputText_Reg;
    private static final int LOGIN_ACTIVITY = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login_reg);
        getSupportActionBar().hide();

        mLogin_editText_Reg = (EditText) findViewById(R.id.login_edit_reg);
        mEmail_editText_Reg = (EditText) findViewById(R.id.email_edit_reg);
        mPassword_editText_Reg = (EditText) findViewById(R.id.password_edit);

        ((CheckBox) findViewById(R.id.show_password_check_reg)).setOnCheckedChangeListener(this);
        findViewById(R.id.login_button_reg).setOnClickListener(this);
        findViewById(R.id.loginInput).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_button_reg:
                onLoginButtonReg();
            case R.id.loginInput:
                this.setVisible(false);
                onLoginButtonInput();

        }
    }

    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    private boolean isFieldsValid() {
        if (mLogin_editText_Reg.getText().toString().isEmpty()) {
            mLogin_editText_Reg.setError(getString(R.string.error_fill_field));
            return false;
        }
        if (mPassword_editText_Reg.getText().toString().isEmpty()) {
            mPassword_editText_Reg.setError(getString(R.string.error_fill_field));
            return false;
        }
        return true;
    }

    private void onLoginButtonInput() {
        startActivityForResult(new Intent(this, LoginActivity.class), LOGIN_ACTIVITY);
    }

    private void onLoginButtonReg() {
        if (isFieldsValid()) {
            String loginReg = mLogin_editText_Reg.getText().toString();
            String passwordReg = mPassword_editText_Reg.getText().toString();

            Preferences.saveLogin(loginReg);
            Preferences.savePassword(passwordReg);
            Toast toast = Toast.makeText(getApplicationContext(), Preferences.getLogin(), Toast.LENGTH_SHORT);
            toast.show();

            //    try {
            //  new LoginService(LoginActivity.this, Constants.LOGIN, login, password).authorization();
            setResult(RESULT_OK);
            finish();
//            } catch (JSONException | NoSuchAlgorithmException | IOException e) {
//                e.printStackTrace();
//            }
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        String temporary_stored_text = mPassword_editText_Reg.getText().toString().trim();
        if (isChecked) {
            mPassword_editText_Reg.setText(temporary_stored_text);
            mPassword_editText_Reg.setTransformationMethod(null);
        } else {
            mPassword_editText_Reg.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }
}
