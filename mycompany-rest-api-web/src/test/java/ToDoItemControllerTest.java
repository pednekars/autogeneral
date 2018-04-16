import fr.mycompany.rest.app.Application;
import fr.mycompany.rest.core.dao.ToDoItemRepository;
import fr.mycompany.rest.core.model.ToDoItem;
import net.minidev.json.JSONArray;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Date;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isA;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * Created by Shankar on 26/03/2018.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class ToDoItemControllerTest extends BaseTest {

    private ToDoItem toDoItem;

    @Autowired
    ToDoItemRepository toDoItemRepository;

    @Before
    public void setUp() {
        this.mockMvc = webAppContextSetup(this.webApplicationContext).build();
        toDoItemRepository.save(new ToDoItem("Wring code for mycompany", true, new Date().toString()));
        
    }

    

    private void test1GetToDoItemDetail() throws Exception {
        mockMvc.perform(get("/todo/" + toDoItem.getId())
                .contentType(contentType))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(toDoItem.getId().intValue())))
                .andExpect(jsonPath("$.text", is(toDoItem.getText())))
                .andExpect(jsonPath("$.isCompleted", is(toDoItem.getIsCompleted())));
                
    }

    

    

}
