package android.java.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    RequestQueue queue = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.enterURL).setOnClickListener(this);
}
public void sendRequest()
{
    final TextView textView = (TextView) findViewById(R.id.text);
    RequestQueue queue = Volley.newRequestQueue(this);
    EditText editText = findViewById(R.id.url);
    String url = editText.getText().toString();

// Request a string response from the provided URL.
    StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    // Display the first 500 characters of the response string.
                    textView.setText("Response is: "+ response.substring(0,500));
                }
            }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            textView.setText("That didn't work!");
        }
    });

// Add the request to the RequestQueue.
    queue.add(stringRequest);
    Log.i("String", url);
}

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.enterURL) {
            sendRequest();
        }
    }
    public void nextTask(View view)
    {
        Intent intent = new Intent(this, StockMoniterActivity.class);
        startActivity(intent);
    }
}
