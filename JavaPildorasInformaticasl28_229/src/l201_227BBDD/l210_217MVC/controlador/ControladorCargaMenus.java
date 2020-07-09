package l201_227BBDD.l210_217MVC.controlador;

import l201_227BBDD.l210_217MVC.modelo.CargadorMenus;
import l201_227BBDD.l210_217MVC.vista.Marco_Aplicacion;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

public class ControladorCargaMenus extends WindowAdapter {
    private CargadorMenus cargadorMenus = new CargadorMenus();
    private Marco_Aplicacion marco_aplicacion;

    public ControladorCargaMenus(Marco_Aplicacion marco_aplicacion){
        this.marco_aplicacion=marco_aplicacion;
    }

    @Override
    public void windowOpened(WindowEvent e) {
        cargadorMenus.ejecutaConsultas();

        try {
            while(cargadorMenus.resultSet.next()){
                marco_aplicacion.secciones.addItem(cargadorMenus.resultSet.getString(1));
            }
            while(cargadorMenus.resultSet2.next()){
                marco_aplicacion.paises.addItem(cargadorMenus.resultSet2.getString(1));
            }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
    }
}
