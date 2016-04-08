package coral.co.coralin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

public class PreLoginScreenActivity extends AppCompatActivity implements View.OnClickListener
{
    TextView txtLoginActivity, txtSignInActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_login_screen);

        txtSignInActivity = (TextView) findViewById(R.id.txtSignInActivity);
        txtLoginActivity = (TextView) findViewById(R.id.txtLoginActivity);

        txtLoginActivity.setOnClickListener(this);
        txtSignInActivity.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {}

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            default:
                break;

            case R.id.txtLoginActivity:
                Intent goLoginScreenActivity = new Intent(this, LoginActivity.class);
                finish();
                startActivity(goLoginScreenActivity);
                break;

            case R.id.txtSignInActivity:
                Intent goSignInScreenActivity = new Intent(this, PreRegisterScreenActivity.class);
                finish();
                startActivity(goSignInScreenActivity);
                break;
        }
    }
}
