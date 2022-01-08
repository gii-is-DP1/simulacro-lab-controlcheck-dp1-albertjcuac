package org.springframework.samples.petclinic.product;

import java.text.ParseException;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.samples.petclinic.pet.PetType;
import org.springframework.stereotype.Component;

@Component
public class ProductTypeFormatter implements Formatter<ProductType>{
	private final ProductService productService;

	@Autowired
	public ProductTypeFormatter(ProductService productService) {
		this.productService = productService;
	}

    @Override
    public String print(ProductType object, Locale locale) {
        
        return object.getName();
    }

    @Override
    public ProductType parse(String text, Locale locale) throws ParseException {
    	ProductType findProductType = this.productService.getProductType(text);
	
			if (findProductType!=null) {
				return findProductType;
			
		}
		throw new ParseException("type not found: " + text, 0);
    }
    
}
