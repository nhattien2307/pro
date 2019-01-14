package com.vdkp.nhattien.dynamiclist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CaculatorActivity extends AppCompatActivity {

    private TextView tvReceive;
    private int mNum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caculator);

        Intent intent = getIntent();
        mNum = intent.getIntExtra("pass_int", 0);
        tvReceive = findViewById(R.id.tvReceive);
        tvReceive.setText(mNum + "");
    }

    public void sendback(View view) {

        Intent intent = new Intent();
        intent.putExtra("pass_result", mNum*mNum);
        setResult(RESULT_OK, intent);

        finish();
    }
}
