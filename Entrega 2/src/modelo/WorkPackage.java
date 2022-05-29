package modelo;

import java.util.ArrayList;

public class WorkPackage {

	private boolean isRoot; // Defines if a work package is a root of an project (Only can have one)
	private ArrayList<Task> tasks; // Contains all tasks to a work package, if a work package have tasks,can't have childs (WorkPackage).
	private WorkPackage parent; // Contains the parent of a WorkPackage, if a workpackage are a root, can't have parent.
	private ArrayList<WorkPackage> childs; // Contains the childs of a WorkPackage, if a workpackage have tasks, can't have childs.
	private boolean haveTaks; // Check if a work package has tasks. True: it has tasks, False: it does not have tasks.
	private String name;  //  Workpackage Name .
	private String description; // Workpackage Description. 
	
	/*
	 * 
	 */
	
}
