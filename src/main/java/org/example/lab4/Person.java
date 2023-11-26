package org.example.lab4;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;
import java.util.Set;

public class Person implements Comparable<Person> {
    private String firstName;
    private String secondName;
    private LocalDate dateOfBirth;
    private Residence residence;

    public Person(String firstName, String secondName, LocalDate dateOfBirth, Residence residence) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.dateOfBirth = dateOfBirth;
        this.residence = residence;
    }

    public Person(Person.PersonBuilder pb) {
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

    public int getDaysFromBirth() {
        return (int) ChronoUnit.DAYS.between(this.dateOfBirth, LocalDate.now());
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
                ", date of birth=" + dateOfBirth +
                ", residence=" + residence +
                '}';
    }

    @Override
    public int compareTo(Person obj) {
        return (int) ChronoUnit.DAYS.between(this.dateOfBirth, obj.dateOfBirth);
    }

    public static class PersonBuilder {
        @NotEmpty
        public String firstName;
        @NotEmpty
        public String secondName;
        @Past
        @NotNull
        public LocalDate dateOfBirth;

        @NotNull
        public Residence residence;

        public Person.PersonBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Person.PersonBuilder setSecondName(String secondName) {
            this.secondName = secondName;
            return this;
        }

        public Person.PersonBuilder setDateOfBirth(LocalDate dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public Person.PersonBuilder setResidence(Residence residence) {
            this.residence = residence;
            return this;
        }

        public Person build() {
            Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
            Set<ConstraintViolation<Person.PersonBuilder>> constraintViolations = validator.validate(this);
            StringBuilder exceptions = new StringBuilder("\n");
            for (ConstraintViolation constraintViolation : constraintViolations) {
                String fieldName = constraintViolation.getPropertyPath().toString().toUpperCase();
                exceptions.append(fieldName).append(" ").append(constraintViolation.getMessage()).append("\n");
            }
            if (constraintViolations.size() > 0) throw new IllegalArgumentException(String.valueOf(exceptions));
            return new Person(this);
        }
    }
}