package application.model.Firma

import application.model.Towar.Towar
import javax.persistence.*

@Entity @Table(name = "firma")
data class Firma(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val firmaID: Long = 0,
        val nazwa: String
){

    @OneToMany(mappedBy = "firma", cascade = arrayOf(CascadeType.ALL), fetch = FetchType.EAGER)
    var generatedProducts : MutableList<Towar> = mutableListOf()




    private var towarKwalif = HashMap<Long, Towar>()

    fun dodajTowar(towar: Towar){
        if (towarKwalif.contains(towar.towarID))
            return

        generatedProducts.add(towar)
        towarKwalif.put(towar.towarID, towar)
        towar.firma = this
    }

    fun usunTowar(towar: Towar){
        if (!towarKwalif.contains(towar.towarID))
            return

        generatedProducts.remove(towar)
        towarKwalif.remove(towar.towarID)
        towar.firma = null
    }


//    fun znajdzTowar(idTowaru: Long): Towar? {
//        if (!towarKwalif.contains(idTowaru))
//            throw Exception("Nie odnaleziono towaru o firmaID: ${idTowaru}")
//
//        return towarKwalif.get(idTowaru)
//    }
//
//    fun getIloscWyprodukowanychTowarow(): Int{
//        return towarKwalif.size
//    }

}