package micro_service.loans;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import micro_service.loans.dto.LoansContactInfoDto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef="auditAwareImpl")
@EnableConfigurationProperties(value=LoansContactInfoDto.class)
@OpenAPIDefinition(
		info=@Info(
				title="Loans microservice REST API Documentation",
				description="Loans microservice REST API Documentation",
				version="v1",
				contact=@Contact(
						name="Putul",
						email="putulkumri0997@gmail.com",
						url="http://localhost:9092"
				),
				license=@License(
						name="Apache 2.0",
						url="http://localhost:9092"
				)
		),
		externalDocs=@ExternalDocumentation(
				description="Test Loans microservice REST API Documentation",
				url="http://localhost:9092/swagger-ui/index.html"
		)
)
public class LoansApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoansApplication.class, args);
	}

}
