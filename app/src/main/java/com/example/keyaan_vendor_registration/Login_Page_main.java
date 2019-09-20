package com.example.keyaan_vendor_registration;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class Login_Page_main extends AppCompatActivity {

    Button btn_login;
    EditText company_name, customer_name, register_office_address_line1, register_office_address_line2, address_landmark, input_Gstn, input_pancard, application_reciept;
    String memberType = "1";

    RadioGroup companyRegisterRadioGroup,fileType;
    RadioButton companyRegister_Yes_RadioButton, companyRegister_No_RadioButton,radio_gst,radio_arn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page_main);

        inflateIds();

        companyRegisterRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {

                    case R.id.companyRegister_Yes_RadioButton:

                        input_Gstn.setVisibility(View.VISIBLE);
                        application_reciept.setVisibility(View.VISIBLE);
                        input_pancard.setVisibility(View.GONE);
                        fileType.setVisibility(View.VISIBLE);
                        memberType = "1";
                        customer_name.setText("");
                        register_office_address_line1.setText("");
                        register_office_address_line2.setText("");
                        address_landmark.setText("");
                        company_name.setText("");


                        break;
                    case R.id.companyRegister_No_RadioButton:
                        // TODO Something
                        input_Gstn.setVisibility(View.GONE);
                        application_reciept.setVisibility(View.GONE);
                        fileType.setVisibility(View.GONE);
                        input_pancard.setVisibility(View.VISIBLE);
                        memberType = "2";
                        company_name.setText("");
                        customer_name.setText("");
                        register_office_address_line1.setText("");
                        register_office_address_line2.setText("");
                        address_landmark.setText("");


                        break;

                }
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getApplicationContext(),Step1_Registration_Activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

    }


    private void inflateIds() {
        companyRegisterRadioGroup = (RadioGroup) findViewById(R.id.companyRegisterRadioGroup);
        companyRegister_Yes_RadioButton = (RadioButton) findViewById(R.id.companyRegister_Yes_RadioButton);
        companyRegister_No_RadioButton = (RadioButton) findViewById(R.id.companyRegister_No_RadioButton);

        fileType = (RadioGroup) findViewById(R.id.fileType);
        radio_gst = (RadioButton) findViewById(R.id.radio_gst);
        radio_arn = (RadioButton) findViewById(R.id.radio_arn);

        company_name = (EditText) findViewById(R.id.company_name);
        customer_name = (EditText) findViewById(R.id.customer_name);
        register_office_address_line1 = (EditText) findViewById(R.id.register_office_address_line1);
        register_office_address_line2 = (EditText) findViewById(R.id.register_office_address_line2);
        address_landmark = (EditText) findViewById(R.id.address_landmark);
        input_Gstn = (EditText) findViewById(R.id.input_Gstn);
        input_pancard = (EditText) findViewById(R.id.input_pancard);
        application_reciept = (EditText) findViewById(R.id.application_reciept);

        btn_login =  findViewById(R.id.btn_login);




    }


    @Override
    public void onBackPressed() {

        doExit();
    }

    private void doExit() {

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(
                Login_Page_main.this);

        alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(Login_Page_main.this, "Logout Successfully Completed", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        alertDialog.setNegativeButton("No", null);

        alertDialog.setMessage("Do you want to exit?");
        alertDialog.setTitle("AppTitle");

        AlertDialog dialog = alertDialog.create();
        dialog.show();

        dialog.getWindow().setBackgroundDrawableResource(android.R.color.darker_gray);
        Button positiveButton = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
        Button negativeButton = dialog.getButton(AlertDialog.BUTTON_NEGATIVE);

        positiveButton.setTextColor(Color.parseColor("#FF0B8B42"));

        negativeButton.setTextColor(Color.parseColor("#FFFF0400"));

    }
}
