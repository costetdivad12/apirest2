package mx.edu.iebem.api2.mapper;



import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import mx.edu.iebem.api2.models.leerXML;
@Component
public class idalumno_mapper implements RowMapper<leerXML> {
    @Override
    public leerXML mapRow(ResultSet arg0, int arg1) throws SQLException {

        leerXML xml = new leerXML();
        xml.setId_alumno(arg0.getInt("IDALUMNO"));
        
        return xml;
    }
}
