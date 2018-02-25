package com.test.catsquizforudacity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Question_4_Activity extends AppCompatActivity implements View.OnClickListener {

    ImageView mCatImage;

    Button mButtonAnswer;
    Button mButtonExit;

    EditText mEditText;

    TextView mQuestionAndCongratulation;
    TextView numberOfQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_et);

        initializationView();
    }

    private void initializationView() {
        mCatImage = (ImageView) findViewById(R.id.cat_image);
        mCatImage.setImageResource(R.drawable.number_of_life_q4);
        mQuestionAndCongratulation = (TextView) findViewById(R.id.question_and_congratulation);
        mQuestionAndCongratulation.setText(R.string.question_4);
        numberOfQuestion = (TextView) findViewById(R.id.number_of_question);
        numberOfQuestion.setText(R.string.question_number_4);

        mEditText = (EditText) findViewById(R.id.edit_text);

        mButtonAnswer = (Button) findViewById(R.id.button_answer);
        mButtonExit = (Button) findViewById(R.id.button_exit);
        mButtonExit.setVisibility(View.INVISIBLE);
        mButtonAnswer.setOnClickListener(this);
        mButtonExit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_answer:
                if (mButtonAnswer.getText().toString().equals(getResources().getString(R.string.result))) {
                    Toast toast = Toast.makeText(this, getString(R.string.you_answered) + " " + GameInfo.Score + " " + getString(R.string.questions_out_of_4), Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                    break;
                }
                if (!mEditText.getText().toString().isEmpty()) {
                    if (9 == Integer.parseInt(mEditText.getText().toString())) {
                        mButtonAnswer.setText(R.string.result);
                        mButtonExit.setVisibility(View.VISIBLE);
                        mQuestionAndCongratulation.setText(R.string.right);
                        GameInfo.Score++;
                    } else {
                        mButtonExit.setVisibility(View.VISIBLE);
                        mButtonExit.setText(R.string.result);
                        mQuestionAndCongratulation.setText(R.string.wrong);
                    }
                } else {
                    Toast.makeText(this, R.string.pls_answer, Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.button_exit:
                finish();
                break;
        }
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
        outState.putInt("mButtonAnswer", mButtonAnswer.getVisibility());
        outState.putInt("mButtonExit", mButtonExit.getVisibility());
        outState.putString("mButtonAnswerName", mButtonAnswer.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        numberOfQuestion.setText(savedInstanceState.getString("numberOfQuestion"));
        mQuestionAndCongratulation.setText(savedInstanceState.getString("mQuestionAndCongratulation"));
        mButtonAnswer.setVisibility(savedInstanceState.getInt("mButtonAnswer"));
        mButtonExit.setVisibility(savedInstanceState.getInt("mButtonExit"));
        mButtonAnswer.setText(savedInstanceState.getString("mButtonAnswerName"));
    }
}
