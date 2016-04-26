package coral.co.coralin;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by joelferman on 4/26/16.
 */
public class Lesson_View_Holder extends RecyclerView.ViewHolder {

    CardView lessonCardView;
    TextView lessonTitle;
    ImageView imageView;

    Lesson_View_Holder(View itemView) {
        super(itemView);
        lessonCardView = (CardView) itemView.findViewById(R.id.lessonCardView);
        lessonTitle = (TextView) itemView.findViewById(R.id.lessonTitle);
        imageView = (ImageView) itemView.findViewById(R.id.lessonImage);
    }
}