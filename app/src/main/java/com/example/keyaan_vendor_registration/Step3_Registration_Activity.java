package com.example.keyaan_vendor_registration;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Step3_Registration_Activity extends AppCompatActivity implements View.OnClickListener {

    Button previous_btn, next_btn;

    EditText edit_owner_name, edit_company_name, search_company_type, edit_landline_number;
    EditText edit_poc_mobile, edit_poc_name, select_customer_city, select_pincode, edit_locality, edit_address, edit_landmark, edit_email, edit_alternative_email;
    EditText edit_TAN, edit_Business, select_proof;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.step3_registation_main);

        previous_btn = findViewById(R.id.btn_previous);
        next_btn = findViewById(R.id.btn_next);

        edit_owner_name = findViewById(R.id.edit_owner_name);
        edit_company_name = findViewById(R.id.edit_company_name);
        search_company_type = findViewById(R.id.search_company_type);
        edit_landline_number = findViewById(R.id.edit_landline_number);
        edit_poc_mobile = findViewById(R.id.edit_poc_mobile);
        edit_poc_name = findViewById(R.id.edit_poc_name);
        select_customer_city = findViewById(R.id.select_customer_city);
        select_pincode = findViewById(R.id.select_pincode);
        edit_locality = findViewById(R.id.edit_locality);
        edit_address = findViewById(R.id.edit_address);
        edit_landmark = findViewById(R.id.edit_landmark);
        edit_email = findViewById(R.id.edit_email);
        edit_alternative_email = findViewById(R.id.edit_alternative_email);
        edit_TAN = findViewById(R.id.edit_TAN);
        edit_Business = findViewById(R.id.edit_Business);
        select_proof = findViewById(R.id.select_proof);


        previous_btn.setOnClickListener(this);
        next_btn.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.btn_previous:

                Intent intent = new Intent(getApplicationContext(), Step2_Registration_Activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);

                break;

            case R.id.btn_next:
                String _owner_name = edit_owner_name.getText().toString();
                String _company_name = edit_company_name.getText().toString();
                String _company_type = search_company_type.getText().toString();
                String _landline_number = edit_landline_number.getText().toString();
                String _poc_mobile = edit_poc_mobile.getText().toString();
                String _customer_city = select_customer_city.getText().toString();
                String _pincode = select_pincode.getText().toString();
                String _locality = edit_locality.getText().toString();
                String _address = edit_address.getText().toString();
                String _landmark = edit_landmark.getText().toString();
                String _email = edit_email.getText().toString();
                String _alternative_email = edit_alternative_email.getText().toString();
                String _TAN = edit_TAN.getText().toString();
                String _Business = edit_Business.getText().toString();
                String _proof = select_proof.getText().toString();


                if (_owner_name.isEmpty() || _owner_name.length() >30) {
                    edit_owner_name.setError("enter mobile nuber");
                } else if (_company_name.isEmpty() || _company_name.length() > 50) {
                    edit_company_name.setError("enter name");

                } else if (_company_type.isEmpty() || _company_type.length() > 30) {
                    search_company_type.setError("enter name");

                } else if (_landline_number.isEmpty() || _landline_number.length() > 30) {
                    edit_landline_number.setError("enter name");

                } else if (_poc_mobile.isEmpty() || _poc_mobile.length() > 30) {
                    edit_poc_mobile.setError("enter name");

                } else if (_customer_city.isEmpty() || _customer_city.length() > 30) {
                    select_customer_city.setError("enter name");

                } else if (_pincode.isEmpty() || _pincode.length() > 30) {
                    select_pincode.setError("enter name");

                } else if (_locality.isEmpty() || _locality.length() > 30) {
                    edit_locality.setError("enter name");

                } else if (_address.isEmpty() || _address.length() > 30) {
                    edit_address.setError("enter name");

                } else if (_landmark.isEmpty() || _landmark.length() > 30) {
                    edit_landmark.setError("enter name");

                } else if (_email.isEmpty() || _email.length() > 30) {
                    edit_email.setError("enter name");

                } else if (_alternative_email.isEmpty() || _alternative_email.length() > 30) {
                    edit_alternative_email.setError("enter name");

                } else if (_TAN.isEmpty() || _TAN.length() > 30) {
                    edit_TAN.setError("enter name");

                } else if (_Business.isEmpty() || _Business.length() > 30) {
                    edit_Business.setError("enter name");

                } else if (_proof.isEmpty() || _proof.length() > 30) {
                    select_proof.setError("enter name");

                } else {
                    Intent intent1 = new Intent(getApplicationContext(), Step4_Registration_Activity.class);
                    intent1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent1);
                }

                break;
        }

    }


}
