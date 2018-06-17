package application.repositories


import application.model.Sklep.Sklep
import org.springframework.transaction.annotation.Transactional

@Transactional
interface SklepRepository : SklepBaseRepository<Sklep> {
}