package com.test.catsquizforudacity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Question_1_Activity extends AppCompatActivity implements View.OnClickListener {

    ImageView mCatImage;

    RadioButton mRadioButton1;
    RadioButton mRadioButton2;
    RadioButton mRadioButton3;
    RadioButton mRadioButton4;

    Button mButtonAnswer;
    Button mButtonNext;

    TextView mQuestionAndCongratulation;
    TextView numberOfQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_rb);

        initializationView();
    }

    private void initializationView() {
        mCatImage = (ImageView) findViewById(R.id.cat_image);
        mCatImage.setImageResource(R.drawable.persian_q1);
        mQuestionAndCongratulation = (TextView) findViewById(R.id.question_and_congratulation);
        mQuestionAndCongratulation.setText(R.string.question_1);
        numberOfQuestion = (TextView) findViewById(R.id.number_of_question);
        numberOfQuestion.setText(R.string.question_number_1);
        mRadioButton1 = (RadioButton) findViewById(R.id.radio_button_button_1);
        mRadioButton2 = (RadioButton) findViewById(R.id.radio_button_button_2);
        mRadioButton3 = (RadioButton) findViewById(R.id.radio_button_button_3);
        mRadioButton4 = (RadioButton) findViewById(R.id.radio_button_button_4);
        mButtonAnswer = (Button) findViewById(R.id.button_answer);
        mButtonNext = (Button) findViewById(R.id.button_next);
        mButtonNext.setVisibility(View.INVISIBLE);
        mRadioButton1.setText(R.string.persian);
        mRadioButton2.setText(R.string.british_shorthair);
        mRadioButton3.setText(R.string.british_shorthair);
        mRadioButton4.setText(R.string.chartreux);
        mRadioButton1.setOnClickListener(this);
        mRadioButton2.setOnClickListener(this);
        mRadioButton3.setOnClickListener(this);
        mRadioButton4.setOnClickListener(this);
        mButtonAnswer.setOnClickListener(this);
        mButtonNext.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.radio_button_button_1:
                mRadioButton2.setChecked(false);
                mRadioButton3.setChecked(false);
                mRadioButton4.setChecked(false);
                break;
            case R.id.radio_button_button_2:
                mRadioButton1.setChecked(false);
                mRadioButton3.setChecked(false);
                mRadioButton4.setChecked(false);
                break;
            case R.id.radio_button_button_3:
                mRadioButton1.setChecked(false);
                mRadioButton2.setChecked(false);
                mRadioButton4.setChecked(false);
                break;
            case R.id.radio_button_button_4:
                mRadioButton1.setChecked(false);
                mRadioButton2.setChecked(false);
                mRadioButton3.setChecked(false);
                break;
            case R.id.button_answer:
                if (mRadioButton1.isChecked() | mRadioButton2.isChecked() | mRadioButton3.isChecked() | mRadioButton4.isChecked()) {

                    if (mRadioButton1.isChecked()) {
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
                    Toast.makeText(this, R.string.pls_answer, Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.button_next:
                Intent intent = new Intent(this, Question_2_Activity.class);
                startActivity(intent);
                finish();
                break;
        }
    }

    private void setAllClickableFalse() {
        mRadioButton1.setClickable(false);
        mRadioButton2.setClickable(false);
        mRadioButton3.setClickable(false);
        mRadioButton4.setClickable(false);
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
        outState.putBoolean("mCheckBox1", mRadioButton1.isChecked());
        outState.putBoolean("mCheckBox2", mRadioButton2.isChecked());
        outState.putBoolean("mCheckBox3", mRadioButton3.isChecked());
        outState.putBoolean("mCheckBox4", mRadioButton4.isChecked());
        outState.putInt("mButtonAnswer", mButtonAnswer.getVisibility());
        outState.putInt("mButtonExit", mButtonNext.getVisibility());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        numberOfQuestion.setText(savedInstanceState.getString("numberOfQuestion"));
        mQuestionAndCongratulation.setText(savedInstanceState.getString("mQuestionAndCongratulation"));
        mRadioButton1.setChecked(savedInstanceState.getBoolean("mCheckBox1"));
        mRadioButton2.setChecked(savedInstanceState.getBoolean("mCheckBox2"));
        mRadioButton3.setChecked(savedInstanceState.getBoolean("mCheckBox3"));
        mRadioButton4.setChecked(savedInstanceState.getBoolean("mCheckBox4"));
        mButtonAnswer.setVisibility(savedInstanceState.getInt("mButtonAnswer"));
        mButtonNext.setVisibility(savedInstanceState.getInt("mButtonExit"));
        if (mButtonNext.getVisibility() == View.VISIBLE) {
            setAllClickableFalse();
        }
    }
}
