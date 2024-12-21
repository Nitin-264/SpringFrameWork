package in.pwskills.nitin.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages =  "in.pwskills.nitin")
@Import(PersistanceConfig.class)
public class AppConfig {

	
}
