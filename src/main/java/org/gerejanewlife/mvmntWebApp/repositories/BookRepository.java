package org.gerejanewlife.mvmntWebApp.repositories;

import org.gerejanewlife.mvmntWebApp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
