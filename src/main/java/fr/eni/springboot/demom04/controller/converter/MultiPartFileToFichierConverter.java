package fr.eni.springboot.demom04.controller.converter;

import java.io.IOException;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import fr.eni.springboot.demom04.bo.Fichier;

@Component
public class MultiPartFileToFichierConverter implements Converter<MultipartFile, Fichier> {

	
	@Override
	public Fichier convert(MultipartFile source) {

		Fichier resultat = null;
		if(null != source) {
			try {
				resultat = new Fichier(source.getOriginalFilename(), source.getContentType(), source.getSize(), source.getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return resultat;
	}	
}
