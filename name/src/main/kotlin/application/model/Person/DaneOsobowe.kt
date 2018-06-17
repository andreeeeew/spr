package application.model.Person

import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id


@Entity
data class DaneOsobowe(
        val plec: Char,
        var numerTelefonu: String,
        var email: String,
        var imie: String,
        var nazwisko: String,
        val dataUrodzenia: LocalDate
        ){
    @Id
    @GeneratedValue
    val id: Long? = null
}