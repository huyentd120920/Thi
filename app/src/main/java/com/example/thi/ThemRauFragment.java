package com.example.thi;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 */
public class ThemRauFragment extends Fragment {


    private RauDAO rauDAO;
    private Spinner spnhacc;

    public ThemRauFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rauDAO = new RauDAO(getActivity());
        View view = inflater.inflate(R.layout.them_rau_fragment, container, false);

        spnhacc = view.findViewById(R.id.spnhacc);
        Button btnAdd = view.findViewById(R.id.btnAdd);
        final EditText txtmarau = view.findViewById(R.id.txtmarau);
        final EditText txttenrau = view.findViewById(R.id.txttenrau);
        final EditText txtgia = view.findViewById(R.id.txtGia);

        Rau objRau = new Rau();

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String marau =txtmarau.getText().toString();
                String tenrau =txttenrau.getText().toString();

                String gia =txtgia.getText().toString();



                Rau objRau =  new Rau(marau, tenrau, gia);
                boolean isSuccess = rauDAO.insertRau(objRau);
                if (isSuccess){
                    Toast.makeText(getActivity(), " Lưu thành công", Toast.LENGTH_SHORT).show();

                }
                else {
                    Toast.makeText(getActivity(), "Lưu thất bại", Toast.LENGTH_SHORT).show();

                }
            }
        });




        return view;
    }

}