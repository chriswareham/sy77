package net.chriswareham.sy77;

/**
 * This enumeration describes the DX7 keyboard level scaling curves.
 */
public enum Dx7KeyboardLevelScalingCurve {
    /**
     * The negative linear keyboard level scaling curve.
     */
    NEGATIVE_LINEAR("-Lin"),
    /**
     * The negative exponential keyboard level scaling curve.
     */
    NEGATIVE_EXPONENTIAL("-Exp"),
    /**
     * The positive exponential keyboard level scaling curve.
     */
    POSITIVE_EXPONENTIAL("Exp"),
    /**
     * The positive linear keyboard level scaling curve.
     */
    POSITIVE_LINEAR("Lin");

    /**
     * The description.
     */
    private final String description;

    /**
     * Construct an enumeration value.
     *
     * @param description the description
     */
    Dx7KeyboardLevelScalingCurve(final String description) {
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
