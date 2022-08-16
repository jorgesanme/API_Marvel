#Api_marvel


## Descripción
Prueba técnica realizada durante un proceso de selección [Test.pdf](https://github.com/jorgesanme/API_Marvel/blob/main/Images/Prueba%20t%C3%A9cnica%20mobile.pdf)

Como su nombre ya indica, esta app consume  datos obtenidos desde  [Marvel](https://developer.marvel.com/docs)

## Explicación de la app:
La app muestra los datos más identificativos de los personajes de Marvel en una CardView.  El conjunto de CardView se muestra en la un RecycleView.

<img src="https://github.com/jorgesanme/API_Marvel/blob/main/Images/start.gif" width="200" height="350" />

A partir de una tarjeta, se pasa el Id de cada personaje a la pantalla de Detalles. En esta pantalla se llama nuevamente a la API para obtener los detalles del mismo.

<img src="https://github.com/jorgesanme/API_Marvel/blob/main/Images/detail.gif" width="200" height="350" />

## Librerias

Para ello se ha usado:
- **Okhttp3**  => Punto de inicio de las llamadas a red.
- **Retrofit**  => Llamadas a red para descargar datos más simplificadas. La construción de la url de llamadas es + simple
- **Binding** => Eliminar código repetitivo en la vinculación de código con las views del xml.

- **Glide**  => Evitar parcear un stream de datos a Bitmap en la descarga de las imagenes desde http. Tiene Cache de imagen y aporta funcionalidad para modificar los bordes redondeados.
- **Coroutines** => Trabajar en Async en background para no bloquear el hilo main de la UI.
- **Moshi** => Parceador de archivos JSon al modelo de datos. 
- **Lifecycle** => Crea más facilmente el viewModel y con ella desacoplar la lógica de la vista. Flujo de información en una sola dirección.   
