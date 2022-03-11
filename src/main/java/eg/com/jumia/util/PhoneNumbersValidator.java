package eg.com.jumia.util;

import eg.com.jumia.dto.CustomerDto;
import eg.com.jumia.dto.PhoneNumberStatus;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.regex.Pattern;

@Component
public class PhoneNumbersValidator {
    private static final Pattern
            cameroonRx = Pattern.compile("\\(237\\)\\ ?[2368]\\d{7,8}$"),
            ethiopiaRx = Pattern.compile("\\(251\\)\\ ?[1-59]\\d{8}$"),
            moroccoRx = Pattern.compile("\\(212\\)\\ ?[5-9]\\d{8}$"),
            mozambiqueRx = Pattern.compile("\\(258\\)\\ ?[28]\\d{7,8}$"),
            ugandaRx = Pattern.compile("\\(256\\)\\ ?\\d{9}$");

    public List<CustomerDto> validateCustomerPhoneNumbers(List<CustomerDto> customers) {

        customers.forEach(customer -> {
            if (cameroonRx.matcher(customer.getPhone()).matches() ||
                    ethiopiaRx.matcher(customer.getPhone()).matches() ||
                    moroccoRx.matcher(customer.getPhone()).matches() ||
                    mozambiqueRx.matcher(customer.getPhone()).matches() ||
                    ugandaRx.matcher(customer.getPhone()).matches()) {
                customer.setStatus(PhoneNumberStatus.VALID.name());
            } else {
                customer.setStatus(PhoneNumberStatus.INVALIDE.name());
            }
        });
        return customers;
    }

}
