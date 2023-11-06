class TipoArticulo {
    //creo enumerados para establecer los articulos que se permiten comprar
    enum class IngredientesExtra(val nombre:String,val precio: Float) {
        Null("Null",0f),
        QuesoGouda("QuesoGouda",1.5f),
        QuesoEdam("QuesoEdam",2f),
        QuesoRoquefort("QuesoRoquefort",3f),
        QuesoCabrales("QuesoCabrales",3f),
        QuesoCrema("QuesoCrema",2.4f),

        Pepperoni("Pepperoni",2f),
        Pollo("Pollo",3f),
        Pina("Pina",1f),
        Salmon("Salmon",4f),
        Bacon("Bacon",2f),
        CarnePicada("CarnePicada",3.4f),
        Jamon("Jamon",1f),
        Champinones("Champinones",1f),


    }

    public enum class Pizzas(val nombre:String,val precio: Float) {
        QuesoPepperoni("QuesoPepperoni",13.5f),
        Margarita("Margarita",10.2f),
        Hawaiana("Hawaiana",13.5f),
        Pollo("Pollo",15.1f),
        Napolitana("Napolitana",18f),
        QuatroQuesos("QuatroQuesos",17f),
        SalmónAhuQuesoCrema("SalmónAhuQuesoCrema",20f),
        Carbonara("Carbonara",15f),
        Barbacoa("Barbacoa",15.5f),
        Calzone("Calzone",19f);

    }

    enum class Bebidas(val nombre:String,val precio: Float) {
        Null("Null",0f),
        Agua("Agua",0.8f),
        Cola("Cola",1.8f),
        Naranja("Naranja",1.4f),
        Limon("Limon",1.2f),
        Cebada("Cebada",2.3f),
        Tonica("Tonica",1.5f),
    }
    enum class Entrantes(val nombre:String,val precio: Float) {
        Null("Null",0f),
        Nuggets("Nuggets",4.8f),
        Chips("Chips",2.8f),
        Onion_rings("Onion_rings",1.4f),
        Cheese_fingers("Cheese_fingers",3.2f),
        Croquetas("Croquetas",5.3f),
        Octopuss("Octopuss",11.5f),
    }
}

// clase articulo que recoje cualquier tipo de enum para poder trabajar con los que hemos creado y su cantidad
data class Articulo(
    val tipo: Enum<*>,
    val cantidad: Int?,
    val ingredienteExtra: Enum<*>?
) {
    val nombre: String
        get() {
            return when (tipo) {
                is TipoArticulo.IngredientesExtra -> (tipo as TipoArticulo.IngredientesExtra).nombre
                is TipoArticulo.Pizzas ->  (tipo as TipoArticulo.Pizzas).nombre
                is TipoArticulo.Bebidas -> (tipo as TipoArticulo.Bebidas).nombre
                is TipoArticulo.Entrantes -> (tipo as TipoArticulo.Entrantes).nombre
                else -> "Desconocido"
            }
        }
    val precio: Float
        get() {
            return when (tipo) {
                is TipoArticulo.IngredientesExtra -> (tipo as TipoArticulo.IngredientesExtra).precio
                is TipoArticulo.Pizzas -> (tipo as TipoArticulo.Pizzas).precio
                is TipoArticulo.Bebidas -> (tipo as TipoArticulo.Bebidas).precio
                is TipoArticulo.Entrantes -> (tipo as TipoArticulo.Entrantes).precio
                else -> 0f
            }
        }

    fun precioTotalArticulo(): Float {
        return when (tipo) {
            is TipoArticulo.IngredientesExtra -> (tipo as TipoArticulo.IngredientesExtra).precio * (cantidad ?: 0)
            is TipoArticulo.Pizzas -> {
                val pizza = tipo as TipoArticulo.Pizzas
                val ingrediente = ingredienteExtra as? TipoArticulo.IngredientesExtra
                val precioPizza = pizza.precio
                val precioIngrediente = ingrediente?.precio ?: 0f
                cantidad?.toFloat() ?: 0f * (precioPizza + precioIngrediente)
            }
            is TipoArticulo.Bebidas -> (tipo as TipoArticulo.Bebidas).precio * (cantidad ?: 0)
            is TipoArticulo.Entrantes -> (tipo as TipoArticulo.Entrantes).precio * (cantidad ?: 0)
            else -> 0f
        }
    }
}


class Pedido(var articulos: MutableList<Articulo>) {
    var precioTotal = 0F
    var numPedido: Int = 1

    /*
    Cada articulo se introduce en el ticket finaL
     */
    fun ticket() {
        println("Ticket del pedido : " + numPedido)
        for (articulo in articulos) {
            val precioArticulo = articulo.precioTotalArticulo()
            precioTotal += precioArticulo
            if (articulo.tipo == articulo.ingredienteExtra) {
                println(" ## EXTRAS ## ")
                println("${articulo.tipo}\t${articulo.cantidad}uds:\t${precioArticulo} $")

            }
            println("${articulo.tipo}\t${articulo.cantidad}uds:\t${precioArticulo} $")
        }
        println("Total : ${precioTotal}")
        numPedido++
    }

}


