package com.example.tictactoegame;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BoardFragment extends Fragment {

    private Button m_backButton;
    private GridView m_gameBoard;
    static final FieldState[][] m_board = new FieldState[][] {{FieldState.EMPTY, FieldState.EMPTY,FieldState.EMPTY, FieldState.EMPTY },
            { FieldState.EMPTY, FieldState.EMPTY,FieldState.EMPTY, FieldState.EMPTY }};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.board_layout, container, false);
        m_backButton = view.findViewById(R.id.back_button);
        m_gameBoard = view.findViewById(R.id.game_board);

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        m_backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Going to play", Toast.LENGTH_SHORT).show();

                ((MainActivity)getActivity()).setViewPager(FragmentCollection.MENU_FRAGMENT);
            }
        });

        m_gameBoard.setAdapter(new BoardAdapter(this.getContext(), m_board));

        m_gameBoard.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), "P: " + position, Toast.LENGTH_SHORT).show();
            }
        });
    }
}