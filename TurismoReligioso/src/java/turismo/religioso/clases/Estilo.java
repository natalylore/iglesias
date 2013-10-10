/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turismo.religioso.clases;

/**
 *
 * @author Fmla Jimenez
 */
public class Estilo {
    private int idEstilo;
    private String nombreEstilo;

    public Estilo() {
    }

    public Estilo(int idEstilo, String nombreEstilo) {
        this.idEstilo = idEstilo;
        this.nombreEstilo = nombreEstilo;
    }

    public int getIdEstilo() {
        return idEstilo;
    }

    public void setIdEstilo(int idEstilo) {
        this.idEstilo = idEstilo;
    }

    public String getNombreEstilo() {
        return nombreEstilo;
    }

    public void setNombreEstilo(String nombreEstilo) {
        this.nombreEstilo = nombreEstilo;
    }
    
}
