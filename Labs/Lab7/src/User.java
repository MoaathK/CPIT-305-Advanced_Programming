import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private String dateOfBirth;
    private String gender;
    private String nationality;
    public User(String name,String dateOfBirth,String gender,String nationality){
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.nationality = nationality;
    }
    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", gender='" + gender + '\'' +
                ", nationality='" + nationality + '\'' +
                '}';
    }
}
