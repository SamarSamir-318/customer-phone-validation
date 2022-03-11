package eg.com.jumia.service;

import eg.com.jumia.dto.ResponseDto;
import eg.com.jumia.dto.ResponseStatus;
import eg.com.jumia.repository.CustomerRepository;
import eg.com.jumia.testdata.CustomerTestData;
import eg.com.jumia.util.PhoneNumbersValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class PhoneNumberServiceImplTest {

    @Spy
    @InjectMocks
    private PhoneNumberServiceImpl phoneNumberService;
    @Mock
    private CustomerRepository customerRepo;

    @Spy
    private PhoneNumbersValidator phoneNumbersValidator;

    @Test
    public void findAllPhoneNumbersByCountryAndStateTest() {
        // test findall customers
        when(customerRepo.findAll()).thenReturn(CustomerTestData.generateTestCustomers());
        ResponseDto response = phoneNumberService.findAllPhoneNumbersByCountryAndState(null, null);
        assertFalse(response.getCustomers().isEmpty());
        assertEquals(response.getCustomers().size(), 5);
        assertTrue(response.getStatus().equals(ResponseStatus.SUCCESS.name()));

        // test when country code is populated
        when(customerRepo.findByPhoneLike(any())).thenReturn(CustomerTestData.generateTestCustomers());
        response = phoneNumberService.findAllPhoneNumbersByCountryAndState("212", null);
        assertFalse(response.getCustomers().isEmpty());
        assertEquals(response.getCustomers().size(), 5);
        assertTrue(response.getStatus().equals(ResponseStatus.SUCCESS.name()));

        // test when country code is populated & state code is populated
        response = phoneNumberService.findAllPhoneNumbersByCountryAndState("212", "66");
        assertFalse(response.getCustomers().isEmpty());
        assertEquals(response.getCustomers().size(), 5);
        assertTrue(response.getStatus().equals(ResponseStatus.SUCCESS.name()));

        // test when there is no matched data
        when(customerRepo.findByPhoneLike(any())).thenReturn(new ArrayList<>());
        response = phoneNumberService.findAllPhoneNumbersByCountryAndState("212", "66");
        assertTrue(response.getCustomers() == null);
        assertTrue(response.getStatus().equals(ResponseStatus.FAILURE.name()));

    }
}
