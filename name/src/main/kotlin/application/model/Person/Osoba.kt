package application.model.Person

import application.model.Person.Status.Status
import org.hibernate.annotations.LazyCollection
import org.hibernate.annotations.LazyCollectionOption
import javax.persistence.*

@Entity
data class Osoba(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long?,
        @OneToOne(fetch = FetchType.EAGER, cascade = [CascadeType.ALL])
        val daneOsobowe: DaneOsobowe){

        @LazyCollection(LazyCollectionOption.FALSE)
        @OneToMany(mappedBy = "osoba", orphanRemoval = true, cascade = [CascadeType.ALL])
        lateinit var statuses: MutableSet<Status>

}