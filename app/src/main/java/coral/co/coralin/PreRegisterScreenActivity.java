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

public class PreRegisterScreenActivity extends AppCompatActivity implements OnClickListener
{
    private Toolbar toolbar;

    //Button btnFBLogin, btnEmailRegister;

    Button btnEmailRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_register_screen);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        assert toolbar != null;
        toolbar.setTitle("Selección de Registro");
        setSupportActionBar(toolbar);

        //SharedPreferences pref = getSharedPreferences("ActivityPREF", Context.MODE_PRIVATE);

        //btnFBLogin = (Button) findViewById(R.id.btnFBLogin);
        btnEmailRegister = (Button) findViewById(R.id.btnEmailRegister);

//        if (pref.getInt("user_age", 0) <= 13)
//        {
//            btnFBLogin.setEnabled(false);
//            btnFBLogin.setVisibility(View.INVISIBLE);
//        }

        assert btnEmailRegister != null;
        btnEmailRegister.setOnClickListener(this);
    }

    @Override
    public void onBackPressed()
    {
        Intent goBackPreLogin = new Intent(this, PreLoginScreenActivity.class);
        finish();
        startActivity(goBackPreLogin);
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            default:
                break;

            case R.id.btnEmailRegister:
                Intent goEmailRegisterScreen = new Intent(this, EmailRegisterScreenActivity.class);
                finish();
                startActivity(goEmailRegisterScreen);
                break;
        }
    }
}
