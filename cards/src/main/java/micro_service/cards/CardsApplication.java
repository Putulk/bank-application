package micro_service.cards;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import micro_service.cards.dto.CardsContactInfoDto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef="auditAwareImpl")
@EnableConfigurationProperties(value=CardsContactInfoDto.class)
@OpenAPIDefinition(
		info=@Info(
				title="Cards microservice REST API Documentation",
				description="Cards microservice REST API Documentation",
				version="v1",
				contact=@Contact(
						name="Putul",
						email="putulkumri0997@gmail.com",
						url="http://localhost:90901"
				),
				license=@License(
						name="Apache 2.0",
						url="http://localhost:9091"
				)
		),
		externalDocs=@ExternalDocumentation(
				description="Test Card microservice REST API Documentation",
				url="http://localhost:9091/swagger-ui/index.html"
		)
)
public class CardsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CardsApplication.class, args);
	}

}
