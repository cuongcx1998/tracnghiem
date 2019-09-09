package com.example.tracnghiem.tracnghiem1.cauhoi;


import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;

import com.example.tracnghiem.tracnghiem1.MainActivity;
import com.example.tracnghiem.tracnghiem1.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchQuesFragment extends Fragment {

    ListView lvQuestion;
    CauHoiController questionController;
    CauHoiAdapter adapter;
    EditText edtSearch;

    public SearchQuesFragment() {
        // Required empty public constructor
    }

    public void begin(){
        lvQuestion=(ListView) getActivity().findViewById(R.id.lvQuestion);
        edtSearch=(EditText)getActivity().findViewById(R.id.edtSearch);
        questionController =new CauHoiController(getActivity());
        listCursor(questionController.getSearchQuestion(edtSearch.getText().toString()));
    }

    public void listCursor(Cursor cursor){
        adapter=new CauHoiAdapter(getActivity(),cursor,true);
        lvQuestion.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Danh sách câu hỏi");
        return inflater.inflate(R.layout.fragment_search_ques, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        begin();

        edtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                listCursor(questionController.getSearchQuestion(edtSearch.getText().toString()));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }
}
