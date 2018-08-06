package com.example.bank.controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.bank.DTO.ClientDTO;
import com.example.bank.model.Clearing;
import com.example.bank.model.Client;
import com.example.bank.model.Place;
import com.example.bank.model.RealTimeGrossSettlement;
import com.example.bank.service.IClearingService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/clearings")
public class ClearingController {

	@Autowired
	private IClearingService clearingService;
	
	@RequestMapping(
			value = "/getAll", 
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Clearing>  getClearings() {
		
		
		return clearingService.getAll();
		
	}
	
	@RequestMapping(
			value = "/export",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean exportClearing(@RequestBody Clearing clearing) {
		
		System.out.println("pogodjenoo");
		String xmlString = "";
	    try {
	        JAXBContext context = JAXBContext.newInstance(Clearing.class);
	        Marshaller m = context.createMarshaller();

	        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE); // To format XML

	        StringWriter sw = new StringWriter();
	        m.marshal(clearing, sw);
	        xmlString = sw.toString();

	    } catch (JAXBException e) {
	        e.printStackTrace();
	    }
	    System.out.println(xmlString);		
	    
	    BufferedWriter bw = null;
		FileWriter fw = null;
	    
	    String filename = "clearing-" + clearing.getPorukaID() +".xml";
	    try{
	    	fw = new FileWriter("C:\\Users\\Arsenije\\Desktop\\exportovaniCLearinzi\\" + filename);		    	
	    	bw = new BufferedWriter(fw);
	    	bw.write(xmlString);
	    	
	    } catch (IOException ex) {

			ex.printStackTrace();

		} finally {
			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();					
					

			} catch (IOException ex) {

				ex.printStackTrace();

			}
		}
		return true;
	}
}
