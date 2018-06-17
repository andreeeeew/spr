package application.model.Person.Status

import application.model.Person.Osoba
import javax.persistence.*

@Entity
abstract class Pracownik(osoba: Osoba) : Status(osoba) {

    @Id
    @GeneratedValue
    private val id: Long? = null

    @Transient
    override val statusType = StatusType.PRACOWNIK

    override fun toString(): String = statusType.toString()
}