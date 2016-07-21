package com.faprun.ptcalculate;

import android.content.Intent;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    CustomViewGroup viewGroup1,viewGroup2;
    EditText editText1,editText2;
    TextView tvResult;
    Button btnCalculate;
    RadioGroup rgOperator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initInstance();

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;
        Toast.makeText(MainActivity.this,
                "Width = " + width +" "+ "Height = " + height,
                Toast.LENGTH_SHORT)
                .show();

        viewGroup1.setButtonText("Hello");
        viewGroup2.setButtonText("World");
    }

    private void initInstance() {
        editText1 = (EditText)findViewById(R.id.editext1);
        editText2 = (EditText)findViewById(R.id.editext2);
        tvResult  = (TextView)findViewById(R.id.tvResult);
        rgOperator = (RadioGroup)findViewById(R.id.rgOperator);
        btnCalculate = (Button)findViewById(R.id.btnCalculate);
        viewGroup1 = (CustomViewGroup)findViewById(R.id.ViewGroup1);
        viewGroup2 = (CustomViewGroup)findViewById(R.id.ViewGroup2);
        btnCalculate.setOnClickListener(listener);
    }
    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          if(v == btnCalculate){
                int val1 = 0;
                int val2 = 0;
                int sum = 0;
                try {
                    val1  = Integer.parseInt(editText1.getText().toString());
                }catch (NumberFormatException e){
                    Toast.makeText(MainActivity.this,"Please input number",
                            Toast.LENGTH_LONG).show();
                }
                try {
                    val2 = Integer.parseInt(editText2.getText().toString());
                }catch (NumberFormatException e){
                    Toast.makeText(MainActivity.this,"Please input number",
                            Toast.LENGTH_LONG).show();
                }
//                sum = val1 + val2;
//
//
//
            switch (rgOperator.getCheckedRadioButtonId()) {
                case R.id.rbPlus :
                    sum = val1 + val2;
                    break;
                case R.id.rbMinus :
                    sum = val1 - val2;
                    break;
                case R.id.rbMultiply :
                    sum = val1 * val2;
                    break;
                case  R.id.rbDivide :
                    sum = val1 / val2;
                    break;
                }
                  tvResult.setText("=" + Integer.toString(sum));
                  Log.d("Calculation", "Result = " + sum);
                  Toast.makeText(MainActivity.this,
                          "Result = " + sum
                          ,Toast.LENGTH_SHORT)
                          .show();

              Intent intent = new Intent(MainActivity.this,
                      SecondActivity.class);
              intent.putExtra("result",sum);
              startActivity(intent);
          }


        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.action_settings){

            Toast.makeText(MainActivity.this,
                    "Setting",
                    Toast.LENGTH_SHORT)
                    .show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
