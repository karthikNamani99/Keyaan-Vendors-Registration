package com.example.keyaan_vendor_registration;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class Step2_Registration_Activity extends AppCompatActivity implements View.OnClickListener {

    Button previous_btn, next_btn;

    EditText select_city, select_category, select_sub_catagory, select_sub_sub_category;

    RadioGroup city_radiogroup;
    String memberType = "1";
    RadioButton fresher_radio, renewal_radio;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.step2_registraion_main);

        previous_btn = findViewById(R.id.btn_previous);
        next_btn = findViewById(R.id.btn_next);

        select_city = findViewById(R.id.city);
        select_category = findViewById(R.id.category);
        select_sub_catagory = findViewById(R.id.sub_catagory);
        select_sub_sub_category = findViewById(R.id.sub_sub_category);

        city_radiogroup = findViewById(R.id.city_radio);
        fresher_radio = findViewById(R.id.radio_single_city);
        renewal_radio = findViewById(R.id.radio_multiple_city);

        previous_btn.setOnClickListener(this);
        next_btn.setOnClickListener(this);

        city_radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {

                    case R.id.companyRegister_Yes_RadioButton:

                        memberType = "1";
                        select_city.setText("");
                        select_category.setText("");
                        select_sub_catagory.setText("");
                        select_sub_sub_category.setText("");

                        break;
                    case R.id.companyRegister_No_RadioButton:
                        memberType = "2";
                        select_city.setText("");
                        select_category.setText("");
                        select_sub_catagory.setText("");
                        select_sub_sub_category.setText("");


                        break;

                }
            }
        });


    }



    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.btn_previous:

                Intent intent = new Intent(getApplicationContext(), Step1_Registration_Activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);

                break;

            case R.id.btn_next:
                String city = select_city.getText().toString();
                String category = select_category.getText().toString();
                String sub_catagory = select_sub_catagory.getText().toString();
                String sub_sub_category = select_sub_sub_category.getText().toString();

                if (city.isEmpty() || city.length() > 30) {
                    select_city.setError("search city by name");
                } else if (category.isEmpty() || category.length() > 30) {
                    select_category.setError("search category by name");

                } else if (sub_catagory.isEmpty() ||  sub_catagory.length() > 30) {
                    select_sub_sub_category.setError("search subcategory by name");

                } else if (sub_sub_category.isEmpty() ||  sub_sub_category.length() > 30) {
                    select_sub_sub_category.setError("search sub subcategory by name");

                } else {

                    Intent intent1 = new Intent(getApplicationContext(), Step3_Registration_Activity.class);
                    intent1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent1);
                }

                break;

        }
    }
}
