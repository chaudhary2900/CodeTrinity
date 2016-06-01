//<!-- copyrighted content owned by Android Arena (www.androidarena.co.in)-->
package home.example.com.cmart;


import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;


public class SignUp extends Activity {

    EditText name, email1, mobileNo;
    Button signup;
    String Name_Send,Email_Send,mobile_Send;
    SharedPreferences sh_Pref;
    String emailPattern,emailInput;
        Editor toEdit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.sign_up);


        name = (EditText) findViewById(R.id.name);

        email1 = (EditText) findViewById(R.id.textmail);
        mobileNo = (EditText) findViewById(R.id.mobile);
        signup = (Button) findViewById(R.id.signUp);
        emailInput  =email1.getText().toString().trim();
        final String email = email1.getText().toString().trim();

        emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        onclickedMethod();

    }
//
//    public void sharedPrefernces() {
//        sh_Pref = getSharedPreferences("Login Credentials", MODE_PRIVATE);
//        toEdit = sh_Pref.edit();
//        toEdit.putString("Name", Name_Send);
//        toEdit.putString("Password", password);
//        toEdit.commit(); }

    boolean isEmailValid(CharSequence email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email)
                .matches();
    }





    public void onclickedMethod()
    {
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


               // isEmailValid(emailPattern);



//                if(!isEmailValid(emailInput)){
//                    email1.setError("Invalid"); /*"Invalid Text" or something like getString(R.string.Invalid)*/
//                    email1.requestFocus();
//                }

                if (name.getText().toString().isEmpty()  ||email1.getText().toString().isEmpty() || mobileNo.getText().toString().isEmpty()) {
//                    if (android.util.Patterns.EMAIL_ADDRESS.matcher(emailPattern).matches())
//                    {
//                        Toast.makeText(getApplicationContext(), "Email id incurrect ", Toast.LENGTH_LONG).show();
//                    }

                    Toast.makeText(getApplicationContext(), "Please Enter Check All Entries ", Toast.LENGTH_LONG).show();
                } else {


                    Toast.makeText(getApplicationContext(), "SignUp Successfully ", Toast.LENGTH_LONG).show();

                    Name_Send=name.getText().toString();
                    Email_Send=email1.getText().toString();
                    mobile_Send=mobileNo.getText().toString();
                    //    sharedPrefernces();
                    new SendtoServer().execute();
                    name.setText(null);
                    email1.setText(null);
                    mobileNo.setText(null);
                    Intent i=new Intent(SignUp.this,MainActivity.class);
                    startActivity(i);
                }

            }
        });
    }



    class SendtoServer extends AsyncTask<String, Void, String> {


        ProgressDialog dlg;


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dlg = new ProgressDialog(SignUp.this);
            dlg.setMessage("Saving...");
            dlg.show();
        }


        @Override
        protected String doInBackground(String... params) {


            List<NameValuePair> nameValuePairList = new ArrayList<NameValuePair>();
            nameValuePairList.add(new BasicNameValuePair("Name",Name_Send));
            nameValuePairList.add(new BasicNameValuePair("Email", Email_Send));
            nameValuePairList.add(new BasicNameValuePair("MobileNo", mobile_Send));







            String result = new ServiceHandler().makeServiceCall("http://trinityapplab.in/C_mart/registration_insert.php",2, nameValuePairList);
            //   Log.d("result =", result.toString());

            return result;
        }



        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            dlg.dismiss();
        }


    }
}
