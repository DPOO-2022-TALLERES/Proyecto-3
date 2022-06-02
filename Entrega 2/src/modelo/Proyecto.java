package modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Proyecto 
{
	
	private String nombre;
	private String descripcion;
	private String fechaInicio;
	private String fechaFin;
	private ArrayList<Actividad> actividades = new ArrayList<Actividad>();
	private Participante participanteduenio; 
	private ArrayList<Participante> participantes = new ArrayList<Participante>();
	
	//WBS
	private WorkPackage rootWBS;
	private HashMap<String,ArrayList<Task>> typeoftasks = new HashMap<String,ArrayList<Task>>();
	private ArrayList<Task> tasks = new ArrayList<Task>();
	private ArrayList<WorkPackage> workpackages = new ArrayList<WorkPackage>();
	
	public Proyecto(String nombre, String descripcion, String fechaInicio, String fechaFin) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		
		// WBS
		WorkPackage rootWBSa = new WorkPackage(nombre + "-WBS", "This is root of  WBS of " + nombre, true, this);
		this.rootWBS = rootWBSa;
		rootWBSa.setProject(this);
		this.workpackages.add(rootWBSa);
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
	
	
	//WBS
	
	public void addTaskTipe(String type) {
		Set<String> llaves = this.typeoftasks.keySet();
		if (!llaves.contains(type)){
			ArrayList<Task> llave = new ArrayList<Task>();
			typeoftasks.put(type, llave);
		}
	}
	
	public void addTask(Task task, String type) {
		this.typeoftasks.get(type).add(task);
		this.tasks.add(task);
	}
	
	public void addWorkPackage(WorkPackage wp) {
		this.workpackages.add(wp);
	}
	
	public String[] giveOptionsWorkPackage() {
		String [] options;
		ArrayList<WorkPackage> optionsArray = new ArrayList<>();
		for (WorkPackage i : this.workpackages) {
			if (!i.haveTasks()) {
				optionsArray.add(i);
			}
		}
		options = new String[optionsArray.size()];
		int iterator = 0;
		for (WorkPackage j : optionsArray) {
			options[iterator] = j.getName();
			iterator++;
		}
		return options;
	}
	
	public String[] giveOptionsTasks() {
		String [] options;
		ArrayList<WorkPackage> optionsArray = new ArrayList<>();
		for (WorkPackage i : this.workpackages) {
			if (!i.haveWorkPackages()) {
				optionsArray.add(i);
			}
		}
		options = new String[optionsArray.size()];
		int iterator = 0;
		for (WorkPackage j : optionsArray) {
			options[iterator] = j.getName();
			iterator++;
		}
		return options;
	}

	public WorkPackage getWorkPackage(String name) {
		WorkPackage returns = null;
		for (WorkPackage wp : this.workpackages) {
			if(name.equals(wp.getName())) {
				returns = wp;
			}
		}
		return returns;
	}

	public Task getTask(String name) {
		Task returns = null; 
		for (Task tk : this.tasks) {
			if(name.equals(tk.getName())) {
				returns = tk;
			}
		}
		return returns;
	}
	
}
