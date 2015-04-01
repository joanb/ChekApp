package joandev.chek.API;

import org.json.JSONObject;

import joandev.chek.Model.User;
import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.Field;
import retrofit.http.POST;
import retrofit.http.Query;

/**
 * Created by joanbarroso on 28/3/15.
 */
public interface ApiInterface {
    @POST("/user")
    void login(@Body User body, Callback<String> callback);

}
