package application.repositories


import application.model.Person.Osoba
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OsobaRepository : JpaRepository<Osoba, Long>