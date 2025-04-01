package micro_service.accounts;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import micro_service.accounts.dto.AccountsContactInfoDto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef="auditAwareImpl")
@EnableConfigurationProperties(value=AccountsContactInfoDto.class)
@OpenAPIDefinition(
		info=@Info(
				title="Account microservice REST API Documentation",
				description="Account microservice REST API Documentation",
				version="v1",
				contact=@Contact(
						name="Putul",
						email="putulkumri0997@gmail.com",
						url="http://localhost:9090"
				),
				license=@License(
						name="Apache 2.0",
						url="http://localhost:9090"
				)
		),
		externalDocs=@ExternalDocumentation(
			description="Test Bank Account microservice REST API Documentation",
				url="http://localhost:9090/swagger-ui/index.html"
		)
)
public class AccountsApplication{

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}

}
