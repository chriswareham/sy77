package net.chriswareham.sy77;

import java.util.HashMap;
import java.util.Map;

/**
 * This enumeration describes the DX7 System Exclusive message types.
 */
public enum Dx7SysexType {
    /**
     * The single voice System Exclusive message type.
     */
    SINGLE_VOICE("Single", 0x00, 163),
    /**
     * The multiple voice System Exclusive message type.
     */
    MULTI_VOICE("Multi", 0x09, 4104);

    /**
     * The mappings from a byte value to enumeration value.
     */
    private static final Map<Byte, Dx7SysexType> VALUES = new HashMap<>();

    static {
        for (Dx7SysexType value : values()) {
            VALUES.put(value.value, value);
        }
    }

    /**
     * Get the enumeration value for a byte value.
     *
     * @param value the byte value to get the enumeration value for
     * @return the enumeration value for the byte value
     */
    public static Dx7SysexType fromValue(final byte value) {
        return VALUES.get(value);
    }

    /**
     * The description.
     */
    private final String description;

    /**
     * The byte value.
     */
    private final byte value;

    /**
     * The message size.
     */
    private final int size;

    /**
     * Construct an enumeration value.
     *
     * @param description the description
     * @param value the byte value
     * @param size the message size
     */
    Dx7SysexType(final String description, final int value, final int size) {
        this.description = description;
        this.value = (byte) value;
        this.size = size;
    }

    /**
     * Get the byte value.
     *
     * @return the byte value
     */
    public byte getValue() {
        return value;
    }

    /**
     * Get the message size.
     *
     * @return the message size
     */
    public int getSize() {
        return size;
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
