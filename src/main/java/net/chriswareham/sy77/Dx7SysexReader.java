package net.chriswareham.sy77;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import net.chriswareham.midi.MidiUtils;

/**
 * This class provides a reader for DX7 System Exclusive data.
 */
public class Dx7SysexReader {
    /**
     * The initial byte of a System Exclusive message.
     */
    public static final byte YAMAHA_MANUFACTURER_ID = (byte) 0x43;

    /**
     * Main entry point for running the DX7 System Exclusive reader.
     *
     * @param args the command line arguments
     */
    public static void main(final String... args) {
        if (args.length != 1) {
            System.err.println("Usage: Dx7SysexReader <sysex-filename>");
            System.exit(1);
        }

        new Dx7SysexReader().run(args[0]);
    }

    /**
     * Run the DX7 System Exclusive reader.
     *
     * @param filename the name of the DX7 System Exclusive file to read
     */
    public void run(final String filename) {
        try {
            Path path = Path.of(filename);

            byte[] data = Files.readAllBytes(path);

            Dx7SysexType type = getType(data);

            if (type == Dx7SysexType.SINGLE_VOICE) {
                System.err.println(deserialiseSingleVoice(Arrays.copyOfRange(data, 6, 161)));
            } else {
                for (int i = 6; i < 4096; i += 128) {
                    System.err.println(deserialiseMultiVoice(Arrays.copyOfRange(data, i, i + 128)));
                    System.err.println();
                }
            }
        } catch (IllegalArgumentException | IOException exception) {
            System.err.println("Invalid file " + filename);
        }
    }

    /**
     * Determine the type of a System Exclusive message.
     *
     * @param data the message to determine the type of
     * @return the type of the the message
     * @throws IllegalArgumentException if the message type cannot be determined
     */
    private Dx7SysexType getType(final byte[] data) throws IllegalArgumentException {
        if (data.length < 4) {
            throw new IllegalArgumentException();
        }
        if (data[0] != MidiUtils.SYSEX_INITIAL_BYTE) {
            throw new IllegalArgumentException();
        }
        if (data[data.length - 1] != MidiUtils.SYSEX_TERMINATING_BYTE) {
            throw new IllegalArgumentException();
        }
        if (data[1] != YAMAHA_MANUFACTURER_ID) {
            throw new IllegalArgumentException();
        }
        Dx7SysexType type = Dx7SysexType.fromValue(data[3]);
        if (type == null || type.getSize() != data.length) {
            throw new IllegalArgumentException();
        }
        return type;
    }

    /**
     * Deserialise a voice from a single voice message.
     *
     * @param data the message to deserialise a voice from
     * @return a voice
     */
    private Dx7Voice deserialiseSingleVoice(final byte[] data) {
        Dx7Voice voice = new Dx7Voice();
        for (int n = 0, op = 5; n < 6; ++n, --op) {
            Dx7Operator operator = voice.getOperators().get(op);
            int i = n * 21;
            operator.getEnvelopeGenerator().setRate1(data[i++]);
            operator.getEnvelopeGenerator().setRate2(data[i++]);
            operator.getEnvelopeGenerator().setRate3(data[i++]);
            operator.getEnvelopeGenerator().setRate4(data[i++]);
            operator.getEnvelopeGenerator().setLevel1(data[i++]);
            operator.getEnvelopeGenerator().setLevel2(data[i++]);
            operator.getEnvelopeGenerator().setLevel3(data[i++]);
            operator.getEnvelopeGenerator().setLevel4(data[i++]);
            operator.setKeyboardLevelScalingBreakPoint(data[i++]);
            operator.setKeyboardLevelScalingLeftDepth(data[i++]);
            operator.setKeyboardLevelScalingRightDepth(data[i++]);
            operator.setKeyboardLevelScalingLeftCurve(Dx7KeyboardLevelScalingCurve.values()[data[i++]]);
            operator.setKeyboardLevelScalingRightCurve(Dx7KeyboardLevelScalingCurve.values()[data[i++]]);
            operator.setKeyboardRateScaling(data[i++]);
            operator.setAmplitudeModulatorSensitivity(data[i++]);
            operator.setKeyVelocitySensitivity(data[i++]);
            operator.setOutputLevel(data[i++]);
            operator.setOscillatorMode(Dx7OperatorOscillatorMode.values()[data[i++]]);
            operator.setOscillatorFrequencyCoarse(data[i++]);
            operator.setOscillatorFrequencyFine(data[i++]);
            operator.setOscillatorDetune(data[i++]);
        }
        voice.getPitchEnvelopeGenerator().setRate1(data[126]);
        voice.getPitchEnvelopeGenerator().setRate2(data[127]);
        voice.getPitchEnvelopeGenerator().setRate3(data[128]);
        voice.getPitchEnvelopeGenerator().setRate4(data[129]);
        voice.getPitchEnvelopeGenerator().setLevel1(data[130]);
        voice.getPitchEnvelopeGenerator().setLevel2(data[131]);
        voice.getPitchEnvelopeGenerator().setLevel3(data[132]);
        voice.getPitchEnvelopeGenerator().setLevel4(data[133]);
        voice.setAlgorithm(data[134]);
        voice.setFeedback(data[135]);
        voice.setKeySync(data[136] != 0);
        voice.getLowFrequencyOscillator().setSpeed(data[137]);
        voice.getLowFrequencyOscillator().setDelay(data[138]);
        voice.getLowFrequencyOscillator().setPitchModulationDepth(data[139]);
        voice.getLowFrequencyOscillator().setAmplitudeModulationDepth(data[140]);
        voice.getLowFrequencyOscillator().setKeySync(data[141] != 0);
        voice.getLowFrequencyOscillator().setWave(Dx7LowFrequencyOscillatorWave.values()[data[141]]);
        voice.getLowFrequencyOscillator().setPitchModulationSensitivity(data[143]);
        voice.setTranspose(data[144]);
        voice.setName(new String(data, 145, 10, StandardCharsets.US_ASCII));
        return voice;
    }

    /**
     * Deserialise a voice from a multiple voice message.
     *
     * @param data the message to deserialise a voice from
     * @return a voice
     */
    private Dx7Voice deserialiseMultiVoice(final byte[] data) {
        Dx7Voice voice = new Dx7Voice();
        for (int n = 0, op = 5; n < 6; ++n, --op) {
            Dx7Operator operator = voice.getOperators().get(op);
            int i = n * 17;
            operator.getEnvelopeGenerator().setRate1(data[i++]);
            operator.getEnvelopeGenerator().setRate2(data[i++]);
            operator.getEnvelopeGenerator().setRate3(data[i++]);
            operator.getEnvelopeGenerator().setRate4(data[i++]);
            operator.getEnvelopeGenerator().setLevel1(data[i++]);
            operator.getEnvelopeGenerator().setLevel2(data[i++]);
            operator.getEnvelopeGenerator().setLevel3(data[i++]);
            operator.getEnvelopeGenerator().setLevel4(data[i++]);
            operator.setKeyboardLevelScalingBreakPoint(data[i++]);
            operator.setKeyboardLevelScalingLeftDepth(data[i++]);
            operator.setKeyboardLevelScalingRightDepth(data[i++]);
            operator.setKeyboardLevelScalingLeftCurve(Dx7KeyboardLevelScalingCurve.values()[data[i] & 0x3]);
            operator.setKeyboardLevelScalingRightCurve(Dx7KeyboardLevelScalingCurve.values()[data[i] >> 2]);
            ++i;
            operator.setKeyboardRateScaling(data[i] & 0x7);
            operator.setOscillatorDetune(data[i] >> 3);
            ++i;
            operator.setAmplitudeModulatorSensitivity(data[i] & 0x3);
            operator.setKeyVelocitySensitivity(data[i] >> 2);
            ++i;
            operator.setOutputLevel(data[i++]);
            operator.setOscillatorMode(Dx7OperatorOscillatorMode.values()[data[i] & 0x1]);
            operator.setOscillatorFrequencyCoarse(data[i] >> 1);
            ++i;
            operator.setOscillatorFrequencyFine(data[i++]);
        }
        voice.getPitchEnvelopeGenerator().setRate1(data[102]);
        voice.getPitchEnvelopeGenerator().setRate2(data[103]);
        voice.getPitchEnvelopeGenerator().setRate3(data[104]);
        voice.getPitchEnvelopeGenerator().setRate4(data[105]);
        voice.getPitchEnvelopeGenerator().setLevel1(data[106]);
        voice.getPitchEnvelopeGenerator().setLevel2(data[107]);
        voice.getPitchEnvelopeGenerator().setLevel3(data[108]);
        voice.getPitchEnvelopeGenerator().setLevel4(data[109]);
        voice.setAlgorithm(data[110]);
        voice.setFeedback(data[111] & 0x7);
        voice.setKeySync((data[111] & 0x8) != 0);
        voice.getLowFrequencyOscillator().setSpeed(data[112]);
        voice.getLowFrequencyOscillator().setDelay(data[113]);
        voice.getLowFrequencyOscillator().setPitchModulationDepth(data[114]);
        voice.getLowFrequencyOscillator().setAmplitudeModulationDepth(data[115]);
        voice.getLowFrequencyOscillator().setKeySync((data[116] & 0x1) != 0);
        voice.getLowFrequencyOscillator().setWave(Dx7LowFrequencyOscillatorWave.values()[data[116] >> 1 & 0x7]);
        voice.getLowFrequencyOscillator().setPitchModulationSensitivity(data[116] >> 4 & 0x7);
        voice.setTranspose(data[117]);
        voice.setName(new String(data, 118, 10, StandardCharsets.US_ASCII));
        return voice;
    }
}
