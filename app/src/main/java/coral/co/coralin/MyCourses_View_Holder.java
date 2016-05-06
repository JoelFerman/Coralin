package coral.co.coralin;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by joelferman on 5/2/16.
 */
public class MyCourses_View_Holder extends RecyclerView.ViewHolder {

    CardView cv;
    TextView title;
    TextView description;
    ImageView imageView;

    MyCourses_View_Holder(View itemView) {
        super(itemView);
        cv = (CardView) itemView.findViewById(R.id.cardView);
        title = (TextView) itemView.findViewById(R.id.courseTitle);
        description = (TextView) itemView.findViewById(R.id.courseDescription);
        imageView = (ImageView) itemView.findViewById(R.id.courseImg);
    }
}
