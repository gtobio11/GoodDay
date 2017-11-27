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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import static com.example.dsm2017.goodday.R.layout.dialog_write;
import static com.example.dsm2017.goodday.R.layout.support_simple_spinner_dropdown_item;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton writebutton;
    Toolbar toolbar;
    ArrayAdapter yearadapter, monthadapter, dayadapter;
    Spinner yearspinner,monthspinner,dayspinner;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String[] year = {"2017년","2018년"};

        final String[] month = {"1월","2월","3월","4월","5월","6월","7월","8월","9월","10월","11월","12월"};

        final String[] day = {"1일","2일","3일","4일","5일","6일","7일","8일","9일","10일","11일","12일","13일",
                              "14일","15일","16일","17일","18일","19일","20일","21일","22일","23일","24일",
                              "25일","26일","27일","28일","29일","30일","31일"};

        writebutton = (FloatingActionButton) findViewById(R.id.writeBtn);
        writebutton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(MainActivity.this);

                View write_dialog = getLayoutInflater().inflate(R.layout.dialog_write,null);
                final EditText editText = (EditText) findViewById(R.id.write_edittext);
                final Button wirte_ok_button = (Button) findViewById(R.id.write_ok);

                dialog.setContentView(write_dialog);
                dialog.show();

                yearspinner = (Spinner) dialog.findViewById(R.id.yearspinner);
                monthspinner = (Spinner) dialog.findViewById(R.id.monthspinner);
                dayspinner = (Spinner) dialog.findViewById(R.id.dayspinner);

                yearadapter = new ArrayAdapter(dialog.getContext(),support_simple_spinner_dropdown_item,year);
                monthadapter = new ArrayAdapter(dialog.getContext(),support_simple_spinner_dropdown_item,month);
                dayadapter = new ArrayAdapter(dialog.getContext(),support_simple_spinner_dropdown_item,day);

                yearspinner.setAdapter(yearadapter);
                monthspinner.setAdapter(monthadapter);
                dayspinner.setAdapter(dayadapter);

                Window window = dialog.getWindow();
                window.setLayout(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);

                dialog.setCanceledOnTouchOutside(true);
            }
        });

    }
}
