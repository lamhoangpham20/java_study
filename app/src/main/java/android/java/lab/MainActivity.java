package android.java.lab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String[] COUNTRIES = new String[]{
                "Afghanistan","Albania", "Angeria", "American Samoa", "Andorra",
                "Angola","Anguilla"
        };
        ListView myListView = (ListView) findViewById(R.id.country_list_view);
        final ArrayAdapter<String> aa ;
        aa = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,COUNTRIES);
        myListView.setAdapter(aa);

    }
}
