package group.abeberodas.demo;

import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Lists {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String listName;
    private String address;
    private String state;
    private String city;

    public String getWifi() {
        return wifi;
    }

    public void setWifi(String wifi) {
        this.wifi = wifi;
    }

    public String getCable() {
        return cable;
    }

    public void setCable(String cable) {
        this.cable = cable;
    }

    public String getRules() {
        return rules;
    }

    public Lists(String listName, String address, String state, String city, int price, String wifi, String cable, String rules, String description, boolean isRented, String bathrooms) {
        this.listName = listName;
        this.address = address;
        this.state = state;
        this.city = city;
        this.price = price;
        this.wifi = wifi;
        this.cable = cable;
        this.rules = rules;
        this.description = description;
        this.isRented = isRented;
        this.bathrooms = bathrooms;
    }

    public void setRules(String rules) {
        this.rules = rules;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private int price;
    private String wifi;
    private String cable;
    private String rules;
    private String description;
    public boolean isRented;

    public String getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(String bathrooms) {
        this.bathrooms = bathrooms;
    }

    private String bathrooms;

    public Lists() {
        this.isRented = false;
        this.bathrooms="no";
        this.wifi="no";
    }




    public long getId() {
        return id;
    }

    public String getListName() {
        return listName;
    }

    public String getAddress() {
        return address;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public int getPrice() {
        return price;
    }

    public boolean isRented() {
        return isRented;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setRented(boolean rented) {
        isRented = rented;
    }
}
