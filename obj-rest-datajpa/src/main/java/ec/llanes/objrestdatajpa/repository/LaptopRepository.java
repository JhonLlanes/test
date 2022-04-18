package ec.llanes.objrestdatajpa.repository;

import ec.llanes.objrestdatajpa.modelo.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop,Long> {
}
