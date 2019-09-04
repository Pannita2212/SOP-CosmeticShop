

package com.yesboxlab.lecture;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@SpringBootApplication
@RestController
public class CosmeticShop {
	public static void main(String[] args) {
		SpringApplication.run(CosmeticShop.class, args);
	}

	List<Cosmetics> cosmetics = new ArrayList<>(Arrays.asList(
			new Cosmetics("l1", "Addict Lip Maximizer Plumping Gloss", 5),
			new Cosmetics("l2", "TOM FORD lip Color", 10),
			new Cosmetics("f1", "Pro Filt'r Hydrating Longwear Foundation-385", 9),
			new Cosmetics("f2", "The Soft Fluid Long Wear Foundation- 150", 15)
			));
	List<Lip> cosLip = new ArrayList<>(Arrays.asList(
			new Lip("l1", "Addict Lip Maximizer Plumping Gloss", "DIOR",
					6, 1045, 5, "rosewood glossy"),
			new Lip("l2", "TOM FORD lip Color", "TOM FORD",
					2.96, 1700, 10, "Open Kimono - neutral pink")
	));
	List<Foundation> cosFoundation = new ArrayList<>(Arrays.asList(
			new Foundation("f1", "Pro Filt'r Hydrating Longwear Foundation-385", "FENTY BEAUTY",
					32, 1080, 9, "Normal Dry Combination", "medium"),
			new Foundation("f2", "The Soft Fluid Long Wear Foundation- 150", "LA MER",
					30, 3700, 15, "Normal Dry Oily Combination", "medium")
			));

	@RequestMapping("/cosmetics")
	public List<Cosmetics> getAllCosmetics() {
		return cosmetics;
	}
	@RequestMapping("/cosmetics/lip")
	public List<Lip> getAllLip() {
		return cosLip;
	}
	@RequestMapping("/cosmetics/foundation")
	public List<Foundation> getAllFoundation() {
		return cosFoundation;
	}


	@RequestMapping(value = "/cosmetics/{id}/{num}", method=RequestMethod.PUT)
	//Enter(in request url) id and number of product that you want to buy
	public String buyCosmetics(@PathVariable String id, @PathVariable int num) {
		for(int i = 0; i < cosmetics.size(); i++) {
			if(cosmetics.get(i).getCosmeticId().equalsIgnoreCase(id)) {
				return cosmetics.get(i).buyCosmetics(num);
			}
		}
		return "Product out of stock";
	}
}
