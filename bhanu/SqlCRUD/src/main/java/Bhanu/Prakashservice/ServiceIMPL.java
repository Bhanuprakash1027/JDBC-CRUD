package Bhanu.Prakashservice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Bhanu.Prakash.model.Student;
import Bhanu.Prakash.repository.Stdrepository;

@Service
public class ServiceIMPL implements Iservice {

	@Autowired
	private Stdrepository repo;
	
	@Override
	public Integer savestudent(Student s) {
		// TODO Auto-generated method stub
		return repo.save(s).getStdId();
	}

	@Override
	public void updatestudent(Student s) {
		// TODO Auto-generated method stub
		repo.save(s);
	}

	@Override
	public void deletestudent(Integer id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

	@Override
	public Optional<Student> getonestudent(Integer id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	@Override
	public List<Student> getallstudents() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public boolean isstudentexist(Integer id) {
		// TODO Auto-generated method stub
		return repo.existsById(id);
	}

}
