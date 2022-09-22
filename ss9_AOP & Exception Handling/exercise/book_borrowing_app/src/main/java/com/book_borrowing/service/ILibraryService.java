package com.book_borrowing.service;

import com.book_borrowing.model.Library;

import java.util.List;
import java.util.Optional;

public interface ILibraryService {

    List<Library> findAll();

    Optional<Library> findById(int id);

    void update(Library library);

    Library findByCode(String code);
}
