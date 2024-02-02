package bhanu.prakash.service;

import java.util.List;
import java.util.Optional;

import bhanu.prakash.model.FoodOrder;

public interface Ondcservice {

	public Integer saveorder(FoodOrder id);
	public void updateorder(FoodOrder id);
	public void deleteorder(Integer id);
	public Optional<FoodOrder> getoneorder(Integer id);
	public List<FoodOrder> Getallorders();
	public boolean isexistorder(Integer id);
}
