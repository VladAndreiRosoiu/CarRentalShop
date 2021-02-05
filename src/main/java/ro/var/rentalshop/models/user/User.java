package ro.var.rentalshop.models.user;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class User {
    private int id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private LocalDate birthDate;
    private LocalDate registeredOn;
    private LocalDate deletedOn;
    private Address address;

    public User(int id, String firstName, String lastName, String username, String password, LocalDate birthDate, LocalDate registeredOn, LocalDate deletedOn, Address address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.birthDate = birthDate;
        this.registeredOn = registeredOn;
        this.deletedOn = deletedOn;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getRegisteredOn() {
        return registeredOn;
    }

    public void setRegisteredOn(LocalDate registeredOn) {
        this.registeredOn = registeredOn;
    }

    public LocalDate getDeletedOn() {
        return deletedOn;
    }

    public void setDeletedOn(LocalDate deletedOn) {
        this.deletedOn = deletedOn;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(username, user.username) && Objects.equals(password, user.password) && Objects.equals(birthDate, user.birthDate) && Objects.equals(registeredOn, user.registeredOn) && Objects.equals(deletedOn, user.deletedOn) && Objects.equals(address, user.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, username, password, birthDate, registeredOn, deletedOn, address);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", birthDate=" + birthDate +
                ", registeredOn=" + registeredOn +
                ", deletedOn=" + deletedOn +
                ", address=" + address +
                '}';
    }
}
