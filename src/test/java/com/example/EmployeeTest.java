package com.example;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

public class EmployeeTest {

    private MockMvc mockMvc;
    private String pattern = "{\"name\":\"lili\",\"gender\":\"female\"}";
    
    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new EmployeeController()).build();
    }
    
    @Test
    public void getMessage() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/employees")
        	.content(pattern).contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.content().json(pattern));
    }
    
    @Test
    public void getSpecific() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/employees/U004"))
            .andExpect(MockMvcResultMatchers.status().isNotFound());
    }
}