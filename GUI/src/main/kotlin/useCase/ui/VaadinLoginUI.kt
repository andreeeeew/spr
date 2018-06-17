package useCase.ui



import application.model.Person.DaneOsobowe
import application.model.Person.Osoba
import application.repositories.OsobaRepository
import com.vaadin.server.VaadinRequest
import com.vaadin.spring.annotation.SpringUI
import com.vaadin.ui.Notification
import com.vaadin.ui.UI
import useCase.mygui.Authentication
import useCase.mygui.LoginPage
import useCase.mygui.OtherSecurePage
import useCase.mygui.SecurePage
import java.time.LocalDate


@SpringUI
class VaadinloginUI(
                    val osobaRepository: OsobaRepository) : UI() {




    override fun init(request: VaadinRequest) {
//        populateDb()
//
//        VaadinloginUI.AUTH = Authentication()
//        Navigator(this, this)
//
//        navigator.addView(LoginPage.NAME, LoginPage::class.java)
//        navigator.setErrorView(LoginPage::class.java)
//
//        Page.getCurrent().addUriFragmentChangedListener { event -> router(event.uriFragment) }
//
//
//        router("")
    }

    private fun populateDb() {
        println("in the begining")
        var daneOsobowe = DaneOsobowe('M', "3123312", "email@at.com", "Jan", "Kowalski", LocalDate.now())
//        daneOsoboweRepository.save(daneOsobowe)
        var osoba = Osoba(null, daneOsobowe)
        osobaRepository.save(osoba)

        println("in the middle")
//        var praktykant = Praktykant(osoba, LocalDate.now(), LocalDate.now())
//        pracownikRepository.save(praktykant)

//        var pracownikStaly = PracownikStaly(osoba, "log1", "pass1", UmowaType.DZIELO)
//        pracownikRepository.save(pracownikStaly)


//        pracownikRepository.findAll().forEach { print("sukableat") }
    }

    private fun router(route: String) {
        Notification.show(route)
        if (session.getAttribute("user") != null) {
            navigator.addView(SecurePage.NAME, SecurePage::class.java)
            navigator.addView(OtherSecurePage.NAME, OtherSecurePage::class.java)
            if (route == "!OtherSecure") {
                navigator.navigateTo(OtherSecurePage.NAME)
            } else {
                navigator.navigateTo(SecurePage.NAME)
            }
        } else {
            navigator.navigateTo(LoginPage.NAME)
        }
    }

    companion object {

        lateinit var AUTH: Authentication
    }

}