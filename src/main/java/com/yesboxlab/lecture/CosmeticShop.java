

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
			new Cosmetics("l1", "Addict Lip Maximizer Plumping Gloss", 5, "Lip"),
			new Cosmetics("l2", "TOM FORD lip Color", 10,"Lip"),
			new Cosmetics("l3", "Lip Sleeping Mask", 20, "Lip"),
            new Cosmetics("l4", "Full-On™ Plumping Lip Polish Gloss", 4, "Lip"),
            new Cosmetics("l5", "Hot Lips Lipstick", 8, "Lip"),
			new Cosmetics("l6", "Permagel Ultra Lip Pencil", 25, "Lip"),
			new Cosmetics("f1", "Pro Filt'r Hydrating Longwear Foundation-385", 9, "Foundation"),
			new Cosmetics("f2", "The Soft Fluid Long Wear Foundation- 150", 15, "Foundation"),
            new Cosmetics("f3", "Sheer Glow Foundation", 7, "Foundation"),
            new Cosmetics("f4", "Born This Way Foundation", 6, "Foundation"),
            new Cosmetics("f5", "Water Foundation Broad Spectrum", 3, "Foundation")
			));
	List<Lip> cosLip = new ArrayList<>(Arrays.asList(
			new Lip("l1", "Addict Lip Maximizer Plumping Gloss", "DIOR",
					1045, 5, "rosewood glossy", "Lip"),
			new Lip("l2", "TOM FORD lip Color", "TOM FORD",
					1700, 10, "Open Kimono - neutral pink", "Lip"),
            new Lip("l3", "Lip Sleeping Mask", "LANEIGE",
                    650, 20,"Original", "Lip"),
            new Lip("l4", "Full-On™ Plumping Lip Polish Gloss", "BUXOM",
                     650, 4, "Dolly", "Lip"),
            new Lip("l5", "Hot Lips Lipstick", "CHARLOTTE TILBURY",
                     1050, 8, "Kim K.W - nude", "Lip"),
            new Lip("l6", "Permagel Ultra Lip Pencil", "PAT MCGRATH LABS",
                    860, 25, "Buff - warm nude", "Lip")
	        ));
	List<Foundation> cosFoundation = new ArrayList<>(Arrays.asList(
			new Foundation("f1", "Pro Filt'r Hydrating Longwear Foundation-385", "FENTY BEAUTY",
					1080, 9, "Normal Dry Combination", "Foundation"),
			new Foundation("f2", "The Soft Fluid Long Wear Foundation- 150", "LA MER",
					3700, 15, "Normal Dry Oily Combination", "Foundation"),
            new Foundation("f3", "Sheer Glow Foundation", "NARS",
                    1500, 7, "Normal Dry", "Foundation"),
            new Foundation("f4", "Born This Way Foundation", "Too Faced",
                    1200, 6, "Normal Dry Combination Oily", "Foundation"),
            new Foundation("f5", "Water Foundation Broad Spectrum", "Tarte",
                    1200, 3, "Normal Dry", "Foundation")
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
	private Categories cat = new Categories();
	private SingletonCosmetic temp = SingletonCosmetic.getInstance();

	//for get cosmetic details

    @RequestMapping(value = "/get")
    public ResponseEntity<List<Cosmetics>> get() {
        return new ResponseEntity<List<Cosmetics>>(this.temp.getAllCosmetics(), HttpStatus.OK);
    }

	@RequestMapping(value = "/get/{index}")
    public ResponseEntity<Cosmetics> get(@PathVariable int index) {
        return new ResponseEntity<Cosmetics>(this.temp.getCosmetics(index), HttpStatus.OK);
    }

    //for create lip
    @RequestMapping(value = "/create/Lip")
    public ResponseEntity<List<Cosmetics>> create(@RequestBody Lip l){
	    Cosmetics lip = cat.create("Lip");
        ((Lip) lip).setCosmeticId(l.getCosmeticId());
        ((Lip) lip).setName(l.getName());
        ((Lip) lip).setBrand(l.getBrand());
        ((Lip) lip).setPrice(l.getPrice());
        ((Lip) lip).setStock(l.getStock());
        ((Lip) lip).setColor(l.getColor());
        ((Lip) lip).setCategory(l.getCategory());
        this.temp.createCosmetic(lip);
	    return new ResponseEntity<List<Cosmetics>>(this.temp.getAllCosmetics(), HttpStatus.OK);
    }

    //for create foundation
    @RequestMapping(value = "/create/Foundation")
    public ResponseEntity<List<Cosmetics>> create(@RequestBody Foundation f){
        Cosmetics foundation = cat.create("Foundation");
        ((Foundation) foundation).setCosmeticId(f.getCosmeticId());
        ((Foundation) foundation).setName(f.getName());
        ((Foundation) foundation).setBrand(f.getBrand());
        ((Foundation) foundation).setPrice(f.getPrice());
        ((Foundation) foundation).setStock(f.getStock());
        ((Foundation) foundation).setSkin(f.getSkin());
        ((Foundation) foundation).setCategory(f.getCategory());
        this.temp.createCosmetic(foundation);
        return new ResponseEntity<List<Cosmetics>>(this.temp.getAllCosmetics(), HttpStatus.OK);
    }

    //for create other cosmetic
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<List<Cosmetics>> create(@RequestBody Cosmetics cosmetic) {
	    this.temp.createCosmetic(cosmetic);
        return new ResponseEntity<List<Cosmetics>>(this.temp.getAllCosmetics(), HttpStatus.OK);
    }

    //for update detail (you must identify index of cosmetic that you want to update
    @RequestMapping(value = "/update/{index}", method = RequestMethod.POST)
    public ResponseEntity<List<Cosmetics>> update(@RequestBody Cosmetics cosmetic, @PathVariable int index){
        this.temp.updateCosmetic(index, cosmetic);
        return new ResponseEntity<List<Cosmetics>>(this.temp.getAllCosmetics(), HttpStatus.OK);
    }

    //for delete cosmetic (you must identify index of cosmetic that you want to delete
    @RequestMapping(value = "/delete/{index}")
    public ResponseEntity<List<Cosmetics>> delete(@PathVariable int index){
        this.temp.delCosmetic(index);
        return new ResponseEntity<List<Cosmetics>>(this.temp.getAllCosmetics(), HttpStatus.OK);
    }
}
