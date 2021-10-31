package net.chriswareham.sy77;

/**
 * This class describes a Yamaha DX7 low frequency oscillator.
 */
public class Dx7LowFrequencyOscillator {
    /**
     * The speed (0 to 99).
     */
    private int speed;

    /**
     * The delay (0 to 99).
     */
    private int delay;

    /**
     * The pitch modulation depth (0 to 99).
     */
    private int pitchModulationDepth;

    /**
     * The amplitude modulation depth (0 to 99).
     */
    private int amplitudeModulationDepth;

    /**
     * The key sync.
     */
    private boolean keySync;

    /**
     * The wave (0 to 5).
     */
    private Dx7LowFrequencyOscillatorWave wave;

    /**
     * The pitch modulation sensitivity (0 to 7).
     */
    private int pitchModulationSensitivity;

    /**
     * Get the speed (0 to 99).
     *
     * @return the speed
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * Set the speed (0 to 99).
     *
     * @param speed the speed
     */
    public void setSpeed(final int speed) {
        this.speed = speed;
    }

    /**
     * Get the delay (0 to 99).
     *
     * @return the delay
     */
    public int getDelay() {
        return delay;
    }

    /**
     * Set the delay (0 to 99).
     *
     * @param delay the delay
     */
    public void setDelay(final int delay) {
        this.delay = delay;
    }

    /**
     * Get the pitch modulation depth (0 to 99).
     *
     * @return the pitch modulation depth
     */
    public int getPitchModulationDepth() {
        return pitchModulationDepth;
    }

    /**
     * Set the pitch modulation depth (0 to 99).
     *
     * @param pitchModulationDepth the pitch modulation depth
     */
    public void setPitchModulationDepth(final int pitchModulationDepth) {
        this.pitchModulationDepth = pitchModulationDepth;
    }

    /**
     * Get the amplitude modulation depth (0 to 99).
     *
     * @return the amplitude modulation depth
     */
    public int getAmplitudeModulationDepth() {
        return amplitudeModulationDepth;
    }

    /**
     * Set the amplitude modulation depth (0 to 99).
     *
     * @param amplitudeModulationDepth the amplitude modulation depth
     */
    public void setAmplitudeModulationDepth(final int amplitudeModulationDepth) {
        this.amplitudeModulationDepth = amplitudeModulationDepth;
    }

    /**
     * Get the key sync.
     *
     * @return the key sync
     */
    public boolean isKeySync() {
        return keySync;
    }

    /**
     * Set the key sync.
     *
     * @param keySync the key sync
     */
    public void setKeySync(final boolean keySync) {
        this.keySync = keySync;
    }

    /**
     * Get the wave (0 to 5).
     *
     * @return the wave
     */
    public Dx7LowFrequencyOscillatorWave getWave() {
        return wave;
    }

    /**
     * Set the wave (0 to 5).
     *
     * @param wave the wave
     */
    public void setWave(final Dx7LowFrequencyOscillatorWave wave) {
        this.wave = wave;
    }

    /**
     * Get the pitch modulation sensitivity (0 to 7).
     *
     * @return the pitch modulation sensitivity
     */
    public int getPitchModulationSensitivity() {
        return pitchModulationSensitivity;
    }

    /**
     * Set the pitch modulation sensitivity (0 to 7).
     *
     * @param pitchModulationSensitivity the pitch modulation sensitivity
     */
    public void setPitchModulationSensitivity(final int pitchModulationSensitivity) {
        this.pitchModulationSensitivity = pitchModulationSensitivity;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return String.format("wave %-13s speed %2d delay %2d PMD %2d PMS %2d AMD %2d key sync %-3s",
            wave,
            speed,
            delay,
            pitchModulationDepth,
            pitchModulationSensitivity,
            amplitudeModulationDepth,
            keySync ? "on" : "off");
    }
}
