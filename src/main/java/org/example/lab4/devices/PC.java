package org.example.lab4.devices;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

final public class PC extends Device {
    private final String mouse;
    private final String keyboard;

    public PC(PCBuilder pcB)
    {
        super(pcB);
        this.keyboard = pcB.keyboard;
        this.mouse = pcB.mouse;
    }

    public String getMouse() {
        return mouse;
    }

    public String getKeyboard() {
        return keyboard;
    }

    @Override
    public String toString() {
        return "PC{" +
                "mouse='" + mouse + '\'' +
                ", keyboard='" + keyboard + '\'' +
                ", ram=" + ram +
                ", memoryType=" + memoryType +
                ", cpu=" + cpu +
                ", gpu=" + gpu +
                ", hardDrive=" + hardDrive +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PC)) return false;
        if (!super.equals(o)) return false;
        PC pc = (PC) o;
        return mouse.equals(pc.mouse) && keyboard.equals(pc.keyboard);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), mouse, keyboard);
    }

    final static public class PCBuilder extends DeviceBuilder
    {
        @NotNull
        private String mouse;
        @NotNull
        private String keyboard;

        public PCBuilder setMouse(String mouse)
        {
            this.mouse = mouse;
            return this;
        }

        public PCBuilder setKeyboard(String keyboard)
        {
            this.keyboard = keyboard;
            return this;
        }

        @Override
        public Device build()
        {
            Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
            Set<ConstraintViolation<PCBuilder>> constraintViolations = validator.validate(this);
            if(!constraintViolations.isEmpty()) {
                String errors = constraintViolations.stream().map(constraintViolation -> {
                    String fieldName = constraintViolation.getPropertyPath().toString().toUpperCase();
                    String message = constraintViolation.getMessage();
                    return String.join(" : ", fieldName, message);
                }).collect(Collectors.joining("\n"));
                throw new IllegalArgumentException(errors);
            }
            return new PC(this);
        }
    }
}