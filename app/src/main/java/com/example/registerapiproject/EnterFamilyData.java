package com.example.registerapiproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class EnterFamilyData extends Fragment {
    TextView textView;
    String str="izaan";

    EditText etName,etFathername,etday,etmnth,etyear,etId,etphn,etAddress;
    Button btnsubmit;
    RadioGroup rdgroup,rdgroup1;
    RadioButton r1,r2,r3,r4,r5,r6,r7;
    public EnterFamilyData() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
     View view= inflater.inflate(R.layout.fragment_enter_family_data, container, false);
     etName=view.findViewById(R.id.etFullName);
     etFathername=view.findViewById(R.id.etFather);
     etday=view.findViewById(R.id.etDay);
     etmnth=view.findViewById(R.id.etMonth);
     etyear=view.findViewById(R.id.etYear);
     etId=view.findViewById(R.id.etIDCard);
     etphn=view.findViewById(R.id.etPhone);
     etAddress=view.findViewById(R.id.etAddress);
     rdgroup=view.findViewById(R.id.rdgroup);
     rdgroup1=view.findViewById(R.id.rdgroup1);
     r1=view.findViewById(R.id.R1);
     r2=view.findViewById(R.id.R2);
     r3=view.findViewById(R.id.R3);
     r4=view.findViewById(R.id.R4);
     r5=view.findViewById(R.id.R5);
     r6=view.findViewById(R.id.R6);
     r7=view.findViewById(R.id.R7);
        rdgroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // find which radio button is selected
                if(checkedId == R.id.R1) {
                    Toast.makeText(getActivity(), "Men", Toast.LENGTH_SHORT).show();
                } else if(checkedId == R.id.R2) {
                    Toast.makeText(getActivity(), "Women",
                            Toast.LENGTH_SHORT).show();
                } else if (checkedId==R.id.R3){
                    Toast.makeText(getActivity(), "Nothing",
                            Toast.LENGTH_SHORT).show();
                }         }
     });
        rdgroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId==R.id.R4){
                    Toast.makeText(getActivity(), "married", Toast.LENGTH_SHORT).show();
                }else if (checkedId==R.id.R5){
                    Toast.makeText(getActivity(), "unmarrid", Toast.LENGTH_SHORT).show();
                }else if (checkedId==R.id.R6){
                    Toast.makeText(getActivity(), "divorce", Toast.LENGTH_SHORT).show();
                }else if(checkedId==R.id.R7){
                    Toast.makeText(getActivity(), "vidow", Toast.LENGTH_SHORT).show();
                }
            }
        });
     btnsubmit=view.findViewById(R.id.btnSubmit);
        return view;
    }
}