package com.example.dsm2017.goodday;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton writebutton;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        writebutton = (FloatingActionButton) findViewById(R.id.writeBtn);
        writebutton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(MainActivity.this);

                View write_dialog = getLayoutInflater().inflate(R.layout.dialog_write,null);
                final EditText editText = (EditText) findViewById(R.id.write_edittext);
                final Button wirte_ok_button = (Button) findViewById(R.id.write_ok);
                Spinner yearspinner = (Spinner) findViewById(R.id.yearspinner);
                Spinner monthspinner = (Spinner) findViewById(R.id.monthspinner);
                Spinner dayspinner = (Spinner) findViewById(R.id.dayspinner);

                dialog.setContentView(write_dialog);
                dialog.show();

                Window window = dialog.getWindow();
                window.setLayout(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);

                dialog.setCanceledOnTouchOutside(true);


            }
        });
    }
}
