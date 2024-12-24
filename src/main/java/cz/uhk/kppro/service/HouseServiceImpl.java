package cz.uhk.kppro.service;

import cz.uhk.kppro.model.House;
import cz.uhk.kppro.repository.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service    // Bez ANOTACE se nejdna o Java Bean
public class HouseServiceImpl implements HouseService {

    private HouseRepository houseRepository;

    @Autowired
    public HouseServiceImpl(HouseRepository houseRepository){
        this.houseRepository = houseRepository;
    }

    @Override
    public List<House> getAllHouses() {
        return houseRepository.findAll();
    }

    @Override
    public House getHouseById(long id) {
        return houseRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteHouseById(long id) {
        Optional<House> house = houseRepository.findById(id);
        if(house.isPresent()){
            houseRepository.delete(house.get());
        }
    }

    @Override
    public void saveHouse(House house) {
        houseRepository.save(house); // pokud existuje pouze se aktualizuje diky Primary Key
    }
}
