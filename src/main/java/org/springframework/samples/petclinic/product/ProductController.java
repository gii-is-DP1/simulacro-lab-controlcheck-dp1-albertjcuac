package org.springframework.samples.petclinic.product;

import java.util.Collection;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.samples.petclinic.pet.Pet;
import org.springframework.samples.petclinic.pet.PetType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {
	private static final String VIEWS_PRODUCTS_CREATE_OR_UPDATE_FORM = "products/createOrUpdateProductForm";
	private static final String VIEWS_WELCOME = "welcome";
	private final ProductService productService;
      

	@Autowired
	public ProductController(ProductService productService) {
		this.productService =productService;
     
	}
	
	@ModelAttribute("types")
	public Collection<ProductType> populateProductTypes() {
		return this.productService.findAllProductTypes();
	}
	
	@GetMapping(value = "/product/create")
	public String initCreationForm(ModelMap model) {
		Product product = new Product();
		model.put("product", product);
		return VIEWS_PRODUCTS_CREATE_OR_UPDATE_FORM;
	}
	@PostMapping(value = "/product/create")
	public String processCreationForm(@Valid Product product, BindingResult result) {
		if (result.hasErrors()) {
			return VIEWS_PRODUCTS_CREATE_OR_UPDATE_FORM;
		}
		else {
			this.productService.save(product);
			
			return VIEWS_WELCOME;
		}
	}

}
