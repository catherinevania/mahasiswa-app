package com.example.praktikum6_3.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.praktikum6_3.R;
import com.example.praktikum6_3.mahasiswaAdapter;
import com.example.praktikum6_3.mahasiswaDataSet;
import com.example.praktikum6_3.repository.MahasiswaRepository;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.example.praktikum6_3.database.Mahasiswa;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText nama, nim;
    private EditText input_nama, input_nim;
    private Button submitButton;
    private RecyclerView recyclerView;
    private com.example.praktikum6_3.mahasiswaAdapter mahasiswaAdapter;
    private com.example.praktikum6_3.mahasiswaDataSet mahasiswaDataSet;
    private FloatingActionButton refreshButton, addButton;
    private ConstraintLayout form;
    private LinearLayout list;
    private MahasiswaRepository mahasiswaRepository;
    @SuppressLint("WrongViewCast")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mahasiswaRepository = new MahasiswaRepository(getApplicationContext());
        recyclerView = findViewById(R.id.recyclerView);
        mahasiswaDataSet = new mahasiswaDataSet();
        ArrayList<Mahasiswa> listMhs = new ArrayList<>(mahasiswaRepository.getAllNotes());
        Toast.makeText(this, String.valueOf(listMhs.size()), Toast.LENGTH_SHORT).show();
        mahasiswaAdapter = new mahasiswaAdapter(listMhs, mahasiswaRepository);
        refreshButton = findViewById(R.id.refreshButton);
        addButton = findViewById(R.id.addButton);
        form = findViewById(R.id.form);
        list = findViewById(R.id.list);
        nama = findViewById(R.id.nama);
        nim = findViewById(R.id.nim);
        input_nama = findViewById(R.id.input_nama);
        input_nim = findViewById(R.id.input_nim);
        submitButton = findViewById(R.id.button);
//        setRecyclerView();
        refreshButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setRecyclerView();
            }
        });
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                form.setVisibility(View.VISIBLE);
                list.setVisibility(View.GONE);
            }
        });
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String string_nama = input_nama.getText().toString();
                String string_nim = input_nim.getText().toString();
                form.setVisibility(View.GONE);
                list.setVisibility(View.VISIBLE);
                mahasiswaRepository.insert(new Mahasiswa(string_nama, string_nim));
                startActivity(getIntent());
            }
        });

    }
    private void setRecyclerView(){
        recyclerView.setAdapter(mahasiswaAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}