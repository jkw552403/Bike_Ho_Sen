package data.open.bike;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ComingFragment extends ListFragment
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
        Event event1 = new Event();
        event1.begintime = "2013/5/31 AM 8:30";
        event1.endtime = "9:00 am";
        event1.currentmember = 11;
        event1.maxmember = 15;
        event1.title = "龍山之旅";
        event1.to = "龍山寺";
        event1.from = "西門町";
        Event event2 = new Event();
        event2.begintime = "2013/5/31 AM 9:00";
        event2.endtime = "10:00 am";
        event2.currentmember = 5;
        event2.maxmember = 15;
        event2.title = "圓仔再臨";
        event2.to = "動物園";
        event2.from = "萬芳醫院";

        
        Event[] events = {event1, event2};
        super.onCreate(savedInstanceState);
        mEventAdapter = new EventAdapter(getActivity(), events);
        this.setListAdapter(mEventAdapter);
    }
    
}
