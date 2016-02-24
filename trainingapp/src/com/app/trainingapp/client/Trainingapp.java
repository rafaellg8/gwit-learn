package com.app.trainingapp.client;

import com.app.trainingapp.shared.FieldVerifier;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
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
	  private TextBox newSymbolTextBox = new TextBox();
	  private Button addStockButton = new Button("Add");
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

		    // Assemble Add Stock panel.
		    addPanel.add(newSymbolTextBox);
		    addPanel.add(addStockButton);

		    // Assemble Main panel.
		    mainPanel.add(stocksFlexTable);
		    mainPanel.add(addPanel);
		    mainPanel.add(lastUpdatedLabel);

		    // Associate the Main panel with the HTML host page.
		    RootPanel.get("timing").add(mainPanel);

		    // Move cursor focus to the input box.
		    newSymbolTextBox.setFocus(true);

		  }
}