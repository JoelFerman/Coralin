package coral.co.coralin;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements OnClickListener
{
    Toolbar toolbar;
    Button btnLogin;
    EditText txtEmail, txtPassword;

    String user = "testuser";
    String pass = "password";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.title_activity_login);
        setSupportActionBar(toolbar);

        SharedPreferences pref = getSharedPreferences("ActivityPREF", Context.MODE_PRIVATE);
        SharedPreferences.Editor ed = pref.edit();

        btnLogin = (Button) findViewById(R.id.btnLogin);
        txtEmail = (EditText) findViewById(R.id.txtEmail);
        txtPassword = (EditText) findViewById(R.id.txtPassword);

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
                if (txtEmail.getText().toString().equals(user) && txtPassword.getText().toString().equals(pass))
                {
                    Intent goMainScreen = new Intent(this, MainScreenActivity.class);
                    finish();
                    startActivity(goMainScreen);
                }
                else
                {
                    Toast.makeText(LoginActivity.this, "Credenciales incorrectas, intentalo de nuevo.", Toast.LENGTH_SHORT).show();
                    txtPassword.setText("");
                }
            }
            break;
        }
    }
}

