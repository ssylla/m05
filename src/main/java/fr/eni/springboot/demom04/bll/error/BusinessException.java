package fr.eni.springboot.demom04.bll.error;

import java.util.ArrayList;
import java.util.List;

public class BusinessException extends RuntimeException {

	private List<BusinessError> errors;
	
	{
		errors = new ArrayList<>();
	}

	public List<BusinessError> getErrors() {
		return errors;
	}
	
	public void add(BusinessError error) {
		if (null != error) {
			errors.add(error);
		}
	}
	
	public boolean isValid() {
		return errors.isEmpty();
	}
}
