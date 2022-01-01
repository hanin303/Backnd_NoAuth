package com.example.web;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.http.MediaType;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.dao.CVRepository;
import com.example.entities.Cv;
import com.example.metier.InterCVMetier;
import com.example.utils.MediaTypeUtils;


@RestController
@CrossOrigin(origins="http://localhost:4200")
public class CVRestService {
	
	@Value("${logging.file.path}")
	String FILE_DIRECTORY;
	
	private static final String DIRECTORY = "C:\\Users\\Mariem\\Desktop\\3emeAnneeDSI\\Projet Recrutement\\-Recruitment_Managment_System\\CvImported";
	@Autowired
    private ServletContext servletContext;
	@RequestMapping(value="/cv/downloadCV/{code}",method = RequestMethod.GET)
	public ResponseEntity<Object> DownloadCv(@PathVariable(value = "code") 
	       Long code,HttpServletResponse response) throws IOException,Exception {
		Cv cvDownloaded = new Cv();
		Optional<Cv> result = cvRep.findById(code);
		if(!result.isPresent()) {
			throw new Exception("could not found cv with id :" + code);
		}
		cvDownloaded = result.get();
		String fileName = cvDownloaded.getPdf();
		
		MediaType mediaType = MediaTypeUtils.getMediaTypeForFileName(this.servletContext, fileName);
        System.out.println("fileName: " + fileName);
        System.out.println("mediaType: " + mediaType);
		
        File file = new File(DIRECTORY + "/" + fileName);
        
        // Content-Type
        // application/pdf
        response.setContentType(mediaType.getType());
       
        // Content-Disposition
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION, 
        		"attachment;filename=" + file.getName());
        
        // Content-Length
        response.setContentLength((int) file.length());
        BufferedInputStream inStream = 
        		new BufferedInputStream(new FileInputStream(file));
        BufferedOutputStream outStream = 
        		new BufferedOutputStream(response.getOutputStream());

        byte[] buffer = new byte[1024];
        int bytesRead = 0;
        while ((bytesRead = inStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, bytesRead);
        }
        inStream.close();
        outStream.flush();
        
		return new ResponseEntity<>("Downloaded cv successfully",HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/cv/UploadCV",method = RequestMethod.POST)
	public ResponseEntity<Object> UploadCv(@RequestParam("file") MultipartFile file) throws IOException{
		File myFile = new File(FILE_DIRECTORY+file.getOriginalFilename());
		Cv cvImported = new Cv(file.getOriginalFilename());
		cvRep.save(cvImported);
		myFile.createNewFile();
		FileOutputStream fos = new FileOutputStream(myFile);
		fos.write(file.getBytes());
		fos.close();
		return new ResponseEntity<Object>("the file uploaded succesfully" ,HttpStatus.OK);
	}
	
	
	@Autowired
	CVRepository cvRep;
	
	@Autowired
	private InterCVMetier CvMetier;
	
	@RequestMapping(value="/cv",method = RequestMethod.GET)
	public List<Cv> getCv(){
		return CvMetier.getCv();
	}
	
	@RequestMapping(value="/cv/{code}",method = RequestMethod.GET)
    public Cv getCv(@PathVariable long code) {
		return CvMetier.getOneCv(code);
	}
	
	
	@RequestMapping(value="/cv/{code}",method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteCv(@PathVariable long code) {
			CvMetier.deleteCv(code);
	}
	
	
	@RequestMapping(value="/cv/{code}",method = RequestMethod.PUT)
	public Cv EditCv(@PathParam(value = "code") long code, @RequestParam("file") MultipartFile file){
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		Cv cvUploaded = new Cv();
		cvUploaded.setPdf(fileName);
		return cvRep.save(cvUploaded);
    }
	
}