package modelo;

import java.util.ArrayList;

public class Proyecto 
{
	
	private String nombre;
	private String descripcion;
	private String fechaInicio;
	private String fechaFin;
	private ArrayList<Actividad> actividades = new ArrayList<Actividad>();
	private Participante participanteduenio; 
	private ArrayList<Participante> participantes = new ArrayList<Participante>();
	
	public Proyecto(String nombre, String descripcion, String fechaInicio, String fechaFin) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}
	
	public void setParticipanteDuenio(Participante participanteduenio) {
		this.participanteduenio = participanteduenio;
	}

	public void agregarParticipante(Participante participante) {
		if(!participantes.contains(participante))
		participantes.add(participante);
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

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

	public ArrayList<Actividad> getActividades() {
		return actividades;
	}

	public ArrayList<Participante> getParticipantes() {
		return participantes;
	}

	public void agregarActividades(Actividad actividad) {
		actividades.add(actividad);
	}

	public void setParticipantes(ArrayList<Participante> participantes) {
		this.participantes = participantes;
	}
	
	public String getNameParticipanteDuenio() {
		return this.participanteduenio.getNombre();
	}
	
	

}
