package useCase.mygui

import com.vaadin.navigator.View
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent
import com.vaadin.server.Page
import com.vaadin.ui.Button
import com.vaadin.ui.Button.ClickEvent
import com.vaadin.ui.Button.ClickListener
import com.vaadin.ui.Label
import com.vaadin.ui.VerticalLayout

class OtherSecurePage : VerticalLayout(), View {
    private val otherSecure: Label
    private val mainsecure: Button

    init {
        mainsecure = Button("Main Secure Area")
        mainsecure.addClickListener(object : ClickListener {
            private val serialVersionUID = 1L

            override fun buttonClick(event: ClickEvent) {
                Page.getCurrent().uriFragment = "!" + SecurePage.NAME
            }
        })
        otherSecure = Label("Other Secure Page ...")
        addComponent(otherSecure)
        addComponent(mainsecure)
    }

    override fun enter(event: ViewChangeEvent?) {

    }

    companion object {

        private val serialVersionUID = 1L
        val NAME = "OtherSecure"
    }

}