package net.chriswareham.sy77;

import java.util.Collections;
import java.util.List;

/**
 * This class describes a Yamaha SY77 voice.
 */
public class Sy77Voice {
    /**
     * The operators.
     */
    private final List<Dx7Operator> operators = List.of(
        new Dx7Operator(),
        new Dx7Operator(),
        new Dx7Operator(),
        new Dx7Operator(),
        new Dx7Operator(),
        new Dx7Operator()
    );

    /**
     * The pitch envelope generator.
     */
    private final Dx7EnvelopeGenerator pitchEnvelopeGenerator = new Dx7EnvelopeGenerator();

    /**
     * The algorithm select (0 to 31).
     */
    private int algorithm;

    /**
     * The feedback (0 to 7).
     */
    private int feedback;

    /**
     * The oscillator key sync.
     */
    private boolean keySync;

    /**
     * The low frequency oscillator.
     */
    private final Dx7LowFrequencyOscillator lowFrequencyOscillator = new Dx7LowFrequencyOscillator();

    /**
     * The transpose (0 to 48).
     */
    private int transpose = 24;

    /**
     * The voice name (10 ASCII characters).
     */
    private String name = "";

    /**
     * Get the operators.
     *
     * @return the operators
     */
    public List<Dx7Operator> getOperators() {
        return Collections.unmodifiableList(operators);
    }

    /**
     * Get the pitch envelope generator.
     *
     * @return the pitch envelope generator
     */
    public Dx7EnvelopeGenerator getPitchEnvelopeGenerator() {
        return pitchEnvelopeGenerator;
    }

    /**
     * Get the algorithm select (0 to 31).
     *
     * @return the algorithm select
     */
    public int getAlgorithm() {
        return algorithm;
    }

    /**
     * Set the algorithm select (0 to 31).
     *
     * @param algorithm the algorithm select
     */
    public void setAlgorithm(final int algorithm) {
        this.algorithm = algorithm;
    }

    /**
     * Get the feedback (0 to 7).
     *
     * @return the feedback
     */
    public int getFeedback() {
        return feedback;
    }

    /**
     * Set the feedback (0 to 7).
     *
     * @param feedback the feedback
     */
    public void setFeedback(final int feedback) {
        this.feedback = feedback;
    }

    /**
     * Get the oscillator key sync.
     *
     * @return the oscillator key sync
     */
    public boolean isKeySync() {
        return keySync;
    }

    /**
     * Set the oscillator key sync.
     *
     * @param keySync the oscillator key sync
     */
    public void setKeySync(final boolean keySync) {
        this.keySync = keySync;
    }

    /**
     * Get the low frequency oscillator.
     *
     * @return the low frequency oscillator
     */
    public Dx7LowFrequencyOscillator getLowFrequencyOscillator() {
        return lowFrequencyOscillator;
    }

    /**
     * Get the transpose (0 to 48).
     *
     * @return the transpose
     */
    public int getTranspose() {
        return transpose;
    }

    /**
     * Set the transpose (0 to 48).
     *
     * @param transpose the transpose
     */
    public void setTranspose(final int transpose) {
        this.transpose = transpose;
    }

    /**
     * Get the voice name (10 ASCII characters).
     *
     * @return the voice name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the voice name (10 ASCII characters).
     *
     * @param name the voice name
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return String.format("\"%s\"\n"
            + "algorithm %2d feedback %d key sync %-3s transpose %d\n"
            + "Operator 1 [ %s ]\n"
            + "Operator 2 [ %s ]\n"
            + "Operator 3 [ %s ]\n"
            + "Operator 4 [ %s ]\n"
            + "Operator 5 [ %s ]\n"
            + "Operator 6 [ %s ]\n"
            + "Pitch EG   [ %s ]\n"
            + "LFO        [ %s ]",
            name,
            algorithm + 1,
            feedback,
            keySync ? "on" : "off",
            transpose - 24,
            operators.get(0),
            operators.get(1),
            operators.get(2),
            operators.get(3),
            operators.get(4),
            operators.get(5),
            pitchEnvelopeGenerator,
            lowFrequencyOscillator);
    }
}
