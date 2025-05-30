package micro_service.cards.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
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
