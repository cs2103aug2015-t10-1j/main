package logic;

import common.Task;
/*
 * Add class description
 */
public class AddCommand implements Command{
	private TaskHandler handler;
	private Task TaskRef;
	
	public AddCommand(TaskHandler handler,Task task){
		this.handler=handler;
		execute(task);
	}
	
	public void execute(Task task){	
		handler.addTask(task);
		TaskRef=task;
		Display.showFeedBack(task.getName()+" is added");
	}
	
	
	public void undo(){
		handler.deleteTask(TaskRef);
	}
	
	public void redo(){
		handler.addTask(TaskRef);
	}
}
