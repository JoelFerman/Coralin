package coral.co.coralin;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joelferman on 4/11/16.
 */
public class NotificationsFragment extends Fragment
{
    private static final String TAG3 = "NotificationFragment";

    protected RecyclerView notificationRecyclerView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_notifications,container,false);

        v.setTag(TAG3);

        List<NotificationData> data = fill_with_data();

        notificationRecyclerView = (RecyclerView) v.findViewById(R.id.notificationRecyclerview);
        Notification_RecyclerView_Adapter adapter = new Notification_RecyclerView_Adapter(data, getActivity());
        notificationRecyclerView.setAdapter(adapter);
        notificationRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return v;
    }

    public List<NotificationData> fill_with_data() {

        List<NotificationData> data = new ArrayList<>();

        data.add(new NotificationData("Notification 1", R.drawable.ic_notification));
        data.add(new NotificationData("Notification 2", R.drawable.ic_notification));
        data.add(new NotificationData("Notification 3", R.drawable.ic_notification));

        return data;
    }
}
