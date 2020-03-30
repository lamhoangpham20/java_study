package android.java.lab2_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Button gameButton = new Button(this);
        final int[] click = {0};
        gameButton.setText("Hello, I'm the button");
        setContentView(gameButton);
        gameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click[0] ++;
                if (click[0] == 1) {
                    gameButton.setText("You have Click " + click[0] + " time");
                }
                else{
                    gameButton.setText("You have Click " + click[0] + " times");
                }
            }
        });
    }
}
