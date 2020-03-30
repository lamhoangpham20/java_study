package android.java.lab;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int REQ_CODE= 12345;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*LinearLayout parent= new LinearLayout(this);
        parent.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT ,ViewGroup.LayoutParams);
        parent.setOrientation(LinearLayout.VERTICAL);
        Button button = new Button(this);
        button.setText("Press Me!");
        button.setOnClickListener(this);
        parent.addView(button);
        TextView textView=new TextView(this);
        textView.setText("Hello");
        parent.addView(textView);*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.layout, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.settings)
        {
            //
        }
        return true;
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.openActivity)
        {
            EditText editor = findViewById(R.id.textEditor);
            String tel = editor.getText().toString();

            Intent intent = new Intent(this, PhoneDetailActivity.class);
            intent.putExtra("PHONE_NUMBER", tel);

            startActivityForResult(intent, REQ_CODE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQ_CODE && resultCode == RESULT_OK)
        {

        }
    }
}
