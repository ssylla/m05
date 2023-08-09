package fr.eni.springboot.demom04.controller.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import fr.eni.springboot.demom04.bll.CoursService;
import fr.eni.springboot.demom04.bo.Cours;

@Component
public class StringToCoursConverter implements Converter<String, Cours> {

	@Autowired
	private CoursService coursService;
	
	
	@Override
	public Cours convert(String id) {
		System.out.println("Conversion du cours à partir de son id"+id);
		
		return coursService.findById(Long.parseLong(id));
	}

}
