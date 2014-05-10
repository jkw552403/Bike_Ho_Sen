package data.open.bike;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class EventAdapter extends BaseAdapter
{
    private LayoutInflater myInflater;
    Event[] events;

    public EventAdapter(Context ctx, Event[] events){
        myInflater = LayoutInflater.from(ctx);
        this.events = events;
    }
    
    @Override
    public int getCount()
    {
        return events.length;
    }

    @Override
    public Object getItem(int position)
    {
        return events[position];
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        Event event = events[position];
        Holder holder = null;
        if (convertView == null) {
            convertView = myInflater.inflate(R.layout.list_event, parent, false);
            holder = new Holder();
            holder.textTitle = (TextView) convertView.
                    findViewById(R.id.text_title);
            holder.textTime_To = (TextView) convertView.
                    findViewById(R.id.text_time_to);
            holder.textcurrent = (TextView) convertView.
                    findViewById(R.id.text_current);
            holder.textall= (TextView) convertView.
                    findViewById(R.id.text_all);
        }
        else {
            holder = (Holder) convertView.getTag();
        }
        holder.textTitle.setText(event.title);
        holder.textTime_To.setText("出發時間" + event.begintime);
        holder.textcurrent.setText("目前人數: " + event.currentmember);
        holder.textall.setText("所有人數: " + event.maxmember);
        return convertView;
    }

    public static class Holder {
        public TextView textTitle;
        public TextView textTime_To;
        public TextView textcurrent;
        public TextView textall;
        
        public ImageView image;
    }
}
