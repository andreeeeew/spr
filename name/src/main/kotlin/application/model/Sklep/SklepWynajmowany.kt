package application.model.Sklep

import application.model.Person.Status.WlascicielSklepu
import java.time.LocalDate
import javax.persistence.*

@Entity @Table(name = "SklepWynajmowany")
data class SklepWynajmowany(override var nazwa: String,
                       override var miasto: String,
                       override var adres: String,
                       var czynsz: Int,
                       var dataRozpoczeciaWynajowania: LocalDate,
                       var czasWypowiedzenia: Int) : Sklep(nazwa = nazwa, miasto = miasto, adres = adres) {


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "wlascicielSklepu_sklepID")
    var wlascicielSklepu: WlascicielSklepu? = null
//        set(value) {
//
//            if (value == field)
//                return
//
//            if (field != null) {
//                    field!!.removeSklepWynajmowanyAndOwner(this)
//            }
//
//
//            field = value
//            if (field != null)
//                field!!.addSklepWynajmowanyAndOwner(this)
//        }


    companion object {
        var currentIdSklepu: Int = 0
    }

}