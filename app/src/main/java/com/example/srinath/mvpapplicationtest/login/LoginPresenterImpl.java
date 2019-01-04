package com.example.srinath.mvpapplicationtest.login;

public class LoginPresenterImpl implements LoginPresenter,LoginInteractor.onLoginFinishedListener {

    LoginView mLoginView;
    LoginInteractor mLoginInteractor;


    public LoginPresenterImpl(LoginView mLoginView) {
        this.mLoginView = mLoginView;
        mLoginInteractor = new LoginInteractorImpl();
    }

    @Override
    public void validateCredentials(String user, String pwd) {
        if (mLoginView!=null){
            mLoginView.showProgress();
            mLoginInteractor.loginMethod(user,pwd,this);
        }

    }

    @Override
    public void onDestroy() {

        if (mLoginView!=null){
            mLoginView =null;
        }

    }

    @Override
    public void onUserNameError() {
        if (mLoginView!=null){
           mLoginView.hideProgress();
           mLoginView.setUserNameError();
        }
    }

    @Override
    public void onPwdError() {
        if (mLoginView!=null){
            mLoginView.hideProgress();
            mLoginView.setPwdError();
        }
    }

    @Override
    public void onSuccess() {
        if (mLoginView!=null){
            mLoginView.hideProgress();
            mLoginView.navigateMain();
        }
    }

    @Override
    public void onFailure(String message) {
        if (mLoginView!=null){
            mLoginView.hideProgress();
            mLoginView.showAlert(message);
        }
    }
}
