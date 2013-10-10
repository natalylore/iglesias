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
    private String direccion;
    private String descripcion;
    private String historia;
    private String horarioVisitas;
    private String horarioMisas;
    private String leyendas;
    private Punto punto;
    private Estilo estilo;
    private Festividades festividades;

    public Iglesia() {
    }

    public Iglesia(int idIglesia, String nombre, String direccion, String descripcion, String historia, String horarioVisitas, String horarioMisas, String leyendas, Punto punto, Estilo estilo, Festividades festividades) {
        this.idIglesia = idIglesia;
        this.nombre = nombre;
        this.direccion = direccion;
        this.descripcion = descripcion;
        this.historia = historia;
        this.horarioVisitas = horarioVisitas;
        this.horarioMisas = horarioMisas;
        this.leyendas = leyendas;
        this.punto = punto;
        this.estilo = estilo;
        this.festividades = festividades;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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

    public Punto getPunto() {
        return punto;
    }

    public void setPunto(Punto punto) {
        this.punto = punto;
    }

    public Estilo getEstilo() {
        return estilo;
    }

    public void setEstilo(Estilo estilo) {
        this.estilo = estilo;
    }

    public Festividades getFestividades() {
        return festividades;
    }

    public void setFestividades(Festividades festividades) {
        this.festividades = festividades;
    } 
}
