package com.example.praktikum6_3.ui;

import android.app.Application;

import androidx.lifecycle.ViewModel;

import com.example.praktikum6_3.database.Mahasiswa;
import com.example.praktikum6_3.repository.MahasiswaRepository;

public class NoteInsertUpdateViewModel extends ViewModel {
    private final MahasiswaRepository mahasiswaRepository;
    public NoteInsertUpdateViewModel(Application application) {
        mahasiswaRepository = new MahasiswaRepository(application);
    }
    public void insert(Mahasiswa note) {
        mahasiswaRepository.insert(note);
    }
    public void update(Mahasiswa note) {
        mahasiswaRepository.update(note);
    }
    public void delete(Mahasiswa note) {
        mahasiswaRepository.delete(note);
    }
}
