package com.example.tictactoegame;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class RankingFragment  extends Fragment {

    private Button m_backButton;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.ranking, container, false);
        m_backButton = (Button) view.findViewById(R.id.back_button);

        m_backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Going to play", Toast.LENGTH_SHORT).show();

                ((MainActivity)getActivity()).setViewPager(0);
            }
        });
        return view;
    }
}