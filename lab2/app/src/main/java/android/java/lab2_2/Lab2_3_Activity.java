package android.java.lab2_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

public class Lab2_3_Activity extends AppCompatActivity {
    final String[] COUNTRIES = new String[]{
            "Afghanistan","Albania", "Angeria", "American Samoa", "Andorra",
            "Angola","Anguilla"
    };
    ArrayList<String> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        list = new ArrayList<>();
        for(int i=0; i<COUNTRIES.length; i++)
        {
            list.add(COUNTRIES[i]);
        }
        LinearLayout layout = new LinearLayout(this);
        LinearLayout btnLayout = new LinearLayout(this);
        Button addBtn = new Button(this);
        Button editBtn = new Button(this);
        Button removeBtn = new Button(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        addBtn.setText("Add");
        editBtn.setText("Edit");
        removeBtn.setText("Remove");
        btnLayout.addView(addBtn);
        btnLayout.addView(editBtn);
        btnLayout.addView(removeBtn);
        final ListView listView = new ListView(this);
        setContentView(layout);
        final EditText editText= new EditText(this);
        layout.addView(btnLayout);
        layout.addView(editText);
        layout.addView(listView);
        final ArrayAdapter<String> aa ;
        aa = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,list);
        listView.setAdapter(aa);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString();
                list.add(text);
                listView.setAdapter(aa);
            }
        });
        removeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString();
                for (int i=0;i<list.size();i++)
                {
                    if(text.equals(list.get(i)))
                    {
                        list.remove(list.get(i));
                        listView.setAdapter(aa);
                    }
                }
            }
        });
    }
}
