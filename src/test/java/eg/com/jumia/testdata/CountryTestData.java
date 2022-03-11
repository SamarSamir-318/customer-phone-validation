package eg.com.jumia.testdata;

import eg.com.jumia.entity.Country;

public class CountryTestData {

    public static Country generateTestCountry(String countryCode){

        switch (countryCode){
            case "237":
                return Country.builder().id(1).countryCode("237").countryName("Cameroon").build();
            case "212":
                return Country.builder().id(2).countryCode("212").countryName("Morocco").build();
            case "258":
                return Country.builder().id(3).countryCode("258").countryName("Mozambique").build();
            case "256":
                return Country.builder().id(4).countryCode("256").countryName("Uganda").build();
            default:
                return Country.builder().id(5).countryCode("251").countryName("Ethiopia").build();

        }

    }
}
