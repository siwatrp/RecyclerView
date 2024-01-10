package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Mhs> mhsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText inpNama = (EditText) findViewById(R.id.inpNama) ;
        EditText inpNim = (EditText) findViewById(R.id.inpNim) ;
        EditText inpNoHP = (EditText) findViewById(R.id.inpNoHP) ;
        Button btnSimpan = (Button) findViewById(R.id.btnSimpan);

       ArrayList<Mhs> mhsList = new ArrayList<>();
        Intent intent_List = new Intent(MainActivity.this, ListActivity.class);
        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String isian_nama = inpNama.getText().toString();
                String isian_Nim = inpNim.getText().toString();
                String isian_NoHP= inpNoHP.getText().toString();

                if(isian_nama.isEmpty() || isian_Nim.isEmpty()  || isian_NoHP.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Isi masih kosong", Toast.LENGTH_SHORT).show();
                }else {
                    mhsList.add(new Mhs(isian_nama, isian_Nim, isian_NoHP));
                    inpNama.setText("");
                    inpNim.setText("");
                    inpNoHP.setText("");

                    intent_List.putParcelableArrayListExtra("mhsList", mhsList);
                    startActivity(intent_List);
                }
            }
        });
        Button btnLihat = (Button) findViewById(R.id.btnLihat);
        btnLihat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mhsList.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Belum ada data", Toast.LENGTH_SHORT).show();
                }
                intent_List.putParcelableArrayListExtra("mhsList", mhsList);
                startActivity(intent_List);
            }
        });
    }
}