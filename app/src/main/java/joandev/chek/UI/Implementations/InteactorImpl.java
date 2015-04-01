package joandev.chek.UI.Implementations;

import android.widget.Toast;

import joandev.chek.API.ApiInterface;
import joandev.chek.Model.User;
import joandev.chek.UI.Interactors.LoginInteractor;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by joanbarroso on 1/4/15.
 */
public class InteactorImpl implements LoginInteractor {

    public InteactorImpl (){}







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
