package cz.uhk.kppro.controller;

import cz.uhk.kppro.model.Wand;
import cz.uhk.kppro.repository.WandRepository;
import cz.uhk.kppro.service.WandService;
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
@RequestMapping("/wands")
public class WandController {
    private WandService wandService;

    @Autowired
    public WandController(WandService wandService, WandRepository wandRepository) {
        this.wandService = wandService;
    }

//    private ArrayList<Wand> wands = new ArrayList<>();        // repository pro preskoceni service vrstvy

    @GetMapping("/")
    public String listAllWands(Model model) {
//        Wand wand = new Wand("modrá",5,"8H02536");
//        wands.add(wand);
        model.addAttribute("wands", wandService.getAllWands());
        return "wand_list";
    }
    @GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable long id) {
//        Wand wand = wands.get(id);
//        wand.setId(id);
        Wand wand = wandService.getWandById(id);
        if(wand != null){
            model.addAttribute("wand", wand);
            return "wand_detail";
        }
        return "redirect:/wands/";
//        model.addAttribute("wand", wand);
//        return "wand_detail";
    }
    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable long id) {
//        Wand wand = wands.get(id);
//        wand.setId(id);
        Wand wand = wandService.getWandById(id);
        if(wand != null){
            model.addAttribute("wand", wand);
            model.addAttribute("edit", true);
            return "wand_edit";
        }
        return "redirect:/wands/";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        wandService.deleteWandById(id);
        return "redirect:/wands/";
    }
    @GetMapping("/create/")
    public String create(Model model){
        model.addAttribute("wand", new Wand());
        model.addAttribute("edit", false);
        return "wand_edit";
    }
    @PostMapping("/save/")
    public String save(@Valid Wand wand, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
//            model.addAttribute("edit", model.getAttribute("edit")); // prijima co uz tam bylo poslano predtim
            model.addAttribute("edit", wand.getId() != 0);

            return "wand_edit";
        }
        wandService.saveWand(wand);
        return "redirect:/wands/";
    }


}
