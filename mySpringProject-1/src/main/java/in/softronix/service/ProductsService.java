package in.softronix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.softronix.entity.Products;
import in.softronix.repository.ProductsRepository;

@Service
public class ProductsService {
	
	@Autowired
	ProductsRepository repo;
	
	public Products savePro(Products product)
	{
		return repo.save(product);
	}
	
	public String deletePro(int id)
	{
		repo.deleteById(id);
		
		return "success";
	}
	public Products finds(int id)
	{
		return repo.findById(id).orElse(null);
	}
	
	public Products update(Products products)
	{
		Products exist = repo.findById(products.getId()).orElse(null);
		exist.setName(products.getName());
		exist.setCost(products.getCost());
		exist.setQuantity(products.getQuantity());
		return repo.save(exist);
	}

}
