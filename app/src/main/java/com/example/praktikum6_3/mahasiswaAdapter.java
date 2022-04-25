package com.example.praktikum6_3;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.praktikum6_3.database.Mahasiswa;
import com.example.praktikum6_3.repository.MahasiswaRepository;

import java.util.ArrayList;

public class mahasiswaAdapter extends RecyclerView.Adapter<mahasiswaAdapter.ViewHolder> {

    private ArrayList<Mahasiswa> localDataSet;
    private MahasiswaRepository mhsRepo;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView nama, nim;
        private Button deleteButton;
        private MahasiswaRepository mhsRepo;

        public ViewHolder(View view, MahasiswaRepository mhsRepo) {
            super(view);
            this.mhsRepo = mhsRepo;
            nama = (TextView) view.findViewById(R.id.nama);
            nim = (TextView) view.findViewById(R.id.nim);
            deleteButton = (Button) view.findViewById(R.id.deleteButton);
        }

        public TextView getNama() {
            return nama;
        }

        public TextView getNim() {
            return nim;
        }

        public TextView getDeleteButton() {
            return deleteButton;
        }
    }

    public mahasiswaAdapter(ArrayList<Mahasiswa> dataSet, MahasiswaRepository mhsRepo) {
        localDataSet = dataSet;
        this.mhsRepo = mhsRepo;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_mahasiswa, viewGroup, false);

        return new ViewHolder(view, mhsRepo);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, @SuppressLint("RecyclerView") final int position) {
        TextView nama = viewHolder.nama;
        TextView nim = viewHolder.nim;
        Button deleteButton = viewHolder.deleteButton;
        Mahasiswa dataMahasiswa = localDataSet.get(position);
        nama.setText(dataMahasiswa.getNama());
        nim.setText(dataMahasiswa.getNim());

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mhsRepo.delete(dataMahasiswa);
                localDataSet.remove(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return localDataSet.size();
    }
}

