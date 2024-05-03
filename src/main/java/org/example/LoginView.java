package org.example;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.textfield.TextField;

public class LoginView extends AbstractSecuredView {

    public LoginView() {
        // In real world, probably passkey, password or something
        TextField user = new TextField();
        add(user,
            new Button("Login", e-> {
                login(user.getValue());
            }));
    }
}
