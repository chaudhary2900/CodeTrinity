package com.example.ayush.myfirstapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    EditText pg_Name,pg_Phone,pg_Email,pg_Locality,pg_pan_Number,pg_Pick_Name,pg_address_details,pg_password;
    TextView pg_textView_fileType,pg_address_proof,pg_address_Type;
    Button pg_browse1,pg_browse2,pg_submit,user_submit,user_buttonLoadPicture;
    EditText user_Name,user_phone,user_email,user_password,user_cur_address,user_permanent_address,user_Parent_email1,user_Parent_phone1,user_Parent_address1,user_editTextLoadPic;
    TextView user_textView_parent,user_imageDocument;
    Button buttonLoadPicture;
    CheckBox user_checkBox,pg_checkBox;
    Spinner user_spinner;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            //edit text
        pg_Name=(EditText)findViewById(R.id.pg_name);
        pg_Phone=(EditText)findViewById(R.id.pg_phone);
        pg_Email=(EditText)findViewById(R.id.pg_email);
        pg_Locality=(EditText)findViewById(R.id.pg_locality);
        pg_pan_Number=(EditText)findViewById(R.id.pg_pan_number);
        pg_Pick_Name=(EditText)findViewById(R.id.pg_Pick_name);
        pg_address_details=(EditText)findViewById(R.id.pg_address_details);
        pg_password=(EditText)findViewById(R.id.pg_password);
        //textview
        pg_textView_fileType=(TextView)findViewById(R.id.pg_textView_fileType);
        pg_address_proof=(TextView)findViewById(R.id.pg_address_proof);
        pg_address_Type=(TextView)findViewById(R.id.pg_address_type);
        user_textView_parent=(TextView)findViewById(R.id.user_textView_parent);
        user_imageDocument=(TextView)findViewById(R.id.user_imageDocument);
        //Button

        pg_browse1=(Button)findViewById(R.id.pg_browse1);
        pg_browse2=(Button)findViewById(R.id.pg_browse2);
        buttonLoadPicture=(Button)findViewById(R.id.buttonLoadPicture);
        pg_submit=(Button)findViewById(R.id.pg_submit);
        user_submit=(Button)findViewById(R.id.user_submit);
          user_spinner=(Spinner)findViewById(R.id.spinner);

        //checkBox

        user_checkBox=(CheckBox)findViewById(R.id.user_checkBox);
        pg_checkBox=(CheckBox)findViewById(R.id.pg_checkBox);



        //User Casting
        user_Name=(EditText)findViewById(R.id.user_name);
        user_phone=(EditText)findViewById(R.id.user_phone);
        user_email=(EditText)findViewById(R.id.user_email);
        user_password=(EditText)findViewById(R.id.user_password);
        user_cur_address=(EditText)findViewById(R.id.user_cur_address);
        user_permanent_address=(EditText)findViewById(R.id.user_pem_address);
        user_Parent_email1=(EditText)findViewById(R.id.user_email1);
        user_Parent_phone1=(EditText)findViewById(R.id.user_phone1);
        user_Parent_address1=(EditText)findViewById(R.id.user_address1);
        user_editTextLoadPic=(EditText)findViewById(R.id.user_editTextLoadPic);

        user_buttonLoadPicture=(Button)findViewById(R.id.user_buttonLoadPicture);
//button pg owner and user


       Button button1=(Button)findViewById(R.id.button1);
        Button button2=(Button)findViewById(R.id.button2);

        pg_Name.setVisibility(View.GONE);

        pg_Phone.setVisibility(View.GONE);
        pg_Email.setVisibility(View.GONE);
        pg_Locality.setVisibility(View.GONE);
        pg_pan_Number.setVisibility(View.GONE);
        pg_Pick_Name.setVisibility(View.GONE);
        pg_address_details.setVisibility(View.GONE);
        pg_password.setVisibility(View.GONE);
        pg_textView_fileType .setVisibility(View.GONE);
        pg_address_proof .setVisibility(View.GONE);
        pg_address_Type.setVisibility(View.GONE);
        pg_checkBox.setVisibility(View.GONE);
        pg_browse2.setVisibility(View.GONE);
        pg_browse1.setVisibility(View.GONE);
        pg_submit.setVisibility(View.GONE);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                pg_Name.setVisibility(View.GONE);

                pg_Phone.setVisibility(View.GONE);
                pg_Email.setVisibility(View.GONE);
                pg_Locality.setVisibility(View.GONE);
                pg_pan_Number.setVisibility(View.GONE);
                pg_Pick_Name.setVisibility(View.GONE);
                pg_address_details.setVisibility(View.GONE);
                pg_password.setVisibility(View.GONE);
                pg_textView_fileType.setVisibility(View.GONE);
                pg_address_proof.setVisibility(View.GONE);
                pg_address_Type.setVisibility(View.GONE);
                pg_checkBox.setVisibility(View.GONE);
                pg_browse2.setVisibility(View.GONE);
                pg_browse1.setVisibility(View.GONE);
                pg_submit.setVisibility(View.GONE);


                user_Name.setVisibility(View.VISIBLE);
                user_phone.setVisibility(View.VISIBLE);
                user_email.setVisibility(View.VISIBLE);
                user_password.setVisibility(View.VISIBLE);
                user_cur_address.setVisibility(View.VISIBLE);
                user_permanent_address.setVisibility(View.VISIBLE);
                user_Parent_email1.setVisibility(View.VISIBLE);
                user_Parent_phone1.setVisibility(View.VISIBLE);
                user_Parent_address1.setVisibility(View.VISIBLE);
                user_editTextLoadPic.setVisibility(View.VISIBLE);
                user_checkBox.setVisibility(View.VISIBLE);
                user_submit.setVisibility(View.VISIBLE);
                user_imageDocument.setVisibility(View.VISIBLE);
                user_textView_parent.setVisibility(View.VISIBLE);
                user_spinner.setVisibility(View.VISIBLE);
                user_buttonLoadPicture.setVisibility(View.VISIBLE);
            }
        });

button2.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        user_Name.setVisibility(View.GONE);
        user_phone.setVisibility(View.GONE);
        user_email.setVisibility(View.GONE);
        user_password.setVisibility(View.GONE);
        user_cur_address.setVisibility(View.GONE);
        user_permanent_address.setVisibility(View.GONE);
        user_Parent_email1.setVisibility(View.GONE);
        user_Parent_phone1.setVisibility(View.GONE);
        user_Parent_address1.setVisibility(View.GONE);
        user_editTextLoadPic.setVisibility(View.GONE);
        user_checkBox.setVisibility(View.GONE);
        user_submit.setVisibility(View.GONE);
        user_imageDocument.setVisibility(View.GONE);
        user_textView_parent.setVisibility(View.GONE);
        user_spinner.setVisibility(View.GONE);
        user_buttonLoadPicture.setVisibility(View.GONE);


        pg_Name.setVisibility(View.VISIBLE);

        pg_Phone.setVisibility(View.VISIBLE);
        pg_Email.setVisibility(View.VISIBLE);
        pg_Locality.setVisibility(View.VISIBLE);
        pg_pan_Number.setVisibility(View.VISIBLE);
        pg_Pick_Name.setVisibility(View.VISIBLE);
        pg_address_details.setVisibility(View.VISIBLE);
        pg_password.setVisibility(View.VISIBLE);
        pg_textView_fileType.setVisibility(View.VISIBLE);
        pg_address_proof.setVisibility(View.VISIBLE);
        pg_address_Type.setVisibility(View.VISIBLE);
        pg_checkBox.setVisibility(View.VISIBLE);
        pg_browse2.setVisibility(View.VISIBLE);
        pg_browse1.setVisibility(View.VISIBLE);
        pg_submit.setVisibility(View.VISIBLE);

    }
});

        user_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                methisAlert();
            }
        });
pg_submit.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        methisAlert();
    }
});

    }
    public void methisAlert() {
        new AlertDialog.Builder(this)
                .setTitle("MyOwnStay")
                .setMessage("Congratulation !  You Have been Successfully Signup Up with My Own Stay ")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // continue with delete
                        Intent intent=new Intent(MainActivity.this, com.example.ayush.myfirstapp.activity.MainActivity.class);
                        startActivity(intent);

                    }
                })
//            .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
//                public void onClick(DialogInterface dialog, int which) {
//                    // do nothing
//                }
//            })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }





}