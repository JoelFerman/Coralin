package coral.co.coralin;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.animation.GridLayoutAnimationController;
import android.widget.GridLayout;

import java.util.ArrayList;
import java.util.List;

public class LessonsActivity extends AppCompatActivity
{
    private static final String TAG3 = "LessonsActivity";

    protected RecyclerView lessonRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lessons);

        List<LessonData> lessonData = fill_with_data();

        lessonRecyclerView = (RecyclerView) findViewById(R.id.lessonRecyclerview);
        Lesson_RecyclerView_Adapter adapter = new Lesson_RecyclerView_Adapter(lessonData, this);
        lessonRecyclerView.setAdapter(adapter);
        lessonRecyclerView.setLayoutManager(new GridLayoutManager(this,2));
    }

    @Override
    public void onBackPressed()
    {
        Intent backCourseDetails = new Intent(this, CourseDetailsActivity.class);
        finish();
        startActivity(backCourseDetails);
    }

    public List<LessonData> fill_with_data() {

        List<LessonData> lessonData = new ArrayList<>();

        lessonData.add(new LessonData("Lección 01", R.drawable.ic_lesson));
        lessonData.add(new LessonData("Lección 02", R.drawable.ic_lesson));
        lessonData.add(new LessonData("Lección 03", R.drawable.ic_lesson));
        lessonData.add(new LessonData("Lección 04", R.drawable.ic_lesson));
        lessonData.add(new LessonData("Lección 05", R.drawable.ic_lesson));
        lessonData.add(new LessonData("Lección 06", R.drawable.ic_lesson));
        lessonData.add(new LessonData("Lección 07", R.drawable.ic_lesson));
        lessonData.add(new LessonData("Lección 08", R.drawable.ic_lesson));
        lessonData.add(new LessonData("Lección 09", R.drawable.ic_lesson));
        lessonData.add(new LessonData("Lección 10", R.drawable.ic_lesson));

        return lessonData;
    }
}
