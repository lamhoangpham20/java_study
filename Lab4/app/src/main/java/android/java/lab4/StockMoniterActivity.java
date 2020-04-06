package android.java.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class StockMoniterActivity extends AppCompatActivity {
    RequestQueue queue = null;
    ArrayList<String> prices = new ArrayList<String>();
    ArrayAdapter<String> todoAdapter;
    private Object ArrayAdapter;

    public static void setTimeout(Runnable runnable, int delay){
        new Thread(() -> {
            try {
                Thread.sleep(delay);
                runnable.run();
            }
            catch (Exception e){
                System.err.println(e);
            }
        }).start();
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final String[] brands = new String[]{
                "AAPL", "GOOGL", "FB", "NOK"
        };
        for (int i = 0; i < brands.length; i++) {
            prices.add(brands[i]);
        }
        setContentView(R.layout.activity_stock_moniter);
        for (int i = 0; i < brands.length; i++) {
            RequestQueue queue = Volley.newRequestQueue(this);
            final String id = brands[i];
            String url = String.format("https://financialmodelingprep.com/api/company/price/%s?datatype=json", id);
            Log.i("id",id);
// Request a string response from the provided URL.
            JsonObjectRequest stringRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            // Display the first 500 characters of the response string.
                            try {
                                JSONObject brand = response.getJSONObject(id);
                                String price = brand.getString("price");
                                prices.add(price);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.i("error", "error");
                }

            }
            );
            queue.add(stringRequest);
        }

        ListView todoListView = findViewById(R.id.brand);

        setTimeout(()-> {ArrayAdapter<String> todoAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, prices);},5000);

        setTimeout(()->todoListView.setAdapter(todoAdapter),5000);
    }


}