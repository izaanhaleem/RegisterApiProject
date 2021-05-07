package com.example.registerapiproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity3 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
Button btnsearchfamily,btnenterfamily;
LinearLayout layout;
    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;
CalendarView card;
    @SuppressLint("WrongViewCast")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        dl = (DrawerLayout) findViewById(R.id.activity_main);
        t = new ActionBarDrawerToggle(this, dl, R.string.Open, R.string.Close);
        dl.addDrawerListener(t);
        t.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        nv = (NavigationView) findViewById(R.id.nav);
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id) {
                    case R.id.account:
                        Toast.makeText(MainActivity3.this, "DashBoard", Toast.LENGTH_SHORT).show();
                    case R.id.settings:
                        Toast.makeText(MainActivity3.this, "خاندان درج کری", Toast.LENGTH_SHORT).show();
                    case R.id.mycart:
                        Toast.makeText(MainActivity3.this, "لاگ آوٹ", Toast.LENGTH_SHORT).show();
                    default:
                        return true;
                }
            }
        });

     /*   FragmentManager fm = getSupportFragmentManager();
         FragmentTransaction fragmentTransaction = fm.beginTransaction();
         EnterFamilyData myFragment = new EnterFamilyData();*/
        // Spinner element
        final Spinner spinner = (Spinner) findViewById(R.id.spinner);
         btnsearchfamily=findViewById(R.id.btnSearch);
layout=findViewById(R.id.layout1);

        btnenterfamily=findViewById(R.id.btnSearch1);

        // Spinner click listener
        spinner.setOnItemSelectedListener(this);
        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("آپشن منتخب کریں");
        categories.add("خاندان نمبر سے تلاش کریں");
        categories.add("شناختی کارڈ نمبر سے تلاش کریں");
        categories.add("نام سے تلاش کریں");
        categories.add("فون نمبر سے تلاش کریں");
        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);

   /*     btnenterfamily.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity3.this,SecondActivity.class);
                intent.putExtra("data",String.valueOf(spinner.getSelectedItem()));
                startActivity(intent);
            }
        })*/;
        btnsearchfamily.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment=new EnterFamilyData();
                FragmentManager fm = getSupportFragmentManager();
// create a FragmentTransaction to begin the transaction and replace the Fragment
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
// replace the FrameLayout with new Fragment
                fragmentTransaction.replace(R.id.framelayout , fragment).commit();
            }
        });
        btnenterfamily.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment=new EnterFamilyData();
                FragmentManager fm = getSupportFragmentManager();
// create a FragmentTransaction to begin the transaction and replace the Fragment
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
// replace the FrameLayout with new Fragment
                fragmentTransaction.replace(R.id.framelayout , fragment).commit();
             //   fragmentTransaction.commit();
                layout.setVisibility(View.GONE);
            }
        });
    }
    private void loadFragment(Fragment fragment) {
// create a FragmentManager
       // save the changes
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
       // Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();

    }

    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(t.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }
}