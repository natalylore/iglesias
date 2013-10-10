/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turismo.religioso.clases;

/**
 *
 * @author Checho
 */
public class Iglesia {
    private int idIglesia;
    private String nombre;
    private String descripcion;
    private String historia;
    private String horarioVisitas;
    private String horarioMisas;
    private String leyendas;
    private Punto idPunto;
    private Estilo idEstilo;
    private Festividades idFestividades;

    public Iglesia() {
    }

    public Iglesia(int idIglesia, String nombre, String descripcion, String historia, String horarioVisitas, String horarioMisas, String leyendas, Punto idPunto, Estilo idEstilo, Festividades idFestividades) {
        this.idIglesia = idIglesia;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.historia = historia;
        this.horarioVisitas = horarioVisitas;
        this.horarioMisas = horarioMisas;
        this.leyendas = leyendas;
        this.idPunto = idPunto;
        this.idEstilo = idEstilo;
        this.idFestividades = idFestividades;
    }

    public int getIdIglesia() {
        return idIglesia;
    }

    public void setIdIglesia(int idIglesia) {
        this.idIglesia = idIglesia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getHistoria() {
        return historia;
    }

    public void setHistoria(String historia) {
        this.historia = historia;
    }

    public String getHorarioVisitas() {
        return horarioVisitas;
    }

    public void setHorarioVisitas(String horarioVisitas) {
        this.horarioVisitas = horarioVisitas;
    }

    public String getHorarioMisas() {
        return horarioMisas;
    }

    public void setHorarioMisas(String horarioMisas) {
        this.horarioMisas = horarioMisas;
    }

    public String getLeyendas() {
        return leyendas;
    }

    public void setLeyendas(String leyendas) {
        this.leyendas = leyendas;
    }

    public Punto getIdPunto() {
        return idPunto;
    }

    public void setIdPunto(Punto idPunto) {
        this.idPunto = idPunto;
    }

    public Estilo getIdEstilo() {
        return idEstilo;
    }

    public void setIdEstilo(Estilo idEstilo) {
        this.idEstilo = idEstilo;
    }

    public Festividades getIdFestividades() {
        return idFestividades;
    }

    public void setIdFestividades(Festividades idFestividades) {
        this.idFestividades = idFestividades;
    }
    
    
}
