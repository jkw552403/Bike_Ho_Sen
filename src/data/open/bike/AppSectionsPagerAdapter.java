package data.open.bike;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.content.Context;
import android.os.Bundle;

public class AppSectionsPagerAdapter extends FragmentPagerAdapter
{
    Context mContext;
    
    public AppSectionsPagerAdapter(Context ctx, FragmentManager supportFragmentManager)
    {
        super(supportFragmentManager);
        mContext = ctx;
    }

    @Override
    public Fragment getItem(int i)
    {
        switch (i) {
        case 0:
            return new ComingFragment();
        case 1:
            return new AllFragment();
        case 2:
            return new SearchFragment();
        default:
            return null;
        }
    }

    @Override
    public int getCount()
    {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position)
    {
        switch (position) {
        case 0:
            return "即將舉辦";
        case 1:
            return "所有活動";
        case 2:
            return "搜尋活動";
        default:
            return null;
        }
    }

}

