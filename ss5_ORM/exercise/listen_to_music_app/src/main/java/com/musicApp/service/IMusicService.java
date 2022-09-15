package com.musicApp.service;

import com.musicApp.model.Music;

import java.util.List;

public interface IMusicService {
    List<Music> findAll();

    void save(Music music);

    Music findById(int id);

    void update(Music music);

    void delete(int id);
}
