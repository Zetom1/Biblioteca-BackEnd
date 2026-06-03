package com.zetom1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zetom1.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    
    // Para el préstamo básico, NO necesitas agregar nada aquí.
    // JpaRepository ya te regala los métodos findById() y save() que usaremos.

}