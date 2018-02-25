package com.test.catsquizforudacity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button_start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GameInfo.Score = 0;

        button_start = (Button) findViewById(R.id.button_start);
        button_start.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_start:
                Intent intent = new Intent(this, Question_1_Activity.class);
                startActivity(intent);
                finish();
        }
    }
}
