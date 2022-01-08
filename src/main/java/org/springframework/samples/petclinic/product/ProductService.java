package org.springframework.samples.petclinic.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.owner.OwnerRepository;
import org.springframework.samples.petclinic.pet.PetRepository;
import org.springframework.samples.petclinic.pet.VisitRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class ProductService {
	private ProductRepository productRepository;
	

	@Autowired
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	
	}
	@Transactional(readOnly = true)
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
	@Transactional(readOnly = true)
	public List<ProductType> findAllProductTypes(){
	 return productRepository.findAllProductTypes();
}
	@Transactional(readOnly = true)
    public List<Product> getProductsCheaperThan(double price) {
        return productRepository.findByPriceLessThan(price);
    }
    @Transactional(readOnly = true)
    public ProductType getProductType(String typeName) {
        return productRepository.findProductTypeByName(typeName);
    }

    public Product save(Product p){
        return productRepository.save(p);       
    }

    
}
