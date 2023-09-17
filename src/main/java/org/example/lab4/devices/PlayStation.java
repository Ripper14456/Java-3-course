package org.example.lab4.devices;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;


final public class PlayStation extends Device {
    public enum PlayStationType
    {
        PS1, PS2, PS3, PS4, PS5, None
    }
    @NotNull
    private PlayStationType type;

    public PlayStation(PSBuilder psBuilder) {
        super(psBuilder);
        this.type = psBuilder.type;
    }

    public PlayStationType getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PlayStation)) return false;
        if (!super.equals(o)) return false;
        PlayStation ps5 = (PlayStation) o;
        return type == ps5.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), type);
    }

    @Override
    public String toString() {
        return  "PS5{" +
                "type=" + type +
                ", ram=" + ram +
                ", memoryType=" + memoryType +
                ", cpu=" + cpu +
                ", gpu=" + gpu +
                ", hardDrive=" + hardDrive +
                '}';
    }

    final static public class PSBuilder extends Device.DeviceBuilder
    {
        private PlayStationType type = PlayStationType.None;

        public PSBuilder setType(PlayStationType type) {
            this.type = type;
            return this;
        }

        public PSBuilder()
        {
            super();
        }
        public PlayStation build()
        {
            Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
            Set<ConstraintViolation<PlayStation.PSBuilder>> constraintViolations = validator.validate(this);
            if(constraintViolations.size() > 0) {
                String errors = constraintViolations.stream().map(constraintViolation -> {
                    String fieldName = constraintViolation.getPropertyPath().toString().toUpperCase();
                    String message = constraintViolation.getMessage();
                    return String.join(" : ", fieldName, message);
                }).collect(Collectors.joining("\n"));
                throw new IllegalArgumentException(errors);
            }
            return new PlayStation(this);
        }
    }
}
