package joandev.chek.Model;

/**
 * Created by joanbarroso on 28/3/15.
 */
public class User {
    String email;
    String password;
    String confirmPassword;

    public  User (String email, String password) {
        this.email = email;
        this.password = password;
        this.confirmPassword = password;
    }
}
