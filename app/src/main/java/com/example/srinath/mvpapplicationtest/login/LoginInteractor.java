package com.example.srinath.mvpapplicationtest.login;

public interface LoginInteractor {

    interface onLoginFinishedListener{
        void onUserNameError();
        void onPwdError();
        void onSuccess();
        void onFailure(String message);

    }

    void loginMethod(String username,String password,onLoginFinishedListener listener);
}
