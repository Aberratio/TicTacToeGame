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

        m_sectionStatePageAdapter = new SectionStatePageAdapter(getSupportFragmentManager(), 5);

        m_viewPager = findViewById(R.id.container);

        setUpViewPager(m_viewPager);
    }

    private void setUpViewPager(ViewPager viewPager) {
        SectionStatePageAdapter adapter = new SectionStatePageAdapter(getSupportFragmentManager(), 5);
        adapter.addFragment(new MenuFragment(), "Menu Fragment");
        adapter.addFragment(new OnePlayerFragment(), "One Player Fragment");
        adapter.addFragment(new TwoPlayerFragment(), "Two Player Fragment");
        adapter.addFragment(new RankingFragment(), "Ranking Fragment");
        adapter.addFragment(new BoardFragment(), "Board Fragment");

        viewPager.setAdapter(adapter);
    }

    public void setViewPager(FragmentCollection fragmentCollection) {
        m_viewPager.setCurrentItem(fragmentCollection.getValue());
    }
}
