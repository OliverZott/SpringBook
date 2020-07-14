package org.taco;


//*
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.taco.controller.DesignTacoController;

@RunWith(SpringRunner.class)
@WebMvcTest(DesignTacoController.class)   // test in context of mvc-application (homecontroller in spring mvc registered)
public class DesignControllerTest {

  @Autowired
  private MockMvc mockMvc;   // test via mock object

  @Test
  public void testShowDesignForm() throws Exception {
    mockMvc.perform(get("/design"))    // GET test
    
      .andExpect(status().isOk())  // status check
      
      .andExpect(view().name("design"))  // view-name test
      
      .andExpect(content().string(           // string-content test
          containsString("DESIGN")));  
  }

}
//*/
