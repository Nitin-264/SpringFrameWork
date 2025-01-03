package in.pwskills.nitin.runner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import in.pwskills.nitin.bean.MarriageSeeker;
import in.pwskills.nitin.dao.IMarriageSeekerRepo;

@Component
public class TestRunner implements CommandLineRunner {

	@Autowired
	private IMarriageSeekerRepo repo;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the name of the user::");
		String name = scanner.next();
		
		System.out.print("Enter the address of the user :: "); 
		String address =scanner.next();
				  
		System.out.print("Is Person Indian? :: "); 
		boolean indian =scanner.nextBoolean();
				  
		System.out.print("Enter the path of Person photo  :: "); 
		String photoLoc =scanner.next();
				  
		System.out.print("Enter the path of Person biodata :: "); 
		String bioDataLoc=scanner.next();
		
		 // working with binary image data
		
		InputStream is = new FileInputStream(new File(photoLoc));
		byte[] image = new byte[is.available()];
		image = is.readAllBytes();
		
		// working with binary text data
		
		File file = new File(bioDataLoc);
		Reader reader  = new FileReader(file);
		
		char[] bio = new char[(int) file.length()];
		 reader.read(bio);
		 
		 MarriageSeeker obj1 = new MarriageSeeker(name, address, LocalDateTime.of(1991,
		                                        1, 3, 19, 45), image, bio, indian); 
		 repo.save(obj1);
		System.out.println("Object saved to database....");
				  
		scanner.close(); reader.close(); is.close();
		
		// code for retrieval
		
		Optional<MarriageSeeker> optional = repo.findById(1L);
		if (optional.isPresent()) {
			
			MarriageSeeker obj = optional.get();
			System.out.println(obj);
			
			System.out.println("Image Data Stored in::");
			OutputStream os = new FileOutputStream(new File("reterived_img.jpg"));
			os.write(obj.getPhoto());
			os.flush();
			
			System.out.println("Biodata stored in..");
			Writer writer = new FileWriter(new File("reterived_bio.txt"));
			writer.write(obj.getBiodata());
			writer.flush();
			
			System.out.println("Lob's are retrieved...");
		}
		else {
			System.out.println("Record not available...");
		}
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
