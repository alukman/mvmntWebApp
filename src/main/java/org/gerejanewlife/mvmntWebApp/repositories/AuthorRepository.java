package org.gerejanewlife.mvmntWebApp.repositories;

import org.gerejanewlife.mvmntWebApp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
