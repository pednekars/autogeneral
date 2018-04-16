package fr.mycompany.rest.core.dao;

import fr.mycompany.rest.core.model.ToDoItem;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface ToDoItemRepository extends PagingAndSortingRepository<ToDoItem, Long> {
	ToDoItem findById(Long id);
}

