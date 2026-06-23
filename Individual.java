/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospitalsystem;

/**
 *
 * @author aryam
 */
public abstract class Individual {
private final int Id;
    private String Name;
    private String Gender;

    
    public Individual(int ID, String name, String gender) {
        this.Id = ID;
        setName(name);
        this.Gender=gender;
    }

    public Individual() {
        this(0, "", "");
    }

    
    public int getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        this.Gender = gender;
    }

    @Override
    public String toString() {
        return String.format("Id: %d\nName: %s\nGender: %s", getId(), getName(), getGender());
    }
}
