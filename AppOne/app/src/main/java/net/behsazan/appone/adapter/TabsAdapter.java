package net.behsazan.appone.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import net.behsazan.appone.DoingFragment;
import net.behsazan.appone.DoneFragment;
import net.behsazan.appone.TodoFragment;

public class TabsAdapter extends FragmentPagerAdapter {
    public TabsAdapter(            @NonNull FragmentManager fm)
    {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position)
    {
        Fragment fragment = null;
        if (position == 0)
            fragment = new TodoFragment();
        else if (position == 1)
            fragment = new DoingFragment();
        else if (position == 2)
            fragment = new DoneFragment();

        return fragment;
    }

    @Override
    public int getCount()
    {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position)
    {
        String title = null;
        if (position == 0)
            title = "to do";
        else if (position == 1)
            title = "doing";
        else if (position == 2)
            title = "done";
        return title;
    }
}

