/**
 * Edit History
 * 4/10 Katrina Slivkoff created the simulation panel with buttons
 * 4/13 Solbi You modified to get view from factory by calling getView method
 */
package simstation;

import java.awt.*;
import javax.swing.*;
import mvc.*;

public class SimulationPanel extends AppPanel {

	private static final long serialVersionUID = 1L;
	
	private JButton startButton, suspendButton, resumeButton, stopButton, statsButton;
	
	public SimulationPanel(AppFactory factory) {
		super(factory);

		this.setLayout(new GridLayout(1, 2));
		
		JPanel buttons = new JPanel();
		buttons.setLayout(new GridLayout(5, 1));
		
		this.startButton = new JButton("Start");
		this.startButton.addActionListener(this);
		JPanel panel = new JPanel();
		panel.add(startButton);
		buttons.add(panel);
		
		this.suspendButton = new JButton("Suspend");
		this.suspendButton.addActionListener(this);
		panel = new JPanel();
		panel.add(suspendButton);
		buttons.add(panel);
		
		this.resumeButton = new JButton("Resume");
		this.resumeButton.addActionListener(this);
		panel = new JPanel();
		panel.add(resumeButton);
		buttons.add(panel);
		
		this.stopButton = new JButton("Stop");
		this.stopButton.addActionListener(this);
		panel = new JPanel();
		panel.add(stopButton);
		buttons.add(panel);
		
		this.statsButton = new JButton("Stats");
		this.statsButton.addActionListener(this);
		panel = new JPanel();
		panel.add(statsButton);
		buttons.add(panel);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BorderLayout());
		buttonPanel.add(buttons, "North");
		this.add(buttonPanel, "West");
		
		SimulationView view = (SimulationView)((SimulationFactory) factory).getView(model);
		//SimulationView view = new SimulationView((Simulation)model);
		
		this.add(view, "East");
	}
	
	public static void main(String[] args) {
		AppFactory factory = new SimulationFactory();
		AppPanel panel = new SimulationPanel(factory);
		panel.display();
	}
}
