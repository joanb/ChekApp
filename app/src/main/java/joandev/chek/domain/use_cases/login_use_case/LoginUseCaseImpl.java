package joandev.chek.domain.use_cases.login_use_case;

import joandev.chek.data.api.ApiInterface;
import joandev.chek.domain.model.User;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by joanbarroso on 1/4/15.
 */
public class LoginUseCaseImpl implements LoginUseCase {

    public LoginUseCaseImpl(){}







    @Override
    public void signIn(String username, String password) {

    }

    @Override
    public void signUp(String username, String password, String password_confirmation) {
        User user = new User(username, password);
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("http://1714f48c.ngrok.com")  //call your base url
                .build();

        ApiInterface mylogin = restAdapter.create(ApiInterface.class); //this is how retrofit create your api
        mylogin.login(user, new Callback<String>() {
            @Override
            public void success(String s, Response response) {
                //process your response if login successfull you can call Intent and launch your main activity
            }

            @Override
            public void failure(RetrofitError retrofitError) {
                retrofitError.printStackTrace(); //to see if you have errors

            }
        });

    }
}
