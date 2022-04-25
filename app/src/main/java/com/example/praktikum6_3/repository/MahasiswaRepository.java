package com.example.praktikum6_3.repository;

import android.content.Context;

import com.example.praktikum6_3.database.DAOMahasiswa;
import com.example.praktikum6_3.database.Mahasiswa;
import com.example.praktikum6_3.database.MahasiswaRoomDB;

import java.util.List;

public class MahasiswaRepository {
    private final DAOMahasiswa mDaoNotes;
    public MahasiswaRepository(Context application) {
        MahasiswaRoomDB db = MahasiswaRoomDB.getDatabase(application);
        mDaoNotes = db.daoNote();
    }
    public List<Mahasiswa> getAllNotes() {
        return mDaoNotes.getAllNotes();
    }
    public void insert(final Mahasiswa mahasiswa) {
         mDaoNotes.insert(mahasiswa);
    }
    public void delete(final Mahasiswa mahasiswa){
         mDaoNotes.delete(mahasiswa);
    }
    public void update(final Mahasiswa mahasiswa){
        mDaoNotes.update(mahasiswa);
    }
}

