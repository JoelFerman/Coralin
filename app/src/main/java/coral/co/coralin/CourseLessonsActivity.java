package coral.co.coralin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

public class CourseLessonsActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_lessons);

        //GridView gridView = (GridView) findViewById(R.id.lessonsGridView);

        // Instance of ImageAdapter Class
        //gridView.setAdapter(new ImageAdapter(this));
    }

    @Override
    public void onBackPressed()
    {
        Intent backMainScreen = new Intent(this, MainScreenActivity.class);
        finish();
        startActivity(backMainScreen);
    }
}
