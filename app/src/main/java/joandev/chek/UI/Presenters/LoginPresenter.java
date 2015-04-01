package joandev.chek.UI.Presenters;

import joandev.chek.UI.Views.LoginView;

/**
 * Created by joanbarroso on 29/3/15.
 */
public interface LoginPresenter {


    void toggleBetweenSignUpAndSignIn();
    void checkButtonPressed(String username, String password, String confirmPassword);
}
