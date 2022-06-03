package modelo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Task {
	private String name; // Name Task 
	private String description; // Description Task
	private String type; // Type of task
	private int expectedTime; // Expected time of a task
	private String expectedFinishDate; // Expected finish date of a task
	private ArrayList<Participante> participants = new ArrayList<Participante>(); // Responsibles
	private ArrayList<Actividad> activities; // Activities
	private boolean isFinished = false; // Check if a task have finished yet. 
	private int finalTime; // Time of a task
	private String finalFinishDate; // Finish date of a task
	private WorkPackage parent; // Parent of a Task
	private Proyecto project; 

/*
 * Constructor of a task
 *
 */
	public Task(String name, String description, String type, Participante participant, Proyecto project) {
		this.name = name;
		this.description = description;
		this.type = type;
		this.participants.add(participant);
		this.project = project;
		this.project.addTaskTipe(type);
		this.project.addTask(this, type);
		participant.addTask(this);
	}
	
	/*
	 * Add the parent of a task
	 */
	public void setParent(WorkPackage parent) {
		this.parent = parent;
	}
	
	/*
	 * Set the expected time (minutes)
	 */
	public void setExpectedTime(int minutes) {
		this.expectedTime = minutes;
	}
	
	/*
	 * Set the expected finish date (yyyy-MM-dd)
	 */
	public void setExpectedFinishDate(String date) {
		this.expectedFinishDate = date;
	}
	
	/*
	 * Adds a participant into the participants ArrayList.
	 */
	public void addParticipant(Participante panticipant) {
		if (!this.participants.contains(panticipant)) {
			this.participants.add(panticipant);
			panticipant.addTask(this);
		}
	}
	
	/*
	 * Adds one activity to the Task's ArrayList
	 * If with an activity the task finish, that calculate 
	 */
	public void addActivity(Actividad activity, boolean isFinished) {
		this.activities.add(activity);
		this.isFinished = isFinished;
		if (isFinished == true) {
			   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			   String finishDate = dtf.format(LocalDateTime.now());
			   this.finalFinishDate = finishDate;
			   int finalTime = 0;
			   for (Actividad activityfor : activities) {
				   int minutosumar = Integer.parseInt(activityfor.getMinutos());
				   finalTime += minutosumar;
			   }
			   this.finalTime = finalTime;
			   this.project.addFinishTask(this);
		}
	}
	
	/*
	 *  Return the name of this task
	 */
	public String getName() {
		return this.name;
	}
	
	public boolean isFinished() {
		return this.isFinished;
	}
}

