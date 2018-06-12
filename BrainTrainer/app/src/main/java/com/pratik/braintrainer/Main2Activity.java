package com.pratik.braintrainer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {
Button b1;
 TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        b1=(Button)findViewById(R.id.button);
        t1=(TextView)findViewById(R.id.textView);
        b1.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent ad1=new Intent(Main2Activity.this,MainActivity.class);
        startActivity(ad1);
    }
}
