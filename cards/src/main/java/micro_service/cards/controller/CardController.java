package micro_service.cards.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import micro_service.cards.constants.CardConstants;
import micro_service.cards.dto.CardDto;
import micro_service.cards.dto.CardsContactInfoDto;
import micro_service.cards.dto.ErrorResponseDto;
import micro_service.cards.dto.ResponseDto;
import micro_service.cards.service.ICardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;



@Tag(
        name = "CRUD REST APIs for Cards in EazyBank",
        description = "CRUD REST APIs in EazyBank to CREATE, UPDATE, FETCH AND DELETE card details"
)
@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@Validated
public class CardController{

    @Value("${build.version}")
    private String buildVersion;
    @Autowired
    private Environment environment;
    @Autowired
    private CardsContactInfoDto cardsContactInfoDto;
    private final ICardService iCardsService;

    public CardController(ICardService iCardsService){
        this.iCardsService=iCardsService;
    }

    @Operation(
            summary="Create Card REST API",
            description="REST API to create new Card inside EazyBank"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode="201",
                    description="HTTP Status CREATED"
            ),
            @ApiResponse(
                    responseCode="500",
                    description="HTTP Status Internal Server Error",
                    content=@Content(
                            schema=@Schema(implementation=ErrorResponseDto.class)
                    )
            )
    }
    )
    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createCard(@Valid @RequestParam
                                                  @Pattern(regexp="(^$|[0-9]{10})", message="Mobile number must be 10 digits")
                                                  String mobileNumber){
        iCardsService.createCard(mobileNumber);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(CardConstants.STATUS_201,CardConstants.MESSAGE_201));
    }

    @Operation(
            summary="Fetch Card Details REST API",
            description="REST API to fetch card details based on a mobile number"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode="200",
                    description="HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode="500",
                    description="HTTP Status Internal Server Error",
                    content=@Content(
                            schema=@Schema(implementation=ErrorResponseDto.class)
                    )
            )
    })
    @GetMapping("/fetch")
    public ResponseEntity<CardDto> fetchCardDetails(@RequestParam
                                                    @Pattern(regexp="(^$|[0-9]{10})", message="Mobile number must be 10 digits")
                                                    String mobileNumber){
        CardDto cardsDto=iCardsService.fetchCard(mobileNumber);
        return ResponseEntity.status(HttpStatus.OK).body(cardsDto);
    }

    @Operation(
            summary="Update Card Details REST API",
            description="REST API to update card details based on a card number"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode="200",
                    description="HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode="417",
                    description="Expectation Failed"
            ),
            @ApiResponse(
                    responseCode="500",
                    description="HTTP Status Internal Server Error",
                    content=@Content(
                            schema=@Schema(implementation=ErrorResponseDto.class)
                    )
            )
    })
    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateCardDetails(@Valid @RequestBody CardDto cardsDto){
        boolean isUpdated=iCardsService.updateCard(cardsDto);
        if(isUpdated){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(CardConstants.STATUS_200,CardConstants.MESSAGE_200));
        }else{
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(CardConstants.STATUS_417,CardConstants.MESSAGE_417_UPDATE));
        }
    }

    @Operation(
            summary="Delete Card Details REST API",
            description="REST API to delete Card details based on a mobile number"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode="200",
                    description="HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode="417",
                    description="Expectation Failed"
            ),
            @ApiResponse(
                    responseCode="500",
                    description="HTTP Status Internal Server Error",
                    content=@Content(
                            schema=@Schema(implementation=ErrorResponseDto.class)
                    )
            )
    })
    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deleteCardDetails(@RequestParam
                                                         @Pattern(regexp="(^$|[0-9]{10})", message="Mobile number must be 10 digits")
                                                         String mobileNumber){
        boolean isDeleted=iCardsService.deleteCard(mobileNumber);
        if(isDeleted){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(CardConstants.STATUS_200,CardConstants.MESSAGE_200));
        }else{
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(CardConstants.STATUS_417,CardConstants.MESSAGE_417_DELETE));
        }
    }

    @Operation(
            summary="Get Build Information",
            description="Get Build Information that is deployed into cards microservice"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode="200",
                    description="HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode="500",
                    description="HTTP Status Internal Server Error",
                    content=@Content(
                            schema=@Schema(implementation=ErrorResponseDto.class)
                    )
            )
    }
    )
    @GetMapping("/build-info")
    public ResponseEntity<String> buildInfo(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(buildVersion);
    }

    @Operation(
            summary="Get JAVA Version",
            description="Get JAVA Version that is deployed into cards microservice"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode="200",
                    description="HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode="500",
                    description="HTTP Status Internal Server Error",
                    content=@Content(
                            schema=@Schema(implementation=ErrorResponseDto.class)
                    )
            )
    }
    )
    @GetMapping("/java-version")
    public ResponseEntity<String> getJavaVersion(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(environment.getProperty("JAVA_HOME"));
    }

    @Operation(
            summary="Get Contact info",
            description="Get Contact info details that ican be reached out in case of any issues"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode="200",
                    description="HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode="500",
                    description="HTTP Status Internal Server Error",
                    content=@Content(
                            schema=@Schema(implementation=ErrorResponseDto.class)
                    )
            )
    }
    )
    @GetMapping("/contact-info")
    public ResponseEntity<CardsContactInfoDto> getContactInfo(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(cardsContactInfoDto);
    }
}
