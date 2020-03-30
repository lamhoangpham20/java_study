package android.java.lab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class PhoneDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_detail);
        final Intent intent = getIntent();
        String text =intent.getStringExtra("PHONE_NUMBER");

        TextView textView = findViewById(R.id.phoneNumberTextView);
        textView.setText(text);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnIntent = new Intent();
                intent.putExtra("RETURN", "This is the secret message");
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
