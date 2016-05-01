package coral.co.coralin;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by joelferman on 4/28/16.
 */
public class OtherResources_View_Holder extends RecyclerView.ViewHolder {

    CardView otherResourcesCardView;
    TextView txtOtherResources;

    OtherResources_View_Holder(View itemView) {
        super(itemView);
        otherResourcesCardView = (CardView) itemView.findViewById(R.id.otherResourcesCardView);
        txtOtherResources = (TextView) itemView.findViewById(R.id.txtOtherResources);
    }
}