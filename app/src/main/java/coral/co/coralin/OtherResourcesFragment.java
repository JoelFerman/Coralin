package coral.co.coralin;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
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
public class OtherResourcesFragment extends Fragment
{
    private static final String TAG3 = "LessonActivity";

    protected RecyclerView otherResourcesRecyclerView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_other_resources,container,false);

        List<OtherResourcesData> otherResourcesData = fill_with_data();

        otherResourcesRecyclerView = (RecyclerView) v.findViewById(R.id.otherResourcesRecyclerview);
        OtherResources_RecyclerView_Adapter adapter = new OtherResources_RecyclerView_Adapter(otherResourcesData, this);
        otherResourcesRecyclerView.setAdapter(adapter);
        otherResourcesRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return v;
    }

    public List<OtherResourcesData> fill_with_data() {

        List<OtherResourcesData> data = new ArrayList<>();

        data.add(new OtherResourcesData("https://studio.code.org/s/mc/stage/1/puzzle/1"));
        data.add(new OtherResourcesData("https://studio.code.org/s/starwarsblocks/stage/1/puzzle/1"));

        return data;
    }
}
