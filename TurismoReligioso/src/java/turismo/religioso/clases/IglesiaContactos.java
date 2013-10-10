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
    private Iglesia iglesia;
    private Contactos contacto;

    public IglesiaContactos() {
    }

    public IglesiaContactos(Iglesia iglesia, Contactos contacto) {
        this.iglesia = iglesia;
        this.contacto = contacto;
    }

    public Iglesia getIglesia() {
        return iglesia;
    }

    public void setIglesia(Iglesia iglesia) {
        this.iglesia = iglesia;
    }

    public Contactos getContacto() {
        return contacto;
    }

    public void setContacto(Contactos contacto) {
        this.contacto = contacto;
    }
    
    
}
