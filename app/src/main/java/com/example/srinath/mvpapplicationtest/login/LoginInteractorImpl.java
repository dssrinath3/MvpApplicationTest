package com.example.srinath.mvpapplicationtest.login;

import android.text.TextUtils;

public class LoginInteractorImpl implements LoginInteractor {
    @Override
    public void loginMethod(String username, String password, onLoginFinishedListener listener) {
        if (TextUtils.isEmpty(username)){
            listener.onUserNameError();
        }else
        if (TextUtils.isEmpty(password)){
            listener.onPwdError();
        }else if(username.equals("admin") && password.equals("12345")){
            listener.onSuccess();

        }else {
            listener.onFailure("Invalid credentials");
        }
    }
}
