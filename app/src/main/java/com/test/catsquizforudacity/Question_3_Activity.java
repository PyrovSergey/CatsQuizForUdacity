package com.test.catsquizforudacity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Question_3_Activity extends AppCompatActivity implements View.OnClickListener {

    ImageView mCatImage;

    CheckBox mCheckBox1;
    CheckBox mCheckBox2;
    CheckBox mCheckBox3;
    CheckBox mCheckBox4;

    Button mButtonAnswer;
    Button mButtonNext;

    TextView mQuestionAndCongratulation;
    TextView numberOfQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_chb);

        initializationView();
    }

    private void initializationView() {
        mCatImage = (ImageView) findViewById(R.id.cat_image);
        mCatImage.setImageResource(R.drawable.munchkin_q3);
        mQuestionAndCongratulation = (TextView) findViewById(R.id.question_and_congratulation);
        mQuestionAndCongratulation.setText(R.string.question_3);
        numberOfQuestion = (TextView) findViewById(R.id.number_of_question);
        numberOfQuestion.setText(R.string.question_number_3);
        mCheckBox1 = (CheckBox) findViewById(R.id.chb_button_button_1);
        mCheckBox2 = (CheckBox) findViewById(R.id.chb_button_button_2);
        mCheckBox3 = (CheckBox) findViewById(R.id.chb_button_button_3);
        mCheckBox4 = (CheckBox) findViewById(R.id.chb_button_button_4);
        mButtonAnswer = (Button) findViewById(R.id.button_answer);
        mButtonNext = (Button) findViewById(R.id.button_next);
        mButtonNext.setVisibility(View.INVISIBLE);
        mCheckBox1.setText(R.string.not_swim);
        mCheckBox2.setText(R.string.ragamuffin);
        mCheckBox3.setText(R.string.mutation);
        mCheckBox4.setText(R.string.munchkin);
        mCheckBox1.setOnClickListener(this);
        mCheckBox2.setOnClickListener(this);
        mCheckBox3.setOnClickListener(this);
        mCheckBox4.setOnClickListener(this);
        mButtonAnswer.setOnClickListener(this);
        mButtonNext.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_answer:
                if (mCheckBox4.isChecked() || mCheckBox3.isChecked() || mCheckBox1.isChecked() || mCheckBox2.isChecked()) {
                    if (mCheckBox4.isChecked() & mCheckBox3.isChecked() & !mCheckBox1.isChecked() & !mCheckBox2.isChecked()) {
                        mButtonAnswer.setVisibility(View.GONE);
                        mButtonNext.setVisibility(View.VISIBLE);
                        setAllClickableFalse();
                        mQuestionAndCongratulation.setText(R.string.right);
                        GameInfo.Score++;
                    } else {
                        mButtonAnswer.setVisibility(View.GONE);
                        mButtonNext.setVisibility(View.VISIBLE);
                        setAllClickableFalse();
                        mQuestionAndCongratulation.setText(R.string.wrong);
                    }
                } else {
                    Toast.makeText(this, R.string.pls_two_answer, Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.button_next:
                Intent intent = new Intent(this, Question_4_Activity.class);
                startActivity(intent);
                finish();
                break;
        }
    }

    private void setAllClickableFalse() {
        mCheckBox1.setClickable(false);
        mCheckBox2.setClickable(false);
        mCheckBox3.setClickable(false);
        mCheckBox4.setClickable(false);
    }

    @Override
    public void onBackPressed() {
        return;
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("numberOfQuestion", numberOfQuestion.getText().toString());
        outState.putString("mQuestionAndCongratulation", mQuestionAndCongratulation.getText().toString());
        outState.putBoolean("mCheckBox1", mCheckBox1.isChecked());
        outState.putBoolean("mCheckBox2", mCheckBox2.isChecked());
        outState.putBoolean("mCheckBox3", mCheckBox3.isChecked());
        outState.putBoolean("mCheckBox4", mCheckBox4.isChecked());
        outState.putInt("mButtonAnswer", mButtonAnswer.getVisibility());
        outState.putInt("mButtonExit", mButtonNext.getVisibility());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        numberOfQuestion.setText(savedInstanceState.getString("numberOfQuestion"));
        mQuestionAndCongratulation.setText(savedInstanceState.getString("mQuestionAndCongratulation"));
        mCheckBox1.setChecked(savedInstanceState.getBoolean("mCheckBox1"));
        mCheckBox2.setChecked(savedInstanceState.getBoolean("mCheckBox2"));
        mCheckBox3.setChecked(savedInstanceState.getBoolean("mCheckBox3"));
        mCheckBox4.setChecked(savedInstanceState.getBoolean("mCheckBox4"));
        mButtonAnswer.setVisibility(savedInstanceState.getInt("mButtonAnswer"));
        mButtonNext.setVisibility(savedInstanceState.getInt("mButtonExit"));
        if (mButtonNext.getVisibility() == View.VISIBLE) {
            setAllClickableFalse();
        }
    }
}
