package org.example.lab3;

import java.util.Objects;

public class Residence {
    public String country;
    public String city;
    public String address;

    public Residence(String country, String city, String address) {
        this.country = country;
        this.city = city;
        this.address = address;
    }

    public Residence(){}

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Residence)) return false;
        Residence residence = (Residence) o;
        return Objects.equals(country, residence.country) && Objects.equals(city, residence.city) && Objects.equals(address, residence.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, city, address);
    }

    @Override
    public String toString() {
        return "Residence{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

}