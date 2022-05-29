package modelo;

import java.util.ArrayList;
import java.util.HashMap;

public class Participante 

{
	
private String correo;
private String nombre;
private int tiempotrabajado = 0;
private int tiempopromedioxactividad= 0;
private int tiempoxdia= 0;
private ArrayList<Actividad> actividades = new ArrayList<Actividad>();
private ArrayList<String> diastrabajados = new ArrayList<String>();

public String getCorreo() 
{
	return correo;
}

public void setCorreo(String correo) 
{
	this.correo = correo;
}

public String getNombre() 
{
	return this.nombre;
}

public void setNombre(String nombre) 
{
	this.nombre = nombre;
}


public Participante(String correo, String nombre) {
	super();
	this.correo = correo;
	this.nombre = nombre;
}

public void agregarActividad(Actividad actividad) {
	actividades.add(actividad);
}

public HashMap mostrarActividades() {
	HashMap<String,Actividad> hashmap = new HashMap<String,Actividad>();
	int iteracion = 1;
	for (Actividad actividad : actividades) {
		hashmap.put(String.valueOf(iteracion), actividad);
		iteracion = ++iteracion;
	}
	return hashmap;
}

public String setgetTiempoTrabajado() {
	this.tiempotrabajado = 0;
	for (Actividad actividad : actividades) {
		this.tiempotrabajado = Integer.parseInt(actividad.getMinutos()) + tiempotrabajado;
		String fecharealizado = actividad.getFechaRealizado().substring(0,10);
		if (!diastrabajados.contains(fecharealizado)) {
			diastrabajados.add(fecharealizado);
		}
	}
	return String.valueOf(this.tiempotrabajado);
}

public String setgetTiempoPromedioxActividad() {
	this.tiempopromedioxactividad = tiempotrabajado / actividades.size();
	return String.valueOf(tiempopromedioxactividad);
}

public String setgetTiempoxDia() {
	this.tiempoxdia = this.tiempotrabajado / diastrabajados.size();
	return String.valueOf(tiempoxdia);
}
}
