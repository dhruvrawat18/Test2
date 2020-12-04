package com.example.mohsin.customlistview;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String mTitle[] = {"Jagdish", "Tushar", "Himanshu", "Jayant", "Jay"};
    String mDescription[] = {"21", "21", "21", "21", "22"};
    String gender[] = {"male","male","male","male","male" };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        Button button = findViewById(R.id.add);
        // now create an adapter class
        MyAdapter adapter = new MyAdapter(this, mTitle, mDescription, gender);
        listView.setAdapter(adapter);

    }

    public void addFriends(){
        Intent i = new Intent(MainActivity.this, Form.class );
        startActivity(i);
    }
    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String rTitle[];
        String rDescription[];
        String rGender[];

        MyAdapter (Context c, String title[], String description[], String gender[]) {
            super(c, R.layout.row, R.id.textView1, title);
            this.context = c;
            this.rTitle = title;
            this.rDescription = description;
            this.rGender = gender;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row, parent, false);
            TextView myTitle = row.findViewById(R.id.textView1);
            TextView myDescription = row.findViewById(R.id.textView2);
            TextView gender = row.findViewById(R.id.gender);

            // now set our resources on views
            myTitle.setText(rTitle[position]);
            myDescription.setText(rDescription[position]);
            gender.setText(rGender[position]);





            return row;
        }
    }
}
