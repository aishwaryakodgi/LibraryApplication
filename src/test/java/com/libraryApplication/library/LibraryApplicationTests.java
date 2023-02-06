package com.libraryApplication.library;

import com.libraryApplication.library.model.Library;
import com.libraryApplication.library.repository.LibraryRepository;
import com.libraryApplication.library.service.LibraryService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.awt.print.Book;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class LibraryTaskApplicationTests {

	@Autowired
	private LibraryService libraryService;

	@MockBean
	private LibraryRepository libraryRepository;


	@Test
	public void addBookTest(){
		Library book_1=new Library(1, "PrettyCat", "Romance","Aishwarya");
		libraryService.addbook(book_1);
		verify(libraryRepository,times(1)).save(book_1);

	}

	@Test
	public void getAllBookTest(){
		when(libraryRepository.findAll()).thenReturn(Stream
				.of(new Library(1,"PrettCat","Romance","Aishwarya"),
						new Library(2,"BigDeal","Action","Saathvik"))
				.collect(Collectors.toList()));
		assertEquals(2,libraryService.getbook().size());
	}

	@Test
	public void updateBookTest(){
		int bookId=1;
		Library book_1=new Library(1,"PrettyCat","Romance","Aishwarya");
		libraryService.updateBook(bookId, book_1);
		verify(libraryRepository,times(1)).save(book_1);
	}

	@Test
	public void deleteBookTest(){
		int bookId=1;
		libraryService.deletebook(bookId);
		verify(libraryRepository,times(1)).deleteById(bookId);
	}

}


