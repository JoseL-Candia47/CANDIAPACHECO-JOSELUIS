package dao;

import model.odontologo;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import java.sql.*;
import java.util.List;

public class OdontologoDaoH2 implements iDao<odontologo>{

    private static final Logger logger= Logger.getLogger(OdontologoDaoH2.class);

    private static final String SQL_INSERT="INSERT INTO ODONTOLOGO (MATRICULA, NOMBRE, APELLIDO) VALUES(?,?,?)";


    public odontologo guardar(odontologo odontologo) {
        logger.info("inicando la operacion de guardado");
        Connection connection=null;
        try{
            connection= BD.getConnection();
            PreparedStatement psInsert= connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            psInsert.setInt(1, odontologo.getNumeroMatricula());
            psInsert.setString(2, odontologo.getNombre());
            psInsert.setString(3, odontologo.getApellido());
            ResultSet rs= psInsert.getGeneratedKeys();
        }catch (Exception e){
            logger.warn(e.getMessage());
        }
        return odontologo;
    }

    @Override
    public List<odontologo> buscarTodos() {
        return List.of();
    }
}
