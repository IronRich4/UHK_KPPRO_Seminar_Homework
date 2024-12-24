package cz.uhk.kppro.repository; // komunikace mezi vrstvami DATASOURCE a SERVICE

import cz.uhk.kppro.model.House;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseRepository extends JpaRepository<House, Long> {
    Long Id(long id);   // ma připravené metody

    // příklady případů užití :)

//    List<House> getAllByColorContainsIgnoreCase(String color);
//    House getHouseByColor(String color);
//    List<House> getHousesByNumberOfSeatsBetweenAndColorContainsIgnoreCase(String from, String to, String color);

}
