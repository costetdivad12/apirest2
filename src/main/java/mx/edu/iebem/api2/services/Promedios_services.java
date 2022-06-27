package mx.edu.iebem.api2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import mx.edu.iebem.api2.mapper.Promedios_mapper;
import mx.edu.iebem.api2.models.Promedios;
import mx.edu.iebem.api2.repositories.Promedios_repositories;
@Service
public class Promedios_services implements Promedios_repositories {
    @Autowired
    private JdbcTemplate jdbc;

    @Autowired private Promedios_mapper mapper;
    
    @Override
    public List<Promedios> ListPromedios() {
        final String sql ="select top 100a.CV_CCT , b.CURP,CONCAT (b.NOMBRE,' ',b.AP_PATERNO,' ',b.AP_MATERNO) as NOMBRE_FULL, PROMEDIO_NIVEL,folio_sep , sello_estatal,sello_sep,fecha_sep from TPromediosFinales a inner join TAlumnos b on a.IDALUMNO=b.IDALUMNO  where CV_CICLOESCOLAR=3 and folio_sep is not null";
        // curp_mapper mapper =new curp_mapper();
        // jdbc.query(sql, mapper, new Object[]{});
        List<Promedios> lista = jdbc.query(sql, mapper);
       
        return lista;
    }
    
}
