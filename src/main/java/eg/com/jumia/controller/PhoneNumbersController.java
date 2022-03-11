package eg.com.jumia.controller;

import eg.com.jumia.dto.ResponseDto;
import eg.com.jumia.service.CustomerPhoneNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class PhoneNumbersController {

    @Autowired
    private CustomerPhoneNumberService phoneNumberService;

    @GetMapping({"/findByCounterAndState","/findByCounterAndState/{countryCode}","/findByCounterAndState/{countryCode}/{stateCode}"})
    public ResponseDto getAllPhoneNumbers(@PathVariable(required = false) String countryCode , @PathVariable(required = false) String stateCode){
        return phoneNumberService.findAllPhoneNumbersByCountryAndState(countryCode,stateCode);
    }
}
