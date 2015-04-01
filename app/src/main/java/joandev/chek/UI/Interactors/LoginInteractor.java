package joandev.chek.UI.Interactors;

import joandev.chek.UI.Views.LoginView;

/**
 * Created by joanbarroso on 1/4/15.
 */
public interface LoginInteractor {

    void signIn(String username, String password);
    void signUp(String username, String password, String password_confirmation);
}
