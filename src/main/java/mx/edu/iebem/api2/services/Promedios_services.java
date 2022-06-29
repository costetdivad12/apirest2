package mx.edu.iebem.api2.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import mx.edu.iebem.api2.mapper.Promedios_mapper;
import mx.edu.iebem.api2.mapper.idalumno_mapper;
import mx.edu.iebem.api2.models.Promedios;
import mx.edu.iebem.api2.models.leerXML;
import mx.edu.iebem.api2.repositories.Promedios_repositories;

@Service
public class Promedios_services implements Promedios_repositories {
    @Autowired
    private JdbcTemplate jdbc;

    @Autowired
    //  private Promedios_mapper mapper;
    
    private idalumno_mapper mapper;
     @Override
    //  public List<Promedios> ListPromedios() {
        //  final String sql = "select top 100a.CV_CCT , b.CURP,CONCAT (b.NOMBRE,' ',b.AP_PATERNO,' ',b.AP_MATERNO) as NOMBRE_FULL, PROMEDIO_NIVEL,folio_sep , sello_estatal,sello_sep,fecha_sep from TPromediosFinales a inner join TAlumnos b on a.IDALUMNO=b.IDALUMNO  where CV_CICLOESCOLAR=3 and folio_sep is not null";
        //  curp_mapper mapper =new curp_mapper();
        //   jdbc.query(sql, mapper, new Object[]{});
        //   List<Promedios> lista = jdbc.query(sql, mapper);

        //  return lista;
    //  }
    
    public leerXML getidalumno(String curp) {
        final String sql = "select top 1IDALUMNO from TAlumnos where CURP=?";
        // curp_mapper mapper =new curp_mapper();
        // jdbc.query(sql, mapper, new Object[]{});
        leerXML re= jdbc.queryForObject(sql, mapper ,new Object[]{curp});
        System.out.println(re);
        return re;
    }

    public Promedios guardar(Promedios datos) {
        final String sql = "insert into TPromediosFinales (CV_CCT,PROMEDIO_NIVEL,CV_CICLOESCOLAR,CV_NIVELEDUCATIVO,CV_TURNO,GRADO,GRUPO,IDALUMNO,PROMEDIO_TEXTO) values (?,?,?,?,?,?,?,?,?)";
        String mensaje = "";
        int insert = jdbc.update(sql, datos.getCT(), datos.getPROMEDIO_NIVEL(), 4, 12, 1, 6, "B", 1, "DIEZ");
        if (insert != 0) {
            mensaje = "Registro exitoso";
        } else {
            mensaje = "Error en el registro";
        }
        return datos;
    }

    @Override
    public String actualizar(int datos,String ruta) {
        final String sql = "update TPromediosFinales set ruta_xml=? where IDALUMNO=?";
        String mensaje="";
        int insert = jdbc.update(sql,ruta, datos);
        if (insert != 0) {
            mensaje = "Registro actualizado";
        } else {
            mensaje = "Error al actualizar";
        }
      return mensaje;
    }

    public void guardarXML(MultipartFile multipartFile) throws IOException {
        // final String uploadsPath="c:\\archivos";
        // File uploadsPath = new File("c:\\archivos");
        // File uploadsPathxml = new File("c:\\xml_2022");
        File uploadsPath = new File("/Users/josedavidcostetorihuela/Downloads/archivos");
        File uploadsPathxml = new File("/Users/josedavidcostetorihuela/Downloads/xml_2022");
        String fileName = multipartFile.getOriginalFilename();

        Path uploadPath = Paths.get(uploadsPath+ "/" + fileName);

        if (!uploadsPath.exists()) {

            uploadsPath.mkdir();
        }
        if (!uploadsPathxml.exists()) {

            uploadsPathxml.mkdir();

        }
        multipartFile.transferTo(uploadPath);

        // valida si existe el directorio
        if (uploadsPath.exists()) {
            // lista los archivos que hay dentro del directorio
            File[] ficheros = uploadsPath.listFiles();
            System.out.println("Número de ficheros encontrados: " + ficheros.length);
            
               
            
            
                // ciclo para recorrer todos los archivos .zip
                for (int i = 0; i < ficheros.length; i++) {
                    System.out.println("Nombre del fichero: " + ficheros[i].getName());
          
                    System.out.println("Descomprimiendo.....");
                    try {
                        // crea un buffer temporal para el archivo que se va descomprimir
                        ZipInputStream zis = new ZipInputStream(
                                new FileInputStream(uploadsPath + "/" + ficheros[i].getName()));

                        ZipEntry salida;
                        // recorre todo el buffer extrayendo uno a uno cada archivo.zip y creándolos de
                        // nuevo en su archivo original
                        while (null != (salida = zis.getNextEntry())) {
                            System.out.println("Nombre del Archivo: " + salida.getName());
                            FileOutputStream fos = new FileOutputStream(uploadsPathxml + "/" + salida.getName());
                            String  ruta =uploadsPathxml + "/" + salida.getName();
                            String curp=salida.getName().substring(0,salida.getName().length()-4);
                            leerXML id_alu =getidalumno(curp);
                            int id=id_alu.getId_alumno();
                            String dato = actualizar(id, ruta);
                            int leer;
                            byte[] buffer = new byte[1024];
                            while (0 < (leer = zis.read(buffer))) {
                                fos.write(buffer, 0, leer);
                            }
                            fos.close();
                            zis.closeEntry();
                        }

                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            
            System.out.println("Directorio de salida: " + uploadsPath);
        }

        // System.out.println("archivo zip ");
        // String dir = StringUtils.cleanPath(pathStamp);
        // String fileDirection = dir +
        // "/"+stampType+"/" +
        // foldername +
        // "/"+stampDir+"/" +
        // rfc +
        // ".xml";

        // Path dirPath =
        // Paths.get(fileDirection.substring(0,fileDirection.lastIndexOf("/")));

    }

}
