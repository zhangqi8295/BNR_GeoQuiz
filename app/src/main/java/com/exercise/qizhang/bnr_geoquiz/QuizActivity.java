package com.exercise.qizhang.bnr_geoquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {
    private Button mTrueButton;
    private Button mFalseButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        initWidgets();

        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast(R.string.correct_toast, Gravity.BOTTOM);
            }
        });

        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast(R.string.incorrect_toast, Gravity.TOP);
            }
        });
    }

    private void initWidgets() {
        mTrueButton = findViewById(R.id.true_button);
        mFalseButton = findViewById(R.id.false_button);
    }

    private void showToast(int stringId, int gravityPosition) {
//        Toast toast = new Toast(this);
//        toast.setGravity(gravityPosition, 0 , 0);
//        toast.setDuration(Toast.LENGTH_SHORT);

        Toast toast = Toast.makeText(this, stringId, Toast.LENGTH_SHORT);
        toast.setGravity(gravityPosition, 0, 0);
        toast.show();
    }

    /**
     * Set customize Toast
     * LayoutInflater inflater = getLayoutInflater();
     View layout = inflater.inflate(R.layout.custom_toast,
     (ViewGroup) findViewById(R.id.custom_toast_container));

     TextView text = (TextView) layout.findViewById(R.id.text);
     text.setText("This is a custom toast");

     Toast toast = new Toast(getApplicationContext());
     toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
     toast.setDuration(Toast.LENGTH_LONG);
     toast.setView(layout);
     toast.show();
     */
}
