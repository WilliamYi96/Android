package com.example.williamyi.todolist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        ListView myListView = (ListView) findViewById(R.id.myListView);
        final EditText myEditText = (EditText) findViewById(R.id.myEditText);

        //Create ArrayList of todoItems
        final ArrayList<String> todoItems = new ArrayList<String>();
        //Create ArrayAdapter and bind array to ListView
        final ArrayAdapter<String> aa;

        aa = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,todoItems);

        //Bind ArrayAdapter to ListView
        myListView.setAdapter(aa);

        myEditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(event.getAction() == KeyEvent.ACTION_DOWN)
                    if(keyCode == KeyEvent.KEYCODE_DPAD_CENTER) {
                        todoItems.add(0,myEditText.getText().toString());
                        aa.notifyDataSetChanged();
                        myEditText.setText(null);
                        return true;
                    }
                return false;
            }
        });
    }
}
