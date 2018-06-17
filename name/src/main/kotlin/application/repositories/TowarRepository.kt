package application.repositories

import application.model.Towar.Towar
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TowarRepository : JpaRepository<Towar, Long>{

}