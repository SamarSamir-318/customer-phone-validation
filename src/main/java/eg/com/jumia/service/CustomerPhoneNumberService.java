package eg.com.jumia.service;

import eg.com.jumia.dto.ResponseDto;

public interface CustomerPhoneNumberService {

    ResponseDto findAllPhoneNumbersByCountryAndState(String countryCode, String stateCode);
}
