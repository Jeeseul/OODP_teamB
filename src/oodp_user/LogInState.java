package oodp_user;

public class LogInState implements LogState{
    @Override
    public void login() {
        System.out.println("already log in\n");
    }
    @Override
    public void logout() {
        System.out.println("start log out...\n");
    }
}
