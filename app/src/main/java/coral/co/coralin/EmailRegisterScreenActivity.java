package coral.co.coralin;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EmailRegisterScreenActivity extends AppCompatActivity implements View.OnClickListener
{
    Button btnRegister;

    EditText txtEmail, txtPassword, txtconfirmPassword;

    String user = "testuser";
    String pass = "password";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_register_screen);

        btnRegister = (Button) findViewById(R.id.btnRegister);
        txtEmail = (EditText) findViewById(R.id.txtREmail);
        txtPassword = (EditText) findViewById(R.id.txtRPassword);
        txtconfirmPassword = (EditText) findViewById(R.id.txtRconfirmPassword);





        txtEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(!txtEmail.getText().toString().isEmpty()){

                    if(!isValidEmail(txtEmail.getText().toString())){
                        txtEmail.setError("Introduzca correo válido.");
                        //btnRegister.setEnabled(false);

                    }
                }

            }
        });

        assert btnRegister != null;
        btnRegister.setOnClickListener(this);


    }

    @Override
    public void onBackPressed()
    {
        Intent goBackPreRegister = new Intent(this, PreRegisterScreenActivity.class);
        finish();
        startActivity(goBackPreRegister);
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            default:
                break;

            case R.id.btnRegister: {
                //Log.e("response","hey");
                user= txtEmail.getText().toString();
                pass= txtPassword.getText().toString();
                if(isValidEmail(txtEmail.getText().toString())){
                    if(!txtEmail.getText().toString().isEmpty() && !txtconfirmPassword.getText().toString().isEmpty() && !txtPassword.getText().toString().isEmpty()){

                        if(txtPassword.getText().toString().equals(txtconfirmPassword.getText().toString())) {
                            AsyncT asyncT = new AsyncT();


                            try {
                                String str_result = asyncT.execute().get().toString();
                            } catch (Exception e) {

                            }

                            ws_static_variables wsvars;
                            wsvars = new ws_static_variables();

                            if (asyncT.getResponse().getError() == wsvars.getWs_sign_up_okcode_value()) {
                                Intent goMainScreen = new Intent(this, MainScreenActivity.class);
                                finish();
                                startActivity(goMainScreen);


                            } else {
                                Toast.makeText(EmailRegisterScreenActivity.this, asyncT.getResponse().getErrormessage(), Toast.LENGTH_SHORT).show();
                                txtPassword.setText("");
                                txtconfirmPassword.setText("");

                            }
                        }else{
                            Toast.makeText(EmailRegisterScreenActivity.this, "Las contraseñas no coinciden.", Toast.LENGTH_SHORT).show();
                            txtPassword.setText("");
                            txtconfirmPassword.setText("");

                        }


                    }else{

                    }

                }else{
                    Toast.makeText(EmailRegisterScreenActivity.this, "Introduzca correo válido.", Toast.LENGTH_SHORT);

                }




            }
            break;
        }
    }

    class AsyncT extends AsyncTask<Void, Void, Void> {

        OUT_st_sign_up response;
        //String responseText = null;


        public AsyncT() {

            this.response = new OUT_st_sign_up();
        }

        public void setResponse(OUT_st_sign_up response) {
            this.response = response;
        }

        public OUT_st_sign_up getResponse() {
            return response;
        }

        @Override
        protected Void doInBackground(Void... voids) {


            IN_st_sign_up IN;
            OUT_st_sign_up OUT;
            try {


                IN = new IN_st_sign_up();

                OUT = new OUT_st_sign_up();

                ws_gucomanager wsmng;
                wsmng = new ws_gucomanager();

                IN.setEmail(user);
                IN.setPassword(pass);

                OUT = wsmng.sing_up_guco(IN);

                setResponse(OUT);




            } catch ( Exception e){
                //e.printStackTrace();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //Here add the toast
                        Toast.makeText(EmailRegisterScreenActivity.this,"En este momento esta fuera de servicio", Toast.LENGTH_SHORT).show();
                    }
                });


            }

            return null;
        }


    }

    public final static boolean isValidEmail(CharSequence target) {
        return !TextUtils.isEmpty(target) && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }
}
