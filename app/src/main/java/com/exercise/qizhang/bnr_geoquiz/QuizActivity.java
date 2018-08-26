package com.exercise.qizhang.bnr_geoquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.exercise.qizhang.bnr_geoquiz.model.Question;

public class QuizActivity extends AppCompatActivity {
    private static final String TAG = QuizActivity.class.getSimpleName();

    private Button mTrueButton;
    private Button mFalseButton;
    private Button mPrevButton;
    private Button mNextButton;
    private TextView mGeoTextView;

    private Question[] questions;

    private int mCurrentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        initWidgets();
        initQuestions();
        updateQeustionText();

        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);
            }
        });

        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
            }
        });

        mPrevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex + (questions.length - 1)) % questions.length;
                updateQeustionText();
            }
        });

        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "next clicked!");
                mCurrentIndex = (mCurrentIndex + 1) % questions.length;
                updateQeustionText();
            }
        });
    }

    private void initWidgets() {
        mTrueButton = findViewById(R.id.true_button);
        mFalseButton = findViewById(R.id.false_button);
        mPrevButton = findViewById(R.id.pre_button);
        mNextButton = findViewById(R.id.next_button);

        mGeoTextView = findViewById(R.id.geo_quesion_text_view);
    }

    private void initQuestions() {
        questions = new Question[6];
        questions = new Question[] {
                questions[0] = new Question(R.string.question_australia, true),
                questions[1] = new Question(R.string.question_oceans, true),
                questions[2] = new Question(R.string.question_mideast, false),
                questions[3] = new Question(R.string.question_africa, false),
                questions[4] = new Question(R.string.question_americas, true),
                questions[5] = new Question(R.string.question_asia, true),
        };
    }


    private void updateQeustionText() {
        int textId = questions[mCurrentIndex].getQuestionId();
        mGeoTextView.setText(textId);
    }

    private void checkAnswer(boolean userPressed) {
        int toastId = (userPressed == questions[mCurrentIndex].ismAnswerTrue()) ? R.string.correct_toast : R.string.incorrect_toast;
        Toast.makeText(this, toastId, Toast.LENGTH_SHORT).show();
    }
}
