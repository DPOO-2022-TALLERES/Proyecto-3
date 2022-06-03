package vista;

import java.util.ArrayList;
import java.util.List;

import modelo.Actividad;
import modelo.Participante;
import modelo.Proyecto;

public class prueba {	 
	  public static void main(String[] args) throws Exception {
		  //DEmMUESTRA QUE LAS GRAFICAS FUNCIONAN
		 Participante Nico = new Participante("Nicoastr@", "Nico");
		 
		List<Participante> ar = new ArrayList<Participante>();
		Actividad ds = new Actividad("Decir Hola", "hola", "holaholahola", Nico,"holaholahola","2022-05-22","Hola","40","Hola" );
		Nico.agregarActividad(ds);
		
		Participante Fede = new Participante("Nicoastr@", "Fede");
		
		Actividad dsr = new Actividad("Despedirse", "hola", "holaholahola", Fede,"holaholahola","2022-06-18","Hola","50","Hola" );
		Actividad dsr2 = new Actividad("Presentarse", "hola", "holaholahola", Fede,"holaholahola","2022-06-01","Hola","10","Hola" );
		Fede.agregarActividad(dsr2);
		Fede.agregarActividad(dsr);
		

		
		ar.add(Nico);
		ar.add(Fede);
		Proyecto Proy = new Proyecto("Nombre del Proyectoxd ", "Holose", "1990-10-10", "1990-10-12");
		Proy.agregarActividades(dsr2);
		Proy.agregarActividades(dsr);
		Proy.agregarActividades(dsr);
		Proy.agregarActividades(ds);
		
		Proy.agregarParticipante(Fede);
		Proy.agregarParticipante(Nico);
		
	    showReport xd =  new showReport();
	    xd.parMean(Proy.getParticipantes());
	    xd.PDatos(ar);
	    xd.ProyectStats(Proy);
	    xd.PercentDatos(ar);
	    xd.grapToGoalDate(Proy.getActividades());
	    
	    
	    
	    
	  }
		

}
