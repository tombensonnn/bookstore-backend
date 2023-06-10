    package com.bookstore.backend.services;

    import com.bookstore.backend.dto.BookDto;
    import com.bookstore.backend.dto.converters.AuthorDtoConverter;
    import com.bookstore.backend.dto.converters.BookDtoConverter;
    import com.bookstore.backend.dto.requests.book.CreateBookRequest;
    import com.bookstore.backend.exceptions.BookCouldNotFindException;
    import com.bookstore.backend.models.Book;
    import com.bookstore.backend.repositories.BookRepository;
    import org.springframework.stereotype.Service;

    import java.util.List;
    import java.util.stream.Collectors;

    @Service
    public class BookService  {

        private final BookRepository bookRepository;
        private final AuthorService authorService;
        private final BookDtoConverter bookDtoConverter;
        private final AuthorDtoConverter authorDtoConverter;

        public BookService(BookRepository bookRepository, AuthorService authorService, BookDtoConverter bookDtoConverter, AuthorDtoConverter authorDtoConverter) {
            this.bookRepository = bookRepository;
            this.authorService = authorService;
            this.bookDtoConverter = bookDtoConverter;
            this.authorDtoConverter = authorDtoConverter;
        }

        public List<BookDto> getAll() {

            List<BookDto> books = this.bookRepository.findAll().stream().map(bookDtoConverter::convert).collect(Collectors.toList());

            return books;
        }

        public Book findBookById(String id) {
            return this.bookRepository.findById(id).orElseThrow(() -> new BookCouldNotFindException("There is no book with that id"));
        }

        public BookDto getBookById(String id) {
            return this.bookDtoConverter.convert(findBookById(id));
        }

        public BookDto createBook(CreateBookRequest createBookRequest) {
            boolean isBookExist = this.bookRepository.existsByName(createBookRequest.getName());

            if(isBookExist){
                throw new BookCouldNotFindException("There is a book with that id");
            }

            Book book = new Book(
                    createBookRequest.getName(), this.authorService.findAuthorById(createBookRequest.getAuthorId())
            );

            return this.bookDtoConverter.convert(this.bookRepository.save(book));

        }

    }
