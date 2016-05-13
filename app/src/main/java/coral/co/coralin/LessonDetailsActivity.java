package coral.co.coralin;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayer.Provider;
import com.google.android.youtube.player.YouTubePlayerView;

public class LessonDetailsActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener, View.OnClickListener
{
    private static final int RECOVERY_REQUEST = 1;
    private YouTubePlayerView lesson_video;

    Button btnLessonDetailPlay;

    //WebView lessonWebView;

    GlobalVars GV = new GlobalVars();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_details);

        btnLessonDetailPlay = (Button)findViewById(R.id.btnLessonDetailPlay);

        lesson_video = (YouTubePlayerView) findViewById(R.id.lesson_video);
        lesson_video.initialize(YouTubeConfig.YOUTUBE_API_KEY, this);

        btnLessonDetailPlay.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.btnLessonDetailPlay:
                String gameURL = "http://coral.rosalilastudio.com/game.html?user_email="+GV.userEmail+"&user_token="+GV.userToken+"&current_level=0";
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(gameURL));
                startActivity(browserIntent);
                break;

            default:
                break;
        }
    }

    @Override
    public void onInitializationSuccess(Provider provider, YouTubePlayer youTubePlayer, boolean wasRestored)
    {
        if (!wasRestored) {
            youTubePlayer.cueVideo("gzT9oCWyJfk"); // Plays https://www.youtube.com/watch?v=fhWaJi1Hsfo
        }
    }

    @Override
    public void onInitializationFailure(Provider provider, YouTubeInitializationResult errorReason)
    {
        String playerError = "Error al iniciar el player de YouTube";
        if (errorReason.isUserRecoverableError()) {
            errorReason.getErrorDialog(this, RECOVERY_REQUEST).show();
        } else {
            String error = String.format(playerError, errorReason.toString());
            Toast.makeText(this, error, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RECOVERY_REQUEST) {
            // Retry initialization if user performed a recovery action
            getYouTubePlayerProvider().initialize(YouTubeConfig.YOUTUBE_API_KEY, this);
        }
    }

    protected Provider getYouTubePlayerProvider() {
        return lesson_video;
    }
}
