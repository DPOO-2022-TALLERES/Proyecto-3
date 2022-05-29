package procesamiento;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

import modelo.Actividad;
import modelo.Participante;
import modelo.Proyecto;



public class LoaderProyectos {
	
	private static String ruta = "Entrega 2/data/proyectos.csv";
	private static String rutaparticipantes = "Entrega 2/data/participantes.csv";
	private static String rutaactividades = "Entrega 2/data/actividades.csv";

	

public void cargarAplicacion(Aplicacion app){
		cargarParticipantes(app);
		cargarActividades(app);
		cargarProyectos(app);

}

private void cargarParticipantes(Aplicacion app) {
	try {
		// Empezamos a cargar los participantes 
					BufferedReader br = new BufferedReader(new FileReader(LoaderProyectos.rutaparticipantes));
					String linea;		
					while((linea=br.readLine())!=null) {
						String []datosparticipante = linea.split(",");
						String nombre = datosparticipante[0];
						String correo = datosparticipante[1];
						Participante participante = app.crearParticipante(correo, nombre);
						app.agregarParticipante(participante, nombre);
						app.elegirParticipante(null);
					}
					br.close();	
					// Aca se terminan de cargar los participantes
	} catch (Exception e) {
		// TODO: handle exception
	}
}

private void cargarActividades(Aplicacion app) {
	try {
		//Empezamos a cargar las actividades
		BufferedReader brac = new BufferedReader(new FileReader(LoaderProyectos.rutaactividades));
		String lineaa;
		while((lineaa=brac.readLine())!=null) {
		String []datosactividad = lineaa.split(",");
		String nombre = datosactividad[0];
		String descripcion = datosactividad[1];
		String fecha = datosactividad[2];
		String nombreparticipante = datosactividad[3];
		String horaInicio = datosactividad[4];
		String horaFin = datosactividad[5];
		String minutostotales = datosactividad[6];
		String tipoActividad = datosactividad[7]; 
		Participante participante = app.getParticipante(nombreparticipante);
		String nombreguardar = nombre + " de " + fecha;
		Actividad actividad = new Actividad(nombre, descripcion, fecha, participante, horaInicio, horaFin, tipoActividad, minutostotales, nombreguardar);
		app.agregarActividad(actividad, nombreguardar);
		participante.agregarActividad(actividad);
		//TipoActividad
		if(app.getTipoActividad(tipoActividad) == null) {
			ArrayList<Actividad> actividades = new ArrayList<Actividad>();
			actividades.add(actividad);
			app.agregarTipoActividad(nombreguardar, actividades);}
			else {
				ArrayList<Actividad> array = app.getTipoActividad(tipoActividad);
				array.add(actividad);
			}
		}
		brac.close();
		// Aca se terminan de cargar las actividades
	} catch (Exception e) {
		// TODO: handle exception
	}
}

private void cargarProyectos(Aplicacion app) {
	try {
		
		// Empezamos a cargar los proyectos
		BufferedReader brp = new BufferedReader(new FileReader(LoaderProyectos.ruta));
		
		String lineaproyectos = brp.readLine();
		String []proyectositerar = lineaproyectos.split(",");
		brp.close();
		// En la primera linea se conocen todos los nombres de los proyectos existentes

		//ACA SE EMPIEZAN A CARGAR LOS PROYECTOS UNO POR UNO
		for (String rutaproyecto: proyectositerar) {
			String rutaproyectostring = "Entrega 2/data/proyectos/" + rutaproyecto;
			BufferedReader brpr = new BufferedReader(new FileReader(rutaproyectostring));
			String lineap;

			lineap= brpr.readLine();
			// En la primera linea se conocen todos los nombres de las actividades existentes
			String []actividades = lineap.split(",");
			
			lineap = brpr.readLine();
			// En la segunda linea se conoce la informacion del proyecto en este orden: [0]Nombre; [1]Descripcion; [2]Fechainicio; [3]Fechafin.
			String []informacion = lineap.split(",");
			lineap= brpr.readLine();
			// En la tercera linea se conoce la informacion de el participante dueño. El nombre para buscarlo en el mapa creado
			String participanteduenio = lineap;
			
			lineap = brpr.readLine();
			// En la cuarta linea se encuentran todos los demas participantes. 
			String []participantes = lineap.split(",");
			brpr.close();
			
			//Creamos el proyecto
			Proyecto proyectoagregar = new Proyecto(informacion[0], informacion[1], informacion[2], informacion[3]);
			//Lo agregamos a la informacion de la aplicacion 
			app.agregarProyecto(proyectoagregar, informacion[0]);
			
			
			
			//Participante Duenio
			Participante participanteduenioo = app.getParticipante(participanteduenio);
			proyectoagregar.setParticipanteDuenio(participanteduenioo);
			
			// Se guardan los demas participantes
			for(String nameparticipante : participantes) {
				Participante participante = app.getParticipante(nameparticipante);
				proyectoagregar.agregarParticipante(participante);
			}
			
			// Actividades
			for (String actividad : actividades) {
				Actividad actividado = app.getActividad(actividad);
				proyectoagregar.agregarActividades(actividado);
			}	
		}
        }
	catch (Exception e) {
		// TODO: handle exception
	}
}

public void guardarAplicacion(Aplicacion app) {
	System.out.println("Entro");
	guardarProyectos(LoaderProyectos.ruta, app);
	guardarActividades(app);
	guardarParticipantes(app);
}

private void guardarProyectos(String ruta, Aplicacion app){
	try {
		//Se guardan los proyectos en general.
		PrintWriter pw = new PrintWriter(new FileWriter(ruta));
		HashMap<String,Proyecto> hashmap = app.getProyectos();
		Set<String> nombres = hashmap.keySet();
		String guardar = "";

		for (String nombre : nombres) {
			String agregar = nombre + ".csv";
			agregar = agregar.toLowerCase();
			agregar = agregar.replace(" ", "");
			guardar = guardar + agregar + ",";
		}
		guardar = guardar.substring(0,guardar.length()-1);
		pw.println(guardar);
		pw.close();		
		guardarProyectoIndividual(hashmap,app);

	} catch (Exception e) {
		// TODO: handle exception
	}	
}

private void guardarProyectoIndividual(HashMap<String, Proyecto> hashmap, Aplicacion app) {
	try {
		
		String rutaguardar = "Entrega 2/data/proyectos/";
		Collection<Proyecto> proyectos = hashmap.values();
		for(Proyecto proyecto : proyectos) {
			
			String nombre = proyecto.getNombre();
			String nombreguardar = nombre.replace(" ", "");
			nombreguardar = nombreguardar.toLowerCase();
			nombreguardar = nombreguardar + ".csv";
			
			PrintWriter pw = new PrintWriter(new FileWriter(rutaguardar + nombreguardar));
			
			// Se empiezan a guardar las actividades
			String actividadesguardar = "";
			try {
				ArrayList<Actividad> actividades = proyecto.getActividades();
				for (Actividad actividad : actividades) {
					String nameactividad = actividad.getnombreguardar();
					actividadesguardar = actividadesguardar + nameactividad + ",";	
				}
				actividadesguardar = actividadesguardar.substring(0, actividadesguardar.length() - 1);
			} catch (Exception e) {
				// TODO: handle exception
			}			
			// Se empieza a organizar la segunda línea a guardar informacion de proyecto
			String segundalinea;
			String descripcion = proyecto.getDescripcion();
			String fechaInicio = proyecto.getFechaInicio();
			String fechaFin = proyecto.getFechaFin();
			segundalinea= nombre + "," + descripcion + "," + fechaInicio + "," + fechaFin;
			 
			//Se guarda la informacion del participante duenio
			String nameparticipante = proyecto.getNameParticipanteDuenio();
			
			//Se guarda la informacion de todos los participantes
			ArrayList<Participante> participantes = proyecto.getParticipantes();
			String participantesguardar = "";
			for (Participante participante : participantes) {
				String nameparti = participante.getNombre();
				participantesguardar = participantesguardar + nameparti + ",";
			}
			participantesguardar = participantesguardar.substring(0, participantesguardar.length()-1);
			pw.println(actividadesguardar);
			pw.println(segundalinea);
			pw.println(nameparticipante);
			pw.println(participantesguardar);
			pw.close();
		}

	} catch (Exception e) {
		// TODO: handle exception
	}
		
	
}

private void guardarActividades(Aplicacion app) {
	try {
		PrintWriter pw = new PrintWriter(new FileWriter(rutaactividades));
		HashMap<String,Actividad> actividades = app.getActividades();
		Collection<Actividad> actividadesrecorrer = actividades.values();
		for (Actividad actividad : actividadesrecorrer) {
			String agregar = "";
			String nombre = actividad.getTitulo();
			String descripcion = actividad.getDescripcion();
			String fecha = actividad.getFechaRealizado();
			String participante = actividad.getParticipante().getNombre();
			String horaInicio = actividad.getHoraInicio();
			String horaFin = actividad.getHoraFin();
			String minutos = actividad.getMinutos();
			String tipo = actividad.getTipo();
			agregar = nombre + "," + descripcion + "," + fecha + "," + participante + "," + horaInicio + "," + horaFin + "," + minutos + "," + tipo;
			pw.println(agregar);

		}
		pw.close();
	} catch (Exception e) {
		// TODO: handle exception
	}

}

private void guardarParticipantes(Aplicacion app) {
	try {
		PrintWriter pw = new PrintWriter(new FileWriter(rutaparticipantes));
		HashMap<String,Participante> parti = app.getParticipantes();
		Collection<Participante> participantes = parti.values();
		for (Participante participante : participantes) {
			String linea = "";
			String nombre = participante.getNombre();
			String correo = participante.getCorreo();
			linea = nombre + "," + correo;
			pw.println(linea);

		}
		pw.close();
		
	} catch (Exception e) {
		// TODO: handle exception
	}
}
}


