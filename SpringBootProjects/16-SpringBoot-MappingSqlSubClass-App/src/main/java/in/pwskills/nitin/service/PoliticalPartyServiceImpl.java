package in.pwskills.nitin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.pwskills.nitin.bean.PoliticalParty;
import in.pwskills.nitin.dao.IPolicitalParty;

@Service("service")
public class PoliticalPartyServiceImpl implements IPolicticalPartyService {

	@Autowired
	private IPolicitalParty dao;
	
	@Override
	public PoliticalParty fetchPoliticalPartyDetailsByPartyId(Integer partyId) {
		// TODO Auto-generated method stub
		return dao.fetchPoliticalPartyDetailsByPartyId(partyId);
	}

	@Override
	public List<PoliticalParty> fetchPoliticalPartiesByNames(String partyName1, String partyName2) {
		// TODO Auto-generated method stub
		return dao.fetchPoliticalPartiesByNames(partyName1, partyName2);
	}

	@Override
	public int modifyFlagColorsByPartyName(String newColor, String partyName) {
		// TODO Auto-generated method stub
		return dao.modifyFlagColorsByPartyName(newColor, partyName);
	}

}
