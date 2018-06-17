package application.model.Person.Status

import application.model.Person.Osoba
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class WlascicielSklepu(osoba: Osoba) : Status(osoba) {

    @Id
    @GeneratedValue
    var id: Long? = null

    @Transient
    override val statusType = StatusType.WLASCICIEL_SKLEPU

    override fun toString(): String = statusType.toString()
}
