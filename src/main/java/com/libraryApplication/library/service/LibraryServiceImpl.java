package com.libraryApplication.library.service;

import com.libraryApplication.library.model.Library;
import com.libraryApplication.library.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibraryServiceImpl implements LibraryService{

    @Autowired
    private LibraryRepository libraryRepository;

    @Override
    public Library addbook(Library library) {
        return libraryRepository.save(library);
    }

    @Override
    public List<Library> getbook()
    {
        return libraryRepository.findAll();
    }

    @Override
    public void deletebook(int bookId) {
        libraryRepository.deleteById(bookId);
    }

    @Override
    public Optional<Library> listbook(int bookId) {
        return libraryRepository.findById(bookId);}

    @Override
    public Optional<Library> listbytitle(String bookTitle ) {
        return libraryRepository.findByTitle(bookTitle);}

    @Override
    public Optional<Library> listbygenre(String genre) {
        return libraryRepository.findByGenre(genre);}

    @Override
    public Optional<Library> listbyauthor(String author) {
        return libraryRepository.findByAuthor(author);}

    @Override
    public Library updateBook(int bookId, Library library) {
        Optional<Library> findById = libraryRepository.findById(bookId);
        if(findById.isPresent()){
            Library bookUpdate=findById.get();
            if(library.getBookTitle()!=null && !library.getBookTitle().isEmpty())
                bookUpdate.setBookTitle(library.getBookTitle());
            if(library.getGenre()!=null && !library.getGenre().isEmpty())
                bookUpdate.setGenre(library.getGenre());
            if(library.getAuthor()!=null && !library.getAuthor().isEmpty())
                bookUpdate.setAuthor(library.getAuthor());
            return libraryRepository.save(bookUpdate);
        }
        return null;
    }



}
