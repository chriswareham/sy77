package net.chriswareham.sy77;

/**
 * This class describes a Yamaha DX7 operator.
 */
public class Dx7Operator {
    /**
     * The envelope generator.
     */
    private final Dx7EnvelopeGenerator envelopeGenerator = new Dx7EnvelopeGenerator();

    /**
     * The keyboard level scaling break point (0 to 99).
     */
    private int keyboardLevelScalingBreakPoint;

    /**
     * The keyboard level scaling left depth (0 to 99).
     */
    private int keyboardLevelScalingLeftDepth;

    /**
     * The keyboard level scaling right depth (0 to 99).
     */
    private int keyboardLevelScalingRightDepth;

    /**
     * The keyboard level scaling left curve (0 to 3).
     */
    private Dx7KeyboardLevelScalingCurve keyboardLevelScalingLeftCurve;

    /**
     * The keyboard level scaling right curve (0 to 3).
     */
    private Dx7KeyboardLevelScalingCurve keyboardLevelScalingRightCurve;

    /**
     * The keyboard rate scaling (0 to 7).
     */
    private int keyboardRateScaling;

    /**
     * The amplitude modulator sensitivity (0 to 3).
     */
    private int amplitudeModulatorSensitivity;

    /**
     * The key velocity sensitivity (0 to 7).
     */
    private int keyVelocitySensitivity;

    /**
     * The output level (0 to 99).
     */
    private int outputLevel;

    /**
     * The oscillator mode (0 to 1).
     */
    private Dx7OperatorOscillatorMode oscillatorMode;

    /**
     * The oscillator frequency coarse (0 to 31).
     */
    private int oscillatorFrequencyCoarse;

    /**
     * The oscillator frequency fine (0 to 99).
     */
    private int oscillatorFrequencyFine;

    /**
     * The oscillator detune (0 to 14).
     */
    private int oscillatorDetune;

    /**
     * Get the envelope generator.
     *
     * @return the envelope generator
     */
    public Dx7EnvelopeGenerator getEnvelopeGenerator() {
        return envelopeGenerator;
    }

    /**
     * Get the keyboard level scaling break point (0 to 99).
     *
     * @return the keyboard level scaling break point
     */
    public int getKeyboardLevelScalingBreakPoint() {
        return keyboardLevelScalingBreakPoint;
    }

    /**
     * Set the keyboard level scaling break point (0 to 99).
     *
     * @param keyboardLevelScalingBreakPoint the keyboard level scaling break point
     */
    public void setKeyboardLevelScalingBreakPoint(final int keyboardLevelScalingBreakPoint) {
        this.keyboardLevelScalingBreakPoint = keyboardLevelScalingBreakPoint;
    }

    /**
     * Get the keyboard level scaling left depth (0 to 99).
     *
     * @return the keyboard level scaling left depth
     */
    public int getKeyboardLevelScalingLeftDepth() {
        return keyboardLevelScalingLeftDepth;
    }

    /**
     * Set the keyboard level scaling left depth (0 to 99).
     *
     * @param keyboardLevelScalingLeftDepth the keyboard level scaling left depth
     */
    public void setKeyboardLevelScalingLeftDepth(final int keyboardLevelScalingLeftDepth) {
        this.keyboardLevelScalingLeftDepth = keyboardLevelScalingLeftDepth;
    }

    /**
     * Get the keyboard level scaling right depth (0 to 99).
     *
     * @return the keyboard level scaling right depth
     */
    public int getKeyboardLevelScalingRightDepth() {
        return keyboardLevelScalingRightDepth;
    }

    /**
     * Set the keyboard level scaling right depth (0 to 99).
     *
     * @param keyboardLevelScalingRightDepth the keyboard level scaling right depth
     */
    public void setKeyboardLevelScalingRightDepth(final int keyboardLevelScalingRightDepth) {
        this.keyboardLevelScalingRightDepth = keyboardLevelScalingRightDepth;
    }

    /**
     * Get the keyboard level scaling left curve (0 to 3).
     *
     * @return the keyboard level scaling left curve
     */
    public Dx7KeyboardLevelScalingCurve getKeyboardLevelScalingLeftCurve() {
        return keyboardLevelScalingLeftCurve;
    }

    /**
     * Set the keyboard level scaling left curve (0 to 3).
     *
     * @param keyboardLevelScalingLeftCurve the keyboard level scaling left curve
     */
    public void setKeyboardLevelScalingLeftCurve(final Dx7KeyboardLevelScalingCurve keyboardLevelScalingLeftCurve) {
        this.keyboardLevelScalingLeftCurve = keyboardLevelScalingLeftCurve;
    }

    /**
     * Get the keyboard level scaling right curve (0 to 3).
     *
     * @return the keyboard level scaling right curve
     */
    public Dx7KeyboardLevelScalingCurve getKeyboardLevelScalingRightCurve() {
        return keyboardLevelScalingRightCurve;
    }

    /**
     * Set the keyboard level scaling right curve (0 to 3).
     *
     * @param keyboardLevelScalingRightCurve the keyboard level scaling right curve
     */
    public void setKeyboardLevelScalingRightCurve(final Dx7KeyboardLevelScalingCurve keyboardLevelScalingRightCurve) {
        this.keyboardLevelScalingRightCurve = keyboardLevelScalingRightCurve;
    }

    /**
     * Get the keyboard rate scaling (0 to 7).
     *
     * @return the keyboard rate scaling
     */
    public int getKeyboardRateScaling() {
        return keyboardRateScaling;
    }

    /**
     * Set the keyboard rate scaling (0 to 7).
     *
     * @param keyboardRateScaling the keyboard rate scaling
     */
    public void setKeyboardRateScaling(final int keyboardRateScaling) {
        this.keyboardRateScaling = keyboardRateScaling;
    }

    /**
     * Get the amplitude modulator sensitivity (0 to 3).
     *
     * @return the amplitude modulator sensitivity
     */
    public int getAmplitudeModulatorSensitivity() {
        return amplitudeModulatorSensitivity;
    }

    /**
     * Set the amplitude modulator sensitivity (0 to 3).
     *
     * @param amplitudeModulatorSensitivity the amplitude modulator sensitivity
     */
    public void setAmplitudeModulatorSensitivity(final int amplitudeModulatorSensitivity) {
        this.amplitudeModulatorSensitivity = amplitudeModulatorSensitivity;
    }

    /**
     * Get the key velocity sensitivity (0 to 7).
     *
     * @return the key velocity sensitivity
     */
    public int getKeyVelocitySensitivity() {
        return keyVelocitySensitivity;
    }

    /**
     * Set the key velocity sensitivity (0 to 7).
     *
     * @param keyVelocitySensitivity the key velocity sensitivity
     */
    public void setKeyVelocitySensitivity(final int keyVelocitySensitivity) {
        this.keyVelocitySensitivity = keyVelocitySensitivity;
    }

    /**
     * Get the output level (0 to 99).
     *
     * @return the output level
     */
    public int getOutputLevel() {
        return outputLevel;
    }

    /**
     * Set the output level (0 to 99).
     *
     * @param outputLevel the output level
     */
    public void setOutputLevel(final int outputLevel) {
        this.outputLevel = outputLevel;
    }

    /**
     * Get the oscillator mode (0 to 1).
     *
     * @return the oscillator mode
     */
    public Dx7OperatorOscillatorMode getOscillatorMode() {
        return oscillatorMode;
    }

    /**
     * Set the oscillator mode (0 to 1).
     *
     * @param oscillatorMode the oscillator mode
     */
    public void setOscillatorMode(final Dx7OperatorOscillatorMode oscillatorMode) {
        this.oscillatorMode = oscillatorMode;
    }

    /**
     * Get the oscillator frequency coarse (0 to 31).
     *
     * @return the oscillator frequency coarse
     */
    public int getOscillatorFrequencyCoarse() {
        return oscillatorFrequencyCoarse;
    }

    /**
     * Set the oscillator frequency coarse (0 to 31).
     *
     * @param oscillatorFrequencyCoarse the oscillator frequency coarse
     */
    public void setOscillatorFrequencyCoarse(final int oscillatorFrequencyCoarse) {
        this.oscillatorFrequencyCoarse = oscillatorFrequencyCoarse;
    }

    /**
     * Get the oscillator frequency fine (0 to 99).
     *
     * @return the oscillator frequency fine
     */
    public int getOscillatorFrequencyFine() {
        return oscillatorFrequencyFine;
    }

    /**
     * Set the oscillator frequency fine (0 to 9).
     *
     * @param oscillatorFrequencyFine the oscillator frequency fine
     */
    public void setOscillatorFrequencyFine(final int oscillatorFrequencyFine) {
        this.oscillatorFrequencyFine = oscillatorFrequencyFine;
    }

    /**
     * Get the oscillator detune (0 to 14).
     *
     * @return the oscillator detune
     */
    public int getOscillatorDetune() {
        return oscillatorDetune;
    }

    /**
     * Set the oscillator detune (0 to 14).
     *
     * @param oscillatorDetune the oscillator detune
     */
    public void setOscillatorDetune(final int oscillatorDetune) {
        this.oscillatorDetune = oscillatorDetune;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return String.format("breakpoint %2d l depth %2d r depth %2d l curve %-4s r curve %-4s rate scaling %d"
            + " AMS %d KVS %d level %2d mode %s coarse %2d fine %2d detune %2d EG %s",
            keyboardLevelScalingBreakPoint,
            keyboardLevelScalingLeftDepth,
            keyboardLevelScalingRightDepth,
            keyboardLevelScalingLeftCurve,
            keyboardLevelScalingRightCurve,
            keyboardRateScaling,
            amplitudeModulatorSensitivity,
            keyVelocitySensitivity,
            outputLevel,
            oscillatorMode,
            oscillatorFrequencyCoarse,
            oscillatorFrequencyFine,
            oscillatorDetune,
            envelopeGenerator);
    }
}
