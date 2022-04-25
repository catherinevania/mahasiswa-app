package com.example.praktikum6_3;

import com.example.praktikum6_3.database.Mahasiswa;

import java.util.ArrayList;

public class mahasiswaDataSet {
    private ArrayList<Mahasiswa> dataMahasiswa = new ArrayList<>();

    public mahasiswaDataSet() {
        dataMahasiswa.add(new Mahasiswa("Catherine", "205150700111001"));
        dataMahasiswa.add(new Mahasiswa("Yerobal", "205150700111002"));
        dataMahasiswa.add(new Mahasiswa("Novel", "205150707111009"));
        dataMahasiswa.add(new Mahasiswa("Vania", "205150700111028"));
    }

    public ArrayList<Mahasiswa> getDataMahasiswa() {
        return dataMahasiswa;
    }
    public void addMahasiswa(String nama, String nim){
        dataMahasiswa.add((new Mahasiswa(nama, nim)));
    }
}
