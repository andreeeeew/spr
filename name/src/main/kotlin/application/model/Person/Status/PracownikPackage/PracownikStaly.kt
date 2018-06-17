package application.model.Person.Status.PracownikPackage


import application.model.Person.Osoba
import application.model.Person.Status.Pracownik
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

enum class UmowaType{//TODO show on diagram
    ZLECENIE,
    DZIELO,
    PRACA
}

@Entity
class PracownikStaly(osoba: Osoba,
                     val login: String,
                     val password: String,
                     val rodzajUmowy: UmowaType) : Pracownik(osoba) {

    constructor(
            pracownik: Pracownik,
            login: String,
            password: String,
            rodzajUmowy: UmowaType
    ) : this(pracownik.osoba, login, password, rodzajUmowy)

    @Id
    @GeneratedValue
    private val id: Long? = null


}