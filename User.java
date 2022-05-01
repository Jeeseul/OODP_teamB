public class User {
    private String name;
    private String id;
    private String password;
    private int type; //0=normal, 1=admin
    private int logincheck; //0=logout, 1=login

    public String getName() {
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getId() {
        return id;
    }
    public void setId(String id){
        this.id = id;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public int getType() {
        return type;
    }
    public void setType(int type){
        this.type = type;
    }
    public int getLogincheck() {
        return logincheck;
    }
    public void setLogincheck(int logincheck) {
        this.logincheck = logincheck;
    }

    public String toString() {
        String typestring = "";
        if(type == 1)typestring = "admin";
        else typestring = "normaluser";
        return "[" +name+ "] : "+ id + " , " + password + " , " + typestring + "\n";
    }

    public User(String name, String id, String password, int type) {
        this.name = name;
        this.id = id;
        this.password = password;
        this.type = type;
        this.logincheck = 0;
    }

    public void login(){
        this.setLogincheck(1);
    }
    public void logout(){
        this.setLogincheck(0);
    }
}
