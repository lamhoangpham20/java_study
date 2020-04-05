package android.java.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

public class EggTimerViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_egg_timer_view);
        Intent intent = getIntent();
        String message = intent.getStringExtra(EggTimerActivity.timer);
        final TextView textView = findViewById(R.id.textView);
        new CountDownTimer(Integer.parseInt(message)*1000, 1000) {

            public void onTick(long millisUntilFinished) {
                textView.setText("seconds remaining: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                textView.setText("done!");
            }
        }.start();

    }
}
