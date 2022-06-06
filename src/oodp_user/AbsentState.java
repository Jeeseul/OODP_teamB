package oodp_user;

public class AbsentState implements TagState{
    public static AbsentState absentState = new AbsentState();
    private AbsentState() {}

    public static AbsentState getInstance() {
        return absentState;
    }

    public void on_attand_pushed(UserDAO user){
        System.out.println("start attand");
        user.setState(AttandState.getInstance());
    }
    public void on_absent_pushed(UserDAO user){
        System.out.println("already absent");
    }
}