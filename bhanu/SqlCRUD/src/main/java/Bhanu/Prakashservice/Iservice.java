package Bhanu.Prakashservice;

import java.util.List;
import java.util.Optional;

import Bhanu.Prakash.model.Student;

public interface Iservice {

	public Integer savestudent(Student s);
	public void updatestudent(Student s);
	public void deletestudent(Integer id);
	public Optional<Student> getonestudent(Integer id);
	public List<Student> getallstudents();
	public boolean isstudentexist(Integer id);
}
