package application



import application.model.Person.DaneOsobowe
import application.model.Person.Osoba
import application.model.Person.Status.PracownikPackage.PracownikStaly
import application.model.Person.Status.PracownikPackage.UmowaType
import application.repositories.Klasa
import application.repositories.OsobaRepository
import application.repositories.PracownikRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Import
import java.time.LocalDate

@SpringBootApplication
@Import({ Klasa.class })
open class Application{

    @Bean
    fun init(osobaRepository: OsobaRepository, pracownikRepository: PracownikRepository) = CommandLineRunner {
        var daneOsobowe = DaneOsobowe('M', "3123312", "email@at.com", "Jan", "Kowalski", LocalDate.now())
//        daneOsoboweRepository.save(daneOsobowe)
        var osoba = Osoba(null, daneOsobowe)
        osobaRepository.save(osoba)

//        var praktykant = Praktykant(osoba, LocalDate.now(), LocalDate.now())
//        pracownikRepository.save(praktykant)

        var pracownikStaly = PracownikStaly(osoba, "log1", "pass1", UmowaType.DZIELO)
        pracownikRepository.save(pracownikStaly)


        pracownikRepository.findAll().forEach { print("sukableat") }



        osobaRepository.findAll().forEach { print("DONEEE") }
        while(true);

    }
}

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)

}