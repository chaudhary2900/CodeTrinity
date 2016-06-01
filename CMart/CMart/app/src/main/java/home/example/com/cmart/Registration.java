package home.example.com.cmart;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ayush on 23/5/16.
 */
public class Registration extends AppCompatActivity {

    private Toolbar toolbar;
    ProgressDialog dlg;
    private EditText inputName, inputEmail, inputPhone;
    private TextInputLayout inputLayoutName, inputLayoutEmail, inputLayoutphone;
    private Button btnSignUp;
    String Name_Send,Email_Send,mobile_Send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);

      toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        inputLayoutName = (TextInputLayout) findViewById(R.id.input_layout_name);
        inputLayoutEmail = (TextInputLayout) findViewById(R.id.input_layout_email);
        inputLayoutphone = (TextInputLayout) findViewById(R.id.input_layout_phone);
        inputName = (EditText) findViewById(R.id.input_name);
        inputEmail = (EditText) findViewById(R.id.input_email);
        inputPhone = (EditText) findViewById(R.id.input_phone);
        btnSignUp = (Button) findViewById(R.id.btn_signup);

        inputName.addTextChangedListener(new MyTextWatcher(inputName));
        inputEmail.addTextChangedListener(new MyTextWatcher(inputEmail));
        inputPhone.addTextChangedListener(new MyTextWatcher(inputPhone));

       sendDatatoServer();
    }



    public void sendDatatoServer(){
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                submitForm();

            }
        });

    }

    /**
     * Validating form
     */
    private void submitForm() {
        if (!validateName()) {
            return;
        }

        if (!validateEmail()) {
            return;
        }

        if (!validatePhoneNumber()) {
            return;
        }

        Name_Send=inputName.getText().toString();
        Email_Send=inputEmail.getText().toString();
        mobile_Send=inputPhone.getText().toString();
        //    sharedPrefernces();
        new SendtoServer().execute();
        inputName.setText(null);
        inputPhone.setText(null);
        inputEmail.setText(null);
        try {
            dlg.setMessage("Saving...");
            Thread.sleep(5000);



        }
        catch (Exception e)
        {
            e.printStackTrace();

        }

        Intent i=new Intent(Registration.this,MainActivity.class);
        startActivity(i);

        Toast.makeText(getApplicationContext(), "Thank You!", Toast.LENGTH_LONG).show();
    }

    private boolean validateName() {
        if (inputName.getText().toString().trim().isEmpty()) {
            inputLayoutName.setError(getString(R.string.err_msg_name));
            requestFocus(inputName);
            return false;
        } else {
            inputLayoutName.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateEmail() {
        String email = inputEmail.getText().toString().trim();

        if (email.isEmpty() || !isValidEmail(email)) {
            inputLayoutEmail.setError(getString(R.string.err_msg_email));
            requestFocus(inputEmail);
            return false;
        } else {
            inputLayoutEmail.setErrorEnabled(false);
        }

        return true;
    }

    private boolean validatePhoneNumber() {
        if (inputPhone.getText().toString().trim().isEmpty()) {
            inputLayoutphone.setError(getString(R.string.err_msg_Phone));
            requestFocus(inputPhone);
            return false;
        } else {
            inputLayoutphone.setErrorEnabled(false);
        }

        return true;
    }

    private static boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    private class MyTextWatcher implements TextWatcher {

        private View view;

        private MyTextWatcher(View view) {
            this.view = view;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void afterTextChanged(Editable editable) {
            switch (view.getId()) {
                case R.id.input_name:
                    validateName();
                    break;
                case R.id.input_email:
                    validateEmail();
                    break;
                case R.id.input_phone:
                    validatePhoneNumber();
                    break;
            }
        }
    }

    class SendtoServer extends AsyncTask<String, Void, String> {





        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dlg = new ProgressDialog(Registration.this);
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