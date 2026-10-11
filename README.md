# IAtlas 🧭

> El mapa de tus IAs: apunta qué haces en cada asistente (ChatGPT, Claude, Gemini, Perplexity…) y para qué, y ve de un vistazo cómo repartes tu uso.

![Kotlin](https://img.shields.io/badge/Kotlin-2.x-7F52FF?logo=kotlin&logoColor=white)
![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-Material%203-4285F4?logo=jetpackcompose&logoColor=white)
![Min SDK](https://img.shields.io/badge/minSdk-26-3DDC84?logo=android&logoColor=white)
![Estado](https://img.shields.io/badge/estado-en%20desarrollo-orange)

<!-- TODO (Fase 10): sustituir por capturas reales o un GIF -->
<p align="center"><i>Capturas próximamente</i></p>

## 🤔 El problema

Mucha gente usa varias IAs a la vez, a menudo aprovechando planes gratuitos, y para cosas muy distintas: estudios, trabajo, proyectos personales. Cada asistente tiene su propio sistema para organizar (Proyectos en ChatGPT, Spaces en Perplexity, Gems en Gemini…), pero ninguno ve lo que hay en los demás. Al final acabas preguntándote: *¿dónde tenía yo las fotos de producto, en ChatGPT o en Claude?*

## 💡 La solución

IAtlas es un índice personal y local. No se conecta a ninguna IA: tú registras **qué haces**, **en qué IA** y **para qué ámbito**, y la app te lo organiza. Además, reúne en una pestaña las novedades de los blogs oficiales de cada IA.

## ✨ Funcionalidades

- [ ] Registrar entradas: título, descripción, IA, categoría y enlace opcional al chat/proyecto
- [ ] Categorías personalizables (Estudio, E-commerce, Personal…)
- [ ] Agrupar la lista por IA o por categoría
- [ ] Filtros con chips y búsqueda por texto
- [ ] Marcar favoritos
- [ ] Guardar un enlace compartiéndolo desde la app de ChatGPT, Claude, etc. (menú *Compartir* de Android)
- [ ] Abrir el chat original con un toque
- [ ] Noticias de los blogs oficiales de cada IA, filtrables y disponibles sin conexión
- [ ] Tema claro/oscuro y color propio para cada IA
- [ ] Exportar/importar copia de seguridad en JSON

## 🛠️ Stack técnico

| Área | Tecnología |
|---|---|
| Lenguaje | Kotlin |
| UI | Jetpack Compose + Material 3, con diseño propio "síntesis" ([docs/DISENO.md](docs/DISENO.md)) |
| Arquitectura | MVVM (ViewModel + StateFlow) + Repository |
| Persistencia | Room (SQLite) |
| Red | Ktor Client + XmlPullParser (RSS) |
| Preferencias | DataStore |
| Navegación | Navigation Compose |
| Tests | JUnit, tests de Room y del ViewModel |
| CI | GitHub Actions (build + tests en cada PR) |

Más detalle en [docs/ARQUITECTURA.md](docs/ARQUITECTURA.md).

## 🚀 Cómo ejecutarlo

1. Clona el repositorio:
   ```bash
   git clone https://github.com/txema9/iatlas.git
   ```
2. Ábrelo con Android Studio (versión reciente).
3. Espera a que Gradle sincronice y pulsa **Run ▶** con un emulador o un dispositivo (Android 8.0+).

También puedes descargar el APK desde la sección [Releases](../../releases).

## 🗺️ Roadmap

El desarrollo va por fases, cada una en su rama y su Pull Request. Ver [docs/ROADMAP.md](docs/ROADMAP.md).

## 📚 Sobre este proyecto

Lo construyo mientras aprendo Kotlin y Jetpack Compose en el ciclo formativo (asignatura de Programación Multimedia), partiendo de una base en Java. Uso Claude Code como **tutor**, no como generador: el código lo escribo yo, y el asistente me explica, revisa y propone. Lo que voy aprendiendo queda en [docs/DIARIO.md](docs/DIARIO.md).

## 👤 Autor

**Jose Perez Herrera** · [LinkedIn](https://linkedin.com/in/jose-perez-herrera) · [GitHub](https://github.com/txema9)

## 📄 Licencia

MIT. Ver [LICENSE](LICENSE).
