++Enunciado++

Esta práctica consiste en la implementación de un programa Java para la gestión del almacén de coches en un concesionario. Los coches tendrán los siguientes atributos, id, matricula, marca, modelo y color.

El usuario interactuará con el programa a través del siguiente menú, que servirá como interfaz.

1.Añadir nuevo coche
2.Borrar coche por id
3.Consulta coche por id
4.Listado de coches
5.Exportar coches a archivo de texto
6.Terminar el programa

Nada más comenzar la ejecución del programa se debe verificar si existe el fichero coches.dat (fichero que contendrá objetos Coche). Si existe, debes leerlo para llenar una colección de tipo ArrayList con todos los objetos Coche existentes en el fichero. Si no existe el archivo coches.dat, no tendrás nada que hacer por el momento, pero sí debes dejar la colección ArrayList disponible, aunque esté vacía.

Las opciones del menú 1 a 5 trabajarán sobre la colección de tipo ArrayList para añadir, borrar, consultar o listar, y no sobre el fichero coches.dat.

Cuando el usuario decida terminar la ejecución del programa pulsando la opción 6, el programa deberá crear el fichero coches.dat, sobrescribiendo el anterior si existiera. Se escribirán en el fichero tantos coches como elementos tenga la colección ArrayList que has creado.

Valoración: 10 puntos sobre 10

++Consideraciones++

Para toda la actividad se valorará la claridad de código, la modularidad, la eficiencia de los algoritmos empleados y lo más importante, los comentarios explicativos sobre los puntos clave de la aplicación (JavaDoc o normales, lo que se consideré más apropiado).

Para la entrega, se subirá el código fuente comprimido a la plataforma, incluyendo todo lo necesario para demostrar el correcto funcionamiento de la actividad (resultados, capturas de pantalla, ficheros, fotos, etc.).

No es necesario la creación de un documento formal sobre la actividad, aunque se puede incluir si se cree necesario para mostrar los resultados de la actividad o cualquier aclaración que el alumno estime necesaria.