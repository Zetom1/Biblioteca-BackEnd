package com.zetom1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.transaction.annotation.Transactional;

import com.zetom1.dto.BookCreateDTO;
import com.zetom1.model.Book;
import com.zetom1.repository.BookRepository;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    @Transactional
    public Book prestarLibro(Long id) {
        // 1. Buscamos el libro en la base de datos
       Book book = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("El libro con ID " + id + " no existe."));

        // 2. Validamos stock disponible
        if (book.getCantidad() <= 0) {
            throw new RuntimeException("No hay copias disponibles del libro: " + book.getTitulo());
        }

        // 3. Modificamos los datos en memoria
        book.setCantidad(book.getCantidad() - 1);
        if (book.getCantidad() == 0) {
            book.setReserva(false);
        }

        try {
            // 4. Intentamos guardar. Aquí JPA verificará si la versión cambió en segundo plano
            return repository.save(book);
        } catch (ObjectOptimisticLockingFailureException e) {
            // 5. Si otro usuario ganó la carrera, se lanza esta excepción
            throw new RuntimeException("El libro está siendo procesado por otro usuario. Por favor, inténtalo de nuevo.");
        }
    }

    // Método para crear un nuevo libro
    public Book crearLibro(Book libro) {
        // Al guardar, Spring Data JPA automáticamente le asignará un ID
        return repository.save(libro);
    }

    public Book saveFromDto(BookCreateDTO dto) {
        Book book = new Book();
        book.setTitulo(dto.getTitulo());
        book.setReserva(dto.getReserva());
        book.setCantidad(dto.getCantidad());
        return repository.save(book);
    }


    // 1. Obtener la lista completa de libros
    public List<Book> obtenerTodosLosLibros() {
        return repository.findAll(); // findAll() ya viene listo en JpaRepository
    }

    // 2. Lógica para devolver un libro
    @Transactional
    public Book devolverLibro(Long id) {
        // Buscamos el libro o lanzamos error si no existe
        Book libro = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("El libro con ID " + id + " no existe."));

        // Incrementamos el inventario disponible
        libro.setCantidad(libro.getCantidad() + 1);
       if (!Boolean.TRUE.equals(libro.getReserva()) && libro.getCantidad() == 1) {
        libro.setReserva(true);
    }

        // Si manejas estados de reserva, aquí podrías cambiar "reserva" a false si es necesario.
        
        return repository.save(libro);
    }

    public List<Book> getAllBooks() {
    return repository.findAll();
}
}