import fr.autogeneral.rest.core.app.TestApplication;
import fr.autogeneral.rest.core.dao.ToDoItemRepository;
import fr.autogeneral.rest.core.model.ToDoItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.*;

import java.util.Optional;
import java.util.stream.StreamSupport;

import static org.junit.Assert.*;

/**
 * Created by Shankar on 26/03/2018.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplication.class)
@DataJpaTest
public class ToDoItemRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    ToDoItemRepository toDoItemRepository;
    

    @Test
    public void getOneToDoItem() throws Exception {
    	ToDoItem one = toDoItemRepository.findOne(1L);
        assertNotNull(one);
    }

    
}
