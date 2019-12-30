package com.example.fixinnew;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class InputStnk extends AppCompatActivity {

    ProgressDialog pd;
    Button buttonCari;
    EditText inputStnk;
    SharedPrefManager sharedPrefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_stnk);

        sharedPrefManager = new SharedPrefManager(this);
        pd = new ProgressDialog(this);

        final EditText editComment = (EditText) findViewById(R.id.inputStnk);

        editComment.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int DRAWABLE_LEFT = 0;
                final int DRAWABLE_TOP = 1;
                final int DRAWABLE_RIGHT = 2;
                final int DRAWABLE_BOTTOM = 3;

                if(event.getAction() == MotionEvent.ACTION_UP) {
                    if(event.getRawX() <= (editComment.getCompoundDrawables()[DRAWABLE_LEFT].getBounds().width()))  {

                        pd.setMessage("Tunggu  ...");
                        pd.setCancelable(false);
                        pd.show();

                        String snoStnk = editComment.getText().toString();
                        sharedPrefManager.saveSPString(SharedPrefManager.SP_STNK, snoStnk);
                        pd.hide();
                        Intent startIntent = new Intent(getApplicationContext(), ActivityBeranda.class);
                        startActivity(startIntent);


                        return true;
                    }
                }
                return false;
            }
        });

    }
}
