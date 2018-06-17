package application.model.Person.Status

import application.model.Person.Osoba
import javax.persistence.*

enum class StatusType
{
    KLIENT,
    WLASCICIEL_SKLEPU,
    PRACOWNIK
}

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
abstract class Status(
        @ManyToOne(cascade = [CascadeType.MERGE])
        var osoba: Osoba) {
    @Id
    @GeneratedValue
    private val id: Long? = null

    abstract val statusType: StatusType
    fun hasStatus(statusType: StatusType) = this.statusType == statusType
}