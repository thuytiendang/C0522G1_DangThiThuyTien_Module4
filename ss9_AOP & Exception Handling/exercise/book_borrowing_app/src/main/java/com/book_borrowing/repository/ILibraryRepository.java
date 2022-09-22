package com.book_borrowing.repository;

import com.book_borrowing.model.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ILibraryRepository extends JpaRepository<Library, Integer> {

    @Query(value = "select * from library where code = :code1", nativeQuery = true)
    Library findByCode(@Param("code1") String code);
}
