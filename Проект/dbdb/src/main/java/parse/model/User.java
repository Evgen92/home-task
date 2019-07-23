package parse.model;

public class User
{
    private int id;
    private String login;
    private String password;
    private String name;
    private String gender;
    private String message;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    public static class Builder {

        private User user;

        public Builder() {
            user = new User();
        }

        public Builder id(int id){
            user.id = id;
            return this;
        }

        public Builder login(String login){
            user.login = login;
            return this;
        }

        public Builder password(String password){
            user.password = password;
            return this;
        }

        public Builder name(String name){
            user.name = name;
            return this;
        }

        public Builder gender(String gender){
            user.gender = gender;
            return this;
        }

        public Builder message(String message){
            user.message = message;
            return this;
        }

        public User build(){
            return user;
        }

    }
}
