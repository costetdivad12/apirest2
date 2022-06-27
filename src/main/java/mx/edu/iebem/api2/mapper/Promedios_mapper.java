package mx.edu.iebem.api2.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import mx.edu.iebem.api2.models.Promedios;

@Component
public class Promedios_mapper implements RowMapper<Promedios> {
    @Override
    public Promedios mapRow(ResultSet arg0, int arg1) throws SQLException {

        Promedios promedios = new Promedios();
        promedios.setCT(arg0.getString(1));
        promedios.setCurp(arg0.getString(2));
        promedios.setNombre_full(arg0.getString(3));
        promedios.setPROMEDIO_NIVEL(arg0.getDouble(4));
        promedios.setFolio_sep(arg0.getString(5));
        promedios.setSelo_estatal(arg0.getString(6));
        promedios.setSello_sep(arg0.getString(7));
        promedios.setFecha_sep(arg0.getString(8));
        return promedios;
    }
}
