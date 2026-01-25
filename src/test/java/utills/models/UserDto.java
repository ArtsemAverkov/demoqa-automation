package utills.models;

public class UserDto {
    public String name;
    public String email;
    public String currentAddress;
    public String permanentAddress;


    public UserDto(String name, String email, String currentAddress, String permanentAddress) {
        this.name = name;
        this.email = email;
        this.currentAddress = currentAddress;
        this.permanentAddress = permanentAddress;
    }
}

