package coral.co.coralin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class EmailRegisterScreenActivity extends AppCompatActivity implements View.OnClickListener
{
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_register_screen);

        btnRegister = (Button) findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(this);
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

            case R.id.btnRegister:
                Toast.makeText(this, "UserRegistration() method invoked.", Toast.LENGTH_SHORT);
                break;
        }
    }
}
