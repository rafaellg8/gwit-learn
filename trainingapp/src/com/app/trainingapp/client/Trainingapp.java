package com.app.trainingapp.client;

import com.app.trainingapp.shared.FieldVerifier;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Trainingapp implements EntryPoint {
	/**
	 * GUI Elements
	 */
	private VerticalPanel mainPanel = new VerticalPanel();
	private FlexTable stocksFlexTable = new FlexTable();
	private HorizontalPanel addPanel = new HorizontalPanel();
	private TextBox hourBox = new TextBox();
	private TextBox minuteBox = new TextBox();
	private TextBox secondBox = new TextBox();
	private HorizontalPanel timePanel = new HorizontalPanel();
	private Button addTimeButton = new Button("Add");
	private Label lastUpdatedLabel = new Label();

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		// Create table for stock data.
		stocksFlexTable.setText(0, 0, "Symbol");
		stocksFlexTable.setText(0, 1, "Price");
		stocksFlexTable.setText(0, 2, "Change");
		stocksFlexTable.setText(0, 3, "Remove");

		// Assemble Add Time panel.
		timePanel.add(hourBox);
		timePanel.add(minuteBox);
		timePanel.add(secondBox);
		addPanel.add(addTimeButton);

		timePanel.add(addPanel);

		// Assemble Main panel.
		mainPanel.add(stocksFlexTable);
		mainPanel.add(timePanel);
		mainPanel.add(lastUpdatedLabel);

		// Associate the Main panel with the HTML host page.
		RootPanel.get("timing").add(mainPanel);

		// Move cursor focus to the input box.
		hourBox.setFocus(true);

		// Event for addTimeButton
		addTimeButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				// Call to function to add time
				addTime();
			}
		});

		// Listen for keyboard events in the input box.
		secondBox.addKeyDownHandler(new KeyDownHandler() {
			public void onKeyDown(KeyDownEvent event) {
				if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
					addTime();
				}
			}
		});
	}

	// Add a box time in the FlexTable
	private void addTime() {
		/**
		 * Hour Box
		 */
		final String symbol = hourBox.getText().trim();
		hourBox.setFocus(true);

		// Hour must be between 1 and 10 chars that are numbers, letters, or
		// dots.
		if (!symbol.matches("^[0-23]$")) {
			Window.alert("'" + symbol + "' is not a valid hour.");
			hourBox.selectAll();
			return;
		}

		hourBox.setText("");

		/**
		 * Minute Box
		 */

		final String symbolMinute = minuteBox.getText().trim();

		// Validate minute
		if (!symbolMinute.matches("^[0-59]$")) {
			Window.alert("'" + symbolMinute + "' is not a valid minute.");
			minuteBox.selectAll();
			return;
		}
		minuteBox.setText("");

		final String symbolSecond = secondBox.getText().trim();

		// Validate minute
		if (!symbolSecond.matches("^[0-59]$")) {
			Window.alert("'" + symbolSecond + "' is not a valid minute.");
			minuteBox.selectAll();
			return;
		}
		secondBox.setText("");

		// TODO Don't add the stock if it's already in the table.
		// TODO Add the stock to the table
		// TODO Add a button to remove this stock from the table.
		// TODO Get the stock price.

	}
}