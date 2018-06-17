package application.model.Person.Status

import application.model.Person.Osoba
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Klient(osoba: Osoba) : Status(osoba) {

    @Id
    @GeneratedValue
    private val id: Long? = null

    @Transient
    override val statusType = StatusType.KLIENT

    override fun toString(): String = statusType.toString()
}