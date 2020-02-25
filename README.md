# Evaluación

### Capas de la aplicación

#### Modelo

	Todas las clases dentro del paquete Dominio,
	Contiene las representaciones(abstracciones) de las peliculas y series para representar la lógica de negocio.
	
###### Genero
###### Pelicula
###### Serie
###### ItemCatalogo
###### Lenguajes
###### Video

#### Vista
  Todas las clases dentro del paquete UI , cada una de ellas se encarga de controlar la interacción 
  de la aplicación con los usuarios y de la interfaz con los datos de aplicación.
	Cada uno de los fragments hereda de la clase generico y tiene su propio controlador de vista para
	gestionar los datos relacionados con la IU.
	Las clases Generico y GenericoViewModel brindan la estructura principal de los fragments y su comportamiento.	
###### Dialogo
###### DialogoVideo
###### Estrenos
###### EstrenosViewModel
###### Generico
###### GenericoViewModel
###### Inicio
###### InicioViewModel
###### ListaCatalogo
###### ListaDetalle
###### PropiedadLista
###### Peliculas
###### PeliculasViewModel
###### Populares
###### PopularesViewModel
###### SeriesEstreno
###### SeriesEstrenoViewModel
###### SeriesMasValoradas
###### SeriesMasValoradasViewModel
###### SeriesPopulares
###### SeriesPopularesViewModel

#### Controlador
 Todas las clases dentro del paquete controlador,
 Es el comunicador bidireccional entre la vista y el modelo, como asi tambien la comunicación con los servicios de persistencia
 y las transformaciones necesarias para actuar el la aplicación.
###### MainActivity
###### ControladorGeneros
###### ControladorLista
###### ControladorPeliculas
###### ControladorSeries
###### Formato

#### Servicios
	Todas las clases dentro del paquete API,
	Se encarga de comunicarse con el servicio de API REST de TMDB y servir a los controladores.

###### ControladorAPI
###### ServicioAPI
###### RespuestaVideoAPI
###### RespuestaPeliculaAPI
###### RespuestaSerieAPI
###### RespuestaGeneroAPI
---------------------------------------------------------------------------
### Principio de Responsabilidad Única

El principio de Responsabilidad Única es uno de los principios SOLID ,
mi apreciación de este principio es que las clases tienen que tener una responsabilidad definida
y no debe un mismo objeto realizar metodos u operaciones que sobrepasen los limites de esta responsabilidad.
Es decir cada clase debe de hacer su trabajo y delegar a las demás aquellas cosas que no se encuentren bajo su responsabilidad.
No existe una forma exacta para saber si se esta violando este principio , pero se debe tratar de modularizar , y no
otorgarle a las clases responsabilidades excesivas o que no tengan que ver con su capa.

### Código Limpio

Más alla de las características técnicas o de performance , para realizar una aplicación de software se debe trabajar en equipo.
Por lo que en mi opinión un código limpio es aquel que además de cumplir con su especificación , debe ser legible por
los otros miembros del equipo de trabajo, para así evitar el retrabajo y fomentar la reutilización de código.
Para esto se debe tratar de respetar ciertos estándares y reglas comunes , un código que no respete un buen diseño quizas no sea
interpretable por otra persona y no se considere un buen código o código limpio.
