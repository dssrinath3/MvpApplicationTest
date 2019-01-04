package com.example.srinath.mvpapplicationtest.login;

public interface LoginView {

    void showProgress();
    void hideProgress();
    void setUserNameError();
    void setPwdError();
    void navigateMain();
    void showAlert(String message);

}
