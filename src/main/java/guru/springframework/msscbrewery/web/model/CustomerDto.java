package guru.springframework.msscbrewery.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.UUID;

/**
 * User: MD.Ahmad
 * Date: 9/21/2019 3:56 PM
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDto {
    private UUID id;

    @NotBlank
    @Size(min = 3, max = 100)
    private  String name;
}
