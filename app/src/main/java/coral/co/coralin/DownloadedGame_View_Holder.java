package coral.co.coralin;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by joelferman on 4/28/16.
 */
public class DownloadedGame_View_Holder extends RecyclerView.ViewHolder {

    CardView downloadGameCardView;
    TextView txtGameName;
    ImageView imageView;
    ImageView imageView2;
    ImageView imageView3;

    DownloadedGame_View_Holder(View itemView) {
        super(itemView);
        downloadGameCardView = (CardView) itemView.findViewById(R.id.downloadGameCardView);
        txtGameName = (TextView) itemView.findViewById(R.id.txtGameName);
        imageView = (ImageView) itemView.findViewById(R.id.downloadGameImg);
        imageView2 = (ImageView) itemView.findViewById(R.id.downloadGameDownloadImg);
        imageView3 = (ImageView) itemView.findViewById(R.id.downloadGameDeleteImg);
    }
}