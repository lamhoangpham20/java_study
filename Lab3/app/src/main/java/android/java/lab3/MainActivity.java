package android.java.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.next_button).setOnClickListener(this);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.layout, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        View main = findViewById(R.id.main);
        TextView text = findViewById(R.id.text);
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.red:
                main.setBackgroundColor(Color.parseColor("#FF0000"));
                text.setText("red");
                return true;
            case R.id.green:
                main.setBackgroundColor(Color.parseColor("#008000"));
                text.setText("green");
                return true;
            case R.id.blue:
                main.setBackgroundColor(Color.parseColor("#0000FF"));
                text.setText("blue");
                return true;
            case R.id.yellow:
                main.setBackgroundColor(Color.parseColor("#FFFF00"));
                text.setText("yellow");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.next_button)
        {
            Intent intent = new Intent(this, Lab3_2.class);
            startActivity(intent);
        }
    }
}
