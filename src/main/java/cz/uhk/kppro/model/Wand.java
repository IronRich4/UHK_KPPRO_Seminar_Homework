package cz.uhk.kppro.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.Comment;

import java.util.List;

@Entity
@Table(name= "wands")
public class Wand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // stara se o autoinkrement
    private long id; // primarni klic musi byt v long

    @NotBlank(message = "Name must not be Empty")
    @Size(min = 3, max = 20, message = "Maximum is 20 Characters")
    private String material;

    @Min(value=1)
    @Max(value=1000)
    @Comment("Must be Older than 0 Years")
    private int age;

    //vlastnena strana
    @OneToMany(mappedBy = "wand")
    private List<Wizard> wizards;



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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Wizard> getWizards() {
        return wizards;
    }

    public void setWizards(List<Wizard> wizards) {
        this.wizards = wizards;
    }
}
