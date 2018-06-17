package application.model.Person.Status

import org.springframework.data.jpa.repository.JpaRepository
import javax.persistence.*

@Entity
class A(@Id
        @GeneratedValue
        var id: Long? = null,
        @OneToOne(mappedBy = "aref", fetch = FetchType.LAZY)
        var bref: B?){
}

@Entity
class B(@Id
        @GeneratedValue
        var id: Long? = null,
        @OneToOne(fetch = FetchType.LAZY)
        var aref: A?){

}

interface ARepository : JpaRepository<A, Long>
interface BRepository : JpaRepository<B, Long>