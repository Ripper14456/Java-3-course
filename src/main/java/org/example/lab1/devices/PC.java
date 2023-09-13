package org.example.lab1.devices;

import java.util.Objects;

/**
 * The type Pc.
 */
final public class PC extends Device {
    private final String mouse;
    private final String keyboard;

    /**
     * Instantiates a new Pc.
     *
     * @param pcB the pc b
     */
    public PC(PCBuilder pcB)
        {
            super(pcB);
            this.keyboard = pcB.keyboard;
            this.mouse = pcB.mouse;
    }

    /**
     * Gets mouse.
     *
     * @return the mouse
     */
    public String getMouse() {
        return mouse;
    }

    /**
     * Gets keyboard.
     *
     * @return the keyboard
     */
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

    /**
     * The type Pc builder.
     */
    final static public class PCBuilder extends DeviceBuilder
    {
        private String mouse;
        private String keyboard;

        /**
         * Sets mouse.
         *
         * @param mouse the mouse
         * @return the mouse
         */
        public PCBuilder setMouse(String mouse)
        {
            this.mouse = mouse;
            return this;
        }

        /**
         * Sets keyboard.
         *
         * @param keyboard the keyboard
         * @return the keyboard
         */
        public PCBuilder setKeyboard(String keyboard)
        {
            this.keyboard = keyboard;
            return this;
        }


        @Override
        public Device build() {
            return new PC(this);
        }
    }
}