package cz.uhk.kppro.controller;

import cz.uhk.kppro.model.House;
import cz.uhk.kppro.repository.HouseRepository;
import cz.uhk.kppro.service.HouseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/houses")
public class HouseController {
    private HouseService houseService;

    @Autowired
    public HouseController(HouseService houseService, HouseRepository houseRepository) {
        this.houseService = houseService;
    }

//    private ArrayList<House> houses = new ArrayList<>();        // repository pro preskoceni service vrstvy

    @GetMapping("/")
    public String listAllHouses(Model model) {
        model.addAttribute("houses", houseService.getAllHouses());
        return "house_list";
    }
    @GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable long id) {

        House house = houseService.getHouseById(id);
        if(house != null){
            model.addAttribute("house", house);
            return "house_detail";
        }
        return "redirect:/houses/";

    }
    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable long id) {

        House house = houseService.getHouseById(id);
        if(house != null){
            model.addAttribute("house", house);
            model.addAttribute("edit", true);
            return "house_edit";
        }
        return "redirect:/houses/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        houseService.deleteHouseById(id);
        return "redirect:/houses/";
    }
    @GetMapping("/create/")
    public String create(Model model){
        model.addAttribute("house", new House());
        model.addAttribute("edit", false);
        return "house_edit";
    }
    @PostMapping("/save/")
    public String save(@Valid House house, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
//            model.addAttribute("edit", model.getAttribute("edit")); // prijima co uz tam bylo poslano predtim
            model.addAttribute("edit", house.getId() != 0);

            return "house_edit";
        }
        houseService.saveHouse(house);
        return "redirect:/houses/";
    }


}
