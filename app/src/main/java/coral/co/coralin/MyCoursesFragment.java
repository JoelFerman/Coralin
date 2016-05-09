package coral.co.coralin;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
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
public class MyCoursesFragment extends Fragment
{
    private static final String TAG = "MyCoursesFragment";

    protected RecyclerView recyclerView;
    //protected CardView cardView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_my_courses, container, false);
        v.setTag(TAG);

        List<MyCoursesData> data = fill_with_data();

        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerview);
        MyCourses_RecyclerView_Adapter adapter = new MyCourses_RecyclerView_Adapter(data, getActivity());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return v;
    }

    public List<MyCoursesData> fill_with_data() {

        List<MyCoursesData> data = new ArrayList<>();

        data.add(new MyCoursesData("Python", "This is the description", R.drawable.course_2));
        data.add(new MyCoursesData("Node JS", "This is the description", R.drawable.course_4));

        return data;
    }
}
