package com.example.srinath.mvpapplicationtest.login;

public interface LoginPresenter  {
    void validateCredentials(String user,String pwd);
    void onDestroy();
}
