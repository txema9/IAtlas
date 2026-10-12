# Roadmap

Cada fase = una rama + un Pull Request + (a veces) una versión. Marca con `[x]` lo terminado.

## Fase 0 · Preparación `v0.0.1`
Rama: `chore/setup`
- [x] Crear proyecto en Android Studio (plantilla *Empty Activity*, que ya trae Compose)
- [x] Recorrido guiado por los archivos generados (ver CLAUDE.md) y primer cambio en `Greeting`
- [x] Crear el emulador (imagen con Google Play) y ejecutar la app por primera vez
- [x] Revisar el `.gitignore` y crear el repo en GitHub
- [x] Añadir README, CLAUDE.md, docs/ y LICENSE
- [x] Primer commit y push
> Aprendes: estructura de un proyecto Android, Gradle, `git init/add/commit/push`

## Fase 1 · UI estática `v0.1.0`
Rama: `feat/static-list`
- [x] Tarjeta `EntryCard` con `@Preview`
- [ ] Lista con `LazyColumn` y datos falsos
- [ ] `Scaffold` con `TopAppBar` y botón flotante
> Aprendes: composables, `Modifier`, `Row`/`Column`, previews, `data class`

## Fase 2 · Estado y ViewModel `v0.2.0`
Rama: `feat/state-viewmodel`
- [ ] Formulario para añadir entrada (en memoria)
- [ ] `remember` / `mutableStateOf` y *state hoisting*
- [ ] Pasar la lista a un `ViewModel` con `StateFlow`
> Aprendes: recomposición, estado, ciclo de vida

## Fase 3 · Navegación `v0.3.0`
Rama: `feat/navigation`
- [ ] Navigation Compose: lista ↔ crear/editar ↔ detalle
- [ ] Pasar el id de la entrada como argumento
> Aprendes: `NavHost`, rutas, back stack

## Fase 4 · Persistencia `v0.4.0`
Rama: `feat/room`
- [ ] Entities `AiTool`, `Category`, `Entry`
- [ ] DAOs con `Flow` y `AppDatabase`
- [ ] Repository y datos iniciales
> Aprendes: Room, anotaciones, corrutinas (`suspend`), `Flow`

## Fase 5 · Organizar `v0.5.0`
Rama: `feat/filters`
- [ ] Agrupar por IA o por categoría (cabeceras en la lista)
- [ ] Chips de filtro y búsqueda
- [ ] Favoritos
- [ ] Gestión de categorías e IAs
> Aprendes: consultas combinadas, `combine` de Flows, estado de UI más complejo

## Fase 6 · Integración con Android `v0.6.0`
Rama: `feat/share-intent`
- [ ] Recibir enlaces desde el menú *Compartir* (`ACTION_SEND`)
- [ ] Detectar la IA por el dominio del enlace (chatgpt.com → ChatGPT…)
- [ ] Abrir el enlace guardado
> Aprendes: Intents, `AndroidManifest`, intent-filters

## Fase 7 · Noticias `v0.7.0`
Rama: `feat/news`
- [ ] Barra de navegación inferior: Mi mapa · Noticias
- [ ] Permiso `INTERNET` en el `AndroidManifest`
- [ ] Descargar los RSS de los blogs oficiales con Ktor Client (comprobar al empezar la fase que cada fuente sigue publicando RSS)
- [ ] Convertir el XML en objetos `NewsItem` con `XmlPullParser`
- [ ] Estados de carga, error y sin conexión; deslizar para actualizar
- [ ] Guardar la última descarga en Room para verlas sin conexión
- [ ] Filtrar por IA y abrir la noticia en el navegador
> Aprendes: red y HTTP, corrutinas con `Dispatchers.IO`, parseo de XML, manejo de errores, caché local

## Fase 8 · Pulido `v0.8.0`
Rama: `feat/polish`
- [ ] Tema propio según `docs/DISENO.md`, modo oscuro, color por IA
- [ ] Estados vacíos y mensajes de confirmación (Snackbar, deshacer borrado)
- [ ] Preferencias con DataStore (agrupación por defecto)
> Aprendes: theming, UX, DataStore

## Fase 9 · Calidad `v0.9.0`
Rama: `test/core`
- [ ] Tests del ViewModel, de los DAO y del parser de noticias (con un XML de ejemplo)
- [ ] GitHub Actions: compilar y pasar tests en cada PR
> Aprendes: testing, CI

## Fase 10 · Lanzamiento `v1.0.0`
Rama: `release/1.0`
- [ ] Capturas/GIF en el README
- [ ] Release en GitHub con el APK
- [ ] Revisar documentación y limpiar comentarios
- [ ] Fijar el repo en tu perfil de GitHub

## 💭 Ideas futuras (no tocar hasta la v1.0)
- **Recomendador "¿Qué IA uso?"** basado en tus propios datos: eliges un ámbito o tarea y te muestra qué IAs has usado para eso y cuántas veces, con acceso directo. Sin APIs y sin quedarse desfasado. Enseña consultas agregadas en Room (`GROUP BY`, `COUNT`). Sería una tercera pestaña.
- Avisos de noticias nuevas en segundo plano (WorkManager + notificaciones)
- Etiquetas libres
- Exportar/importar JSON
- Estadísticas (cuántas entradas por IA/categoría)
- Recordatorio de renovación de planes de pago
- Migrar a Hilt
- Versión del README en inglés
