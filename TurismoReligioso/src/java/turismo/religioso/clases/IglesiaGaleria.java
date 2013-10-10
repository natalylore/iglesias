/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turismo.religioso.clases;

/**
 *
 * @author Checho
 */
public class IglesiaGaleria {
    private Iglesia iglesia;
    private Galeria galeria;

    public IglesiaGaleria() {
    }

    public IglesiaGaleria(Iglesia iglesia, Galeria galeria) {
        this.iglesia = iglesia;
        this.galeria = galeria;
    }

    public Iglesia getIglesia() {
        return iglesia;
    }

    public void setIglesia(Iglesia iglesia) {
        this.iglesia = iglesia;
    }

    public Galeria getGaleria() {
        return galeria;
    }

    public void setGaleria(Galeria galeria) {
        this.galeria = galeria;
    }
    
}
