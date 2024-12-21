package in.pwskills.nitin.runner;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import in.pwskills.nitin.bean.Naukri;
import in.pwskills.nitin.dao.INaukriDao;

@Component
public class NaukriRunner implements CommandLineRunner {

	@Autowired
	private INaukriDao dao;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
/*
		Naukri naukri = new Naukri();
		naukri.setAddress("MI");
		naukri.setName("Rohit");
		
		File image = new File("D:\\RohitPhoto\\rohit.webp");
		naukri.setImage(image);
		
		File resume = new File("D:\\rohitresume\\Rohit.txt.txt");
		naukri.setResume(resume);
		
		dao.insertrecord(naukri);
		*/
		Naukri naukri = dao.readObject();
		System.out.println(naukri);
		
		
		
	}

}
