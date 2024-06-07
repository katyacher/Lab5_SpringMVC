package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Jewel;
import com.example.JewelService;


@Controller
public class JewelController {

	@Autowired
	JewelService jewelService;

	@GetMapping("/jewelry")
    public String get(Model mvcModel){
        mvcModel.addAttribute("jewelry",jewelService.findAll());
        return "jewelry";
    }
	
    @GetMapping("/jewelry/{id}")
    public String getOne(@PathVariable("id") long id, Model mvcModel){
        Jewel jewel = jewelService.findById(id);
        if(jewel == null){
            return "404";
        }
        mvcModel.addAttribute("jewel", jewelService.findById(id));
        return "jewel";
    }
    
    @GetMapping("/jewel/add")
    public String insertJewelForm(){
        return "jewelForm";
    }
    
    @GetMapping("/jewels/{id}/edit")
    public String editJewelForm(@PathVariable("id") long id, Model mvcModel){
        Jewel jewel = jewelService.findById(id);
        if(jewel == null){
            return "404";
        }
        mvcModel.addAttribute("bike", jewelService.findById(id));
        return "jewelForm";
    }
	
    @GetMapping("/jewels/search")
    public String searchJewelUpToPrice(@RequestParam("price") int price, Model mvcModel) {
        mvcModel.addAttribute("jewels", jewelService.searchUpTo(price));
        return "jewels";
    }
    
    
    
    @PostMapping("/jewels")
    public String add(@RequestBody MultiValueMap<String, String> formData, Model mvcModel){
        Jewel jewel = new Jewel();
        int size; 
        int price;
        String type;
        String metal;
        String stone;
        
        type = formData.getFirst("type");
        if(type == null || type.length() < 3){
            mvcModel.addAttribute("failReason", "Type length must be > 3 characters");
        }
        jewel.setType(type);
        
        metal = formData.getFirst("metal");
        if(metal == null || metal.length() < 3){
            mvcModel.addAttribute("failReason", "Metal length must be > 3 characters");
        }
        jewel.setMetal(metal);
        
        stone = formData.getFirst("stone");
        if(stone == null || stone.length() < 3){
            mvcModel.addAttribute("failReason", "Stone length must be > 3 characters");
        }
        jewel.setStone(stone);
        
        String sizeStr = formData.getFirst("size");
        try{
        	size = Integer.parseInt(sizeStr);
        } catch(Exception ex) {
        	size = 0;
        }

        if(size < 1){
            mvcModel.addAttribute("failReason", "Size cannot be 0 or negative.");
        }
        jewel.setSize(size);
        
        String priceStr = formData.getFirst("price");
        try{
            price = Integer.parseInt(priceStr);
        } catch(Exception ex) {
            price = 0;
        }
        if(price < 1){
            mvcModel.addAttribute("failReason", "Price cannot be less then 1");
        }
        jewel.setPrice(price);
        
        if(mvcModel.getAttribute("failReason") != null){
            return "jewelForm";
        }
        
        jewelService.insert(jewel);
        mvcModel.addAttribute("jewel", jewel);
        return "redirect:/jewels/"+jewel.getId();
    }

    
    @PostMapping("/jewels/{id}")
    public String edit(@PathVariable("id") long id, @RequestBody MultiValueMap<String, String> formData, Model mvcModel){
        Jewel jewel = jewelService.findById(id);
        int size; 
        int price;
        String type;
        String metal;
        String stone;
        
        if(jewel == null){
            return "404";
        }
        
        type = formData.getFirst("type");
        if(type == null || type.length() < 3){
            mvcModel.addAttribute("failReason", "Type length must be > 3 characters");
        }
        jewel.setType(type);
        
        metal = formData.getFirst("metal");
        if(metal == null || metal.length() < 3){
            mvcModel.addAttribute("failReason", "Metal length must be > 3 characters");
        }
        jewel.setMetal(metal);
        
        stone = formData.getFirst("stone");
        if(stone == null || stone.length() < 3){
            mvcModel.addAttribute("failReason", "Stone length must be > 3 characters");
        }
        jewel.setStone(stone);
        
        String sizeStr = formData.getFirst("size");
        try{
        	size = Integer.parseInt(sizeStr);
        } catch(Exception ex) {
        	size = 0;
        }

        if(size < 1){
            mvcModel.addAttribute("failReason", "Size cannot be 0 or negative.");
        }
        jewel.setSize(size);
        
        String priceStr = formData.getFirst("price");
        try{
            price = Integer.parseInt(priceStr);
        } catch(Exception ex) {
            price = 0;
        }
        if(price < 1){
            mvcModel.addAttribute("failReason", "Price cannot be less then 1");
        }
        jewel.setPrice(price);
        mvcModel.addAttribute("jewel", jewel);
        if(mvcModel.getAttribute("failReason") != null){
            return "jewelForm";
        }
        
        
        jewelService.update(id, jewel);
        return "redirect:/bikes/"+jewel.getId();
    }
    
    @PostMapping("/jewels/{id}/delete")
    public String deleteJewel(@PathVariable("id") long id, Model mvcModel){
    	Jewel jewel = jewelService.findById(id);
        if(jewel == null){
            return "404";
        }
        jewelService.delete(id);
        return "redirect:/bikes";
    }

}
