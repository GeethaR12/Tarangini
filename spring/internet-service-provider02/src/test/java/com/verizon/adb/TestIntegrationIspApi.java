package com.verizon.adb;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.verizon.adb.model.IspModel;
import com.verizon.adb.restapi.IspController;
import com.verizon.adb.service.IspService;
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestIntegrationIspApi {
	private MockMvc mockMvc;
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@Autowired
	private IspService ispSer;

	@Before
	public void setUp() throws Exception {
		mockMvc=MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetAllContacts() throws Exception {
		assertThat(this.ispSer).isNotNull();
		List<IspModel> c=this.ispSer.getAll();
		
		
		
		this.mockMvc.perform(get("/abc")).andExpect(status().isOk()).andDo(print());
		
		
		
	}

	@Test
	public void testGetPlanByTitle() throws Exception{
		assertThat(this.ispSer).isNotNull();
		IspModel e= this.ispSer.getByTitle("Plan1");
		
		
		this.mockMvc.perform(get("/abc","Plan1"))
		.andExpect(status().isOk())
		.andDo(print());
	}
}
