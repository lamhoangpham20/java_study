package android.java.lab2_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    public int click = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout layout = new LinearLayout(this);
        final Button gameButton = new Button(this);

        final Button nextButton = new Button(this);
        gameButton.setText("Hello, I'm the button");
        nextButton.setText("next task");
        layout.addView(gameButton);
        layout.addView(nextButton);
        setContentView(layout);
        final Intent intent = new Intent(this, Lab2_3_Activity.class);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
        gameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click ++;
                if (click == 1) {
                    gameButton.setText("You have Click " + click + " time");
                }
                else{
                    gameButton.setText("You have Click " + click + " times");
                }
            }
        });
    }
}
