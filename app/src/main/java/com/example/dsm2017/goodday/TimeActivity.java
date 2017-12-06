package com.example.dsm2017.goodday;

import android.app.AlertDialog;
import android.app.Application;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import org.w3c.dom.Text;

public class TimeActivity extends AppCompatActivity {
    int backPressedTime;
    Button homekeylock;
    TimePicker timePicker;
    HomeKeyLocker homeKeyLocker;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_lock);

        timePicker = (TimePicker) findViewById(R.id.timepicker);

        homekeylock = (Button) findViewById(R.id.lock_button);

        homekeylock.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(TimeActivity.this);
                builder.setTitle("잠금")
                        .setMessage("지금부터 폰이 잠깁니다.")
                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                                Intent intent = new Intent(TimeActivity.this,LockActivity.class);
                                startActivity(intent);
                            }
                        });

                AlertDialog alertDialog = builder.create();
                alertDialog.show();


            }

        });


    }
}

