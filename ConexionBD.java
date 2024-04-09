import java.sql.*;

public class ConexionBD {
    Connection conexion = null;
    PreparedStatement consulta = null;
    ResultSet resultado = null;
    String url = "jdbc:mysql://localhost:3306/";
    String username = "root";
    String password = "Gelatina12345";
    
    public void setConexion()
    {
        try
        {
            this.conexion = DriverManager.getConnection(url, username, password);
        }
        catch(SQLException error)
        {
            error.printStackTrace();
        }
    }
    
    public void setConsulta(String consulta)
    {
        try
        {
            this.consulta = conexion.prepareStatement(consulta);
        }
        catch(SQLException error)
        {
            error.printStackTrace();
        }
    }
    
    public ResultSet getResultado()
    {
        try
        {
            return consulta.executeQuery();
        }
        catch(SQLException error)
        {
            error.printStackTrace();
            return null;
        }
    }
    
    public PreparedStatement getConsulta()
    {
        return consulta;
    }
    
    public void cerrarConexion()
    {
        //Cerramos y limpiamos los resultados
        if(resultado != null)
        {
            try
            {
                resultado.close();
            }
            catch(SQLException error)
            {
                error.printStackTrace();
            }
        }
        //Cerramos y limpiamos las consultas
        if(consulta != null)
        {
            try
            {
                consulta.close();
            }
            catch(SQLException error)
            {
                error.printStackTrace();
            }
        }
        //Cerramos y limpiamos la conexión
        if(conexion != null)
        {
            try
            {
                conexion.close();
            }
            catch(SQLException error)
            {
                error.printStackTrace();
            }
        }
    }
}
