package in.pwskills.nitin.dao;

import in.pwskills.nitin.bean.Naukri;

public interface INaukriDao {

	public int insertrecord(Naukri naukri);
	
	public Naukri readObject();
}
