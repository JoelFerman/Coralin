package coral.co.coralin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by joelferman on 4/11/16.
 */
public class MyCoursesFragment extends Fragment implements View.OnClickListener
{
    ListView lstMyCourses;
    ArrayList<HashMap<String, String>> oslist = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        lstMyCourses = (ListView) lstMyCourses.findViewById(R.id.lstMyCourses);

        View v = inflater.inflate(R.layout.fragment_my_courses, container, false);
        return v;
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            default:
                break;

            case R.id.imgCourse1:
                Intent goCourseDetails = new Intent(getActivity(), CourseDetailsActivity.class);
                startActivity(goCourseDetails);
                break;
        }
    }
}
