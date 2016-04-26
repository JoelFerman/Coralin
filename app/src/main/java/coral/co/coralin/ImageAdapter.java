package coral.co.coralin;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by joelferman on 4/20/16.
 */
public class ImageAdapter extends BaseAdapter {
    private Context mContext;

    // Keep all Images in array
    public Integer[] mThumbIds =
            {
                    R.drawable.ic_dialpad_0, R.drawable.ic_dialpad_1,
                    R.drawable.ic_dialpad_2, R.drawable.ic_dialpad_3,
                    R.drawable.ic_dialpad_4, R.drawable.ic_dialpad_5,
                    R.drawable.ic_dialpad_6, R.drawable.ic_dialpad_7,
                    R.drawable.ic_dialpad_8, R.drawable.ic_dialpad_9
            };

    // Constructor
    public ImageAdapter(Context c) {
        mContext = c;
    }

    @Override
    public int getCount() {
        return mThumbIds.length;
    }

    @Override
    public Object getItem(int position) {
        return mThumbIds[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(mContext);
        imageView.setImageResource(mThumbIds[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new GridView.LayoutParams(70, 70));
        return imageView;
    }
}
