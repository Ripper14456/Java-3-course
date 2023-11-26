package org.example.lab2.entities;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

public class Person {
    public String firstName;
    public String secondName;
    @JsonSerialize(using = ToStringSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    public LocalDate dateOfBirth;
    @JsonUnwrapped
    public Residence residence;

    public Person() {}

    public Person(String firstName, String secondName, LocalDate dateOfBirth, Residence residence) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.dateOfBirth = dateOfBirth;
        this.residence = residence;
    }
    public Person(PersonBuilder pb) {
        this.firstName = pb.firstName;
        this.secondName = pb.secondName;
        this.dateOfBirth = pb.dateOfBirth;
        this.residence = pb.residence;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Residence getResidence() {
        return residence;
    }

    public void setResidence(Residence residence) {
        this.residence = residence;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return Objects.equals(dateOfBirth, person.dateOfBirth) &&
                Objects.equals(firstName, person.firstName) &&
                Objects.equals(secondName, person.secondName) &&
                Objects.equals(residence, person.residence);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, secondName, dateOfBirth, residence);
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", residence=" + residence +
                '}';
    }

    public static class PersonBuilder
    {
        public String firstName;
        public String secondName;
        public LocalDate dateOfBirth;
        public Residence residence;

        public PersonBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }
        public PersonBuilder setSecondName(String secondName) {
            this.secondName = secondName;
            return this;
        }
        public PersonBuilder setDateOfBirth(LocalDate dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }
        public PersonBuilder setResidence(Residence residence) {
            this.residence = residence;
            return this;
        }

        public Person build() {
            Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
            Set<ConstraintViolation<PersonBuilder>> constraintViolations = validator.validate(this);
            StringBuilder exceptions = new StringBuilder("\n");
            for(ConstraintViolation constraintViolation : constraintViolations) {
                String fieldName = constraintViolation.getPropertyPath().toString().toUpperCase();
                exceptions.append(fieldName).append(" ").append(constraintViolation.getMessage()).append("\n");
            }
            if(constraintViolations.size() > 0)throw new IllegalArgumentException(String.valueOf(exceptions));
            return new Person(this);
        }
    }
}
