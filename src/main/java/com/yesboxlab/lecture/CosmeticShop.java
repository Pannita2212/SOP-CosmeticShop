

package com.yesboxlab.lecture;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@SpringBootApplication
@RestController
public class CosmeticShop {
	public static void main(String[] args) {
		SpringApplication.run(CosmeticShop.class, args);
	}

//	Assignment 1
	List<Cosmetics> cosmetics = new ArrayList<>(Arrays.asList(
			new Cosmetics("l1", "Addict Lip Maximizer Plumping Gloss", 5),
			new Cosmetics("l2", "TOM FORD lip Color", 10),
			new Cosmetics("l3", "Lip Sleeping Mask", 20),
            new Cosmetics("l4", "Full-On™ Plumping Lip Polish Gloss", 4),
            new Cosmetics("l5", "Hot Lips Lipstick", 8),
			new Cosmetics("l6", "Permagel Ultra Lip Pencil", 25),
			new Cosmetics("f1", "Pro Filt'r Hydrating Longwear Foundation-385", 9),
			new Cosmetics("f2", "The Soft Fluid Long Wear Foundation- 150", 15),
            new Cosmetics("f3", "Sheer Glow Foundation", 7),
            new Cosmetics("f4", "Born This Way Foundation", 6),
            new Cosmetics("f5", "Water Foundation Broad Spectrum", 3)
			));
	List<Lip> cosLip = new ArrayList<>(Arrays.asList(
			new Lip("l1", "Addict Lip Maximizer Plumping Gloss", "DIOR",
					6, 1045, 5, "rosewood glossy"),
			new Lip("l2", "TOM FORD lip Color", "TOM FORD",
					2.96, 1700, 10, "Open Kimono - neutral pink"),
            new Lip("l3", "Lip Sleeping Mask", "LANEIGE",
                    20, 650, 20,"Original"),
            new Lip("l4", "Full-On™ Plumping Lip Polish Gloss", "BUXOM",
                    4.44, 650, 4, "Dolly"),
            new Lip("l5", "Hot Lips Lipstick", "CHARLOTTE TILBURY",
                    12, 1050, 8, "Kim K.W - nude"),
            new Lip("l6", "Permagel Ultra Lip Pencil", "PAT MCGRATH LABS",
                    1.2, 860, 25, "Buff - warm nude")
	        ));
	List<Foundation> cosFoundation = new ArrayList<>(Arrays.asList(
			new Foundation("f1", "Pro Filt'r Hydrating Longwear Foundation-385", "FENTY BEAUTY",
					32, 1080, 9, "Normal Dry Combination", "medium"),
			new Foundation("f2", "The Soft Fluid Long Wear Foundation- 150", "LA MER",
					30, 3700, 15, "Normal Dry Oily Combination", "medium"),
            new Foundation("f3", "Sheer Glow Foundation", "NARS",
                    30, 1500, 7, "Normal Dry", "Medium"),
            new Foundation("f4", "Born This Way Foundation", "Too Faced",
                    25, 1200, 6, "Normal Dry Combination Oily", "Full"),
            new Foundation("f5", "Water Foundation Broad Spectrum", "Tarte",
                    30, 1200, 3, "Normal Dry", "Medium")
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



//	Assignment 2
    private SingletonCosmetic temp = SingletonCosmetic.getInstance();

	@RequestMapping(value = "/get/{index}")
    public ResponseEntity<Cosmetics> get(@PathVariable int index) {
        return new ResponseEntity<Cosmetics>(this.temp.getCosmetics(index), HttpStatus.OK);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<List<Cosmetics>> create(@RequestBody Cosmetics cosmetic) {
	    this.temp.createCosmetic(cosmetic);
        return new ResponseEntity<List<Cosmetics>>(this.temp.getAllCosmetics(), HttpStatus.OK);
    }

    @RequestMapping(value = "/update/{index}", method = RequestMethod.POST)
    public ResponseEntity<List<Cosmetics>> update(@RequestBody Cosmetics cosmetic, @PathVariable int index){
        this.temp.updateCosmetic(index, cosmetic);
        return new ResponseEntity<List<Cosmetics>>(this.temp.getAllCosmetics(), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{index}")
    public ResponseEntity<List<Cosmetics>> delete(@PathVariable int index){
        this.temp.delCosmetic(index);
        return new ResponseEntity<List<Cosmetics>>(this.temp.getAllCosmetics(), HttpStatus.OK);
    }
}
