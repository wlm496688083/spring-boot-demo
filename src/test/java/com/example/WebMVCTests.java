package com.example;

import com.example.domain.Order;
import com.example.service.DbService;
import com.example.web.DbController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by wanglimin1 on 2016/12/20.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(DbController.class)
public class WebMVCTests {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private DbService dbService;

    @Test
    public void testExample() throws Exception {
       // given(this.dbService.getOrderSingleton2(42746860760L))
       //         .willReturn(new Order(42746860760L, 888L, 9991L, 1, null, 1, null, null));

        this.mvc.perform(get("/db2").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk()).andExpect(content().string("Honda Civic"));
    }
}
