package org.springframework.samples.petclinic.product;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.samples.petclinic.owner.Owner;



public interface ProductRepository extends CrudRepository<Product, Integer> {
	 @Query("SELECT p FROM Product p ORDER BY p.name")
    List<Product> findAll();    
    @Query("SELECT ptype FROM ProductType ptype ORDER BY ptype.name")
    List<ProductType> findAllProductTypes();
    @Query("SELECT ptype FROM ProductType ptype WHERE ptype.name LIKE :name")
    ProductType findProductTypeByName(@Param("name") String name);
    
    @Query("SELECT p FROM Product p WHERE p.price< :price")
    List<Product> findByPriceLessThan(@Param("price") Double price);
    Optional<Product> findById(int id);
    Product findByName(String name);
    Product save(Product p);
}
