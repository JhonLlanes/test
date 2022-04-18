package ec.llanes.objrestdatajpa.modelo;

import javax.persistence.*;

@Entity
@Table(name = "laptop")
public class Laptop {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String marca;
    private String color;
    private int ram;

    public Laptop(Long id, String marca, String color, int ram) {
        this.id = id;
        this.marca = marca;
        this.color = color;
        this.ram = ram;
    }

    public Laptop() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", color='" + color + '\'' +
                ", ram=" + ram +
                '}';
    }
}
