package modelo;

import java.util.ArrayList;

public class Task {
	private String name; // Name Task
	private String description; // Description Task
	private String type; // Type of task
	private int expectedTime; // Expected time of a task
	private String expectedFinishDate; // Expected finish date of a task
	private ArrayList<Participante> participants; // Responsibles
	private ArrayList<Actividad> activities; // Activities
	private boolean isFinished; // Check if a task have finished yet. 
	private int finalTime; // Time of a task
	private String finalFinishDate; // Finish date of a task
	private WorkPackage parent; // Parent of a Task
}

