package coral.co.coralin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class GameScreenActivity extends AppCompatActivity
{
    private WebView wbGame;

    GlobalVars GV = new GlobalVars();

    String gameURL = "http://coral.rosalilastudio.com/game.html?user_email="+GV.userEmail+"&user_token="+GV.userToken+"&current_level=0";//"http://beta.html5test.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);

        wbGame = (WebView) findViewById(R.id.wbGame);
        wbGame.getSettings().setJavaScriptEnabled(true);
        wbGame.getSettings().setSupportZoom(true);
        wbGame.getSettings().setBuiltInZoomControls(true);
        wbGame.loadUrl(gameURL);
    }
}
