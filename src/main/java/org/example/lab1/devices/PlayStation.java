package org.example.lab1.devices;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import java.util.Objects;


/**
 * The type Play station.
 */
final public class PlayStation extends Device {
    /**
     * The enum Play station type.
     */
    public enum PlayStationType
    {
        PS1, PS2, PS3, PS4, PS5, None
    }
    @JsonUnwrapped
    private PlayStationType type;

    /**
     * Instantiates a new Play station.
     *
     * @param psBuilder the ps builder
     */
    public PlayStation(PSBuilder psBuilder) {
        super(psBuilder);
        this.type = psBuilder.type;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
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

    /**
     * The type Ps builder.
     */
    final static public class PSBuilder extends Device.DeviceBuilder
    {
        private PlayStationType type = PlayStationType.None;

        /**
         * Sets type.
         *
         * @param type the type
         * @return the type
         */
        public PSBuilder setType(PlayStationType type) {
            this.type = type;
            return this;
        }

        /**
         * Instantiates a new Ps builder.
         */
        public PSBuilder()
        {
            super();
        }
        public PlayStation build()
        {
            return new PlayStation(this);
        }
    }
}
