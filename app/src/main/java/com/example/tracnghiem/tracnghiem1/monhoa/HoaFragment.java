package com.example.tracnghiem.tracnghiem1.monhoa;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.tracnghiem.tracnghiem1.MainActivity;
import com.example.tracnghiem.tracnghiem1.R;
import com.example.tracnghiem.tracnghiem1.slide.ScreenSlideActivity;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HoaFragment extends Fragment {

    HoaAdapter examAdapter;
    GridView gvExam;
    ArrayList<Hoa> arr_exam= new ArrayList<Hoa>();

    public HoaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Kiểm tra theo từng chương");
        return inflater.inflate(R.layout.fragment_hoa, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        gvExam=(GridView) getActivity().findViewById(R.id.gvExam);
        arr_exam.add(new Hoa("Este - Lipit"));
        arr_exam.add(new Hoa("Cacbonhidrat"));
        arr_exam.add(new Hoa("Amin - AminoAxit - Protein"));
        arr_exam.add(new Hoa("Polime"));
        arr_exam.add(new Hoa("Kiềm - Kiềm thổ - Nhôm"));
        arr_exam.add(new Hoa("Sắt và một số kim loại quan trọng"));

        examAdapter=new HoaAdapter(getActivity(),arr_exam);
        gvExam.setAdapter(examAdapter);
        gvExam.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent= new Intent(getActivity(), ScreenSlideActivity.class);
                intent.putExtra("num_exam",i+1);
                intent.putExtra("subject","hoa");
                startActivity(intent);
            }
        });

    }
}
