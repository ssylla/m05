package fr.eni.springboot.demom04.bll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eni.springboot.demom04.bo.Cours;
import fr.eni.springboot.demom04.dal.CoursDAO;

@Service
public class CoursServiceImpl implements CoursService {
	private CoursDAO courseDAO;

	@Autowired
	public CoursServiceImpl(CoursDAO courseDAO) {
		this.courseDAO = courseDAO;
	}

	@Override
	public List<Cours> getCours() {
		return courseDAO.findAll();
	}

	@Override
	public Cours findById(long id) {
		return courseDAO.read(id);
	}
}
