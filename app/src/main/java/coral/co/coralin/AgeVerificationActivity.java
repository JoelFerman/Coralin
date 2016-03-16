package coral.co.coralin;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class AgeVerificationActivity extends AppCompatActivity implements OnClickListener
{
    GlobalVars GV = new GlobalVars();

    EditText txtAgeValidation;
    Button btnValidateAge;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age_verification);

        txtAgeValidation = (EditText) findViewById(R.id.txtAgeValidation);

        btnValidateAge = (Button) findViewById(R.id.btnValidateAge);

        btnValidateAge.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.btnValidateAge:
            {
                Intent goLogin = new Intent(this, LoginActivity.class);
                finish();
                startActivity(goLogin);
            }
            break;

            default:
            {
            }
            break;
        }
    }

    public void save(View view)
    {
        SharedPreferences sharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Age", txtAgeValidation.getText().toString());
        editor.commit();
    }
}