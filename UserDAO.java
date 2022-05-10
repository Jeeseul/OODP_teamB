public abstract class UserDAO{
    abstract public String getName();
    abstract public String getID();
    abstract public String getPassword();
    abstract public String getType();
    abstract public String getLogincheck();

    abstract public int login();
    abstract public int logout();
    abstract public String toString();
}   