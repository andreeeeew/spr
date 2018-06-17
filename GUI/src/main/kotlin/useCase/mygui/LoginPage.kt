package useCase.mygui

import com.vaadin.navigator.View
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent
import com.vaadin.server.Page
import com.vaadin.server.VaadinSession
import com.vaadin.ui.Alignment
import com.vaadin.ui.Button
import com.vaadin.ui.Button.ClickEvent
import com.vaadin.ui.Button.ClickListener
import com.vaadin.ui.FormLayout
import com.vaadin.ui.Notification
import com.vaadin.ui.Panel
import com.vaadin.ui.PasswordField
import com.vaadin.ui.TextField
import com.vaadin.ui.VerticalLayout
import useCase.ui.VaadinloginUI

class LoginPage : VerticalLayout(), View {
    init {
        val panel = Panel("Login")
        panel.setSizeUndefined()
        addComponent(panel)


        val content = FormLayout()
        val username = TextField("Username")
        content.addComponent(username)
        val password = PasswordField("Password")
        content.addComponent(password)

        val send = Button("Enter")
        send.addClickListener(object : ClickListener {
            private val serialVersionUID = 1L

            override fun buttonClick(event: ClickEvent) {
                if (VaadinloginUI.AUTH.authenticate(username.value, password.value)!!) {
                    VaadinSession.getCurrent().setAttribute("user", username.value)
                    ui.navigator.addView(SecurePage.NAME, SecurePage::class.java)
                    ui.navigator.addView(OtherSecurePage.NAME, OtherSecurePage::class.java)
                    Page.getCurrent().uriFragment = "!" + SecurePage.NAME
                } else {
                    Notification.show("Invalid credentials", Notification.Type.ERROR_MESSAGE)
                }
            }

        })
        content.addComponent(send)
        content.setSizeUndefined()
        content.setMargin(true)
        panel.content = content
        setComponentAlignment(panel, Alignment.MIDDLE_CENTER)

    }

    override fun enter(event: ViewChangeEvent?) {

    }

    companion object {
        private val serialVersionUID = 1L
        val NAME = ""
    }

}