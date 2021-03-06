package coral.co.coralin;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class LoadingActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                final Intent goAgeValidation = new Intent(LoadingActivity.this, TutorialActivity.class);
                finish();
                startActivity(goAgeValidation);
            }
        }, 3500);
    }

    @Override
    public void onBackPressed() {}
}
