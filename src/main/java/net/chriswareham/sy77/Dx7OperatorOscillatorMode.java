package net.chriswareham.sy77;

/**
 * This enumeration describes the DX7 operator oscillator modes.
 */
public enum Dx7OperatorOscillatorMode {
    /**
     * The ratio operator oscillator mode.
     */
    RATIO("Ratio"),
    /**
     * The fixed operator oscillator mode.
     */
    FIXED("Fixed");

    /**
     * The description.
     */
    private final String description;

    /**
     * Construct an enumeration value.
     *
     * @param description the description
     */
    Dx7OperatorOscillatorMode(final String description) {
        this.description = description;
    }

    /**
     * Get the description.
     *
     * @return the description
     */
    @Override
    public String toString() {
        return description;
    }
}
