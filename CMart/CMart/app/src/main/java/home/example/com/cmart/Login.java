//<!-- copyrighted content owned by Android Arena (www.androidarena.co.in)-->
package home.example.com.cmart;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends Activity {

    Button login;
    EditText username,innputPassword;
    private TextInputLayout inputLayoutUserName, inputLayoutPassword;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        requestWindowFeature(Window.FEATURE_NO_TITLE);  
        
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.login);
        inputLayoutUserName = (TextInputLayout) findViewById(R.id.input_layout_userName);
        inputLayoutPassword = (TextInputLayout) findViewById(R.id.input_layout_password);
        login=(Button)findViewById(R.id.Login);
        username=(EditText)findViewById(R.id.userName);
        innputPassword=(EditText)findViewById(R.id.input_password);

        username.addTextChangedListener(new MyTextWatcher(username));
        innputPassword.addTextChangedListener(new MyTextWatcher(innputPassword));
       MethodBelow();
       LoginListner();
	}

    public void MethodBelow()
    {
        TextView reg = (TextView)findViewById(R.id.registed);
        reg.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent nxt = new Intent(getApplicationContext(), Registration.class);
                startActivity(nxt);
            }
        });

        TextView forget = (TextView)findViewById(R.id.forgot_password);
        forget.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent nxt = new Intent(getApplicationContext(), ForgetPassword.class);
                startActivity(nxt);
            }
        });



    }


    public void LoginListner(){

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitForm();




            }
        });
    }

    private void submitForm() {
        if (!validateUserName()) {
            return;
        }


        if (!validatePassword()) {
            return;
        }

        Intent nxt = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(nxt);
    }

    private boolean validateUserName() {
        if (username.getText().toString().trim().isEmpty()||username.getText().toString().isEmpty()) {
            inputLayoutUserName.setError(getString(R.string.err_msg_user_name));
            requestFocus(username);
            return false;
        } else {
            inputLayoutUserName.setErrorEnabled(false);
        }

        return true;
    }




    private boolean validatePassword() {
        if (innputPassword.getText().toString().trim().isEmpty()||innputPassword.getText().toString().isEmpty()) {
            inputLayoutPassword.setError(getString(R.string.err_msg_password));
            requestFocus(innputPassword);
            return false;
        } else {
            inputLayoutPassword.setErrorEnabled(false);
        }

        return true;
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
                case R.id.userName:
                    validateUserName();
                    break;

                case R.id.input_password:
                    validatePassword();
                    break;
            }
        }
    }

}
