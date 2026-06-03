package com.zetom1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.zetom1.model.Book;
import com.zetom1.service.BookService;

@RestController
@RequestMapping("/api/libros")
public class BookController {

    @Autowired
    private BookService bookService;

    // Endpoint para realizar el préstamo
    @PostMapping("/{id}/prestar")
    public ResponseEntity<?> prestarLibro(@PathVariable Long id) {
        try {
            // El controlador delega el trabajo al servicio
            Book libroActualizado = bookService.prestarLibro(id);
            
            // Si todo sale bien, devolvemos un código 200 (OK) con el libro
            return ResponseEntity.ok(libroActualizado);
            
        } catch (RuntimeException e) {
            // Si el servicio lanza el error (no hay stock o no existe el ID),
            // devolvemos un código 400 (Bad Request) con el mensaje de error
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Endpoint para crear un libro nuevo
    @PostMapping
    public ResponseEntity<Book> crearLibro(@RequestBody Book libro) {
        Book nuevoLibro = bookService.crearLibro(libro);
        return ResponseEntity.ok(nuevoLibro);
    }    

    @PostMapping("/{id}/devolver")
    public ResponseEntity<Book> devolverLibro(@PathVariable Long id) {
        Book libroActualizado = bookService.devolverLibro(id);
        return ResponseEntity.ok(libroActualizado);
    }

    @GetMapping
    public ResponseEntity<List<Book>> listarLibros() {
        List<Book> catalogo = bookService.getAllBooks();
        return ResponseEntity.ok(catalogo);
    }
}
