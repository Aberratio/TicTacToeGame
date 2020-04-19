package com.example.tictactoegame;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class BoardAdapter extends BaseAdapter {
    private Context m_context;
    private final FieldState[][] m_fieldStatesArray;

    public BoardAdapter(Context context, FieldState[][] fieldStatesArray) {
        m_context = context;
        m_fieldStatesArray = fieldStatesArray;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) m_context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View gridView;

        if (convertView == null) {

            gridView = new View(m_context);

            gridView = inflater.inflate(R.layout.cross_circle_image, null);

            ImageView imageView =  gridView
                    .findViewById(R.id.grid_item_image);

            FieldState fieldState = m_fieldStatesArray[0][position];

            if (fieldState == FieldState.CROSS) {
                imageView.setImageResource(R.drawable.circle);
            } else if (fieldState == FieldState.CROSS) {
                imageView.setImageResource(R.drawable.cross);
            } else {
                imageView.setImageResource(R.drawable.nothing);
            }
        } else {
            gridView = (View) convertView;
        }

        return gridView;
    }

    @Override
    public int getCount() {
        return m_fieldStatesArray.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

}
