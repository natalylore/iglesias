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
    private int punto;
    private int estilo;
    
    public Iglesia() {
    }

    public Iglesia(int idIglesia, String nombre, String direccion, String descripcion, String historia, String horarioVisitas, String horarioMisas, String leyendas, int punto, int estilo) {
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

    public int getPunto() {
        return punto;
    }

    public void setPunto(int punto) {
        this.punto = punto;
    }

    public int getEstilo() {
        return estilo;
    }

    public void setEstilo(int estilo) {
        this.estilo = estilo;
    }

    public void setLeyendas(String leyendas) {
        this.leyendas = leyendas;
    }
 

    @Override
    public String toString() {
        return "Iglesia{" + "idIglesia=" + idIglesia + ", nombre=" + nombre + ", direccion=" + direccion + ", descripcion=" + descripcion + ", historia=" + historia + ", horarioVisitas=" + horarioVisitas + ", horarioMisas=" + horarioMisas + ", leyendas=" + leyendas + ", punto=" + punto + ", estilo=" + estilo + '}';
    }

 }
