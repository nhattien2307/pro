package com.vdkp.nhattien.dynamiclist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView lvHistory;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> mList;
    private EditText etInput;
    private int mNum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etInput = findViewById(R.id.etInput);
        lvHistory = findViewById(R.id.lvHistory);
        mList = new ArrayList<>();
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,mList);
        lvHistory.setAdapter(adapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode ==1000 && resultCode == RESULT_OK){
            int result = data.getIntExtra("pass_result", 0);
            String str = mNum + " * " + mNum + " = " + result;
            mList.add(0,str);
            adapter.notifyDataSetChanged();
        }
    }

    public void send(View view) {
        String str = etInput.getText().toString();
        try{
            mNum = Integer.parseInt(str);
            Intent intent = new Intent(MainActivity.this,CaculatorActivity.class);
            intent.putExtra("pass_int",mNum);
            startActivityForResult(intent,1000);
        }catch (Exception ex){
            Toast.makeText(this, "Wrong number !", Toast.LENGTH_SHORT).show();
        }
    }
}
