public class AdminUser extends UserDAO{
    private String name;
    private String ID;
    private String password;
    private int type;
    private int logincheck;
    //private AddTaskDAO addtaskdao;

    public AdminUser(String name, String id, String password, int type) {
        this.name = name;
        this.ID = id;
        this.password = password;
        this.type = type;
        this.logincheck = 0;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getID() {
        return ID;
    }
    public void setID(String ID){
        this.ID = ID;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getType() {
        return Integer.toString(type);
    }
    public void setType(int type){
        this.type = type;
    }
    public String getLogincheck() {
        return Integer.toString(logincheck);
    }
    public void setLogincheck(int logincheck){
        this.logincheck = logincheck;
    }

    public int login(){
        this.logincheck = 1;
        return 1; //success
    }

    public int logout(){
        this.logincheck = 0;
        return 1; //success
    }

    public String toString(){
        return "id : " + this.ID + ", name : " + this.name
            + ", password : " + this.password + ", type : " + this.type;
    }
}