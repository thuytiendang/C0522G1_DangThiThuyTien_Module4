package com.musicApp.repository.impl;

import com.musicApp.model.Music;
import com.musicApp.repository.IMusicRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class MusicRepository implements IMusicRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Music> findAll() {
        TypedQuery<Music> query = entityManager.createQuery("SELECT m FROM Music as m", Music.class);
        return query.getResultList();
    }

    @Override
    public void save(Music music) {
        entityManager.persist(music);
    }

    @Override
    public Music findById(int id) {
        return entityManager.find(Music.class, id);
    }

    @Override
    public void update(Music music) {
        entityManager.merge(music);
    }

    @Override
    public void delete(int id) {
        entityManager.remove(entityManager.find(Music.class, id));
    }
}
