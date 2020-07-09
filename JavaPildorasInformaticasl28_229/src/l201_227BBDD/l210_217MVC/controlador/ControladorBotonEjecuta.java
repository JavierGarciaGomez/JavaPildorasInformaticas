package l201_227BBDD.l210_217MVC.controlador;

import l201_227BBDD.l210_217MVC.modelo.EjecutableConsultas;
import l201_227BBDD.l210_217MVC.vista.Marco_Aplicacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ControladorBotonEjecuta implements ActionListener {

    private Marco_Aplicacion marco_aplicacion;
    private EjecutableConsultas ejecutableConsultas = new EjecutableConsultas();
    private ResultSet resultSet;

    public ControladorBotonEjecuta(Marco_Aplicacion marco_aplicacion) {
        this.marco_aplicacion = marco_aplicacion;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            marco_aplicacion.resultado.setText("");
            String seleccionSeccion = (String) marco_aplicacion.secciones.getSelectedItem();
            String seleccionPais = (String) marco_aplicacion.paises.getSelectedItem();
            resultSet = ejecutableConsultas.filtraBBDD(seleccionSeccion, seleccionPais);
            while (resultSet.next()) {
                marco_aplicacion.resultado.append(resultSet.getString(1)+" "+resultSet.getString(2)+
                        " "+resultSet.getString(3)+" "+resultSet.getString(4));
                marco_aplicacion.resultado.append("\n");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
}
