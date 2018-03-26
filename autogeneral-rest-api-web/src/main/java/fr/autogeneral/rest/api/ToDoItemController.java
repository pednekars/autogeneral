package fr.autogeneral.rest.api;

import fr.autogeneral.rest.core.dao.ToDoItemRepository;
import fr.autogeneral.rest.core.model.ToDoItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Shankar on 26/03/2018.
 */
@RestController
@RequestMapping("/todo")
public class ToDoItemController {

    private final ToDoItemRepository toDoItemRepository;
    

    @Autowired
    public ToDoItemController(ToDoItemRepository toDoItemRepository) {
        this.toDoItemRepository = toDoItemRepository;
        
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> add(@RequestBody ToDoItem toDoItem) {
        return saveToDoItem(toDoItem);
    }

    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
    public ResponseEntity<?> update(@RequestBody ToDoItem toDoItem,@PathVariable Long id) {
        if (toDoItemRepository.findById(id) != null) {
        	toDoItem.setId(id);
            return saveToDoItem(toDoItem);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<ToDoItem> getById(@PathVariable Long id) {
    	System.out.println("The ToDoItem input is "+id);
        return  new ResponseEntity<>(toDoItemRepository.findById(id), HttpStatus.OK);
    }

    
    private ResponseEntity<?> saveToDoItem(ToDoItem toDoItem) {
        return new ResponseEntity<>(toDoItemRepository.save(toDoItem), HttpStatus.OK);
    }
}
