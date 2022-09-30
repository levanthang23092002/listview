package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnThem, btnCapNhat;
    ListView lvMonhoc;
    EditText edtMonhoc;
    ArrayList<String> arrMonhoc;
    int vitri = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnThem = (Button) findViewById(R.id.btnThem);
        btnCapNhat = (Button) findViewById(R.id.btnCapNhat);
        edtMonhoc = (EditText) findViewById(R.id.edtMonhoc);
        lvMonhoc = (ListView) findViewById(R.id.lvMonhoc);

        arrMonhoc = new ArrayList<>();
        arrMonhoc.add("PHP");
        arrMonhoc.add("CSS");
        arrMonhoc.add("HTML");
        arrMonhoc.add("WEB");
        arrMonhoc.add("C#");

        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, arrMonhoc);

        lvMonhoc.setAdapter(adapter);

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String monhoc;
                monhoc = edtMonhoc.getText().toString();
                arrMonhoc.add(monhoc);
                adapter.notifyDataSetChanged();
                edtMonhoc.setText("");
            }
        });

        lvMonhoc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                edtMonhoc.setText(arrMonhoc.get(i));
                vitri =i;

            }
        });
        btnCapNhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrMonhoc.set(vitri,edtMonhoc.getText().toString());
                adapter.notifyDataSetChanged();
                edtMonhoc.setText("");
            }
        });

        lvMonhoc.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                arrMonhoc.remove(i);
                adapter.notifyDataSetChanged();
                return false;
            }
        });


    }
}