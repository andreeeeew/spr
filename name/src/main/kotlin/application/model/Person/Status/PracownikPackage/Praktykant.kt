package application.model.Person.Status.PracownikPackage

import application.model.Person.Osoba
import application.model.Person.Status.Pracownik
import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Praktykant(osoba: Osoba,
                 dataRozpoczeciaStazu: LocalDate,
                 dataZakonczeniaStazu: LocalDate) : Pracownik(osoba) {
    @Id
    @GeneratedValue
    private val id: Long? = null

}