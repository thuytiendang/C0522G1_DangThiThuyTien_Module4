package com.musicApp.repository;

import com.musicApp.model.Music;

import java.util.List;

public interface IMusicRepository {
    List<Music> findAll();

    void save(Music music);

    Music findById(int id);

    void update(Music music);

    void delete(int id);
}
