package eg.com.jumia.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountryDto implements Serializable {

    private Integer id;

    private String countryName;

    private String countryCode;
}
