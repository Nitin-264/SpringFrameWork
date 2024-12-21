package in.pwskills.nitin.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.jdbc.support.lob.LobHandler;
import org.springframework.stereotype.Component;

@Configuration
@Component
public class PersistanceConfig {

	@Bean
	public LobHandler lobhandler() {
		return new DefaultLobHandler();
	}
}

