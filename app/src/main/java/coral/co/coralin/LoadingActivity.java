package coral.co.coralin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class LoadingActivity extends AppCompatActivity implements OnClickListener
{
    Button btnContinue;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        btnContinue = (Button) findViewById(R.id.btnContinue);

        btnContinue.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.btnContinue:
                Intent goTutorial = new Intent(this, AgeVerificationActivity.class);
                finish();
                startActivity(goTutorial);
                break;
        }
    }
}
