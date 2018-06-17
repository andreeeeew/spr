package useCase.mygui


import com.vaadin.navigator.View
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent
import com.vaadin.server.Page
import com.vaadin.server.VaadinSession
import com.vaadin.ui.Button
import com.vaadin.ui.Button.ClickEvent
import com.vaadin.ui.Button.ClickListener
import com.vaadin.ui.Label
import com.vaadin.ui.VerticalLayout

class SecurePage : VerticalLayout(), View {
    private val secure: Label
    private val currentUser: Label
    private val otherSecure: Button
    private val logout: Button

    init {

        otherSecure = Button("OtherSecure")
        otherSecure.addClickListener(object : ClickListener {
            private val serialVersionUID = 1L

            override fun buttonClick(event: ClickEvent) {
                Page.getCurrent().uriFragment = "!" + OtherSecurePage.NAME
            }
        })

        logout = Button("Logout")
        logout.addClickListener(object : ClickListener {
            private val serialVersionUID = 1L

            override fun buttonClick(event: ClickEvent) {
                ui.navigator.removeView(NAME)
                ui.navigator.removeView(OtherSecurePage.NAME)
                VaadinSession.getCurrent().setAttribute("user", null)
                Page.getCurrent().uriFragment = ""
            }
        })

        secure = Label("secure")
        currentUser = Label("Current User")
        addComponent(secure)
        addComponent(currentUser)
        addComponent(otherSecure)
        addComponent(logout)
    }

    override fun enter(event: ViewChangeEvent?) {
        currentUser.caption = "Current user : " + VaadinSession.getCurrent().getAttribute("user").toString()

    }

    companion object {
        private val serialVersionUID = 1L
        val NAME = "Secure"
    }

}