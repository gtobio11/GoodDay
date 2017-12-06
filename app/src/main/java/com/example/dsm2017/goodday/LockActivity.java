package com.example.dsm2017.goodday;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by dsm2017 on 2017-12-06.
 */

public class LockActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_lockscreen);

    }

    @Override
    protected void onUserLeaveHint() {

        Intent i = new Intent(this,LockActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(i);

        super.onUserLeaveHint();
    }
}