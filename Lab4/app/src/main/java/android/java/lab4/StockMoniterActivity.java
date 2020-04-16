package android.java.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
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
    ArrayList<String> brands = new ArrayList<String>();
    ArrayList<String> list = new ArrayList<String>();
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
        final String[] brand = new String[]{
                "AAPL", "GOOGL", "FB", "NOK"
        };
        for (int i = 0; i < brand.length; i++) {
            brands.add(brand[i]);
        }
        setContentView(R.layout.activity_stock_moniter);
        for (int i = 0; i < brand.length; i++) {
            RequestQueue queue = Volley.newRequestQueue(this);
            final String id = brand[i];
            String url = "https://financialmodelingprep.com/api/company/price/" +id+ "?datatype=json";
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
                                Log.i("price", price);
                                prices.add(price);
                                Log.i("hello", Integer.toString(prices.size()));
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

    }
    public void showList(View view)
    {
        for (int i=0;i<prices.size();i++)
        {
            String item = brands.get(i) + " :" + prices.get(i);
            list.add(item);
        }
        ListView todoListView = findViewById(R.id.brand);
        ArrayAdapter<String> todoAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, list);

        todoListView.setAdapter(todoAdapter);
    }

}