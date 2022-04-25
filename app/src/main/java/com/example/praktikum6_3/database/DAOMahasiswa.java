package com.example.praktikum6_3.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface DAOMahasiswa {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Mahasiswa note);
    @Update()
    void update(Mahasiswa note);
    @Delete()
    void delete(Mahasiswa note);
    @Query("SELECT * from Mahasiswa ORDER BY id ASC")
    List<Mahasiswa> getAllNotes();
}
