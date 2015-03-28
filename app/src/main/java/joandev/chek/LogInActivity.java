package joandev.chek;

import android.provider.SyncStateContract;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import joandev.chek.Model.User;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class LogInActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        User user = new User("joan@gmail.com", "devpass");
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("http://22d6a49d.ngrok.com")  //call your base url
                .build();

        LogInService mylogin = restAdapter.create(LogInService.class); //this is how retrofit create your api
        mylogin.login(user,  new Callback<String>() {
            @Override
            public void success(String s, Response response) {
                //process your response if login successfull you can call Intent and launch your main activity
                Toast.makeText(getApplicationContext(),"DONEEEEEEE", Toast.LENGTH_LONG).show();
            }

            @Override
            public void failure(RetrofitError retrofitError) {
                Toast.makeText(getApplicationContext(),"T_T", Toast.LENGTH_LONG).show();
                retrofitError.printStackTrace(); //to see if you have errors

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_log_in, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
