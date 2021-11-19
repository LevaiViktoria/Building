package hu.validation.domain;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

@Entity
public class Building {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "dateofbuild")
    @Past(message = "The date of build must be in the past")
    private Date dateOfBuild;
    @Size(min = 5, message = "The length of address is to short")
    private String address;
    @AssertTrue(message = "The building must be rentable")
    private boolean rentable;
    @Min(value = 10, message = "Price must be at least 10$")
    @Max(value=100, message = "Price must be at the most 100$")
    private double price;

    public Building() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateOfBuild() {
        return dateOfBuild;
    }

    public void setDateOfBuild(Date dateOfBuild) {
        this.dateOfBuild = dateOfBuild;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isRentable() {
        return rentable;
    }

    public void setRentable(boolean rentable) {
        this.rentable = rentable;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Building{" +
                "id=" + id +
                ", dateOfBuild=" + dateOfBuild +
                ", address='" + address + '\'' +
                ", rentable=" + rentable +
                ", price=" + price +
                '}';
    }
}

