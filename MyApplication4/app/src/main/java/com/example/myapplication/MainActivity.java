package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import java.io.Serializable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<person> listP =new ArrayList<>();
    ArrayAdapter<person> da =null;
    EditText etName, etAddress;
    person p;
    Button btnAdd;
    RadioGroup group;
    ListView lstPerson;
    CheckBox cbTheThao,cbDuLich,cbGame;
    private ArrayList<CountryItem> mCountryList;
    private CountryAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstPerson = (ListView) findViewById(R.id.lstPerson);
        da = new ArrayAdapter<person>(this,android.R.layout.simple_list_item_1,listP);
        lstPerson.setAdapter(da);
        btnAdd = (Button)findViewById(R.id.btnAdd);
        initList();

        Spinner spinnerCountries = findViewById(R.id.spinner_countries);
        mAdapter = new CountryAdapter(this,mCountryList);
        spinnerCountries.setAdapter(mAdapter);
        spinnerCountries.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> person, View view, int position, long id) {
                CountryItem clickedItem = (CountryItem) person.getItemAtPosition(position);
                String clickedCountryName = clickedItem.getCountryName();
                Toast.makeText(MainActivity.this, clickedCountryName + " selected", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p = new person();
                etName = (EditText)findViewById(R.id.etName);
                etAddress = (EditText)findViewById(R.id.etAddress);
                cbTheThao=findViewById(R.id.cbTheThao);
                cbDuLich=findViewById(R.id.cbDuLich);
                cbGame=findViewById(R.id.cbGame);
                p.setName(etName.getText().toString());
                p.setAddress(etAddress.getText().toString());
                group = (RadioGroup)findViewById(R.id.group);
                switch (group.getCheckedRadioButtonId()){
                    case R.id.radNam:
                        p.setCountry("male");
                        break;
                    case R.id.radNu:
                        p.setCountry("female");
                        break;
                    case R.id.radGTK:
                        p.setCountry("male or female");
                        break;
                }
                String thongbao="";
                if(cbTheThao.isChecked())
                {
                    p.setThongbao("Sport");
                }
                else if (cbGame.isChecked())
                {
                    p.setThongbao("Game");
                }
                else if(cbDuLich.isChecked()){
                    p.setThongbao("Torms");
                }
                else if(cbTheThao.isChecked() ||cbGame.isChecked())
                {
                    p.setThongbao("Sport\n"+ "Game\n");
                }
//                switch (View.generateViewId()){
//                    case R.id.cbDuLich:
//                        if(cbDuLich.isChecked())
//                        {
//                            p.setThongbao("Sport");
//                            break;
//                        }
//                    case R.id.cbGame:
//                        if(cbGame.isChecked()){
//                            p.setThongbao("Game");
//                            break;
//                        }
//                    case R.id.cbTheThao:{
//                        if(cbTheThao.isChecked())
//                        {
//                            p.setThongbao("Torms");
//                            break;
//                        }
//                    }
//                }
                // Toast.makeText(MainActivity.this, p.toString(), Toast.LENGTH_SHORT).show();

                listP.add(p);
                da.notifyDataSetChanged();
            }
        });
}

    private void initList() {
        mCountryList = new ArrayList<>();
        mCountryList.add(new CountryItem("India", R.drawable.argentina));
        mCountryList.add(new CountryItem("VietNam", R.drawable.vietname));
        mCountryList.add(new CountryItem("USA", R.drawable.indonesia));
        mCountryList.add(new CountryItem("Germany", R.drawable.burkinafasoflat));
    }
}
