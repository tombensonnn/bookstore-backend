    package com.bookstore.backend.services;

    import com.bookstore.backend.dto.BookDto;
    import com.bookstore.backend.dto.converters.AuthorDtoConverter;
    import com.bookstore.backend.dto.converters.BookDtoConverter;
    import com.bookstore.backend.dto.requests.book.CreateBookRequest;
    import com.bookstore.backend.dto.requests.book.DeleteBookRequest;
    import com.bookstore.backend.dto.requests.book.UpdateBookRequest;
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

        public BookService(BookRepository bookRepository, AuthorService authorService, BookDtoConverter bookDtoConverter) {
            this.bookRepository = bookRepository;
            this.authorService = authorService;
            this.bookDtoConverter = bookDtoConverter;
        }

        public List<BookDto> getAll() {

            return this.bookRepository.findAll().stream().map(bookDtoConverter::convert).collect(Collectors.toList());

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

        public BookDto updateBook(UpdateBookRequest updateBookRequest) {
            Book book = findBookById(updateBookRequest.getId());

            book.setName(updateBookRequest.getName());

            return this.bookDtoConverter.convert(this.bookRepository.save(book));
        }

        public BookDto deleteBook(DeleteBookRequest deleteBookRequest) {
            Book book = findBookById(deleteBookRequest.getId());

            this.bookRepository.deleteById(deleteBookRequest.getId());

            return this.bookDtoConverter.convert(book);
        }

    }
