package com.verizon.adb;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.verizon.adb.model.Customer;
import com.verizon.adb.restapi.CustomerApi;
import com.verizon.adb.restapi.IspController;
import com.verizon.adb.service.CustomerService;
import com.verizon.adb.service.IspService;
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestIntegrationCustomer {
	private MockMvc mockMvc;
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@Autowired
	private CustomerService ser;

	@Before
	public void setUp() throws Exception {
		mockMvc=MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddContact() throws IOException, Exception {
			assertThat(this.ser).isNotNull();
			
			Customer e=new Customer();
			e.setName("Geetha");
			e.setAddress("abc");
			e.setCharge(1230.00);
			e.setMobile("1234567890");
			e.setTimeSlot("11am");
			e.setTitle("Plan1");
			e.setDateOfInstallation(null);
			e.setDateOfRequest(null);
			
			this.mockMvc.perform(post("/customer")
					.contentType(TestUtil.APPLICATION_JSON_UTF8)
					.content(TestUtil.convertObjectToJsonBytes(e)))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().contentType(TestUtil.APPLICATION_JSON_UTF8));
			
		}
	
	

}
