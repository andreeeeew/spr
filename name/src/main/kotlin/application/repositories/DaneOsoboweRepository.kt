package application.repositories


import application.model.Person.DaneOsobowe
import org.springframework.data.jpa.repository.JpaRepository

interface DaneOsoboweRepository : JpaRepository<DaneOsobowe, Long>