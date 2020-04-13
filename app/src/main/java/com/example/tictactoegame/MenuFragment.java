package com.example.tictactoegame;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class MenuFragment extends Fragment {

    private Button m_onePlayerGameButton;
    private Button m_twoPlayerGameButton;
    private Button m_rankingButton;
    private Button m_exitButton;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.menu_layout, container, false);
        m_onePlayerGameButton = (Button) view.findViewById(R.id.one_player_game_button);
        m_twoPlayerGameButton = (Button) view.findViewById(R.id.two_player_game_button);
        m_rankingButton = (Button) view.findViewById(R.id.ranking_button);
        m_exitButton = (Button) view.findViewById(R.id.exit_button);

        m_onePlayerGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Going to oneplayer game", Toast.LENGTH_SHORT).show();

                ((MainActivity)getActivity()).setViewPager(0);
            }
        });

        m_twoPlayerGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Going to twoplayer game", Toast.LENGTH_SHORT).show();

                ((MainActivity)getActivity()).setViewPager(1);
            }
        });

        m_rankingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Going to ranking", Toast.LENGTH_SHORT).show();

                ((MainActivity)getActivity()).setViewPager(2);
            }
        });

        m_exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Exit", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
