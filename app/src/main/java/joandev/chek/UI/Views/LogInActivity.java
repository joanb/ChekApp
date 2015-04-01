package joandev.chek.UI.Views;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import joandev.chek.R;
import joandev.chek.UI.Presenters.LoginPresenter;
import joandev.chek.UI.Implementations.PresenterImpl;


public class LogInActivity extends Activity implements LoginView {

    @InjectView(R.id.cPasswordET) EditText cPasswordET;
//    @InjectView(R.id.passwordET) EditText passwordET;
    @InjectView(R.id.emailET) EditText emailET;
    @InjectView(R.id.signButton) Button signButton;
    @InjectView((R.id.memberTV)) TextView memberTV;
    LoginPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        ButterKnife.inject(this);
        presenter = new PresenterImpl(this);


        //Tv initialization
        memberTV.setText(getString(R.string.SignUpMessage));

    }

    @OnClick (R.id.signButton)
    public void toggleSignMode (View v) {
        presenter.toggleBetweenSignUpAndSignIn();
    }

    @OnClick(R.id.checkButton)
    public void checkButtonPressed(View v) {
       // presenter.checkButtonPressed(emailET.getText().toString(),passwordET.getText().toString(),cPasswordET.getText().toString());
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

    @Override
    public void activateSignUpMode() {
        signButton.setText(getString(R.string.SignUpMessage));
        cPasswordET.setVisibility(View.VISIBLE);
        Toast.makeText(getApplicationContext(),"Password missmatch", Toast.LENGTH_LONG).show();

    }

    @Override
    public void activateSignInMode() {
        signButton.setText(getString(R.string.SignUpMessage));
        cPasswordET.setVisibility(View.GONE);

    }

    @Override
    public void notifyPasswordMismatch() {
        Toast.makeText(getApplicationContext(),"Password missmatch", Toast.LENGTH_LONG).show();
    }
}
