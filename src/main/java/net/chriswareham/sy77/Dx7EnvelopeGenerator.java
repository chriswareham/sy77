package net.chriswareham.sy77;

/**
 * This class describes a Yamaha DX7 envelope generator.
 */
public class Dx7EnvelopeGenerator {
    /**
     * The rate 1 (0 to 99).
     */
    private int rate1;

    /**
     * The rate 2 (0 to 99).
     */
    private int rate2;

    /**
     * The rate 3 (0 to 99).
     */
    private int rate3;

    /**
     * The rate 4 (0 to 99).
     */
    private int rate4;

    /**
     * The level 1 (0 to 99).
     */
    private int level1;

    /**
     * The level 2 (0 to 99).
     */
    private int level2;

    /**
     * The level 3 (0 to 99).
     */
    private int level3;

    /**
     * The level 4 (0 to 99).
     */
    private int level4;

    /**
     * Get the rate 1 (0 to 99).
     *
     * @return the rate 1
     */
    public int getRate1() {
        return rate1;
    }

    /**
     * Set the rate 1 (0 to 99).
     *
     * @param rate1 the rate 1
     */
    public void setRate1(final int rate1) {
        this.rate1 = rate1;
    }

    /**
     * Get the rate 2 (0 to 99).
     *
     * @return the rate 2
     */
    public int getRate2() {
        return rate2;
    }

    /**
     * Set the rate 2 (0 to 99).
     *
     * @param rate2 the rate 2
     */
    public void setRate2(final int rate2) {
        this.rate2 = rate2;
    }

    /**
     * Get the rate 3 (0 to 99).
     *
     * @return the rate 3
     */
    public int getRate3() {
        return rate3;
    }

    /**
     * Set the rate 3 (0 to 99).
     *
     * @param rate3 the rate 3
     */
    public void setRate3(final int rate3) {
        this.rate3 = rate3;
    }

    /**
     * Get the rate 4 (0 to 99).
     *
     * @return the rate 4
     */
    public int getRate4() {
        return rate4;
    }

    /**
     * Set the rate 4 (0 to 99).
     *
     * @param rate4 the rate 4
     */
    public void setRate4(final int rate4) {
        this.rate4 = rate4;
    }

    /**
     * Get the level 1 (0 to 99).
     *
     * @return the level 1
     */
    public int getLevel1() {
        return level1;
    }

    /**
     * Set the level 1 (0 to 99).
     *
     * @param level1 the level 1
     */
    public void setLevel1(final int level1) {
        this.level1 = level1;
    }

    /**
     * Get the level 2 (0 to 99).
     *
     * @return the level 2
     */
    public int getLevel2() {
        return level2;
    }

    /**
     * Set the level 2 (0 to 99).
     *
     * @param level2 the level 2
     */
    public void setLevel2(final int level2) {
        this.level2 = level2;
    }

    /**
     * Get the level 3 (0 to 99).
     *
     * @return the level 3
     */
    public int getLevel3() {
        return level3;
    }

    /**
     * Set the level 3 (0 to 99).
     *
     * @param level3 the level 3
     */
    public void setLevel3(final int level3) {
        this.level3 = level3;
    }

    /**
     * Get the level 4 (0 to 99).
     *
     * @return the level 4
     */
    public int getLevel4() {
        return level4;
    }

    /**
     * Set the level 4 (0 to 99).
     *
     * @param level4 the level 4
     */
    public void setLevel4(final int level4) {
        this.level4 = level4;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return String.format("r1 %2d r2 %2d r3 %2d r4 %2d l1 %2d l2 %2d l3 %2d l4 %2d ",
            rate1,
            rate2,
            rate3,
            rate4,
            level1,
            level2,
            level3,
            level4);
    }
}
