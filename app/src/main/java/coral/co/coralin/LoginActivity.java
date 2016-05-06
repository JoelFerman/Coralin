package coral.co.coralin;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements OnClickListener
{
    Toolbar toolbar;
    Button btnLogin;
    EditText txtEmail, txtPassword;

    String user = "testuser";
    String pass = "password";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.title_activity_login);
        setSupportActionBar(toolbar);

        SharedPreferences pref = getSharedPreferences("ActivityPREF", Context.MODE_PRIVATE);
        SharedPreferences.Editor ed = pref.edit();

        btnLogin = (Button) findViewById(R.id.btnLogin);
        txtEmail = (EditText) findViewById(R.id.txtEmail);
        txtPassword = (EditText) findViewById(R.id.txtPassword);

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


                 }
             }

            }
        });

        assert btnLogin != null;
        btnLogin.setOnClickListener(this);

    }

    @Override
    public void onBackPressed()
    {
        Intent goBackPreLogin = new Intent(this, PreLoginScreenActivity.class);
        finish();
        startActivity(goBackPreLogin);
    }


    public final static boolean isValidEmail(CharSequence target) {
        return !TextUtils.isEmpty(target) && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.btnLogin:
            {
                if(!txtEmail.getText().toString().isEmpty() && !txtPassword.getText().toString().isEmpty()){
                    user= txtEmail.getText().toString();
                    pass= txtPassword.getText().toString();


                    if(isValidEmail(txtEmail.getText().toString())) {


                        AsyncT asyncT = new AsyncT();


                        try {
                            String str_result = asyncT.execute().get().toString();
                        } catch (Exception e) {

                        }

                        ws_static_variables wsvars;
                        wsvars = new ws_static_variables();


                        if (asyncT.getResponse().getStatus().equals("ok")){//.getError().equals(wsvars.getWs_sign_in_errorcode_value())) {
                            Intent goMainScreen = new Intent(this, MainScreenActivity.class);
                            finish();
                            startActivity(goMainScreen);


                        }else{
                            Toast toast = Toast.makeText(LoginActivity.this, asyncT.getResponse().getErrormessage(), Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.CENTER,0,0);
                            toast.show();
                            txtPassword.setText("");

                        }

                    }else{

                        Toast.makeText(LoginActivity.this, "Introduzca un correo válido.", Toast.LENGTH_SHORT).show();
                    }




                }

            }
            break;
        }
    }


    class AsyncT extends AsyncTask<Void, Void, Void> {

        OUT_st_sign_in response;
        //String responseText = null;


        public AsyncT() {

            this.response = new OUT_st_sign_in();
        }

        public void setResponse(OUT_st_sign_in response) {
            this.response = response;
        }

        public OUT_st_sign_in getResponse() {
            return response;
        }

        @Override
        protected Void doInBackground(Void... voids) {

            IN_st_sign_in IN;
            OUT_st_sign_in OUT;
            try {


                IN = new IN_st_sign_in();

                OUT = new OUT_st_sign_in();

                ws_gucomanager wsmng;
                wsmng = new ws_gucomanager();

                IN.setEmail(user);
                IN.setPassword(pass);

                OUT = wsmng.sing_in_guco(IN);

                setResponse(OUT);




            } catch ( Exception e){
                //e.printStackTrace();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //Here add the toast
                        Toast.makeText(getApplicationContext(),"En este momento esta fuera de servicio", Toast.LENGTH_SHORT).show();
                    }
                });


            }

            return null;
        }


    }
}

