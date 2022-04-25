package com.example.praktikum6_3.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
@Database(entities = {Mahasiswa.class}, version = 1)
public abstract class MahasiswaRoomDB extends RoomDatabase {
    public abstract DAOMahasiswa daoNote();
    private static volatile MahasiswaRoomDB INSTANCE;
    public static MahasiswaRoomDB getDatabase(final Context context){
        if (INSTANCE == null){
            synchronized (MahasiswaRoomDB.class){
                INSTANCE =
                        Room.databaseBuilder(context.getApplicationContext(),
                                MahasiswaRoomDB.class, "mahasiswa_db").allowMainThreadQueries().build();
            }
        }
        return INSTANCE;
    }
}
