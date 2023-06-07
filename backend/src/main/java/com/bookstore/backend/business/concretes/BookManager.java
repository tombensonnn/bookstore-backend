package com.bookstore.backend.business.concretes;

import com.bookstore.backend.business.abstracts.BookService;
import com.bookstore.backend.business.requests.book.CreateBookRequest;
import com.bookstore.backend.business.requests.book.UpdateBookRequest;
import com.bookstore.backend.business.responses.book.GetAllBooksResponse;
import com.bookstore.backend.business.responses.book.GetByIdBookResponse;
import com.bookstore.backend.business.rules.BookBusinessRules;
import com.bookstore.backend.core.utilities.mappers.ModelMapperService;
import com.bookstore.backend.repositories.BookRepository;
import com.bookstore.backend.entities.Book;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BookManager implements BookService {

    private BookRepository bookRepository;
    private ModelMapperService modelMapperService;
    private BookBusinessRules bookBusinessRules;

    @Override
    public List<GetAllBooksResponse> getAll() {

        List<Book> books = this.bookRepository.findAll();

        List<GetAllBooksResponse> booksResponses = books.stream()
                .map(book -> this.modelMapperService.forResponse()
                        .map(book, GetAllBooksResponse.class)).collect(Collectors.toList());

        return booksResponses;
    }

    @Override
    public GetByIdBookResponse getById(UUID id) {
        Book book = this.bookRepository.findById(id).orElseThrow();

        GetByIdBookResponse bookResponse = this.modelMapperService.forResponse().map(book, GetByIdBookResponse.class);

        return bookResponse;
    }

    @Override
    public void createBook(CreateBookRequest createBookRequest) {
        this.bookBusinessRules.checkIfBookNameExists(createBookRequest.getName());

        Book createdBook = this.modelMapperService.forRequest().map(createBookRequest, Book.class);

        this.bookRepository.save(createdBook);
    }

    @Override
    public void updateBook(UpdateBookRequest updateBookRequest) {
        Book updatedBook = this.modelMapperService.forRequest().map(updateBookRequest, Book.class);

        this.bookRepository.save(updatedBook);
    }
}
