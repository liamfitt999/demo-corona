package com.example;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class DashboardNumber extends VerticalLayout {

    public DashboardNumber(String description, Number number) {
        Div descriptionDiv = new Div(new Text(description));
        descriptionDiv.getStyle().set("font-size", "small");

        Div numberDiv = new Div(new Text("" + number));
        numberDiv.getStyle().set("font-size", "xx-large");
        numberDiv.getStyle().set("font-weight", "bold");
        numberDiv.getStyle().set("margin-top", "0");

        add(descriptionDiv, numberDiv);
    }

}
