package joandev.chek.data.api;

import joandev.chek.domain.model.User;
import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.POST;

/**
 * Created by joanbarroso on 28/3/15.
 */
public interface ApiInterface {
    @POST("/user")
    void login(@Body User body, Callback<String> callback);

}
