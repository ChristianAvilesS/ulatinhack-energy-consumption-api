package oneupstudios.ulatinhackapi.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDTO {
    private Long customerId;
    private String customerType;
    private String name;
    private String address;
    private String city;
    private String country;
    private Integer numberOccupants; // para casas
    private String industry; // para empresas
}
