package net.chriswareham.sy77;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import net.chriswareham.gui.DefaultCheckBox;
import net.chriswareham.gui.DefaultComboBoxModel;
import net.chriswareham.gui.GridBagPanel;
import net.chriswareham.gui.SliderPanel;

/**
 * This class provides a panel for editing the element values of a voice.
 *
 * <p>TODO : split the pitch sliders to create coarse and fine sliders.</p>
 * <p>TODO : disable filter sliders when "through" filter type is selected.</p>
 * <p>TODO : Handle differing maximum filter cutoff of LPF and HPF.</p>
 */
public class ElementPanel extends JPanel {
    /**
     * The serial version UID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The wave combo box model.
     */
    private final DefaultComboBoxModel<Wave> waveComboBoxModel = new DefaultComboBoxModel<>();

    /**
     * The wave combo box.
     */
    private final JComboBox<Wave> waveComboBox = new JComboBox<>(waveComboBoxModel);

    /**
     * The reverse wave check box.
     */
    private final JCheckBox reverseCheckBox = new DefaultCheckBox(event -> updateReverse());

    /**
     * The level slider.
     */
    private final SliderPanel levelSlider = new SliderPanel(0, 63, this::updateLevel);

    /**
     * The pan slider.
     */
    private final SliderPanel panSlider = new SliderPanel(-16, 16, 16, this::updatePan);

    /**
     * The pitch slider.
     */
    private final SliderPanel pitchSlider = new SliderPanel(-3600, 3600, this::updatePitch);

    /**
     * The decay slider.
     */
    private final SliderPanel decaySlider = new SliderPanel(0, 63, this::updateDecay);

    /**
     * The filter type combo box model.
     */
    private final DefaultComboBoxModel<FilterType> filterTypeComboBoxModel = new DefaultComboBoxModel<>();

    /**
     * The filter type combo box.
     */
    private final JComboBox<FilterType> filterTypeComboBox = new JComboBox<>(filterTypeComboBoxModel);

    /**
     * The filter cutoff slider.
     */
    private final SliderPanel filterCutoffSlider = new SliderPanel(0, 128, this::updateFilterCutoff); // XXX max is 115 for HPF

    /**
     * The filter resonance slider.
     */
    private final SliderPanel filterResonanceSlider = new SliderPanel(0, 99, this::updateFilterResonance);

    /**
     * The filter EG level slider.
     */
    private final SliderPanel filterEgLevelSlider = new SliderPanel(-63, 63, this::updateFilterEgLevel);

    /**
     * The filter EG rate slider.
     */
    private final SliderPanel filterEgRateSlider = new SliderPanel(0, 63, this::updateFilterEgRate);

    /**
     * The level sensitivity slider.
     */
    private final SliderPanel levelSensitivitySlider = new SliderPanel(-7, 7, this::updateLevelSensitivity);

    /**
     * The pitch sensitivity slider.
     */
    private final SliderPanel pitchSensitivitySlider = new SliderPanel(-7, 7, this::updatePitchSensitivity);

    /**
     * The EG sensitivity slider.
     */
    private final SliderPanel egSensitivitySlider = new SliderPanel(-7, 7, this::updateEgSensitivity);

    /**
     * The filter sensitivity slider.
     */
    private final SliderPanel filterSensitivitySlider = new SliderPanel(-7, 7, this::updateFilterSensitivity);

    /**
     * The listener to notify when a voice has been updated.
     */
    private VoiceUpdatedListener listener;

    /**
     * The element to edit.
     */
    private Element element;

    /**
     * Construct an instance of a panel for editing the element values of a
     * voice.
     */
    public ElementPanel() {
        this(null);
    }

    /**
     * Construct an instance of a panel for editing the element values of a
     * voice.
     *
     * @param listener the listener to notify when a voice has been updated
     */
    public ElementPanel(final VoiceUpdatedListener listener) {
        super(new GridLayout(1, 3, 4, 4));
        this.listener = listener;
        createInterface();
    }

    /**
     * Set the listener to notify when a voice has been updated.
     *
     * @param listener the listener to notify when a voice has been updated
     */
    public void setListener(final VoiceUpdatedListener listener) {
        this.listener = listener;
    }

    /**
     * Set the element to edit.
     *
     * @param element the element to edit
     */
    public void setElement(final Element element) {
        this.element = element;

        waveComboBoxModel.setSelectedRow(element.getWave());
        reverseCheckBox.setSelected(element.isReverse());
        levelSlider.setValue(element.getLevel());
        panSlider.setValue(element.getPan());
        pitchSlider.setValue(element.getPitch());
        decaySlider.setValue(element.getDecay());
        filterTypeComboBoxModel.setSelectedRow(element.getFilterType());
        filterCutoffSlider.setValue(element.getFilterCutoff());
        filterResonanceSlider.setValue(element.getFilterResonance());
        filterEgLevelSlider.setValue(element.getFilterEgLevel());
        filterEgRateSlider.setValue(element.getFilterEgRate());
        levelSensitivitySlider.setValue(element.getLevelSensitivity());
        pitchSensitivitySlider.setValue(element.getPitchSensitivity());
        egSensitivitySlider.setValue(element.getEgSensitivity());
        filterSensitivitySlider.setValue(element.getFilterSensitivity());
    }

    /**
     * Create the interface.
     */
    private void createInterface() {
        waveComboBoxModel.addRows(Wave.values());
        waveComboBox.addActionListener(event -> updateWave());

        filterTypeComboBoxModel.addRows(FilterType.values());
        filterTypeComboBox.addActionListener(event -> updateFilterType());

        add(createWavePanel());
        add(createFilterPanel());
        add(createSensitivityPanel());
    }

    /**
     * Create the wave panel.
     *
     * @return the wave panel
     */
    private JPanel createWavePanel() {
        return new GridBagPanel()
            .addBorder(BorderFactory.createLineBorder(Color.BLACK))
            .addCell("Wave:")
            .addCell(waveComboBox, true)
            .addCell("Reverse:")
            .addCell(reverseCheckBox)
            .endRow()
            .addCell("Level:")
            .addCell(levelSlider, 3, true)
            .endRow()
            .addCell("Pan:")
            .addCell(panSlider, 3, true)
            .endRow()
            .addCell("Pitch:")
            .addCell(pitchSlider, 3, true)
            .endRow()
            .addCell("Decay:")
            .addCell(decaySlider, 3, true)
            .endRow()
            .addExpandingRow();
    }

    /**
     * Create the filter panel.
     *
     * @return the filter panel
     */
    private JPanel createFilterPanel() {
        return new GridBagPanel()
            .addBorder(BorderFactory.createLineBorder(Color.BLACK))
            .addCell("Filter Type:")
            .addCell(filterTypeComboBox, true)
            .endRow()
            .addCell("Filter Cutoff:")
            .addCell(filterCutoffSlider, true)
            .endRow()
            .addCell("Filter Resonance:")
            .addCell(filterResonanceSlider, true)
            .endRow()
            .addCell("Filter EG Level:")
            .addCell(filterEgLevelSlider, true)
            .endRow()
            .addCell("Filter EG Rate:")
            .addCell(filterEgRateSlider, true)
            .endRow()
            .addExpandingRow();
    }

    /**
     * Create the sensitivity panel.
     *
     * @return the sensitivity panel
     */
    private JPanel createSensitivityPanel() {
        return new GridBagPanel()
            .addBorder(BorderFactory.createLineBorder(Color.BLACK))
            .addCell("Level Sensitivity:")
            .addCell(levelSensitivitySlider, true)
            .endRow()
            .addCell("Pitch Sensitivity:")
            .addCell(pitchSensitivitySlider, true)
            .endRow()
            .addCell("EG Sensitivity:")
            .addCell(egSensitivitySlider, true)
            .endRow()
            .addCell("Filter Sensitivity:")
            .addCell(filterSensitivitySlider, true)
            .endRow()
            .addExpandingRow();
    }

    /**
     * Update the wave.
     */
    private void updateWave() {
        Wave wave = waveComboBoxModel.getSelectedRow();
        reverseCheckBox.setEnabled(wave.ordinal() < Wave.DIG_WAVE.ordinal());
        if (!reverseCheckBox.isEnabled() && reverseCheckBox.isSelected()) {
            reverseCheckBox.setSelected(false);
        }
        if (element != null) {
            element.setWave(wave);
            fireVoiceUpdated();
        }
    }

    /**
     * Update whether the wave is reversed.
     */
    private void updateReverse() {
        if (element != null) {
            element.setReverse(reverseCheckBox.isSelected());
            fireVoiceUpdated();
        }
    }

    /**
     * Update the level.
     */
    private void updateLevel() {
        if (element != null) {
            element.setLevel(levelSlider.getValue());
            fireVoiceUpdated();
        }
    }

    /**
     * Update the pan.
     */
    private void updatePan() {
        if (element != null) {
            element.setPan(panSlider.getValue());
            fireVoiceUpdated();
        }
    }

    /**
     * Update the pitch.
     */
    private void updatePitch() {
        if (element != null) {
            element.setPitch(pitchSlider.getValue());
            fireVoiceUpdated();
        }
    }

    /**
     * Update the decay.
     */
    private void updateDecay() {
        if (element != null) {
            element.setDecay(decaySlider.getValue());
            fireVoiceUpdated();
        }
    }

    /**
     * Update the filter type.
     */
    private void updateFilterType() {
        if (element != null) {
            element.setFilterType(filterTypeComboBoxModel.getSelectedRow());
            fireVoiceUpdated();
        }
    }

    /**
     * Update the filter cutoff.
     */
    private void updateFilterCutoff() {
        if (element != null) {
            element.setFilterCutoff(filterCutoffSlider.getValue());
            fireVoiceUpdated();
        }
    }

    /**
     * Update the filter resonance.
     */
    private void updateFilterResonance() {
        if (element != null) {
            element.setFilterResonance(filterResonanceSlider.getValue());
            fireVoiceUpdated();
        }
    }

    /**
     * Update the filter EG level.
     */
    private void updateFilterEgLevel() {
        if (element != null) {
            element.setFilterEgLevel(filterEgLevelSlider.getValue());
            fireVoiceUpdated();
        }
    }

    /**
     * Update the filter EG rate.
     */
    private void updateFilterEgRate() {
        if (element != null) {
            element.setFilterEgRate(filterEgRateSlider.getValue());
            fireVoiceUpdated();
        }
    }

    /**
     * Update the level sensitivity.
     */
    private void updateLevelSensitivity() {
        if (element != null) {
            element.setLevelSensitivity(levelSensitivitySlider.getValue());
            fireVoiceUpdated();
        }
    }

    /**
     * Update the pitch sensitivity.
     */
    private void updatePitchSensitivity() {
        if (element != null) {
            element.setPitchSensitivity(pitchSensitivitySlider.getValue());
            fireVoiceUpdated();
        }
    }

    /**
     * Update the EG sensitivity.
     */
    private void updateEgSensitivity() {
        if (element != null) {
            element.setEgSensitivity(egSensitivitySlider.getValue());
            fireVoiceUpdated();
        }
    }

    /**
     * Update the filter sensitivity.
     */
    private void updateFilterSensitivity() {
        if (element != null) {
            element.setFilterSensitivity(filterSensitivitySlider.getValue());
            fireVoiceUpdated();
        }
    }

    /**
     * Inform the listener that a voice has been updated.
     */
    private void fireVoiceUpdated() {
        if (listener != null) {
            listener.updated();
        }
    }
}
