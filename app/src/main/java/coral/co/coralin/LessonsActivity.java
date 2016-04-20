package coral.co.coralin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class LessonsActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lessons);
    }

    @Override
    public void onBackPressed()
    {
        Intent backCourseDetails = new Intent(this, CourseDetailsActivity.class);
        finish();
        startActivity(backCourseDetails);
    }
}
