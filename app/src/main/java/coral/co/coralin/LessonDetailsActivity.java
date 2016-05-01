package coral.co.coralin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;

public class LessonDetailsActivity extends AppCompatActivity implements View.OnClickListener
{
    Button btnLessonDetailPlay;

    WebView lessonWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_details);

        btnLessonDetailPlay = (Button)findViewById(R.id.btnLessonDetailPlay);
        lessonWebView = (WebView)findViewById(R.id.lessonWebView);
        lessonWebView.getSettings().setJavaScriptEnabled(true);
        lessonWebView.loadUrl("https://www.youtube.com/watch?v=gzT9oCWyJfk");

        btnLessonDetailPlay.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.btnLessonDetailPlay:
                Intent goLessonPlay = new Intent(this, GameScreenActivity.class);
                startActivity(goLessonPlay);
                break;

            default:
                break;
        }
    }
}
