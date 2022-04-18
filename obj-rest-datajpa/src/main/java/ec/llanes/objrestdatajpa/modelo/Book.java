package ec.llanes.objrestdatajpa.modelo;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String autor;
    private String paginas;
    private Double costo;
    private LocalDate lazamientofecha;
    private Boolean online;

    public Book() {
    }

    public Book(Long id, String title, String autor, String paginas, Double costo, LocalDate lazamientofecha, Boolean online) {
        this.id = id;
        this.title = title;
        this.autor = autor;
        this.paginas = paginas;
        this.costo = costo;
        this.lazamientofecha = lazamientofecha;
        this.online = online;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getPaginas() {
        return paginas;
    }

    public void setPaginas(String paginas) {
        this.paginas = paginas;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public LocalDate getLazamientofecha() {
        return lazamientofecha;
    }

    public void setLazamientofecha(LocalDate lazamientofecha) {
        this.lazamientofecha = lazamientofecha;
    }

    public Boolean getOnline() {
        return online;
    }

    public void setOnline(Boolean online) {
        this.online = online;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", autor='" + autor + '\'' +
                ", paginas='" + paginas + '\'' +
                ", costo=" + costo +
                ", lazamientofecha=" + lazamientofecha +
                ", online=" + online +
                '}';
    }
}
