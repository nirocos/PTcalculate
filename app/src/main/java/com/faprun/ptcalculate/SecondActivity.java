package com.faprun.ptcalculate;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends Activity {
    TextView tvResult;
    int sum = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        sum  = intent.getIntExtra("result",0);
        initInstaces();
        tvResult.setText("Result = "+sum + "");
    }

    private void initInstaces() {
        tvResult = (TextView)findViewById(R.id.tvResult);
    }
}
