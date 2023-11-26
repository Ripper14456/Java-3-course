package org.example.lab2.entities;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

public class Residence {
    public String country;
    public String city;
    public String address;

    public Residence(String country, String city, String address) {
        this.country = country;
        this.city = city;
        this.address = address;
    }
    public Residence(Residence.ResidenceBuilder rb) {
        this.country = rb.country;
        this.city = rb.city;
        this.address = rb.address;
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

    public static class ResidenceBuilder
    {
        public String country;
        public String city;
        public String address;

        public Residence.ResidenceBuilder setCountry(String country) {
            this.country = country;
            return this;
        }
        public Residence.ResidenceBuilder setCity(String city) {
            this.city = city;
            return this;
        }
        public Residence.ResidenceBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Residence build() {
            Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
            Set<ConstraintViolation<Residence.ResidenceBuilder>> constraintViolations = validator.validate(this);
            StringBuilder exceptions = new StringBuilder("\n");
            for(ConstraintViolation constraintViolation : constraintViolations) {
                String fieldName = constraintViolation.getPropertyPath().toString().toUpperCase();
                exceptions.append(fieldName).append(" ").append(constraintViolation.getMessage()).append("\n");
            }
            if(constraintViolations.size() > 0)throw new IllegalArgumentException(String.valueOf(exceptions));
            return new Residence(this);
        }
    }
}
