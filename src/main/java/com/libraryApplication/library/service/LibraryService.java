package com.libraryApplication.library.service;

import com.libraryApplication.library.model.Library;

import java.util.List;
import java.util.Optional;

public interface LibraryService {
    public Library addbook(Library library);

    public List<Library> getbook();

    public void deletebook(int bookId);


    public Library updateBook(int bookId, Library library);

     public Optional<Library> listbook(int bookId);

   public Optional<Library> listbytitle(String bookTitle);

    public  Optional<Library> listbygenre(String genre);

   public Optional<Library> listbyauthor(String author);
}
