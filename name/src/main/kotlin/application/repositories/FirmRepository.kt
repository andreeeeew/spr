package application.repositories



import application.model.Firma.Firma
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface FirmRepository : JpaRepository<Firma, Long>{

}