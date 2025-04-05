package org.Nize.Controller;

import org.Nize.Mod.Direccion;
import org.Nize.Mod.DireccionDAO;

import java.util.List;

public class DireccionController {

    private DireccionDAO direccionDAO;

    public DireccionController(){
        direccionDAO = new DireccionDAO();
    }


    public void insertarDireccion(Direccion direccion){
        direccionDAO.insertarDireccion(direccion);
    }

    public List<Direccion> obtenerDirecciones(){
        return direccionDAO.listarDirecciones();
    }

    public boolean eliminarDireccion(int id){
        return direccionDAO.eliminarDireccion(id);
    }

    public Direccion obtenerDireccion(int id){
        return direccionDAO.obtenerDireccionPorId(id);
    }
}
