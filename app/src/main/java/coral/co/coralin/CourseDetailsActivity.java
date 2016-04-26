package coral.co.coralin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CourseDetailsActivity extends AppCompatActivity implements View.OnClickListener
{
    Button btnCourseRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_details);

        btnCourseRegister = (Button) findViewById(R.id.btnCourseRegister);

        btnCourseRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            default:
                break;

            case R.id.btnCourseRegister:
                Intent goLessons = new Intent(this, LessonsActivity.class);
                finish();
                startActivity(goLessons);
                break;
        }
    }

    @Override
    public void onBackPressed()
    {
        Intent backMainScreen = new Intent(this, MainScreenActivity.class);
        finish();
        startActivity(backMainScreen);
    }
}
