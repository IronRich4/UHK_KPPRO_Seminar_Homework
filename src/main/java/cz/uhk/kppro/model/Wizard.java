package cz.uhk.kppro.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name= "wizards")
public class Wizard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // stara se o autoinkrement
    private long id; // primarni klic musi byt v long

    @NotBlank(message = "SPZ NESMI byt Prazdne")
    //@Size(min = 7, max = 7, message = "MAX 7 Znaku pro SPZ")
    private String name;

    @Min(value = 18)
    @Max(value = 99)
    private int age;

//    @OneToOne
//    private Broom broom;

    //vlastnici strana
    @ManyToOne
    private Broom broom;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Broom getBroom() {
        return broom;
    }

    public void setBroom(Broom broom) {
        this.broom = broom;
    }
}

