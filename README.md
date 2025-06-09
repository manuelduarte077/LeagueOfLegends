# League of Legends Champions App

Esta aplicación móvil para Android muestra información detallada sobre los campeones de League of Legends, utilizando la API pública de Riot Games (Data Dragon).

## Características

- Lista de todos los campeones de League of Legends
- Búsqueda de campeones por nombre
- Vista detallada de cada campeón con:
  - Imagen splash art
  - Información general (nombre, título, tags)
  - Historia del campeón (lore)
  - Habilidad pasiva
  - Habilidades (Q, W, E, R)

## Arquitectura

La aplicación está construida siguiendo los principios de Clean Architecture y MVVM (Model-View-ViewModel), organizando el código en tres capas principales:

### 1. Capa de Presentación (presentation)

Contiene las interfaces de usuario (UI) y los ViewModels:

- **Screens**: Pantallas principales de la aplicación
  - `champion_list`: Lista de campeones con búsqueda
  - `champion_details`: Detalles completos de un campeón seleccionado
- **ViewModels**: Manejan la lógica de presentación y el estado de la UI
  - `ChampionListViewModel`: Gestiona la lista de campeones y la búsqueda
  - `ChampionDetailsViewModel`: Gestiona los detalles de un campeón específico

### 2. Capa de Dominio (domain)

Contiene la lógica de negocio y los modelos de datos:

- **Models**: Clases de datos que representan la información de los campeones
  - `ChampionModel`: Información completa de un campeón
  - `ChampionResponseModel`: Respuesta de la API con la lista de campeones
  - `ImageModel`: Información de las imágenes
  - `PassiveModel`: Información de la habilidad pasiva
  - `SpellModel`: Información de las habilidades
- **Repository Interfaces**: Define los contratos para acceder a los datos
  - `ApiRepository`: Interface para las operaciones de la API

### 3. Capa de Datos (data)

Implementa el acceso a datos y la comunicación con APIs externas:

- **Repository Implementations**: Implementaciones concretas de los repositorios
  - `ApiRepositoryImpl`: Implementación del repositorio para la API de League of Legends
- **Dependency Injection**: Configuración de inyección de dependencias
  - `AppModule`: Proporciona las dependencias necesarias para la aplicación

## Tecnologías Utilizadas

- **Kotlin**: Lenguaje de programación principal
- **Jetpack Compose**: Framework moderno para la UI declarativa
- **Hilt**: Inyección de dependencias
- **Ktor Client**: Cliente HTTP para comunicación con la API
- **Kotlinx Serialization**: Serialización/deserialización de JSON
- **Coil**: Carga y caché de imágenes
- **Sandwich**: Manejo de respuestas de API
- **Navigation Compose**: Navegación entre pantallas

## Estructura de Navegación

La aplicación utiliza Navigation Compose para la navegación entre pantallas:

- `ChampionList`: Pantalla inicial que muestra la lista de campeones
- `ChampionDetails(name)`: Pantalla de detalles que muestra información completa de un campeón específico

## API

La aplicación utiliza la API pública de Data Dragon de Riot Games:

- Base URL: `https://ddragon.leagueoflegends.com/cdn/9.19.1/data/en_US/`
- Endpoints:
  - Lista de campeones: `champion.json`
  - Detalles de un campeón: `champion/{name}.json`
- URLs de imágenes:
  - Splash art: `https://ddragon.leagueoflegends.com/cdn/img/champion/splash/`
  - Loading: `https://ddragon.leagueoflegends.com/cdn/img/champion/loading/`
  - Square: `https://ddragon.leagueoflegends.com/cdn/9.19.1/img/champion/`
  - Passive: `https://ddragon.leagueoflegends.com/cdn/9.19.1/img/passive/`
  - Ability: `https://ddragon.leagueoflegends.com/cdn/9.19.1/img/spell/`

## Requisitos

- Android 5.0 (API level 21) o superior
- Conexión a Internet para cargar los datos de los campeones

## Configuración del Proyecto

1. Clona el repositorio
2. Abre el proyecto en Android Studio
3. Sincroniza el proyecto con los archivos Gradle
4. Ejecuta la aplicación en un emulador o dispositivo físico
