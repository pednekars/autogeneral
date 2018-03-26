package fr.autogeneral.rest.core.dao;

import fr.autogeneral.rest.core.model.ToDoItem;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface ToDoItemRepository extends PagingAndSortingRepository<ToDoItem, Long> {
	ToDoItem findById(Long id);
}

