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

public class Step1_Registration_Activity extends AppCompatActivity implements View.OnClickListener {

    Button previous_btn,next_btn;

    EditText user_mobile,user_name,user_password;

    RadioGroup membertype_radiogroup;
    String memberType = "1";
    RadioButton freshe_radio,renewal_radio;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.step1_registation_main);

        previous_btn=findViewById(R.id.btn_previous);
        next_btn=findViewById(R.id.btn_next);

        user_mobile=findViewById(R.id.mobile_number);
        user_name=findViewById(R.id.user_name);
        user_password=findViewById(R.id.user_password);

        membertype_radiogroup=findViewById(R.id.membertype);
        freshe_radio=findViewById(R.id.radio_fresh);
        renewal_radio=findViewById(R.id.radio_renewal);



        membertype_radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {

                    case R.id.radio_fresh:

                        user_name.setVisibility(View.VISIBLE);
                        user_password.setVisibility(View.VISIBLE);

                        memberType = "1";
                        user_mobile.setText("");

                        break;
                    case R.id.radio_renewal:
                        // TODO Something
                        user_name.setVisibility(View.GONE);
                        user_password.setVisibility(View.GONE);

                        memberType = "2";
                        user_mobile.setText("");



                        break;

                }
            }
        });

        previous_btn.setOnClickListener(this);
        next_btn.setOnClickListener(this);
    }



    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.btn_previous:

                Intent intent=new Intent(getApplicationContext(),Login_Page_main.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);

                break;

            case R.id.btn_next:
                String mobile = user_mobile.getText().toString();
                String username = user_name.getText().toString();
                String password = user_password.getText().toString();

                if (mobile.isEmpty() || mobile.length() < 10 ) {
                    user_mobile.setError("enter mobile nuber");
                }
                else if (username.isEmpty() || username.length() > 20) {
                    user_name.setError("enter name");

                }
                else if (password.isEmpty() || password.length() < 4 || password.length() > 20) {
                    user_password.setError("between 4 and 10 alphanumeric characters");

                }
                else {

                    Intent intent1=new Intent(getApplicationContext(),Step2_Registration_Activity.class);
                    intent1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent1);
                }

                break;
        }
    }


}
