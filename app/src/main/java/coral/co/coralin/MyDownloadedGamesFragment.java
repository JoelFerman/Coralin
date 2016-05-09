package coral.co.coralin;

import android.app.FragmentTransaction;
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
public class MyDownloadedGamesFragment extends Fragment implements View.OnClickListener
{
    private static final String TAG2 = "MyDownloadedGamesFragment";

    protected RecyclerView downloadGameRecyclerview;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_my_downloaded_games,container,false);

        v.setTag(TAG2);

        List<DownloadGameData> data = fill_with_data();

        downloadGameRecyclerview = (RecyclerView) v.findViewById(R.id.downloadGameRecyclerview);
        DownloadGame_RecyclerView_Adapter adapter = new DownloadGame_RecyclerView_Adapter(data, getActivity());
        downloadGameRecyclerview.setAdapter(adapter);
        downloadGameRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));

        return v;
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            default:
                break;
        }
    }

    public List<DownloadGameData> fill_with_data() {

        List<DownloadGameData> data = new ArrayList<>();

        data.add(new DownloadGameData("Ro-Bot-Cito", R.drawable.ic_game, R.drawable.ic_game_download, R.drawable.ic_game_delete));

        return data;
    }
}
