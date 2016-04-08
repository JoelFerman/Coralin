package coral.co.coralin;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by joelferman on 3/29/16.
 */
public class PreferencesFragment
{
    // Required empty public constructor
    public PreferencesFragment() {}

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout from this fragment
        return inflater.inflate(R.layout.fragment_preferences, container, false);
    }
}