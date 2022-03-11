package eg.com.jumia.util;

import eg.com.jumia.dto.CustomerDto;
import eg.com.jumia.testdata.CustomerTestData;
import lombok.Builder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class PhoneNumbersValidatorTest {

    @Spy
    @InjectMocks
    private PhoneNumbersValidator phoneNumbersValidator;

    private List<CustomerDto> customerDtoList;

    @Before
    public void setup(){
        ModelMapper modelMapper = new ModelMapper();
        customerDtoList= new ArrayList<>();
        CustomerTestData.generateTestCustomers().forEach(c->customerDtoList.add(modelMapper.map(c,CustomerDto.class)));

    }
    @Test
    public void validateCustomerPhoneNumbers(){
        List<CustomerDto> customers = phoneNumbersValidator.validateCustomerPhoneNumbers(customerDtoList);
        assertEquals(customers.get(0).getStatus(),"VALID");
        assertEquals(customers.get(1).getStatus(),"INVALIDE");
        assertEquals(customers.get(2).getStatus(),"VALID");
        assertEquals(customers.get(3).getStatus(),"INVALIDE");
        assertEquals(customers.get(4).getStatus(),"INVALIDE");

    }
}
