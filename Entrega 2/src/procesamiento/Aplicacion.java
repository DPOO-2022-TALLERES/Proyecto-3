package procesamiento;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Observable;

import modelo.Actividad;
import modelo.Participante;
import modelo.Proyecto;

public class Aplicacion extends Observable{
	
	private HashMap<String, Proyecto> proyectos = new HashMap<String, Proyecto>();
	private HashMap<String,Participante> participantes = new HashMap<String,Participante>();
	private HashMap<String, Actividad> actividades = new HashMap<String, Actividad>();
	private HashMap<String, ArrayList> tiposActividades = new HashMap<String,ArrayList>();
	private Participante participanteactivo;
	private Proyecto proyectoelegido;
	
	

public void agregarProyecto(Proyecto proyecto, String nombre) {
	proyectos.put(nombre, proyecto);
}

public void agregarParticipante(Participante participante, String nombre) {
	participantes.put(nombre, participante);
}

public Participante getParticipante(String name) {
	Participante participante = participantes.get(name);
	return participante;
}

public void agregarActividad(Actividad actividad, String nombre) {
	actividades.put(nombre,actividad);
}

public int verificarParticipante(String nombre) {
	//Retorna 1 si lo contiene, 0 si no.
	int respuesta;
	if (participantes.containsKey(nombre)){
		respuesta = 1;
		
	}else {
		respuesta = 0;
	}
	return respuesta;
}

public boolean verificarProyecto(String nombre) {
	// Retorna true si está disponible, false si no lo esta.
	boolean respuesta = true;
	if (proyectos.containsKey(nombre))
		respuesta = false;
	return respuesta;
}

public void elegirParticipante(String nombre) {
	participanteactivo = getParticipante(nombre);
	this.notificar();
}

private Proyecto getProyecto(String name) {
	return proyectos.get(name);
}

public void elegirProyecto(String nombre) {
	this.proyectoelegido = getProyecto(nombre);
	this.notificar();
}

public boolean verificarParticipanteActivo() {
	boolean respuesta;
	if (participanteactivo == null)
		respuesta = true;
	else
		respuesta = false;
	return respuesta;
	
}

public void crearProyecto(String nombre, String descripcion, String fechaInicio, String fechaFin) {
	Proyecto proyectonuevo = new Proyecto(nombre, descripcion, fechaInicio, fechaFin);
	proyectonuevo.setParticipanteDuenio(this.participanteactivo);
	agregarProyecto(proyectonuevo, nombre);
	this.proyectoelegido = proyectonuevo;
	proyectonuevo.agregarParticipante(participanteactivo);
}

public boolean verificarProyectoActivo() {
	boolean respuesta;
	// Retorna true si está vacio, false si está ocupado
	if (this.proyectoelegido == null)
		respuesta = true;
	else
		respuesta = false;
	return respuesta;
}

public Participante crearParticipante(String correo, String nombre) {
	Participante participantenuevo = new Participante(correo, nombre);
	this.participanteactivo = participantenuevo;
	participantes.put(nombre, participantenuevo);
	notificar();
	return participantenuevo;
	
}

public void agregarParticipanteProyecto(){
	Participante participante = this.participanteactivo;
	proyectoelegido.agregarParticipante(participante);
}

public void crearActividad(String titulo, String descripcion, String fechaRealizado,String horaInicio, String horaFin, String tipoActividad){
	//public Actividad(String titulo, String descripcion, String fechaRealizado, Participante participante,String horaInicio, String horaFin, String tipoActividad) 
}

public boolean verificarActividad(String nombre) {
	//Devuelve true si lo contiene, false si no
	if (actividades.containsKey(nombre))
		return true;
		else
			return false;
}

public Actividad getActividad(String name) {
	return actividades.get(name);
}

public ArrayList<Actividad> getTipoActividad(String name) {
	return tiposActividades.get(name);
}

public void agregarTipoActividad(String nombre, ArrayList array) {
	tiposActividades.put(nombre, array);
}

public HashMap mostrarActividades() {
	return  participanteactivo.mostrarActividades();
}

public void modificarActividad(Actividad actividad, String fecha,  String horaFin, String minutosTotales) {
	

		actividad.setFechaRealizado(fecha);
		String horaInicio = fecha.substring(11,19);
		actividad.setHoraInicio(horaInicio);
		actividad.setHoraFin(horaFin);
		actividad.setMinutos(minutosTotales);
		actividad.setNombreGuardar(actividad.getTitulo() + " de " + fecha);
}

public String[] informacionParticipante(String nombreparticipante) {
	Participante participante = getParticipante(nombreparticipante);
	String tiempotrabajado = participante.setgetTiempoTrabajado();
	String tiempoxactividad = participante.setgetTiempoPromedioxActividad();
	String tiempoxdia = participante.setgetTiempoxDia();
	String []respuesta = new String[]{tiempotrabajado,tiempoxactividad,tiempoxdia};
	return respuesta;
}

public ArrayList<Participante> mostrarParticipantesProyecto(String nameproyecto) {
	Proyecto proyecto = proyectos.get(nameproyecto);
	return proyecto.getParticipantes();
	
}

public HashMap<String,Proyecto> getProyectos() {
	return this.proyectos;
}

public HashMap<String,Actividad> getActividades() {
	return this.actividades;
}

public HashMap<String,Participante> getParticipantes() {
	return this.participantes;
}

public void crearActividad(String titulo, String descripcion, String fechaRealizado,String horaInicio, String horaFin, String tipoActividad, String minutos, String nombreguardar) {
	Participante participante = this.participanteactivo;
	Actividad nuevaactividad = new Actividad(titulo, descripcion,fechaRealizado, participante ,horaInicio,horaFin,tipoActividad,minutos,nombreguardar);
	agregarActividad(nuevaactividad, nombreguardar);
	System.out.println("Correcto agregar");
	this.proyectoelegido.agregarActividades(nuevaactividad);
	System.out.println("Correcto agregar proyecto");
	this.participanteactivo.agregarActividad(nuevaactividad);
	System.out.println("Correcto agregar participante");
}

public String getParticipanteActivo() {
	return this.participanteactivo.getNombre();
}

public String getProyectoActivo() {
	return this.proyectoelegido.getNombre();
}

public String[] optionsModify(){
	String[] returns;
	HashMap<Integer,Actividad> hashmap = mostrarActividades();
	Collection<Actividad> keys = hashmap.values();
	int size = keys.size();
	returns = new String [size];
	int i = 0;
	for(Actividad actividad : keys) {
		returns[i] = actividad.getnombreguardar();
		i++;
	}
	return returns;
}

private void notificar() {
	this.setChanged();
	this.notifyObservers(this);	
}










}