package in.softronix.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.softronix.entity.Products;

@Repository
public interface ProductsRepository extends JpaRepository<Products,Integer>{

}
