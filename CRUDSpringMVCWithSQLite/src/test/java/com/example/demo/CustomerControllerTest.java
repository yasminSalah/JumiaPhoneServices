package com.example.demo;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import com.example.demo.config.RequestNotValidException;
import com.example.demo.config.ResourceItemNotFoundException;

import org.hibernate.jdbc.Expectations;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.example.dem.dto.CustomerTestObjectFactory;
import com.example.demo.controllers.CustomerController;
import com.example.demo.dtos.CustomerDetailsDto;
import com.example.demo.repositories.CustomerRepository;
import com.example.demo.service.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {

	@MockBean
	CustomerService customerService;

	@MockBean
	CustomerRepository customerRepository;

	@Autowired
	private MockMvc mockMvc;

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getAllCustomersforMoroccoWithStatusOk() throws Exception {

		ObjectMapper ObjectMapper = new ObjectMapper();

		Mockito.when(customerService.getAllCustomers("(212)", 0, 41))
				.thenReturn(CustomerTestObjectFactory.testGenerateCustomers());
		//
		// public Object answer(InvocationOnMock invocation) {
		//
		// return CustomerTestObjectFactory.testGenerateCustomers();
		// }
		// });
		// doAnswer(new Answer() {
		// private int count = 0;
		//
		// public Object answer(InvocationOnMock invocation) {
		// return CustomerTestObjectFactory.testGenerateCustomers();
		// }
		// }).when(customerService.getAllCustomers("(212)", 0, 41));

		// testing Customers phone data in Morocco country
		// Send course as body to /Customer/all
		String postBody = "{\"pageNumber\":\"0\",\"limit\":\"41\",\"searchText\":\"(212)\"}";
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/Customer/all").accept(MediaType.APPLICATION_JSON)
				.content(postBody).contentType(MediaType.APPLICATION_JSON);

		MvcResult mvcresult = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = mvcresult.getResponse();
		Assert.assertEquals(HttpStatus.OK.value(), response.getStatus());
		System.out.println("**********************************Status: " + response.getStatus());
		String reponseString = mvcresult.getResponse().getContentAsString();
		CustomerDetailsDto actualCustomer = ObjectMapper.readValue(reponseString, CustomerDetailsDto.class);
		System.out.println("(((((((((((((((((((((((((((((" + actualCustomer + "))))))))))))))))))))))");
		CustomerDetailsDto expectedCustomer = CustomerTestObjectFactory.testGenerateCustomers();
		System.out.println("(((((((((((((((((((((((((((((" + expectedCustomer + "))))))))))))))))))))))");
		Assert.assertEquals(expectedCustomer, actualCustomer);
		System.out.println("-------------------------end--------------------------------");

	}

//	@Test(expected = com.example.demo.config.RequestNotValidException.class)
//	public void getAllCustomersforMoroccoWithStatusBadRequest() throws RequestNotValidException {
//
//		try {
//
//			when(customerService.getAllCustomers("", 0, 0)).thenAnswer(new Answer() {
//
//				public Object answer(InvocationOnMock invocation) {
//
//					return CustomerTestObjectFactory.testGenerateCustomersRequestNotValid();
//				}
//			});
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			assertTrue(e instanceof com.example.demo.config.RequestNotValidException);
//		}
//	}

	// @Test(expected = com.example.demo.config.ResourceItemNotFoundException.class)
	// public void
	// getAllCustomersforMoroccoWithStatusResourceItemNotFoundException() throws
	// ResourceItemNotFoundException {
	//
	// try {
	//
	// when(customerService.getAllCustomers("", 0, 0)).thenAnswer(new Answer() {
	//
	// public Object answer(InvocationOnMock invocation) {
	//
	// return
	// CustomerTestObjectFactory.testGenerateCustomersRequestResourceItemNotFound();
	// }
	// });
	// } catch (Exception e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// assertTrue(e instanceof
	// com.example.demo.config.ResourceItemNotFoundException);
	// }
	// }
}
