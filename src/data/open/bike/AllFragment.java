package data.open.bike;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class AllFragment extends ListFragment
{
    private EventAdapter mEventAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_event, container, false);
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        // TODO get event list here
        super.onCreate(savedInstanceState);
        // TODO new Adpater
        // TODO setAdapter
    }
}
