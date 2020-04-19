package com.example.tictactoegame;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class TwoPlayerFragment  extends Fragment {

    private Button m_startGameButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.two_players_game_layout, container, false);
        m_startGameButton = view.findViewById(R.id.start_game_button);

        m_startGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Going to play", Toast.LENGTH_SHORT).show();

                ((MainActivity)getActivity()).setViewPager(FragmentCollection.BOARD_FRAGMENT);
            }
        });
        return view;
    }
}