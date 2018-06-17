package application.repositories

import application.model.Sklep.Sklep
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.NoRepositoryBean

@NoRepositoryBean
interface SklepBaseRepository<T: Sklep> : JpaRepository<T, Int>{

}