package data.open.bike;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class AllFragment extends ListFragment
{
    
    Event[] events;
    
    private EventAdapter mEventAdapter;

    private String TITLE = "TITLE_EVENT";

    private String BEGIN_TIME = "BEGIN_TIME_EVENT";

    private String END_TIME = "END_TIME_EVENT";

    private String CURRENT_MEMBER = "CURRENT_MEMBER_EVENT";

    private String ALL_MEMBER = "ALL_MEMBER_EVENT";

    private String TO = "TO_EVENT";

    private String FROM = "FROM_EVENT";

    private String DETAIL = "DETAIL_EVENT";

    private String IMAGE = "IMAGE_EVENT";
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
        event1.detail = getActivity().getString(R.string.detail_lon);
        event1.image = R.drawable.lon;
        Event event2 = new Event();
        event2.begintime = "2013/5/31 AM 9:00";
        event2.endtime = "10:00 am";
        event2.currentmember = 5;
        event2.maxmember = 15;
        event2.title = "圓仔再臨";
        event2.to = "動物園";
        event2.from = "萬芳醫院";
        event2.detail = getActivity().getString(R.string.detail_zoo);
        event2.image = R.drawable.panda;

        
        Event[] tempevent = {event1, event2};
        events = tempevent;
        super.onCreate(savedInstanceState);
        mEventAdapter = new EventAdapter(getActivity(), events);
        this.setListAdapter(mEventAdapter);
        
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id)
    {
        super.onListItemClick(l, v, position, id);
        Event event = events[position];
        Log.d("AF", "JKW: " + event.title);
        Intent intent = new Intent(getActivity(), ShowEvent.class);
        intent.putExtra(TITLE, event.title);
        intent.putExtra(BEGIN_TIME, event.begintime);
        intent.putExtra(END_TIME, event.endtime);
        intent.putExtra(CURRENT_MEMBER, event.currentmember);
        intent.putExtra(ALL_MEMBER, event.maxmember);
        intent.putExtra(TO, event.to);
        intent.putExtra(FROM, event.from);
        intent.putExtra(DETAIL , event.detail);
        intent.putExtra(IMAGE , event.image);
        startActivity(intent);
    }
}
