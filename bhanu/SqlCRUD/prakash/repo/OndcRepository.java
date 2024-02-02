package bhanu.prakash.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import bhanu.prakash.model.FoodOrder;


public interface OndcRepository extends JpaRepository<FoodOrder, Integer> {

}
