package coral.co.coralin;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoadingActivity extends AppCompatActivity implements View.OnClickListener
{
    GlobalVars GV = new GlobalVars();

    Button btnContinue;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

//        SharedPreferences sharedPreferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);
//        String age = sharedPreferences.getString("Age", "");

        btnContinue = (Button) findViewById(R.id.btnContinue);

        btnContinue.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.btnContinue:

//                if (GV.tutorialView == 0)
//                {
                    Intent goTutorial = new Intent(this, AgeVerificationActivity.class);
                    finish();
                    startActivity(goTutorial);
//                }
//                else if (GV.tutorialView == 1)
//                {
//                    Intent goAgeVerification = new Intent(this, AgeVerificationActivity.class);
//                    finish();
//                    startActivity(goAgeVerification);
//                }
//                else if (GV.tutorialView == 2)
//                {
//                    Intent goLogin = new Intent(this, LoginActivity.class);
//                    finish();
//                    startActivity(goLogin);
//                }
                break;
        }
    }
}
