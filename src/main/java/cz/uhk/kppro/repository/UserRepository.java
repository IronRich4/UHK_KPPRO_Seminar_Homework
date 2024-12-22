package cz.uhk.kppro.repository; // komunikace mezi vrstvami DATASOURCE a SERVICE

import cz.uhk.kppro.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    Long Id(long id);   // ma připravené metody

    User findByUsername(String username);

    // příklady případů užití :)

//    List<Car> getAllByColorContainsIgnoreCase(String color);
//    Car getCarByColor(String color);
//    List<Car> getCarsByNumberOfSeatsBetweenAndColorContainsIgnoreCase(String from, String to, String color);

}

