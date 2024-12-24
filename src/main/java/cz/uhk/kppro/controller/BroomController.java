package cz.uhk.kppro.controller;

import cz.uhk.kppro.model.Broom;
import cz.uhk.kppro.repository.BroomRepository;
import cz.uhk.kppro.service.BroomService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/brooms")
public class BroomController {
    private BroomService broomService;

    @Autowired
    public BroomController(BroomService broomService, BroomRepository broomRepository) {
        this.broomService = broomService;
    }

//    private ArrayList<Broom> brooms = new ArrayList<>();        // repository pro preskoceni service vrstvy

    @GetMapping("/")
    public String listAllBrooms(Model model) {
        model.addAttribute("brooms", broomService.getAllBrooms());
        return "broom_list";
    }
    @GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable long id) {

        Broom broom = broomService.getBroomById(id);
        if(broom != null){
            model.addAttribute("broom", broom);
            return "broom_detail";
        }
        return "redirect:/brooms/";

    }
    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable long id) {

        Broom broom = broomService.getBroomById(id);
        if(broom != null){
            model.addAttribute("broom", broom);
            model.addAttribute("edit", true);
            return "broom_edit";
        }
        return "redirect:/brooms/";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        broomService.deleteBroomById(id);
        return "redirect:/brooms/";
    }
    @GetMapping("/create/")
    public String create(Model model){
        model.addAttribute("broom", new Broom());
        model.addAttribute("edit", false);
        return "broom_edit";
    }
    @PostMapping("/save/")
    public String save(@Valid Broom broom, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
//            model.addAttribute("edit", model.getAttribute("edit")); // prijima co uz tam bylo poslano predtim
            model.addAttribute("edit", broom.getId() != 0);

            return "broom_edit";
        }
        broomService.saveBroom(broom);
        return "redirect:/brooms/";
    }


}
