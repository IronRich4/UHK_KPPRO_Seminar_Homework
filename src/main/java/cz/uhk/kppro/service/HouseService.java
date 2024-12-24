package cz.uhk.kppro.service;

import cz.uhk.kppro.model.House;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HouseService {
    List<House> getAllHouses();
    House getHouseById(long id);
    void deleteHouseById(long id);
    void saveHouse(House house);
}
