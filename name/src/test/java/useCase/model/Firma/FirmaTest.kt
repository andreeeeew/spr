package application.model.Firma


import application.model.Towar.Towar
import org.junit.Test

class FirmaTest {
    @Test
    fun createConnection(){
        var firma = Firma(nazwa = "firmaName")
        var towar = Towar(nazwa = "towar")

        towar.firma = firma

        assert(towar.firma == firma)
        assert(firma.generatedProducts.size == 1)
        assert(firma.generatedProducts.contains(towar))

        towar.firma = null
        assert(towar.firma == null)
        assert(firma.generatedProducts.size == 0)


    }

}