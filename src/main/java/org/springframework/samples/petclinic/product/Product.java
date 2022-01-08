package org.springframework.samples.petclinic.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.model.NamedEntity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Product extends BaseEntity {
	  @NotNull	
	  @Size(min = 3, max = 50)
	  @Column(name = "name")
	  private String name;
	  
	  @NotNull
	  @Min(0)
	  private double price;
	  @ManyToOne
	  ProductType productType;
}
