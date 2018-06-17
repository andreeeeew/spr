package application.model.Sklep

import javax.persistence.*

@Entity
@Inheritance
open class Sklep(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var sklepID: Int = 0,
        open var nazwa: String,
        open var miasto: String,
        open var adres: String){

}