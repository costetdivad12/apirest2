package mx.edu.iebem.api2.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;
import mx.edu.iebem.api2.models.Promedios;
@Repository
public interface Promedios_repositories {
    public List<Promedios> ListPromedios();
}
