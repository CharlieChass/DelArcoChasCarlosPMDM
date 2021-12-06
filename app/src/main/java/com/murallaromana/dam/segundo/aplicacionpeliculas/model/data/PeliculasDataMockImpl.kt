package com.murallaromana.dam.segundo.aplicacionpeliculas.model.data

import com.murallaromana.dam.segundo.aplicacionpeliculas.model.entidades.Pelicula
import java.util.*
import kotlin.collections.ArrayList

 open class PeliculasDataMockImpl : PeliculasData {
    override fun getTodos() = mutableListOf(
                    Pelicula(
                        "Venom: Habrá Matanza",
                        "Acción",
                        "Andy Serkis",
                        7.8,
                        "698745213",
                        "https://es.web.img3.acsta.net/c_310_420/pictures/21/08/31/16/41/4145554.jpg",
                        "Eddie Brock (Tom Hardy) y su simbionte Venom todavía están intentando descubrir cómo vivir juntos cuando un preso que está en el corredor de la muerte (Woody Harrelson) se infecta con un simbionte propio."
                    ),
                    Pelicula(
                        "Clifford, el gran perro rojo",
                        "Comedia",
                        "Walt Becker",
                        7.6,
                        "87765645",
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/kW5JBtCGnIwBS1SD4sMXu8gee4U.jpg",
                        "Cuando Emily Elizabeth conoce a un rescatador mágico de animales que le regala un pequeño cachorro rojo, nunca se hubiera imaginado que al despertarse se encontraría un sabueso gigante de tres metros en su pequeño apartamento de Nueva York. Mientras su madre soltera se encuentra de viaje de negocios, Emily y su divertido pero impulsivo tío Casey se embarcan en una gran aventura."
                    ),
                    Pelicula(
                        "Shang-Chi y la leyenda de los Diez Anillos",
                        "Acción",
                        "Destin Daniel Cretton",
                        7.9,
                        "8765464",
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/9VqajJXm29uprSaxOcEh7O0d6E9.jpg",
                        "Adaptación cinematográfica del héroe creado por Steve Englehart y Jim Starlin en 1973, un personaje mitad chino, mitad americano, cuyo característico estilo de combate mezclaba kung-fu, nunchacos y armas de fuego."
                    ),
                    Pelicula(
                        "Encanto",
                        "Familia",
                        "Byron Howard",
                        7.4,
                        "65443453",
                        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/pZc0GpA8jPTwqHuABnSW6XwvWAi.jpg",
                        "\"Encanto\" relata la historia de los Madrigal, una familia extraordinaria que vive en una casa mágica de un pueblo vibrante en las montañas de Colombia escondidas en un “Encanto”. La magia del Encanto ha bendecido a cada niño de la familia con un don único, desde la superfuerza hasta el poder de sanar. A todos, excepto Mirabel, quien desea ser tan especial como el resto de su familia. Pero cuando la magia que rodea al Encanto está en peligro, Mirabel decide que ella, la única Madrigal sin ningún tipo de don único, puede ser la única esperanza de su excepcional familia."
                    )
    )
}