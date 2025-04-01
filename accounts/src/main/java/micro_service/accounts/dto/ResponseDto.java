package micro_service.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Schema(
        name="Response",
        description="Schema to hold successful response information"
)
public class ResponseDto{
    @Schema(
            description="Status code in the response"
    )
    private String statusCode;
    @Schema(
            description="Status message in the response"
    )
    private String statusMessage;
}
