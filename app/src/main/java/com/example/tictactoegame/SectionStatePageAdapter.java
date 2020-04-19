package com.example.tictactoegame;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class SectionStatePageAdapter extends FragmentStatePagerAdapter {

    private final List<Fragment> m_fragmentList = new ArrayList<>();
    private final List<String> m_fragmentNameList = new ArrayList<>();

    public SectionStatePageAdapter(FragmentManager fragmentManager, int b) {
        super(fragmentManager, b);
    }

    public void addFragment(Fragment fragment, String fragmentName) {
        m_fragmentList.add(fragment);
        m_fragmentNameList.add(fragmentName);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return m_fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return m_fragmentList.size();
    }
}
