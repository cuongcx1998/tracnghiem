package com.example.tracnghiem.tracnghiem1;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 */
public class BangTuanHoanFragment extends Fragment {


    public BangTuanHoanFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Bảng tuần hoàn");
        return inflater.inflate(R.layout.fragment_bang_tuan_hoan, container, false);
    }

}
