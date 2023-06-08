    package com.bookstore.backend.business.services;

    import com.bookstore.backend.business.requests.book.CreateBookRequest;
    import com.bookstore.backend.business.requests.book.UpdateBookRequest;
    import com.bookstore.backend.business.responses.book.GetAllBooksResponse;
    import com.bookstore.backend.business.responses.book.GetByIdBookResponse;
    import com.bookstore.backend.business.rules.BookBusinessRules;
    import com.bookstore.backend.core.utilities.mappers.ModelMapperService;
    import com.bookstore.backend.repositories.BookRepository;
    import com.bookstore.backend.entities.Book;
    import org.springframework.stereotype.Service;

    import java.util.List;
    import java.util.stream.Collectors;

    @Service
    public class BookService  {

        private final BookRepository bookRepository;
        private final ModelMapperService modelMapperService;
        private final BookBusinessRules bookBusinessRules;

        public BookService(BookRepository bookRepository, ModelMapperService modelMapperService, BookBusinessRules bookBusinessRules) {
            this.bookRepository = bookRepository;
            this.modelMapperService = modelMapperService;
            this.bookBusinessRules = bookBusinessRules;
        }

        public List<GetAllBooksResponse> getAll() {

            List<Book> books = this.bookRepository.findAll();

            List<GetAllBooksResponse> booksResponses = books.stream()
                    .map(book -> this.modelMapperService.forResponse()
                            .map(book, GetAllBooksResponse.class)).collect(Collectors.toList());

            return booksResponses;
        }

            public GetByIdBookResponse getById(String id) {
                Book book = this.bookRepository.findById(id).orElseThrow();

                GetByIdBookResponse bookResponse = this.modelMapperService.forResponse().map(book, GetByIdBookResponse.class);

                return bookResponse;
            }

        public void createBook(CreateBookRequest createBookRequest) {
            this.bookBusinessRules.checkIfBookNameExists(createBookRequest.getName());

            Book createdBook = this.modelMapperService.forRequest().map(createBookRequest, Book.class);

            this.bookRepository.save(createdBook);
        }

        public void updateBook(UpdateBookRequest updateBookRequest) {
            Book updatedBook = this.modelMapperService.forRequest().map(updateBookRequest, Book.class);

            this.bookRepository.save(updatedBook);
        }
    }
