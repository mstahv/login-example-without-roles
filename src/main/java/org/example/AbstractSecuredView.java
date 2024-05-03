package org.example;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;

@Route
public class AbstractSecuredView extends VerticalLayout implements BeforeEnterObserver {


    public String getUserConnectionOrWhatever() {
        return (String) VaadinSession.getCurrent().getAttribute("user");
    }

    @Override
    public void beforeEnter(BeforeEnterEvent event) {
        // Only allow LoginView if not logged in
        if(getUserConnectionOrWhatever() == null && event.getNavigationTarget() != LoginView.class) {
            event.forwardTo(LoginView.class);
        }
    }

    protected void login(String userConnectionOrWhatever) {
        VaadinSession.getCurrent().setAttribute("user", userConnectionOrWhatever);
        UI.getCurrent().navigate(MainView.class);
    }

    protected void logout() {
        VaadinSession.getCurrent().setAttribute("user", null);
        UI.getCurrent().navigate(LoginView.class);
    }

}
