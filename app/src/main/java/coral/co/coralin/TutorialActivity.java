package coral.co.coralin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toolbar;

public class TutorialActivity extends AppCompatActivity implements OnClickListener
{
//    GlobalVars GV = new GlobalVars();

    Button btnAdvance;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);

        btnAdvance = (Button) findViewById(R.id.btnAdvance);

        btnAdvance.setOnClickListener(this);
    }

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