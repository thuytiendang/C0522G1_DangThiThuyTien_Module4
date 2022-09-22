package com.book_borrowing.service.impl;

import com.book_borrowing.model.Library;
import com.book_borrowing.repository.ILibraryRepository;
import com.book_borrowing.service.ILibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibraryService implements ILibraryService {

    @Autowired
    private ILibraryRepository iLibraryRepository;

    @Override
    public List<Library> findAll() {
        return iLibraryRepository.findAll();
    }

    @Override
    public Optional<Library> findById(int id) {
        return iLibraryRepository.findById(id);
    }

    @Override
    public void update(Library library) {
        iLibraryRepository.save(library);
    }

    @Override
    public Library findByCode(String code) {
        return iLibraryRepository.findByCode(code);
    }
}
