package oodp_collaborationApp;

public class TodoAppRunner 
{
	public static void toprintFrontPage() 
	{
		System.out.println("\n*** [OODP TeamB Collabration App] ***");
		System.out.println("Please Login to use App");
	    System.out.println("to login, press 1");
	    System.out.println("to quit App, press 0\n");
	}
	
	
	public static void toprintMainPage() 
	{
		System.out.println("\nWelcome!! - OODP TeamB Collaboration");
		System.out.println("\n*** [Manage Menu] ***");
	    System.out.println("to check notices, press 1");
	    System.out.println("to manage tasks, press 2");
	    System.out.println("to reserve meetingroom, press 3");
	    System.out.println("to logout, press 4");
	    System.out.println("to exit front page, press 0\n");
	}
	
	
	public static void toExitApp() 
	{
		System.out.println("Good bye!");
		System.exit(0);
	}
}
