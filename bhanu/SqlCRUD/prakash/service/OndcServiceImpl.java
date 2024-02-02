package bhanu.prakash.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bhanu.prakash.model.FoodOrder;
import bhanu.prakash.repo.OndcRepository;

@Service
public class OndcServiceImpl implements Ondcservice {

	@Autowired
	private OndcRepository repo;
	
//	public OndcServiceImpl(OndcRepository ondcrepository) {
//		this.repo=ondcrepository;
//	}
//	
	@Override
	public Integer saveorder(FoodOrder id) {
		// TODO Auto-generated method stub
		return repo.save(id).getOrderid();
	}

	@Override
	public void updateorder(FoodOrder id) {
		// TODO Auto-generated method stub
		repo.save(id);
	}

	@Override
	public void deleteorder(Integer id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

	@Override
	public boolean isexistorder(Integer id) {
		// TODO Auto-generated method stub
		return repo.existsById(id);
	}

	@Override
	public Optional<FoodOrder> getoneorder(Integer id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	@Override
	public List<FoodOrder> Getallorders() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

}
