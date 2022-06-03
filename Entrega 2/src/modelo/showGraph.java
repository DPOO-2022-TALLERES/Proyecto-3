package modelo;

import java.awt.Color;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;
import static java.time.temporal.ChronoUnit.DAYS;

import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.style.Styler.ChartTheme;



public class showGraph {
	public showGraph()
	{
		
	}
	private static final String SERIES_NAME = "Tareas Totales";
	 private static final String SERIES_NAME2 = "Tareas Hechas";


	 
	 public void PDatos(List<Participante> Participantes) {
		 ///MUESTRAN EL DESEMPENIO POR INTEGRANTE
		 
		 List<String> xData = new ArrayList<String>();
		 List<String> xdData = new ArrayList<String>();
		 List<Integer> yData = new ArrayList<Integer>();
		 List<Integer> ydData = new ArrayList<Integer>();
		 
		 ListIterator<Participante> it = Participantes.listIterator();
		 while (it.hasNext()) {
			 Participante temp = it.next();
			 String name = temp.getNombre();
			 int hechas = temp.mostrarActividades().size()+10;
			 
			 /// ACTUALIZAR CUANDO YA ESTE HECHA LA LISTA DE ACTIVIDADES HECHAS
			 int totales =  hechas +4;
			 
			 xData.add(name);
			 xdData.add(name);
			 yData.add(hechas);
			 ydData.add(totales);
			 
			 
		 }
			    // Create Chart
	    CategoryChart Chart = new CategoryChartBuilder()
	    	.xAxisTitle("Name")
	    	.yAxisTitle("Number of Tasks")
		    .width(500)
		    .height(400)
		    .theme(ChartTheme.Matlab)
		    .title("Progress per Member")
		    .build()
	    	;
	    Chart.getStyler().setAvailableSpaceFill(.56);
	    Chart.getStyler().setOverlapped(true);

	    Chart.addSeries(SERIES_NAME, xdData, ydData).setFillColor(new Color(255, 182, 193));
	    Chart.addSeries(SERIES_NAME2, xData, yData).setFillColor(new Color(143, 188, 143));
	    

			    
	    new SwingWrapper<CategoryChart>(Chart).displayChart();
	    
	  }
	 public void PercentDatos(List<Participante> Participantes) {

	
	//Muestra el porcentaje de los integrantes
		 
		 List<String> xData = new ArrayList<String>();
		 List<String> xdData = new ArrayList<String>();
		 List<Integer> yData = new ArrayList<Integer>();
		 List<Integer> ydData = new ArrayList<Integer>();
		 
		 ListIterator<Participante> it = Participantes.listIterator();
		 while (it.hasNext()) {
			 Participante temp = it.next();
			 String name = temp.getNombre();
			 
			 int hechas = temp.mostrarActividades().size();
			 
			 /// ACTUALIZAR CUANDO YA ESTE HECHA LA LISTA DE ACTIVIDADES HECHAS
			 int totales =  hechas+5 ;
			 hechas  = (hechas)*100/ totales;
			 
			 
			 xData.add(name);
			 xdData.add(name);
			 yData.add(hechas);
			 ydData.add(100);
			 
			 
		 }
			    // Create Chart
	    CategoryChart Chart = new CategoryChartBuilder()
	    	.xAxisTitle("Participant Name")
	    	.yAxisTitle("Finished Tasks")
		    .width(500)
		    .height(400)
		    .theme(ChartTheme.Matlab)
		    .title("Progress per Member (%)")
		    .build()
	    	;
	    Chart.getStyler().setAvailableSpaceFill(.56);
	    Chart.getStyler().setOverlapped(true);

	    Chart.addSeries(SERIES_NAME, xdData, ydData).setFillColor(new Color(255, 182, 193));
	    Chart.addSeries(SERIES_NAME2, xData, yData).setFillColor(new Color(143, 188, 143));
	    

			    
	    new SwingWrapper<CategoryChart>(Chart).displayChart();
	    
}
	 
	 public void ProyectStats(Proyecto Proy) {
		 List<String> xData = new CopyOnWriteArrayList<String>( Arrays.asList(new String[] {"Tiempo.", "Actividades"}));
		 List<Integer> yData = new ArrayList<Integer>();
		 List<Integer> iData = new ArrayList<Integer>();
		 
		 ArrayList<Task> tasks = Proy.getTasks() ;
		 String[] fechaIn = Proy.getFechaInicio().strip().split("-");
		 String[] fechaFin = Proy.getFechaFin().strip().split("-");
		 
		 int tiempoFinEst = calcularTiempoEstimado(fechaIn, fechaFin);
		 int totalesAct = tasks.size();
		 int tiempoTrans= calTiempoTras(tasks)*100/tiempoFinEst;
		 int hechasAct = getActividadesHechas(Proy)*100/totalesAct;
		 System.out.println(tiempoTrans + "   " + tiempoFinEst + "  "+ calTiempoTras(tasks));
		 
		 
		
		 iData.add(100);
		 yData.add(tiempoTrans);
		 iData.add(100);
		 yData.add(hechasAct);
		 
		 CategoryChart Chart = new CategoryChartBuilder()
			    	.xAxisTitle("Stat.")
			    	.yAxisTitle("Percentage of Progress.")
				    .width(500)
				    .height(400)
				    .theme(ChartTheme.Matlab)
				    .title("Stats. of " + Proy.getNombre())
				    .build()
			    	;

	    Chart.getStyler().setAvailableSpaceFill(0.56);
	    Chart.addSeries("Goal", xData, iData).setFillColor(new Color(255, 182, 193));
	    Chart.addSeries("Current Data", xData, yData).setFillColor(new Color(143, 188, 143));
	    
	    new SwingWrapper<CategoryChart>(Chart).displayChart();
	 }
	 
	 public void parMean(ArrayList<Participante> Participantes) {
		 List<String> xData = new ArrayList<String>();
		 List<Integer> yData = new ArrayList<Integer>();
	
		 
		 ListIterator<Participante> it = Participantes.listIterator();
		 while (it.hasNext()) {
			 Participante temp = it.next();
			 String name = temp.getNombre();
			 int hechas = Integer.parseInt(temp.setgetTiempoPromedioxActividad());
			 System.out.println(hechas);
			 System.out.println(name);
			 
			 xData.add(name);
			 yData.add(hechas);
			
			 
			 
		 }
			    // Create Chart
	    CategoryChart Chart = new CategoryChartBuilder()
	    	.xAxisTitle("Name")
	    	.yAxisTitle("Mean")
		    .width(500)
		    .height(400)
		    .theme(ChartTheme.GGPlot2)
		    .title("Participant.")
		    .build()
	    	;
	    Chart.getStyler().setAvailableSpaceFill(.56);
	    Chart.getStyler().setOverlapped(true);

	    Chart.addSeries("Activity time.", xData, yData).setFillColor(new Color(143, 188, 143));

	    

			    
	    new SwingWrapper<CategoryChart>(Chart).displayChart();
	 }
	 
	 public int calTiempoTras(ArrayList<Task> tasks) {
		 ListIterator<Task> lt = tasks.listIterator();
		 int cont  =0;
			 
		 while (lt.hasNext()) {
			 Task temp = lt.next();
			 cont += temp.getMinutos();
		 }
		return cont;
		 
		 
	 }
	 public int getActividadesHechas(Proyecto Proy)
	 
	 {
		 int cont = 0;
		 ListIterator<Participante> it = Proy.getParticipantes().listIterator();
		 while(it.hasNext()) {
			 Participante temp = it.next();
			 cont += temp.mostrarActividades().size();
			 
			 
		 }
		 return cont;
	 }
	 
	 public int calcularTiempoEstimado(String[] fechaIn, String[] fechaFin) {
		 int tiempoFin = (Integer.parseInt(fechaFin[0])-Integer.parseInt(fechaFin[0]))*60*24*365 +
				 (Integer.parseInt(fechaFin[1])*30*24*60) + (Integer.parseInt(fechaFin[2])*24*60); //Termina el calculo de la fecha final
		 int tiempoFinEst = tiempoFin	 - (Integer.parseInt(fechaIn[1])*30*24*60)  - (Integer.parseInt(fechaIn[2])*24*60)  ; //Resta el tiempo inicial
		 return tiempoFinEst;
	 }
	 
	 public void grapToGoalDate(ArrayList<Task> tasks) {
		 List<String> xData = new ArrayList<String>();
		 List<Integer> yData = new ArrayList<Integer>();
		 ListIterator<Task> it = tasks.listIterator();
		 
		 while (it.hasNext()) {
			 Task task = it.next();
			 String temp = task.getHoraFin();
			 String name = task.getName();
			 int time  = now_to_Fecha(temp);
			 xData.add(name);
			 yData.add(time);
			 
			 
		 }
		 CategoryChart Chart = new CategoryChartBuilder()
			    	.xAxisTitle("Task Name")
			    	.yAxisTitle("Remaining Days.")
				    .width(500)
				    .height(400)
				    .theme(ChartTheme.Matlab)
				    .title(".")
				    .build()
		    	;
		    Chart.getStyler().setAvailableSpaceFill(.56);
		    Chart.getStyler().setOverlapped(true);

		    Chart.addSeries("Activity time.", xData, yData).setFillColor(new Color(143, 188, 143));

		    new SwingWrapper<CategoryChart>(Chart).displayChart();
			   

	 }
	 
	 public int now_to_Fecha(String lim) {
		 
		 LocalDateTime fin = LocalDateTime.parse(lim +"T00:00:00");
		 
		 LocalDateTime current = LocalDateTime.now();
		 long min = DAYS.between(current, fin);
		 int minu =  (int)min;
		 return minu;
	 }

}
