package application.repositories


import application.model.Person.Status.Pracownik
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PracownikRepository : JpaRepository<Pracownik, Long>