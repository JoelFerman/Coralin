package coral.co.coralin;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class TutorialActivity extends AppCompatActivity implements OnClickListener
{
    Toolbar toolbar;
    TextView tutorialSkip;
    //Button btnAdvance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        assert toolbar != null;
        toolbar.setTitle(R.string.title_activity_tutorial);

        SharedPreferences pref = getSharedPreferences("ActivityPREF", Context.MODE_PRIVATE);
        if (pref.getBoolean("activity_executed", false)) {
            Intent intent = new Intent(this, AgeVerificationActivity.class);
            startActivity(intent);
            finish();
        } else {
            SharedPreferences.Editor ed = pref.edit();
            ed.putBoolean("activity_executed", true);
            ed.apply();
        }

        tutorialSkip = (TextView) findViewById(R.id.tutorialSkip);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        assert viewPager != null;
        viewPager.setAdapter(new CustomPagerAdapter(this));

//        TitlePageIndicator titleIndicator = (TitlePageIndicator) findViewById(R.id.indicator);
//        assert titleIndicator != null;
//        titleIndicator.setViewPager(viewPager);

//        btnAdvance = (Button) findViewById(R.id.btnAdvance);
//
//        assert btnAdvance != null;
//        btnAdvance.setOnClickListener(this);

        tutorialSkip.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.tutorialSkip:
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