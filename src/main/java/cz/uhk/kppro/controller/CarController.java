package cz.uhk.kppro.controller;

import cz.uhk.kppro.model.Car;
import cz.uhk.kppro.repository.CarRepository;
import cz.uhk.kppro.service.CarService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/cars")
public class CarController {
    private CarService carService;

    @Autowired
    public CarController(CarService carService, CarRepository carRepository) {
        this.carService = carService;
    }

//    private ArrayList<Car> cars = new ArrayList<>();        // repository pro preskoceni service vrstvy

    @GetMapping("/")
    public String listAllCars(Model model) {
//        Car car = new Car("modrá",5,"8H02536");
//        cars.add(car);
        model.addAttribute("cars", carService.getAllCars());
        return "car_list";
    }
    @GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable long id) {
//        Car car = cars.get(id);
//        car.setId(id);
        Car car = carService.getCarById(id);
        if(car != null){
            model.addAttribute("car", car);
            return "car_detail";
        }
        return "redirect:/cars/";
//        model.addAttribute("car", car);
//        return "car_detail";
    }
    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable long id) {
//        Car car = cars.get(id);
//        car.setId(id);
        Car car = carService.getCarById(id);
        if(car != null){
            model.addAttribute("car", car);
            model.addAttribute("edit", true);
            return "car_edit";
        }
        return "redirect:/cars/";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        carService.deleteCarById(id);
        return "redirect:/cars/";
    }
    @GetMapping("/create/")
    public String create(Model model){
        model.addAttribute("car", new Car());
        model.addAttribute("edit", false);
        return "car_edit";
    }
    @PostMapping("/save/")
    public String save(@Valid Car car, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
//            model.addAttribute("edit", model.getAttribute("edit")); // prijima co uz tam bylo poslano predtim
            model.addAttribute("edit", car.getId() != 0);

            return "car_edit";
        }
        carService.saveCar(car);
        return "redirect:/cars/";
    }


}
