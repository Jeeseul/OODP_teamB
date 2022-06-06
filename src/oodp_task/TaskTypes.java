package oodp_task;

public enum TaskTypes {
	//4 types of task
	DEVELOP, RESEARCH, DESIGN, FEEDBACK;
	
	public static TaskTypes setTypeByNum(int num) {
		TaskTypes typ;
		switch(num) {
			case 1: typ = TaskTypes.DEVELOP; break;
			case 2: typ = TaskTypes.RESEARCH; break;
			case 3: typ = TaskTypes.DESIGN; break;
			case 4: typ = TaskTypes.FEEDBACK; break;
			default: typ = null; break;
		}
		return typ;
	}
}
