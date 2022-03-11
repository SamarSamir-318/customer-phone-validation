package eg.com.jumia.testdata;

import eg.com.jumia.entity.Customer;

import java.util.List;

public class CustomerTestData {

    public static Customer generateTestCustomer() {
        return Customer.builder().id(1).name("Walid Hammadi").phone("(212) 6007989253").build();
    }

    public static List<Customer> generateTestCustomers() {
        return List.of(Customer.builder().id(1).name("Yosaf Karrouch").phone("(212) 698054317").country(CountryTestData.generateTestCountry("212")).build(),
                Customer.builder().id(1).name("Younes Boutikyad").phone("(256) 7734127498").country(CountryTestData.generateTestCountry("256")).build(),
                Customer.builder().id(1).name("Filimon Embaye").phone("(251) 914701723").country(CountryTestData.generateTestCountry("251")).build(),
                Customer.builder().id(1).name("Ezequiel Fenias").phone("((258) 848826725").country(CountryTestData.generateTestCountry("258")).build(),
                Customer.builder().id(1).name("WILLIAM KEMFANG").phone("(237) 6622284920").country(CountryTestData.generateTestCountry("237")).build());
    }
}
