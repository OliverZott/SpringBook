package org.taco;

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

@RunWith(SpringRunner.class)
@WebMvcTest(HomeController.class)   // test in context of mvc-application (homecontroller in spring mvc registered)
public class HomeControllerTest {

  @Autowired
  private MockMvc mockMvc;   // test via mock object

  @Test
  public void testHomePage() throws Exception {
    mockMvc.perform(get("/"))    // GET test
    
      .andExpect(status().isOk())  // status check
      
      .andExpect(view().name("home"))  // view-name test
      
      .andExpect(content().string(           // string-content test
          containsString("Welcome to...")));  
  }

}