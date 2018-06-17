package application.repositories


import application.model.Sklep.SklepWynajmowany
import org.springframework.transaction.annotation.Transactional

@Transactional
interface SklepWynajmowanyRepository : SklepBaseRepository<SklepWynajmowany>{}