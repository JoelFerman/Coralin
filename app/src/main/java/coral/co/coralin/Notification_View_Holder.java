package coral.co.coralin;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by joelferman on 4/28/16.
 */
public class Notification_View_Holder extends RecyclerView.ViewHolder {

    CardView notificationCardView;
    TextView notificationTitle;
    ImageView imageView;

    Notification_View_Holder(View itemView) {
        super(itemView);
        notificationCardView = (CardView) itemView.findViewById(R.id.notificationCardView);
        notificationTitle = (TextView) itemView.findViewById(R.id.txtNotification);
        imageView = (ImageView) itemView.findViewById(R.id.notificationImg);
    }
}