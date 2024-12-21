package in.pwskills.nitin.service;

import java.util.List;

import in.pwskills.nitin.bean.PoliticalParty;

public interface IPolicticalPartyService {

	public PoliticalParty fetchPoliticalPartyDetailsByPartyId(Integer partyId);
	public List<PoliticalParty> fetchPoliticalPartiesByNames(String partyName1,String partyName2);
	public int modifyFlagColorsByPartyName(String newColor,String partyName);
}
