package com.example.yzj.navigationviewtest.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.yzj.navigationviewtest.R;

public class LoginActivity extends AppCompatActivity {

    private AutoCompleteTextView mEmailView;
    private EditText mPasswordView;
    private View mLoginFormView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEmailView = (AutoCompleteTextView) findViewById(R.id.email);
        mPasswordView = (EditText) findViewById(R.id.password);

        getUserInfo();

        Button mEmailSignInButton = (Button) findViewById(R.id.email_sign_in_button);
        //登录
        mEmailSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Editable emailText = mEmailView.getText();
                Editable passwordText = mPasswordView.getText();
                //跳转主页面
                attemptLogin(emailText, passwordText);
            }
        });

        mLoginFormView = findViewById(R.id.login_form);
    }

    //登录
    private void attemptLogin(Editable emailText, Editable passwordText) {
        if (isEmailValid(emailText.toString()) == true && isPasswordValid(passwordText.toString()) == true){
            saveUserInfo();
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("email", emailText.toString());
            startActivityForResult(intent,MainActivity.Request_Code_Main);
        } else if (isEmailValid(emailText.toString()) == false) {
            Toast.makeText(LoginActivity.this, "邮箱格式不正确！", Toast.LENGTH_SHORT).show();
        } else if (isPasswordValid(passwordText.toString()) == false) {
            Toast.makeText(LoginActivity.this, "密码不能小于4位！", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean isEmailValid(String email) {
        return email.contains("@");
    }

    private boolean isPasswordValid(String password) {
        return password.length() > 4;
    }

    /**
     * 保存用户登录信息
     */
    private void saveUserInfo(){
        SharedPreferences userInfo = getSharedPreferences("data", MODE_PRIVATE);
        SharedPreferences.Editor editor = userInfo.edit();
        editor.putString("email", mEmailView.getText().toString());
        editor.putString("password", mPasswordView.getText().toString());
        editor.commit();
    }

    /**
     * 读取用户信息
     */
    private void getUserInfo(){
        SharedPreferences userInfo = getSharedPreferences("data", MODE_PRIVATE);
        String email = userInfo.getString("email", null);
        String password = userInfo.getString("password", null);
        mEmailView.setText(email);
        mPasswordView.setText(password);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == MainActivity.Request_Code_Main){
        //if(requestCode == MainActivity.Request_Code_Main && resultCode == MainActivity.Result_Code_Main){
            //String s = data.getStringExtra("count"); //获取Intent传过来的值
            //Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}

