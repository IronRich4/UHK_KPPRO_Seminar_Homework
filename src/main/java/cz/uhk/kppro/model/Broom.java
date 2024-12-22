package cz.uhk.kppro.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.Comment;

import java.util.List;

@Entity
@Table(name= "brooms")
public class Broom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // stara se o autoinkrement
    private long id; // primarni klic musi byt v long

    @NotBlank(message = "Name must not be Empty")
    @Size(min = 3, max = 20, message = "Maximum is 20 Characters")
    private String name;

    private String material;

    @Min(value=10)
    @Max(value=2000)
    @Comment("Must be Faster than 10 KMH")
    private int speed;

//    @OneToOne(mappedBy = "broom")
//    private Wizard wizard;

    //vlastnena strana
    @OneToMany(mappedBy = "broom")
    private List<Wizard> wizards;

//    public Broom(String color, int i, String s) {
//        this.color = color;
//        this.numberOfSeats = i;
//        this.licensePlate = s;
//    }
//    public Broom(){
//    }


    public String getName() {
        return name;
    }

    public void setName(String licensePlate) {
        this.name = licensePlate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int numberOfSeats) {
        this.speed = numberOfSeats;
    }
}
