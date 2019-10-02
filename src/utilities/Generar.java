package utilities;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.Categoria;
import model.Pelicula;

public class Generar {
	public static Pelicula generarPelicula(ResultSet rs) {
        Pelicula p = null;
        try {
            if(Categoria.ANIMACION.toString().equalsIgnoreCase(rs.getString("categoria"))) {
                p = new Pelicula(rs.getString("nombre"),rs.getInt("agnoEstreno"),Categoria.ANIMACION);
            }else if(Categoria.AVENTURA.toString().equalsIgnoreCase(rs.getString("categoria"))) {
                p = new Pelicula(rs.getString("nombre"),rs.getInt("agnoEstreno"),Categoria.AVENTURA);
            }else if(Categoria.COMEDIA.toString().equalsIgnoreCase(rs.getString("categoria"))) {
                p = new Pelicula(rs.getString("nombre"),rs.getInt("agnoEstreno"),Categoria.COMEDIA);
            }else if(Categoria.POLICIACA.toString().equalsIgnoreCase(rs.getString("categoria"))) {
                p = new Pelicula(rs.getString("nombre"),rs.getInt("agnoEstreno"),Categoria.POLICIACA);
            }else if(Categoria.ROMANTICA.toString().equalsIgnoreCase(rs.getString("categoria"))) {
                p = new Pelicula(rs.getString("nombre"),rs.getInt("agnoEstreno"),Categoria.ROMANTICA);
            }else{
                p = new Pelicula(rs.getString("nombre"),rs.getInt("agnoEstreno"),Categoria.THRILLER);
        }
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            return p;
        }
    }
}
