package com.example.demo;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="http://localhost:3000" ,allowedHeaders="*")
@RestController
public class HomeController {
	
	@GetMapping(value="/v1/unames/{id}")
	//public String homePage(Model model) {
	public String homePage(@PathVariable(value = "id") String userID) {
		String b64 = null;
		try {
			
			Map<String, String> map = new HashMap<String, String>();
			map.put("A", "C:/Users/Bhoomi/Downloads/testImg/nature 1.jpg");
			map.put("B", "C:/Users/Bhoomi/Downloads/testImg/nature 2.jpg");
			map.put("C", "C:/Users/Bhoomi/Downloads/testImg/nature 3.jpg");
			map.put("D", "C:/Users/Bhoomi/Downloads/testImg/nature 4.jpg");
			map.put("E", "C:/Users/Bhoomi/Downloads/testImg/nature 5.jpg");
			
			
			String fpath = (String) map.get(userID);
			
			//bImage to be replaced with our bufferedImage
			BufferedImage bImage = ImageIO.read(new File(fpath));//give the path of an image
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write( bImage, "jpg", baos );
			baos.flush();
			byte[] imageInByteArray = baos.toByteArray();
			baos.close();
			b64 = javax.xml.bind.DatatypeConverter.printBase64Binary(imageInByteArray);
			//model.addAttribute("imgToBeDisplayed",b64);
		
		}catch(IOException io) {
			io.printStackTrace();
		}
		return b64;
		//return "index";
	}
	
	//@ResponseBody
	@GetMapping(value="/v1/unames")
	public List<String> getUserNames(Model model) {
		
		List<String> unameList = new ArrayList<String>();
		unameList.add("A");
		unameList.add("B");
		unameList.add("C");
		unameList.add("D");
		unameList.add("E");
		return unameList;
	}
}
