package dao;

import java.sql.Connection;
import org.apache.log4j.Logger;
import java.sql.DriverManager;
import java.sql.Statement;

public class BD {
    private static final Logger logger= Logger.getLogger(BD.class);
    private static final String SQL_DROP_CREATE_ODONTOLOGO="DROP TABLE IF EXISTS ODONTOLOGOS; " +
            "CREATE TABLE ODONTOLOGO (MATRICULA INT NOT NULL, NOMBRE VARCHAR(100) NOT NULL, APELLIDO VARCHAR(100) NOT NULL) ";
    private static final String SQL_PRUEBA="INSERT INTO ODONTOLOGOS (MATRICULA,NOMBRE,APELLIDO) VALUES('205045','JOSE LUIS','CANDIA PACHECO'),('205045','DEAN','WINCHESTER'); ";

    public static void crearTablas(){
        Connection connection= null;
        try{
            connection= getConnection();
            Statement statement= connection.createStatement();
            statement.execute(SQL_DROP_CREATE_ODONTOLOGO);
            statement.execute(SQL_PRUEBA);
            logger.info("tabla creada con exito");

        }catch (Exception e){
            logger.warn(e.getMessage());
        }

    }
    public static Connection getConnection() throws Exception{
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/CANDIAPACHECO-JOSELUIS","sa","sa");
    }
}
