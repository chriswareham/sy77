package net.chriswareham.sy77;

/**
 * This enumeration describes the DX7 low frequency oscillator waves.
 */
public enum Dx7LowFrequencyOscillatorWave {
    /**
     * The triangle low frequency oscillator wave.
     */
    TRIANGLE("Triangle"),
    /**
     * The downward sloping saw tooth low frequency oscillator wave.
     */
    SAW_DOWN("Saw Down"),
    /**
     * The upward sloping saw tooth low frequency oscillator wave.
     */
    SAW_UP("Saw Up"),
    /**
     * The square low frequency oscillator wave.
     */
    SQUARE("Square"),
    /**
     * The sine low frequency oscillator wave.
     */
    SINE("Sine"),
    /**
     * The sample and hold low frequency oscillator wave.
     */
    SAMPLE_HOLD("Sample & Hold");

    /**
     * The description.
     */
    private final String description;

    /**
     * Construct an enumeration value.
     *
     * @param description the description
     */
    Dx7LowFrequencyOscillatorWave(final String description) {
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
