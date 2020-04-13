package com.example.tictactoegame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private SectionStatePageAdapter m_sectionStatePageAdapter;
    private ViewPager m_viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        m_sectionStatePageAdapter = new SectionStatePageAdapter(getSupportFragmentManager(), 0);

        m_viewPager = (ViewPager) findViewById(R.id.container);

        setUpViewPager(m_viewPager);
    }

    public void setViewPager(int fragmentNumber) {
        m_viewPager.setCurrentItem(fragmentNumber);
    }

    private void setUpViewPager(ViewPager viewPager) {
        SectionStatePageAdapter adapter = new SectionStatePageAdapter(getSupportFragmentManager(), 0);
        adapter.addFragment(new MenuFragment(), "Menu Fragment");
        adapter.addFragment(new MenuFragment(), "One Player Fragment");
        adapter.addFragment(new MenuFragment(), "Two Player Fragment");
        adapter.addFragment(new MenuFragment(), "Ranking Fragment");
        adapter.addFragment(new MenuFragment(), "Board Fragment");

        viewPager.setAdapter(adapter);
    }


}
