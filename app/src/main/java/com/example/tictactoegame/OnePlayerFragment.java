package com.example.tictactoegame;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class OnePlayerFragment  extends Fragment {

    private Button m_startGameButton;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.one_player_game_layout, container, false);
        m_startGameButton = (Button) view.findViewById(R.id.start_game_button);

        m_startGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Going to play", Toast.LENGTH_SHORT).show();

                ((MainActivity)getActivity()).setViewPager(3);
            }
        });
        return view;
    }
}

