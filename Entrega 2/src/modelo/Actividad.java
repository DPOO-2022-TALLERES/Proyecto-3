package modelo;

public class Actividad 
{
private String titulo;
private String descripcion;
private String fechaRealizado;
private Participante participante;
private String horaInicio;
private String horaFin;
private String tipoActividad;
private String minutos;
private String nombreguardar;

public String getnombreguardar() {
	return this.nombreguardar;
}

public String getTitulo() 
{
	return titulo;
}

public void setTitulo(String titulo) 
{
	this.titulo = titulo;
}

public String getDescripcion() 
{
	return descripcion;
}

public void setDescripcion(String descripcion) 
{
	this.descripcion = descripcion;
}

public String getFechaRealizado() 
{
	return fechaRealizado;
}

public void setFechaRealizado(String fechaRealizado) 
{
	this.fechaRealizado = fechaRealizado;
}

public Participante getParticipante() 
{
	return participante;
}

public void setParticipante(Participante participante) 
{
	this.participante = participante;
}

public String getHoraInicio() 
{
	return horaInicio;
}

public void setHoraInicio(String horaInicio) 
{
	this.horaInicio = horaInicio;
}

public String getHoraFin() 
{
	return horaFin;
}

public void setHoraFin(String horaFin) 
{
	this.horaFin = horaFin;
}

public Actividad(String titulo, String descripcion, String fechaRealizado, Participante participante,String horaInicio, String horaFin, String tipoActividad, String minutos, String nombreguardar) 
{
	super();
	this.titulo = titulo;
	this.descripcion = descripcion;
	this.fechaRealizado = fechaRealizado;
	this.participante = participante;
	this.horaInicio = horaInicio;
	this.horaFin = horaFin;
	this.tipoActividad = tipoActividad;
	this.minutos = minutos;
	this.nombreguardar = nombreguardar;
}

public String getMinutos() {
	return minutos;
}

public void setMinutos(String minutos) {
	this.minutos = minutos;
}

public String getTipo() {
	return this.tipoActividad;
}

public void setNombreGuardar(String name) {
	this.nombreguardar = name;
}
}
