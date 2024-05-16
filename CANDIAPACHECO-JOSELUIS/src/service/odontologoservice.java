import dao.BD;
import model.odontologo;
import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;
import service.OdontologoService;

import java.util.List;

public class OdontologoTestService {
    @Test
    public void buscarUnPaciente(){
        BD.crearTablas();
        OdontologoService odontologoService= new OdontologoService();
        Integer busqueda= 1;
        Odontologo odontologo= OdontologoService.buscarPaciente(busqueda);
        Assertions.assertTrue(Odontologo!=null);
    }
}