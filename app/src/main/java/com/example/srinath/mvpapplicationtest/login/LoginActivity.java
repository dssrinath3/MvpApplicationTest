package com.example.srinath.mvpapplicationtest.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.srinath.mvpapplicationtest.MainActivity;
import com.example.srinath.mvpapplicationtest.R;

public class LoginActivity extends AppCompatActivity implements LoginView {

    private EditText edUserName,edPassword;
    private Button btnLogin;
    private ProgressBar progressBar;
    private LoginPresenter mLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edUserName = findViewById(R.id.username);
        edPassword = findViewById(R.id.password);
        btnLogin = findViewById(R.id.button);
        progressBar = findViewById(R.id.progressbar);

        mLoginPresenter = new LoginPresenterImpl(this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLoginPresenter.validateCredentials(edUserName.getText().toString(),edPassword.getText().toString());
            }
        });

    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void setUserNameError() {
        edUserName.setError("Username Empty");
    }

    @Override
    public void setPwdError() {
        edPassword.setError("Pwd Empty");
    }

    @Override
    public void navigateMain() {
        Intent in= new Intent(this, MainActivity.class);
        startActivity(in);
    }

    @Override
    public void showAlert(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mLoginPresenter.onDestroy();
    }
}
