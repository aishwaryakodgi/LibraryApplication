package com.libraryApplication.library.controller;

import com.libraryApplication.library.LibraryApplication;
import com.libraryApplication.library.model.Library;
import com.libraryApplication.library.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/book")
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    @PostMapping("/addbook")
    public Library addbook(@RequestBody Library library) {
        return libraryService.addbook(library);

    }

    @GetMapping("/listallbook")
    public List<Library> getbook() {
        return libraryService.getbook();

    }
    @GetMapping("/viewbyid/{bookId}")
    public Optional<Library> listbook(@PathVariable("bookId") int bookId) {
        return libraryService.listbook(bookId);
    }

    @GetMapping("/viewbytitle/{bookTitle}")
    public Optional<Library> listbytitle(@PathVariable("bookTitle") String bookTitle) {
        return libraryService.listbytitle(bookTitle);
    }

    @GetMapping("/viewbygenre/{genre}")
    public Optional<Library> listbygenre(@PathVariable("genre") String genre) {
        return libraryService.listbygenre(genre);
    }

    @GetMapping("/viewbyauthor/{author}")
    public Optional<Library> listbyauthor(@PathVariable("author") String author) {
        return libraryService.listbyauthor(author);
    }





    @DeleteMapping("/delete/{bookId}")
    public String deleteBook(@PathVariable("bookId") int bookId) {
        libraryService.deletebook(bookId);
        return "data deleted successfully";
    }

    @PutMapping("/update/{bookId}")
    public Library updateBook(@RequestBody Library library, @PathVariable("bookId") int bookId) {
        return libraryService.updateBook(bookId, library);
    }

}
