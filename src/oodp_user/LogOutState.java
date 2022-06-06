package oodp_user;

public class LogOutState implements LogState{
    @Override
    public void login() {
        System.out.println("start log in...\n");
    }
    @Override
    public void logout() {
        System.out.println("already log out\n");
    }
}