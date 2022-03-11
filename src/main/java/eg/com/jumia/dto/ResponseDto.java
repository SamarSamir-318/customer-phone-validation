package eg.com.jumia.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class ResponseDto implements Serializable {

    private List<CustomerDto> customers;
    private String status;

    public ResponseDto (String status){
        this.status = status;
    }
}
