package com.example;

import java.io.File;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.dao.CVRepository;
import com.example.entities.Cv;

@SpringBootTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class RecruitmentManagmentSystemApplicationTests {

	@Autowired
	CVRepository cvRep;

	@Test
	void TestInsertCV() {
		File file = new File("C:\\Users\\Mariem\\Desktop\\3emeAnneeDSI\\BigData\\Hadoop.pdf");
		
		Cv cv = new Cv();
		cv.setPdf(file.getName());
		
		cvRep.save(cv);
			
	}

}
