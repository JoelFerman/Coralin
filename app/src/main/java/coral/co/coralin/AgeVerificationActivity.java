package coral.co.coralin;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import de.hdodenhof.circleimageview.CircleImageView;

public class AgeVerificationActivity extends AppCompatActivity implements OnClickListener
{
    private Vibrator dialVib;

    EditText txtAgeValidation;
    TextView btnValidateAge;

    Button dialPad1, dialPad2, dialPad3, dialPad4, dialPad5, dialPad6, dialPad7, dialPad8, dialPad9, dialPad0, dialPadDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age_verification);

        //MediaPlayer mp = MediaPlayer.create(this, R.raw.rw_keytone);

        txtAgeValidation = (EditText) findViewById(R.id.txtAgeValidation);

        txtAgeValidation.setInputType(InputType.TYPE_NULL);

        dialPad1 = (Button) findViewById(R.id.dialPad1);
        dialPad2 = (Button) findViewById(R.id.dialPad2);
        dialPad3 = (Button) findViewById(R.id.dialPad3);
        dialPad4 = (Button) findViewById(R.id.dialPad4);
        dialPad5 = (Button) findViewById(R.id.dialPad5);
        dialPad6 = (Button) findViewById(R.id.dialPad6);
        dialPad7 = (Button) findViewById(R.id.dialPad7);
        dialPad8 = (Button) findViewById(R.id.dialPad8);
        dialPad9 = (Button) findViewById(R.id.dialPad9);
        dialPad0 = (Button) findViewById(R.id.dialPad0);
        dialPadDelete = (Button) findViewById(R.id.dialPadDelete);

        btnValidateAge = (TextView) findViewById(R.id.btnValidateAge);
        //btnValidateAge.setEnabled(false);
        //btnValidateAge.setVisibility(View.INVISIBLE);

        SharedPreferences pref = getSharedPreferences("ActivityPREF", Context.MODE_PRIVATE);
        if(pref.getBoolean("user_age_bool", false))
        {
            Intent intent = new Intent(this, PreLoginScreenActivity.class);
            startActivity(intent);
            finish();
        }
        else
        {
            SharedPreferences.Editor ed = pref.edit();
            ed.putBoolean("user_age_bool", true);
            ed.apply();
        }

//        txtAgeValidation.addTextChangedListener(new TextWatcher()
//        {
//        @Override
//        public void onTextChanged(CharSequence s, int start, int before, int count)
//        {
//
//            //btnValidateAge.setEnabled(true);
//            //btnValidateAge.setVisibility(View.VISIBLE);
//            // TODO Auto-generated method stub
//        }
//
//        @Override
//        public void beforeTextChanged(CharSequence s, int start, int count, int after)
//        {
//            //btnValidateAge.setEnabled(false);
//            //btnValidateAge.setVisibility(View.INVISIBLE);
//            // TODO Auto-generated method stub
//        }
//
//        @Override
//        public void afterTextChanged(Editable s)
//        {
//            String ageValue = txtAgeValidation.getText().toString();
//            // if length greater then 1 enable the button else disable it here
//            if (txtAgeValidation.equals(null) || txtAgeValidation.equals(""))
//            {
//                btnValidateAge.setEnabled(false);
//                btnValidateAge.setVisibility(View.INVISIBLE);
//            }
//            else
//            {
//                btnValidateAge.setEnabled(true);
//                btnValidateAge.setVisibility(View.VISIBLE);
//            }
//            // TODO Auto-generated method stub
//        }
//    });

        btnValidateAge.setOnClickListener(this);
        dialPad1.setOnClickListener(this);
        dialPad2.setOnClickListener(this);
        dialPad3.setOnClickListener(this);
        dialPad4.setOnClickListener(this);
        dialPad5.setOnClickListener(this);
        dialPad6.setOnClickListener(this);
        dialPad7.setOnClickListener(this);
        dialPad8.setOnClickListener(this);
        dialPad9.setOnClickListener(this);
        dialPad0.setOnClickListener(this);
        dialPadDelete.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {}

    @Override
    public void onClick(View v)
    {
        //MediaPlayer mp = MediaPlayer.create(this, R.raw.rw_keytone);
        dialVib = (Vibrator) this.getSystemService(VIBRATOR_SERVICE);

        switch (v.getId())
        {
            case R.id.btnValidateAge:
            {
                if (txtAgeValidation.equals(null) || txtAgeValidation.equals(""))
                {
                    Toast.makeText(AgeVerificationActivity.this, "Por Favor, ingresa tu edad.", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    saveAge();
                    Intent goLogin = new Intent(this, PreLoginScreenActivity.class);
                    startActivity(goLogin);
                    finish();
                }
            }
            break;

            case R.id.dialPad1:
            {
                //mp.start();
                dialVib.vibrate(50);
                txtAgeValidation.setText(txtAgeValidation.getText().toString() + "1");
            }
            break;

            case R.id.dialPad2:
            {
                //mp.start();
                dialVib.vibrate(50);
                txtAgeValidation.setText(txtAgeValidation.getText().toString()+ "2");
            }
            break;

            case R.id.dialPad3:
            {
                //mp.start();
                dialVib.vibrate(50);
                txtAgeValidation.setText(txtAgeValidation.getText().toString()+ "3");
            }
            break;

            case R.id.dialPad4:
            {
                //mp.start();
                dialVib.vibrate(50);
                txtAgeValidation.setText(txtAgeValidation.getText().toString()+ "4");
            }
            break;

            case R.id.dialPad5:
            {
                //mp.start();
                dialVib.vibrate(50);
                txtAgeValidation.setText(txtAgeValidation.getText().toString()+ "5");
            }
            break;

            case R.id.dialPad6:
            {
                //mp.start();
                dialVib.vibrate(50);
                txtAgeValidation.setText(txtAgeValidation.getText().toString()+ "6");
            }
            break;

            case R.id.dialPad7:
            {
                //mp.start();
                dialVib.vibrate(50);
                txtAgeValidation.setText(txtAgeValidation.getText().toString()+ "7");
            }
            break;

            case R.id.dialPad8:
            {
                //mp.start();
                dialVib.vibrate(50);
                txtAgeValidation.setText(txtAgeValidation.getText().toString()+ "8");
            }
            break;

            case R.id.dialPad9:
            {
                //mp.start();
                dialVib.vibrate(50);
                txtAgeValidation.setText(txtAgeValidation.getText().toString()+ "9");
            }
            break;

            case R.id.dialPad0:
            {
                //mp.start();
                dialVib.vibrate(50);
                txtAgeValidation.setText(txtAgeValidation.getText().toString()+ "0");
            }
            break;

            case R.id.dialPadDelete:
            {
                //mp.start();
                dialVib.vibrate(50);
                int length = txtAgeValidation.getText().length();
                if (length > 0)
                {
                    txtAgeValidation.getText().delete(length - 1, length);
                }
                break;
            }

            default:
            {
            }
            break;
        }
    }

    public void saveAge()
    {
        SharedPreferences pref = getSharedPreferences("ActivityPREF", Context.MODE_PRIVATE);
        pref.getInt("user_age", 0);
        SharedPreferences.Editor ed = pref.edit();
        ed.putInt("user_age", Integer.parseInt(txtAgeValidation.getText().toString()));
        ed.apply();
    }
}