package joandev.chek.UI.Implementations;

import joandev.chek.UI.Interactors.LoginInteractor;
import joandev.chek.UI.Presenters.LoginPresenter;
import joandev.chek.UI.Views.LogInActivity;
import joandev.chek.UI.Views.LoginView;

/**
 * Created by joanbarroso on 29/3/15.
 */
public class PresenterImpl implements LoginPresenter {

    LoginView view;
    LoginInteractor interactor;
    boolean signInMode;


    public PresenterImpl(LoginView view) {
        signInMode =  true;
        this.view = view;
    }


    @Override
    public void toggleBetweenSignUpAndSignIn() {
        if (signInMode) {
            view.activateSignUpMode();
            signInMode = false;
        }
        else {
            view.activateSignInMode();
            signInMode =  true;
        }
    }

    @Override
    public void checkButtonPressed(String username, String password, String confirmPassword) {
        if (signInMode)
            interactor.signIn(username, password);
        else{
            if (confirmPassword == password)
                interactor.signUp(username,password,confirmPassword);
            else view.notifyPasswordMismatch();
        }
    }
}
