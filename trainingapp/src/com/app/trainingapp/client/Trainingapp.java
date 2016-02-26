package com.app.trainingapp.client;

import java.util.ArrayList;

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
import com.google.gwt.user.client.ui.CellPanel;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.datepicker.client.DateBox;
import com.app.trainingapp.client.Training;;
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
	private DateBox dateBox = new DateBox();
	private TextBox placeBox = new TextBox();
	private TextBox distanceBox = new TextBox();
	private TextBox avgBox = new TextBox();
	private TextBox pulseBox = new TextBox();
	private HorizontalPanel timePanel = new HorizontalPanel();
	private Button addTimeButton = new Button("Add");
	private Label lastUpdatedLabel = new Label();

	// ArrayList for time
	private ArrayList<Training> trainingDay = new ArrayList<Training>();
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		// Create table for stock data.
		stocksFlexTable.setText(0, 0, "Date");
		stocksFlexTable.setText(0, 1, "Hour");
		stocksFlexTable.setText(0, 2, "Minute");
		stocksFlexTable.setText(0, 3, "Second");
		stocksFlexTable.setText(0, 5, "Place");
		stocksFlexTable.setText(0, 6, "Distance");
		stocksFlexTable.setText(0, 7, "KM/H");
		stocksFlexTable.setText(0, 8, "Pulse");
		stocksFlexTable.setText(0, 9, "Change");
		stocksFlexTable.setText(0, 10, "Remove");

		
		// Assemble Add Time panel.
		timePanel.add(dateBox);
		timePanel.add(hourBox);
		timePanel.add(minuteBox);
		timePanel.add(secondBox);
		timePanel.add(placeBox);
		timePanel.add(distanceBox);
		timePanel.add(avgBox);
		timePanel.add(pulseBox);
		//Set the size
		avgBox.setPixelSize(30,26);
		hourBox.setPixelSize(24,26);
		minuteBox.setPixelSize(24,26);
		secondBox.setPixelSize(24,26);
		
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

		// Hour must be between 0 and 23
		if (!symbol.matches("([0-9]|1[0-9]|2[0-3])")) {
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
		if (!symbolMinute.matches("^[1-5]?[0-9]$")) {
			Window.alert("'" + symbolMinute + "' is not a valid minute.");
			minuteBox.selectAll();
			return;
		}
		minuteBox.setText("");

		/**
		 * Second Boxs
		 */
		final String symbolSecond = secondBox.getText().trim();

		// Validate minute
		if (!symbolSecond.matches("^[1-5]?[0-9]$")) {
			Window.alert("'" + symbolSecond + "' is not a valid minute.");
			minuteBox.selectAll();
			return;
		}
		secondBox.setText("");
		
		/**
		 * PlaceBox
		 * \w+
		 */
		final String symbolPlace = placeBox.getText().trim();
		if (!symbolSecond.matches("\\w+")) {
			Window.alert("'" + symbolPlace + "' is not a valid place.");
			placeBox.selectAll();
			return;
		}
		placeBox.setText("");
		
		/**
		 * Distance, any digit
		 */
		final String symbolKm = distanceBox.getText().trim();
		if (!symbolKm.matches("\\d+")){
			Window.alert("'" + symbolKm + "'is not a valid distance");
			distanceBox.selectAll();
			return;
		}
		
		distanceBox.setText("");
		
		/**
		 * Pulse, any digit
		 */
		final String pulse = pulseBox.getText().trim();
		if (!pulse.matches("\\d+")){
			Window.alert("'" + pulse + "'is not a valid distance");
			pulseBox.selectAll();
			return;
		}
		
		pulseBox.setText("");
		
		// Don't add the TrainingDay if it's already in the table.
	    if (trainingDay.contains(symbol))
	    	return;
		// TODO Add the stock to the table
		// TODO Add a button to remove this stock from the table.
		// TODO Get the stock price.

	}
}