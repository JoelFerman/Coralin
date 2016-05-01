package coral.co.coralin;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class GameScreenActivity extends AppCompatActivity {
    private WebView wbGame;

    String gameURL = "https://studio.code.org/s/mc/stage/1/puzzle/1";//"http://coral.rosalilastudio.com/game.html?user_email=joelferman@hotmail.com&user_token=6d_jMoVH1vvzzxvh38CU&current_level=1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);

        wbGame = (WebView) findViewById(R.id.wbGame);
        wbGame.getSettings().setJavaScriptEnabled(true);
        wbGame.loadUrl(gameURL);
    }
}
