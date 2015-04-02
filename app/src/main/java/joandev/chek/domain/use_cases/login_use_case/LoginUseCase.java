package joandev.chek.domain.use_cases.login_use_case;

/**
 * Created by joanbarroso on 1/4/15.
 */
public interface LoginUseCase {

    void signIn(String username, String password);
    void signUp(String username, String password, String password_confirmation);
}
