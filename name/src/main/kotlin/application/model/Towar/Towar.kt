package application.model.Towar

import application.model.Firma.Firma
import java.util.*
import java.time.LocalDate;
import javax.persistence.*

@Entity @Table(name = "towar")
data class Towar(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
            val towarID: Long = 0,
        val nazwa: String,
        val waga: Int = 0,
        val cenaZakupu: Int = 0,
        val proba: Int = 0,
        val rozmiar: Int = 0,
        val dataOtrymania: LocalDate = LocalDate.now(),
        val zlotyCzySrebry: Boolean = true) {


    var dataSprzedazy: Date? = null

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "firma_firmaID")
    var firma: Firma? = null
    set(value) {
        if (field == value)
            return

        if (field != null) {
            field!!.usunTowar(this)
        }

        field = value

        if (value != null)
            value.dodajTowar(this)
    }




//    companion object {
//            val maksymalnaLiczbaZarezerwowanychTowarow: Int = 7
//            var ostatnieIdTowaru = 1
//            var towarEkstensja: TreeMap<Long, Towar> = TreeMap<Long, Towar>()
//
//            fun DodajTowar(towar: Towar) {
//                if (!towarEkstensja.contains(towar.towarID))
//                    towarEkstensja.put(towar.towarID, towar)
//            }
//
//            fun UsunTowar(towar: Towar) {
//                if (towarEkstensja.containsKey(towar.towarID)) {
//                    towarEkstensja.remove(towar.towarID)
//                } else {
//                    throw Exception("No such element")
//                }
//            }
//
//    }

    //    var rezerwacji: ArrayList<Rezerwacja> = ArrayList<Rezerwacja>()

//    init {
//        towarID = Towar.ostatnieIdTowaru++
//        towarEkstensja.put(towarID, this)
//    }

//    fun czyJestAktualnieZarezerwowany(): Boolean{
//        if (rezerwacji.size == 0)
//            return false
//        if (rezerwacji[rezerwacji.size - 1].dataSkonczeniaRezerwacji <= LocalDate.now())
//            return false
//        return true
//}

//    fun dodajRezerwacje(rezerwacja: Rezerwacja){
//        rezerwacji.add(rezerwacja)
//    }

//    fun usunRezerwacje(rezerwacja: Rezerwacja) {
//        rezerwacji.remove(rezerwacja)
//    }

}