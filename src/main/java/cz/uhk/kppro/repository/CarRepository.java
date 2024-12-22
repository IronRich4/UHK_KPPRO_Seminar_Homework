package cz.uhk.kppro.repository; // komunikace mezi vrstvami DATASOURCE a SERVICE

import cz.uhk.kppro.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    Long Id(long id);   // ma připravené metody

    // příklady případů užití :)

//    List<Car> getAllByColorContainsIgnoreCase(String color);
//    Car getCarByColor(String color);
//    List<Car> getCarsByNumberOfSeatsBetweenAndColorContainsIgnoreCase(String from, String to, String color);

}
