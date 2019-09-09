package com.example.tracnghiem.tracnghiem1.diem;


import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.tracnghiem.tracnghiem1.MainActivity;
import com.example.tracnghiem.tracnghiem1.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DiemFragment extends Fragment {

    ListView lvScore;
    DiemController scoreController;
    DiemAdapter scoreAdapter;

    public DiemFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Danh sách điểm");
        return inflater.inflate(R.layout.fragment_diem, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        scoreController=new DiemController(getActivity());
        lvScore=(ListView) getActivity().findViewById(R.id.lvScore);
        Cursor cursor=scoreController.getScore();
        scoreAdapter=new DiemAdapter(getActivity(),cursor,true);
        lvScore.setAdapter(scoreAdapter);
    }
}
