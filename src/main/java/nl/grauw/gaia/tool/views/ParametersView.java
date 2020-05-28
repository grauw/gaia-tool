package nl.grauw.gaia.tool.views;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;

import nl.grauw.gaia.Gaia;

public abstract class ParametersView extends JPanel implements ActionListener {
	private static final long serialVersionUID = 123L;
	
	private JLabel titleLabel;
	private JPanel buttonsPanel;
	private JButton refreshButton;
	
	public abstract Gaia getGaia();
	
	public abstract void loadParameters();
	
	public abstract void saveParameters();
	
	public abstract String getTitle();
	
	protected abstract boolean isRefreshShown();
	
	protected abstract JComponent getParametersContainer();
	
	protected void initComponents() {
		GroupLayout layout = new GroupLayout(this);
		setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setHorizontalGroup(
				layout.createParallelGroup()
					.addGroup(
						layout.createSequentialGroup()
							.addComponent(getTitleLabel())
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.PREFERRED_SIZE, Integer.MAX_VALUE)
							.addComponent(getSyncButtons(), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					)
					.addComponent(getParametersContainer())
			);
		layout.setVerticalGroup(
				layout.createSequentialGroup()
					.addGroup(
						layout.createParallelGroup(Alignment.CENTER)
							.addComponent(getTitleLabel())
							.addComponent(getSyncButtons(), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					)
					.addComponent(getParametersContainer())
			);
	}
	
	private JLabel getTitleLabel() {
		if (titleLabel == null) {
			titleLabel = new JLabel();
			titleLabel.setFont(titleLabel.getFont().deriveFont(24f).deriveFont(Font.BOLD));
			titleLabel.setText(getTitle());
		}
		return titleLabel;
	}
	
	private JPanel getSyncButtons() {
		if (buttonsPanel == null) {
			buttonsPanel = new JPanel();
			if (isRefreshShown()) {
				buttonsPanel.add(getRefreshButton());
			}
		}
		return buttonsPanel;
	}
	
	private JButton getRefreshButton() {
		if (refreshButton == null) {
			refreshButton = new JButton();
			refreshButton.setText("Refresh");
			refreshButton.setToolTipText("Refresh patch data.");
			refreshButton.addActionListener(this);
		}
		return refreshButton;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == refreshButton) {
			loadParameters();
		}
	}
	
}
