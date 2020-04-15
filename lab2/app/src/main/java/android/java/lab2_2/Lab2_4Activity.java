package android.java.lab2_2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class Lab2_4Activity extends AppCompatActivity{

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout layout = new LinearLayout(this);
        LinearLayout btnLayout1 = new LinearLayout(this);
        LinearLayout btnLayout2 = new LinearLayout(this);
        Button englishBtn = new Button(this);
        Button sverigeBtn = new Button(this);
        Button suomeksiBtn = new Button(this);
        Button surpriseBtn = new Button(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        englishBtn.setText("English");
        sverigeBtn.setText("Sverige");
        suomeksiBtn.setText("Suomeksi");
        surpriseBtn.setText("Surprise");
        surpriseBtn.setId(1);
        btnLayout1.addView(englishBtn);
        btnLayout1.addView(sverigeBtn);
        btnLayout2.addView(suomeksiBtn);
        btnLayout2.addView(surpriseBtn);
        final TextView textView = new TextView(this);
        setContentView(layout);
        final EditText editText= new EditText(this);
        layout.addView(editText);
        layout.addView(btnLayout1);
        layout.addView(btnLayout2);
        layout.addView(textView);
        englishBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                textView.setText("Hello " + editText.getText());
            }
        });
        sverigeBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                textView.setText("Hejjsan " + editText.getText());
            }
        });
        suomeksiBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                textView.setText("Terve " + editText.getText());
            }
        });
        surpriseBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                textView.setText("Hola " + editText.getText());
            }
        });
    }
}
