package nl.grauw.gaia.tool.views;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import javax.sound.midi.MidiDevice;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequencer;
import javax.sound.midi.Synthesizer;
import javax.swing.JOptionPane;

import nl.grauw.gaia.midi.JavaMidiConnection.GaiaNotFoundException;
import nl.grauw.gaia.tool.GaiaTool;

public class MIDIDeviceSelector {
	
	GaiaTool gaiaTool;
	Component parent;
	static final String AUTODETECT = "Auto-detect";
	
	public MIDIDeviceSelector(GaiaTool gaia, Component parent) {
		this.gaiaTool = gaia;
		this.parent = parent;
	}
	
	public void show() {
		selectMIDIInputDevice();
		selectMIDIOutputDevice();
		
		gaiaTool.closeGaia();
		
		try {
			gaiaTool.openGaia();
		} catch (GaiaNotFoundException e) {
			// that’s fine
		} catch (MidiUnavailableException e) {
			e.printStackTrace();
		}
	}
	
	private void selectMIDIInputDevice() {
		List<Object> inputDevices = new ArrayList<Object>();
		inputDevices.add(AUTODETECT);
		for (MidiDevice.Info mdi : MidiSystem.getMidiDeviceInfo()) {
			try {
				MidiDevice md = MidiSystem.getMidiDevice(mdi);
				if (md.getMaxTransmitters() != 0 && !(md instanceof Sequencer) && !(md instanceof Synthesizer))
					inputDevices.add(mdi);
			} catch (MidiUnavailableException e) {
			}
		}
		
		MidiDevice currentDevice = gaiaTool.getMidiConnection().getMidiInput();
		
		Object selection = JOptionPane.showInputDialog(parent, "Please select a MIDI input device",
				"Select MIDI input device", JOptionPane.QUESTION_MESSAGE, null, inputDevices.toArray(),
				currentDevice != null ? currentDevice.getDeviceInfo() : null);
		
		if (selection instanceof MidiDevice.Info) {
			gaiaTool.getMidiConnection().setDefaultMidiInput(((MidiDevice.Info) selection).getName());
		} else if (selection == AUTODETECT) {
			gaiaTool.getMidiConnection().setDefaultMidiInput(null);
		}
	}
	
	private void selectMIDIOutputDevice() {
		List<Object> outputDevices = new ArrayList<Object>();
		outputDevices.add(AUTODETECT);
		for (MidiDevice.Info mdi : MidiSystem.getMidiDeviceInfo()) {
			try {
				MidiDevice md = MidiSystem.getMidiDevice(mdi);
				if (md.getMaxReceivers() != 0 && !(md instanceof Sequencer) && !(md instanceof Synthesizer))
					outputDevices.add(mdi);
			} catch (MidiUnavailableException e) {
			}
		}
		
		MidiDevice currentDevice = gaiaTool.getMidiConnection().getMidiOutput();
		
		Object selection = JOptionPane.showInputDialog(parent, "Please select a MIDI output device",
				"Select MIDI output device", JOptionPane.QUESTION_MESSAGE, null, outputDevices.toArray(),
				currentDevice != null ? currentDevice.getDeviceInfo() : null);
		
		if (selection instanceof MidiDevice.Info) {
			gaiaTool.getMidiConnection().setDefaultMidiOutput(((MidiDevice.Info) selection).getName());
		} else if (selection == AUTODETECT) {
			gaiaTool.getMidiConnection().setDefaultMidiOutput(null);
		}
	}
	
}
