package micro_service.loans.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
public class LoansDto{
    @NotEmpty(message="Mobile number cannot be null or empty")
    @Pattern(regexp="($|[0-9]{10})", message="Mobile number must be 10-digits")
    @Schema(
            description="Mobile number of customer",
            example="6275487539"
    )
    private String mobileNumber;
    @NotEmpty(message="Loan number cannot be null or empty")
    @Pattern(regexp="($|[0-9]{12})", message="Loan number must be 12-digits")
    @Schema(
            description="Loan number of customer",
            example="462754875398"
    )
    private String loanNumber;
    @NotEmpty(message="Loan type cannot be null or empty")
    @Schema(
            description="Type of the loan",
            example="Home loan"
    )
    private String loanType;
    @Positive(message="Total loan amount should be equal or greater than zero")
    @Schema(
            description="Total loan amount",
            example="100000"
    )
    private int totalLoan;
    @PositiveOrZero(message="Total loan amount paid should be equal or greater than zero")
    @Schema(
            description="Total loan amount paid",
            example="5000"
    )
    private int amountPaid;
    @PositiveOrZero(message="Total Outstanding amount should be equal or greater than zero")
    @Schema(
            description="Total outstanding amount against a loan",
            example="950000"
    )
    private int outstandingAmount;
}
