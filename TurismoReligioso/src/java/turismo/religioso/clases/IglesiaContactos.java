/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turismo.religioso.clases;

/**
 *
 * @author Fmla Jimenez
 */
public class IglesiaContactos {
    private int iglesia;
    private int contacto;

    public IglesiaContactos() {
    }

    public IglesiaContactos(int iglesia, int contacto) {
        this.iglesia = iglesia;
        this.contacto = contacto;
    }

    public int getIglesia() {
        return iglesia;
    }

    public void setIglesia(int iglesia) {
        this.iglesia = iglesia;
    }

    public int getContacto() {
        return contacto;
    }

    public void setContacto(int contacto) {
        this.contacto = contacto;
    }

    
}
