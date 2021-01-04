package com.company;
import java.util.Objects;

public class Clubs {
    private String name;
    private String city;
    private int foundationDate;

    Clubs(){

    }
    Clubs(Clubs club){
        this.name = club.name;
        this.city = club.city;
        this.foundationDate = club.foundationDate;
    }

    Clubs(String _name, String _city, int _date){
        name = _name;
        city = _city;
        foundationDate = _date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFoundationDate() {
        return foundationDate;
    }

    public void setFoundationDate(int foundationDate) {
        this.foundationDate = foundationDate;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Clubs{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", foundationDate=" + foundationDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clubs that = (Clubs) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
