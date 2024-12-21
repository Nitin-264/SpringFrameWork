package in.pwskills.nitin.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import in.pwskills.nitin.bean.PoliticalParty;
import in.pwskills.nitin.service.IPolicticalPartyService;

@Configuration
public class PoliticalPartyRunner implements CommandLineRunner {

	@Autowired
	private IPolicticalPartyService service;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		/*
		PoliticalParty party = service.fetchPoliticalPartyDetailsByPartyId(1);
		System.out.println(party);
		*/
		
		/*List<PoliticalParty> partyList = service.fetchPoliticalPartiesByNames("Congress", "JJP");
		partyList.forEach(System.out::println);
		*/
		
		int count = service.modifyFlagColorsByPartyName("Yellowish", "INLD");
		if (count==1) {
			System.out.println("Flag Color changed Succesfully");
		}
;
	}

}
