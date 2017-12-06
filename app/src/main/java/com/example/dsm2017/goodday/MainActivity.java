package com.example.dsm2017.goodday;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.os.Build;
import android.provider.ContactsContract;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Calendar;

import static com.example.dsm2017.goodday.R.layout.design_layout_tab_icon;
import static com.example.dsm2017.goodday.R.layout.dialog_write;
import static com.example.dsm2017.goodday.R.layout.support_simple_spinner_dropdown_item;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton writebutton;
    Toolbar toolbar;
    ArrayAdapter<Integer> yearadapter, monthadapter, dayadapter;
    Spinner yearspinner,monthspinner,dayspinner;
    LinearLayout table1, table2, table3, table4, table5, table6;
    String title, deadline = null;
    TextView table1_title, table1_deadline, table2_title, table2_deadline, table3_title, table3_deadline,
            table4_title, table4_deadline, table5_title, table5_deadline, table6_title, table6_deadline;
    ImageView table1_image, table2_image, table3_image, table4_image, table5_image, table6_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        table1 = (LinearLayout) findViewById(R.id.table1);
        table2 = (LinearLayout) findViewById(R.id.table2);
        table3 = (LinearLayout) findViewById(R.id.table3);
        table4 = (LinearLayout) findViewById(R.id.table4);
        table5 = (LinearLayout) findViewById(R.id.table5);
        table6 = (LinearLayout) findViewById(R.id.table6);

        table1_title = (TextView) findViewById(R.id.table1_title);
        table1_deadline = (TextView) findViewById(R.id.table1_deadline);

        table2_title = (TextView) findViewById(R.id.table2_title);
        table2_deadline = (TextView) findViewById(R.id.table2_deadline);

        table3_title = (TextView) findViewById(R.id.table3_title);
        table3_deadline = (TextView) findViewById(R.id.table3_deadline);

        table4_title = (TextView) findViewById(R.id.table4_title);
        table4_deadline = (TextView) findViewById(R.id.table4_deadline);

        table5_title = (TextView) findViewById(R.id.table5_title);
        table5_deadline = (TextView) findViewById(R.id.table5_deadline);

        table6_title = (TextView) findViewById(R.id.table6_title);
        table6_deadline = (TextView) findViewById(R.id.table6_deadline);

        table1_image = (ImageView) findViewById(R.id.table1_image);
        table2_image = (ImageView) findViewById(R.id.table2_image);
        table3_image = (ImageView) findViewById(R.id.table3_image);
        table4_image = (ImageView) findViewById(R.id.table4_image);
        table5_image = (ImageView) findViewById(R.id.table5_image);
        table6_image = (ImageView) findViewById(R.id.table6_image);

        table1.setVisibility(View.INVISIBLE);
        table2.setVisibility(View.INVISIBLE);
        table3.setVisibility(View.INVISIBLE);
        table4.setVisibility(View.INVISIBLE);
        table5.setVisibility(View.INVISIBLE);
        table6.setVisibility(View.INVISIBLE);


        final String[] year = {"2017년","2018년"};

        final String[] month = {"1월","2월","3월","4월","5월","6월","7월","8월","9월","10월","11월","12월"};

        final String[] day = new String[31];

        for(int i=0;i<31;i++)
            day[i] = (i+1)+"일";

        writebutton = (FloatingActionButton) findViewById(R.id.writeBtn);
        writebutton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(MainActivity.this);

                View write_dialog = getLayoutInflater().inflate(R.layout.dialog_write,null);
                final EditText write_title =  write_dialog.findViewById(R.id.write_edittext);
                View wirte_ok_button = write_dialog.findViewById(R.id.write_ok);

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

                yearspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        yearspinner.setSelection(position);
                        String year = yearspinner.getSelectedItem().toString();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                        yearspinner.setSelection(1);
                    }
                });

                monthspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        monthspinner.setSelection(position);
                        String month = monthspinner.getSelectedItem().toString();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                        monthspinner.setSelection(1);
                    }
                });

                dayspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        dayspinner.setSelection(position);
                        String day = dayspinner.getSelectedItem().toString();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                        dayspinner.setSelection(1);
                    }
                });

                Window window = dialog.getWindow();
                window.setLayout(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);

                dialog.setCanceledOnTouchOutside(true);

                wirte_ok_button.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        String year = yearspinner.getSelectedItem().toString();
                        String month = monthspinner.getSelectedItem().toString();
                        String day = dayspinner.getSelectedItem().toString();
                        title = write_title.getText().toString();
                        deadline = year.toString() + " " + month.toString() + " " + day.toString();

                        if (title.equals(""))
                            Toast.makeText(MainActivity.this, "제목을 입력해주세요.", Toast.LENGTH_SHORT).show();

                        else {
                            Toast.makeText(MainActivity.this, "과제가 등록되었습니다.", Toast.LENGTH_SHORT).show();
                            if (table6.getVisibility() == View.VISIBLE) {
                                Toast.makeText(MainActivity.this, "더 이상 만들수 없습니다.", Toast.LENGTH_SHORT).show();
                            }
                            dialog.cancel();//토스트메시지

                            if (table1.getVisibility() == View.INVISIBLE) {
                                table1_title.setText(title);
                                table1_deadline.setText(deadline);
                                table1.setVisibility(View.VISIBLE);
                            } else if (table1.getVisibility() == View.VISIBLE && table2.getVisibility() == View.INVISIBLE) {
                                table2_title.setText(title);
                                table2_deadline.setText(deadline);
                                table2.setVisibility(View.VISIBLE);

                            } else if (table1.getVisibility() == View.VISIBLE
                                    && table2.getVisibility() == View.VISIBLE
                                    && table3.getVisibility() == View.INVISIBLE) {
                                table3_title.setText(title);
                                table3_deadline.setText(deadline);
                                table3.setVisibility(View.VISIBLE);

                            } else if (table1.getVisibility() == View.VISIBLE &&
                                    table2.getVisibility() == View.VISIBLE &&
                                    table3.getVisibility() == View.VISIBLE &&
                                    table4.getVisibility() == View.INVISIBLE) {

                                table4_title.setText(title);
                                table4_deadline.setText(deadline);
                                table4.setVisibility(View.VISIBLE);

                            } else if (table1.getVisibility() == View.VISIBLE &&
                                    table2.getVisibility() == View.VISIBLE &&
                                    table3.getVisibility() == View.VISIBLE &&
                                    table4.getVisibility() == View.VISIBLE &&
                                    table5.getVisibility() == View.INVISIBLE) {
                                table5_title.setText(title);
                                table5_deadline.setText(deadline);
                                table5.setVisibility(View.VISIBLE);

                            } else if (table1.getVisibility() == View.VISIBLE &&
                                    table2.getVisibility() == View.VISIBLE && table3.getVisibility() == View.VISIBLE
                                    && table4.getVisibility() == View.VISIBLE
                                    && table5.getVisibility() == View.VISIBLE
                                    && table6.getVisibility() == View.INVISIBLE) {
                                table6_title.setText(title);
                                table6_deadline.setText(deadline);
                                table6.setVisibility(View.VISIBLE);

                            }

                        }
                    }
                });
            }
        });
        //status dialog
        ImageView.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){

                    case R.id.table1_image :
                        final Dialog dialog1 = new Dialog(MainActivity.this);
                        View status_dialog1 = getLayoutInflater().inflate(R.layout.dialog_status,null);
                        final TextView status_text1 = status_dialog1.findViewById(R.id.statusText);
                        View doNextBtn = status_dialog1.findViewById(R.id.doNextBtn);
                        View doNowBtn = status_dialog1.findViewById(R.id.doNowBtn);

                        //status_text색깔바꾸기

                        //calender에서 날짜 꺼내오기
                        Calendar oCalendar = Calendar.getInstance( );
                        int year = oCalendar.get(Calendar.YEAR);
                        int month = oCalendar.get(Calendar.MONTH);
                        int day = oCalendar.get(Calendar.DATE);
                        String today= year+"년"+" "+month+"월"+" "+day+"일";



                        dialog1.setContentView(status_dialog1);
                        dialog1.show();

                        Window window = dialog1.getWindow();
                        window.setLayout(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);

                        dialog1.setCanceledOnTouchOutside(false);

                        doNextBtn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                dialog1.cancel();
                            }
                        });

                        doNowBtn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                            Intent intent = new Intent(MainActivity.this,TimeActivity.class);
                            startActivity(intent);

                            }
                        });
                        break;

                    case R.id.table2_image :
                        final Dialog dialog2 = new Dialog(MainActivity.this);
                        View status_dialog2 = getLayoutInflater().inflate(R.layout.dialog_status,null);
                        final TextView status_text2 = status_dialog2.findViewById(R.id.statusText);
                        View doNextBtn2 = status_dialog2.findViewById(R.id.doNextBtn);
                        View doNowBtn2 = status_dialog2.findViewById(R.id.doNowBtn);

                        //status_text색깔바꾸기


                        dialog2.setContentView(status_dialog2);
                        dialog2.show();

                        Window window2 = dialog2.getWindow();
                        window2.setLayout(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);

                        dialog2.setCanceledOnTouchOutside(false);

                        doNextBtn2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                dialog2.cancel();
                            }
                        });

                        doNowBtn2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent intent = new Intent(MainActivity.this,TimeActivity.class);
                                startActivity(intent);

                            }
                        });


                        break;

                    case R.id.table3_image :
                        final Dialog dialog3 = new Dialog(MainActivity.this);
                        View status_dialog3 = getLayoutInflater().inflate(R.layout.dialog_status,null);
                        final TextView status_text3 = status_dialog3.findViewById(R.id.statusText);
                        View doNextBtn3 = status_dialog3.findViewById(R.id.doNextBtn);
                        View doNowBtn3 = status_dialog3.findViewById(R.id.doNowBtn);

                        //status_text색깔바꾸기


                        dialog3.setContentView(status_dialog3);
                        dialog3.show();

                        Window window3 = dialog3.getWindow();
                        window3.setLayout(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);

                        dialog3.setCanceledOnTouchOutside(false);

                        doNextBtn3.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                dialog3.cancel();
                            }
                        });

                        doNowBtn3.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent intent = new Intent(MainActivity.this,TimeActivity.class);
                                startActivity(intent);

                            }
                        });



                        break;

                    case R.id.table4_image :
                        final Dialog dialog4 = new Dialog(MainActivity.this);
                        View status_dialog4 = getLayoutInflater().inflate(R.layout.dialog_status,null);
                        final TextView status_text4 = status_dialog4.findViewById(R.id.statusText);
                        View doNextBtn4 = status_dialog4.findViewById(R.id.doNextBtn);
                        View doNowBtn4 = status_dialog4.findViewById(R.id.doNowBtn);

                        //status_text색깔바꾸기


                        dialog4.setContentView(status_dialog4);
                        dialog4.show();

                        Window window4 = dialog4.getWindow();
                        window4.setLayout(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);

                        dialog4.setCanceledOnTouchOutside(false);

                        doNextBtn4.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                dialog4.cancel();
                            }
                        });

                        doNowBtn4.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent intent = new Intent(MainActivity.this,TimeActivity.class);
                                startActivity(intent);

                            }
                        });

                        break;

                    case R.id.table5_image :

                        final Dialog dialog5 = new Dialog(MainActivity.this);
                        View status_dialog5 = getLayoutInflater().inflate(R.layout.dialog_status,null);
                        final TextView status_text5 = status_dialog5.findViewById(R.id.statusText);
                        View doNextBtn5 = status_dialog5.findViewById(R.id.doNextBtn);
                        View doNowBtn5 = status_dialog5.findViewById(R.id.doNowBtn);

                        //status_text색깔바꾸기


                        dialog5.setContentView(status_dialog5);
                        dialog5.show();

                        Window window5 = dialog5.getWindow();
                        window5.setLayout(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);

                        dialog5.setCanceledOnTouchOutside(false);

                        doNextBtn5.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                dialog5.cancel();
                            }
                        });

                        doNowBtn5.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent intent = new Intent(MainActivity.this,TimeActivity.class);
                                startActivity(intent);

                            }
                        });




                        break;

                    case R.id.table6_image :

                        final Dialog dialog6 = new Dialog(MainActivity.this);
                        View status_dialog6 = getLayoutInflater().inflate(R.layout.dialog_status,null);
                        final TextView status_text6 = status_dialog6.findViewById(R.id.statusText);
                        View doNextBtn6 = status_dialog6.findViewById(R.id.doNextBtn);
                        View doNowBtn6 = status_dialog6.findViewById(R.id.doNowBtn);

                        //status_text색깔바꾸기


                        dialog6.setContentView(status_dialog6);
                        dialog6.show();

                        Window window6 = dialog6.getWindow();
                        window6.setLayout(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);

                        dialog6.setCanceledOnTouchOutside(false);

                        doNextBtn6.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                dialog6.cancel();
                            }
                        });

                        doNowBtn6.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent intent = new Intent(MainActivity.this,TimeActivity.class);
                                startActivity(intent);

                            }
                        });



                        break;
                }
            }
        };

        table1_image.setOnClickListener(listener);
        table2_image.setOnClickListener(listener);
        table3_image.setOnClickListener(listener);
        table4_image.setOnClickListener(listener);
        table5_image.setOnClickListener(listener);
        table6_image.setOnClickListener(listener);
    }
}
