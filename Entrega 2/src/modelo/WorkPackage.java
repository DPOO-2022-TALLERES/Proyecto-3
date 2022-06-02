package modelo;

import java.util.ArrayList;

public class WorkPackage {

	private boolean isRoot; // Defines if a work package is a root of an project (Only can have one)
	private ArrayList<Task> tasks = new ArrayList<Task>(); // Contains all tasks to a work package, if a work package have tasks,can't have childs (WorkPackage).
	private WorkPackage parent; // Contains the parent of a WorkPackage, if a workpackage are a root, can't have parent.
	private ArrayList<WorkPackage> childs = new ArrayList<WorkPackage>(); // Contains the childs of a WorkPackage, if a workpackage have tasks, can't have childs.
	private boolean haveTaks = false; // Check if a work package has tasks. True: it has tasks, False: it does not have tasks.
	private String name;  //  Workpackage Name .
	private String description; // Workpackage Description. 
	private Proyecto project; // Project to contains the WorkPackage
	private boolean haveWorkPackages = false;
	
	/*
	 * Constructor of a root WorkPackage
	 */
	public WorkPackage( String name, String description, boolean isRoot, Proyecto project) {
		this.name = name;
		this.description= description;
		this.isRoot = isRoot; 
		this.project = project;
	}
	
	/*
	 * Constructor of a WorkPackage who is not a root. And inmediatly add that like child to his parent.
	 */
	public void addChildWorkPackage(WorkPackage parent, String name, String description) {
		WorkPackage child = new WorkPackage(name, description, false, this.project);
		child.setParent(parent); // Set parent of a child
		parent.addChildtoParent(child); // Add child to parent, that is added in the ArrayList
		this.project.addWorkPackage(child);
		this.haveWorkPackages = true;
	}
	
	/*
	 * Sets the parent of a WorkPackage
	 */
	public void setParent(WorkPackage parent) {
		this.parent = parent;
	}
	
	/*
	 * Adds a child to a parent, that add this in the ArrayList of the parent. 
	 */
	public void addChildtoParent(WorkPackage child) {
		this.childs.add(child);
	}
	
	/*
	 * Adds a task to a WorkPackage
	 */
	public void addTasktoWorkPackage(Task task){
		this.haveTaks = true; // Set the boolean true because the WorkPackage have tasks.
		this.tasks.add(task); // Add the task to the ArrayList of this WorkPackage.
	}
	
	/*
	 * Sets project to WorkPackage
	 */
	public void setProject(Proyecto project) {
		this.project = project;
	}
	
	public boolean haveTasks() {
		return this.haveTaks;
	}
	
	public String getName() {
		return this.name;
	}
	
	public boolean haveWorkPackages() {
		return this.haveWorkPackages;
	}
}
