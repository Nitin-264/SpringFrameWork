package in.pwskills.nitin.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.jdbc.object.SqlUpdate;
import org.springframework.stereotype.Repository;

import in.pwskills.nitin.bean.PoliticalParty;

@Repository("dao")
public class PolicitalPartyIDaompl implements IPolicitalParty {

	private static final String SQL_SELECTOR1 = "select * from politicalParty where partyId=? ";

	private static final String SQL_SELECTOR_BY_NAME = "select partyId,flagcolors,partyName,partySymbol from politicalParty where partyName in (?,?)";

	private static final String SQL_UPDATER_FLAGCOLOUR_BY_NAME = "update politicalParty set flagColors =? where partyName=?";
	
	private politicalpartySelector1 selector1;
	private politicalpartySelector2 selector2;
	private politicalpartyUpdater   updater;
	
	public PolicitalPartyIDaompl(DataSource ds) {
		System.out.println("PolicitalPartyIDaompl.PolicitalPartyIDaompl()");
		selector1 = new politicalpartySelector1(ds,SQL_SELECTOR1);
		selector2 = new politicalpartySelector2(ds, SQL_SELECTOR_BY_NAME);
		updater = new politicalpartyUpdater(ds, SQL_UPDATER_FLAGCOLOUR_BY_NAME);
	}
	
	@Override
	public PoliticalParty fetchPoliticalPartyDetailsByPartyId(Integer partyId) {
		// TODO Auto-generated method stub
		return selector1.findObject(partyId);
	}

	@Override
	public List<PoliticalParty> fetchPoliticalPartiesByNames(String partyName1, String partyName2) {
		// TODO Auto-generated method stub
		return selector2.execute(partyName1,partyName2);
	}

	@Override
	public int modifyFlagColorsByPartyName(String newColor, String partyName) {
		// TODO Auto-generated method stub
		return updater.update(newColor, partyName);
	}
	
	//*******************************************************************************
	
	private static class politicalpartySelector1 extends MappingSqlQuery<PoliticalParty>{

		public politicalpartySelector1(DataSource ds , String query) {
			super(ds,query);
			super.declareParameter(new SqlParameter(Types.INTEGER));
			super.compile();
			
		}
		
		@Override
		protected PoliticalParty mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			System.out.println("PolicitalPartyIDaompl.politicalpartySelector1.mapRow()");
			PoliticalParty party = new PoliticalParty();
			party.setPartyId(rs.getInt(1));
			party.setFlagColors(rs.getString(2));
			party.setPartyName(rs.getString(3));
			party.setPartySymbol(rs.getString(4));
			return party;
		}
		
	}

	private static class politicalpartySelector2 extends MappingSqlQuery<PoliticalParty>{

		public politicalpartySelector2(DataSource ds , String query) {
			
			super(ds,query);
			super.declareParameter(new SqlParameter(Types.CHAR));
			super.declareParameter(new SqlParameter(Types.CHAR));
			super.compile();
			
		}
		
		@Override
		protected PoliticalParty mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			System.out.println("PolicitalPartyIDaompl.politicalpartySelector2.mapRow()");
			PoliticalParty party = new PoliticalParty();
			party.setPartyId(rs.getInt(1));
			party.setFlagColors(rs.getString(2));
			party.setPartyName(rs.getString(3));
			party.setPartySymbol(rs.getString(4));
			return party;
		}
		
	}
	
	private static class politicalpartyUpdater extends SqlUpdate{

		public politicalpartyUpdater(DataSource ds , String Query) {
			super(ds,Query);
			super.declareParameter(new SqlParameter(Types.CHAR));
			super.declareParameter(new SqlParameter(Types.CHAR));
			super.compile();
		}
		
		
	}
	
}
