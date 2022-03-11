package eg.com.jumia.service;

import eg.com.jumia.dto.CustomerDto;
import eg.com.jumia.dto.ResponseDto;
import eg.com.jumia.dto.ResponseStatus;
import eg.com.jumia.entity.Customer;
import eg.com.jumia.repository.CustomerRepository;
import eg.com.jumia.util.PhoneNumbersValidator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PhoneNumberServiceImpl implements CustomerPhoneNumberService {

    @Autowired
    private CustomerRepository customerRepo;

    @Autowired
    private PhoneNumbersValidator phoneNumbersValidator;


    private ModelMapper modelMapper;

    private ResponseDto findAllCustomers() {
        List<Customer> customers = customerRepo.findAll();
        if (customers.isEmpty()) {
            return getInvalidResponse();
        }
        return getResponse(customers);
    }

    @Override
    public ResponseDto findAllPhoneNumbersByCountryAndState(String countryCode, String stateCode) {
        if (countryCode == null && stateCode == null) {
            return findAllCustomers();
        }
        String phone = "";
        if (countryCode != null && stateCode == null) {
            phone = countryCode.length() == 3 ? "(" + countryCode + ") " : "(" + countryCode;
        } else {
            phone = "(" + countryCode + ") " + stateCode;

        }
        return findAllCustomerByPhoneLike(phone);
    }


    private ResponseDto findAllCustomerByPhoneLike(String phone) {
        List<Customer> customers = customerRepo.findByPhoneLike(phone);
        if (customers.isEmpty()) {
            return getInvalidResponse();
        }
        return getResponse(customers);
    }

    private ResponseDto getResponse(List<Customer> customers) {
        List<CustomerDto> customerDtoList = new ArrayList<>();
        modelMapper = new ModelMapper();

        ResponseDto response = new ResponseDto(ResponseStatus.SUCCESS.name());
        customers.forEach(customer -> customerDtoList.add(modelMapper.map(customer, CustomerDto.class)));
        System.out.println(customers.get(0));
        List<CustomerDto> validList = phoneNumbersValidator.validateCustomerPhoneNumbers(customerDtoList);
        if (validList.isEmpty()) {
            response.setStatus(ResponseStatus.FAILURE.name());
        }
        response.setCustomers(phoneNumbersValidator.validateCustomerPhoneNumbers(customerDtoList));
        return response;
    }

    private ResponseDto getInvalidResponse() {
        return ResponseDto.builder()
                .status(ResponseStatus.FAILURE.name())
                .customers(null)
                .build();
    }
}
