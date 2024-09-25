
package modelo.pojo;

/**
 *
 * @author lizet
 */
public class Promocion {
    private int id_promocion;
    private String nombre;
    private String descripcion;
    private byte[] imagen;
    private String fecha_inicio;
    private String fecha_termino;
    private String restricciones;
    private String tipo;
    private float descuento;
    private int categoria_id;
    private int numero_cupones;
    private byte estatus;
    private int empresa_id;
    private String codigo_promocion;

    public Promocion() {
    }

    public Promocion(int id_promocion, String nombre, String descripcion, byte[] imagen, String fecha_inicio, String fecha_termino, String restricciones, String tipo, float descuento, int categoria_id, int numero_cupones, byte estatus, int empresa_id, String codigo_promocion) {
        this.id_promocion = id_promocion;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.fecha_inicio = fecha_inicio;
        this.fecha_termino = fecha_termino;
        this.restricciones = restricciones;
        this.tipo = tipo;
        this.descuento = descuento;
        this.categoria_id = categoria_id;
        this.numero_cupones = numero_cupones;
        this.estatus = estatus;
        this.empresa_id = empresa_id;
        this.codigo_promocion = codigo_promocion;
    }

    public int getId_promocion() {
        return id_promocion;
    }

    public void setId_promocion(int id_promocion) {
        this.id_promocion = id_promocion;
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

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getFecha_termino() {
        return fecha_termino;
    }

    public void setFecha_termino(String fecha_termino) {
        this.fecha_termino = fecha_termino;
    }

    public String getRestricciones() {
        return restricciones;
    }

    public void setRestricciones(String restricciones) {
        this.restricciones = restricciones;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public float getDescuento() {
        return descuento;
    }

    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }

    public int getCategoria_id() {
        return categoria_id;
    }

    public void setCategoria_id(int categoria_id) {
        this.categoria_id = categoria_id;
    }

    public int getNumero_cupones() {
        return numero_cupones;
    }

    public void setNumero_cupones(int numero_cupones) {
        this.numero_cupones = numero_cupones;
    }

    public byte getEstatus() {
        return estatus;
    }

    public void setEstatus(byte estatus) {
        this.estatus = estatus;
    }

    public int getEmpresa_id() {
        return empresa_id;
    }

    public void setEmpresa_id(int empresa_id) {
        this.empresa_id = empresa_id;
    }

    public String getCodigo_promocion() {
        return codigo_promocion;
    }

    public void setCodigo_promocion(String codigo_promocion) {
        this.codigo_promocion = codigo_promocion;
    }
    
    
    
    
    
}
