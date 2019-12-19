package com.example.thi;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class DanhSachRauFragment extends Fragment {


    private ListView lvRau;
    private RauDAO rauDAO;
    private List<Rau> dsRau;

    public DanhSachRauFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rauDAO = new RauDAO(getActivity());
        dsRau = rauDAO.getAllRau();
        ArrayAdapter adapter = new ArrayAdapter(
                getActivity(),
                android.R.layout.simple_list_item_1,
                dsRau);

        View view = inflater.inflate(R.layout.danh_sach_rau_fragment, container, false);
        lvRau = view.findViewById(R.id.lvRau);
        lvRau.setAdapter(adapter);
        lvRau.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long id) {


                return false;
            }
        });

        return view;
    }

}
