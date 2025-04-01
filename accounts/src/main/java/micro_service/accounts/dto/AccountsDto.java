package micro_service.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Schema(
        name="Accounts",
        description="Schema to hold Account information"
)
public class AccountsDto{
    @Schema(
            description="Account Number of the Customer",
            example="8765432190"
    )
    @NotEmpty(message="Account number cannot be null or empty")
    @Pattern(regexp="($|[0-9]{10})", message="Account number must be 10-digits")
    private Long accountNumber;

    @Schema(
            description="Account type of the Customer",
            example="SAVING"
    )
    @NotEmpty(message="Account type cannot be null or empty")
    private String accountType;

    @Schema(
            description="Branch Address of the Customer",
            example="123, main street, New York"
    )
    @NotEmpty(message="Branch address cannot be null or empty")
    private String branchAddress;
}
