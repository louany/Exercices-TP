package com.tactfactory.monprojetsb.monprojetsb.services;

import java.util.List;

import com.tactfactory.monprojetsb.monprojetsb.entities.Product;
import com.tactfactory.monprojetsb.monprojetsb.repository.ProductRepository;

public class ProductService {
		
	private ProductRepository productRepository;
	
    public Product getOne(Long id) {
        return this.productRepository.getOne(id);
    }
    
	public Product save(Product item) {
		return this.productRepository.save(item);
	}
	
	public void delete(Product item) {
        this.productRepository.delete(item);
	}
	
	public List<Product> findAll() {	
		return this.productRepository.findAll();
	}
}
