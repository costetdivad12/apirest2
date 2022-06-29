package mx.edu.iebem.api2.repositories;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import mx.edu.iebem.api2.models.Promedios;
import mx.edu.iebem.api2.models.leerXML;
@Repository
public interface Promedios_repositories {
    // public List<Promedios> ListPromedios();

    public Promedios guardar (Promedios datos);
    public String actualizar (int datos,String ruta);
    public void guardarXML (MultipartFile multipartFile) throws IOException;

    public leerXML getidalumno(String curp);
}
