package oodp_user;

public class AttandState implements TagState{
    public static AttandState attandstate = new AttandState();
    AttandState() {}

    public static AttandState getInstance() {
        return attandstate;
    }

    public void on_attand_pushed(UserDAO user){
        System.out.println("already attand");
    }
    public void on_absent_pushed(UserDAO user){
        System.out.println("start absent");
        user.setState(AbsentState.getInstance());
    }
}