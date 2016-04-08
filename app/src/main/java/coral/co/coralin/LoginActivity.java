package coral.co.coralin;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity implements OnClickListener
{
    Toolbar toolbar;

    Button btnLogin, btnFBLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        toolbar = (Toolbar) findViewById(R.id.toolbar);

        SharedPreferences pref = getSharedPreferences("ActivityPREF", Context.MODE_PRIVATE);
        SharedPreferences.Editor ed = pref.edit();

        btnLogin = (Button) findViewById(R.id.btnLogin);
        //btnFBLogin = (Button) findViewById(R.id.btnFBLogin);

        if (pref.getInt("user_age", 0) <= 13)
        {
//            btnFBLogin.setEnabled(false);
//            btnFBLogin.setVisibility(View.INVISIBLE);
        }


        assert btnLogin != null;
        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {}

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.btnLogin:
            {
                Intent goMainScreen = new Intent(this, MainScreenActivity.class);
                finish();
                startActivity(goMainScreen);
            }
            break;
        }
    }
}

