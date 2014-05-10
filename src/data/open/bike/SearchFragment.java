package data.open.bike;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class SearchFragment extends Fragment
{

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_search, container, false);
        Spinner dateSpinner = (Spinner) v.findViewById(R.id.date_spinner);
        String[] date = {"今天", "明天", "未來一周"};
        ArrayAdapter<String> dateadpater = new ArrayAdapter<>(getActivity(), 
                android.R.layout.simple_spinner_item,date);
        dateadpater.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dateSpinner.setAdapter(dateadpater);
        Spinner locationSpinner = (Spinner) v.findViewById(R.id.location_spinner);
        String[] location = {"中山區", "中正", "大安", "信義", "松山", "士林"};
        ArrayAdapter<String> locationadapter = new ArrayAdapter<>(getActivity(), 
                android.R.layout.simple_spinner_item,location);
        locationadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        locationSpinner.setAdapter(locationadapter);
        return v;
    }

}
