package org.example;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

public class MainView extends AbstractSecuredView {

    public MainView() {
        add("Hello " + getUserConnectionOrWhatever());
        add(new Button("Click me",
                event -> add(new Paragraph("Clicked!"))));

        add(new Button("Logout", e -> {
            logout();
        } ));

    }

}
