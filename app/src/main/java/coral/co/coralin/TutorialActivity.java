package coral.co.coralin;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class TutorialActivity extends AppCompatActivity implements OnClickListener
{
    Button btnAdvance;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);

        SharedPreferences pref = getSharedPreferences("ActivityPREF", Context.MODE_PRIVATE);
        if(pref.getBoolean("activity_executed", false))
        {
            Intent intent = new Intent(this, AgeVerificationActivity.class);
            startActivity(intent);
            finish();
        }
        else
        {
            SharedPreferences.Editor ed = pref.edit();
            ed.putBoolean("activity_executed", true);
            ed.apply();
        }

        btnAdvance = (Button) findViewById(R.id.btnAdvance);

        assert btnAdvance != null;
        btnAdvance.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {}

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.btnAdvance:
            {
                Intent goAgeValidation = new Intent(this, AgeVerificationActivity.class);
                finish();
                startActivity(goAgeValidation);
            }
            break;

            default:
            {

            }
            break;
        }
    }
}