package es.urjc.code.daw.library.book;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.ff4j.FF4j;
import org.springframework.stereotype.Service;

import es.urjc.code.daw.library.notification.NotificationService;
import static es.urjc.code.daw.library.FeatureFlagsInitializer.*;

/* Este servicio se usará para incluir la funcionalidad que sea 
 * usada desde el BookRestController y el BookWebController
 */
@Service
public class BookService {

	private BookRepository repository;
	private NotificationService notificationService;
	private FF4j ff4j;

	public BookService(BookRepository repository, NotificationService notificationService, FF4j ff4j){
		this.repository = repository;
		this.notificationService = notificationService;
		this.ff4j = ff4j;
	}

	public Optional<Book> findOne(long id) {
		return repository.findById(id);
	}
	
	public boolean exist(long id) {
		return repository.existsById(id);
	}

	public List<Book> findAll() {
		return repository.findAll();
	}

	public Book save(Book book) {
		Book newBook = repository.save(book);
		notificationService.notify("Book Event: book with title="+newBook.getTitle()+" was created");
		return newBook;
	}

	public void delete(long id) {
		repository.deleteById(id);
		notificationService.notify("Book Event: book with id="+id+" was deleted");
	}
	
	public List<Book> findByTitle(String title) {
		return repository.findByTitle(title);
	}
}
