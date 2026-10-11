# Arquitectura

## Visión general (MVVM)

```
UI (Composables)  ──eventos──▶  ViewModel  ──▶  Repository  ──▶  Room (DAO → SQLite)
      ▲                             │                 │
      └──────── StateFlow ◀─────────┘                 └──▶  RSS (Ktor) · solo Noticias
```

- **UI**: solo pinta el estado y avisa de lo que hace el usuario. Sin lógica de negocio.
- **ViewModel**: guarda el estado de la pantalla (`StateFlow<UiState>`) y sobrevive a la rotación.
- **Repository**: punto único de acceso a datos. La UI no sabe que existe Room.
- **Room**: base de datos local. Los DAO devuelven `Flow`, así la UI se actualiza sola.
- **Red (solo Noticias)**: `NewsRepository` descarga los RSS, los guarda en Room y la UI siempre lee de Room. Así, sin conexión se ve lo último descargado (patrón *offline first*).

> 🔁 Para alguien que viene de Java: es la misma idea de separar capas (como modelo/controlador/vista), pero la UI **reacciona** a cambios de estado en vez de actualizarla tú a mano.

## Modelo de datos

```
AiTool                Category              Entry
──────                ────────              ─────
id                    id                    id
name ("ChatGPT")      name ("Estudio")      title
colorHex              icon                  description
url                                         aiToolId   → AiTool
feedUrl (opcional)
plan (FREE/PAID)                            categoryId → Category
                                            link (opcional)
                                            isFavorite
                                            createdAt
                                            updatedAt

NewsItem (caché de noticias)
────────
id (url del artículo)
aiToolId → AiTool
title
summary
url
publishedAt
```

- Al instalar, la app crea las IAs más comunes (ChatGPT, Claude, Gemini, Perplexity) y algunas categorías de ejemplo. El usuario puede añadir más.
- Relación: una IA y una categoría tienen muchas entradas (1:N).
- Cada IA tiene, además, la dirección de su RSS oficial (`feedUrl`, opcional) para la sección de Noticias.

## Estructura de paquetes

```
com.txema9.iatlas
├── data
│   ├── local        # Entities, DAOs, AppDatabase
│   ├── remote       # Cliente Ktor y parser de RSS
│   └── repository   # Repositorios
├── domain
│   └── model        # Modelos que usa la UI (si hace falta separarlos de las Entities)
├── ui
│   ├── theme        # Colores, tipografía, tema
│   ├── components   # Composables reutilizables (EntryCard, FilterChips…)
│   ├── list         # Pantalla de lista + ViewModel
│   ├── edit         # Pantalla de crear/editar + ViewModel
│   ├── news         # Pantalla de noticias + ViewModel
│   └── navigation   # NavHost y rutas
└── MainActivity.kt
```

## Decisiones (y por qué)

| Decisión | Motivo |
|---|---|
| Room y no ficheros | Consultas, filtros y relaciones; es lo estándar en Android |
| StateFlow y no LiveData | Es lo recomendado hoy con Compose y Kotlin |
| Sin Hilt al principio | Inyección manual primero para entender qué hace; Hilt como mejora opcional |
| Sin backend ni cuentas | Alcance realista y privacidad |
| Tus datos nunca salen del móvil | La única conexión es para **leer** RSS públicos; no se envía nada |
| Ktor Client + `XmlPullParser` para RSS | Ktor está hecho en y para Kotlin; `XmlPullParser` viene con Android. Retrofit brilla con APIs JSON, no con RSS |
| Noticias guardadas en Room | La app funciona sin conexión y no descarga lo mismo cada vez |
| Sin logos de las IAs | Sus guías de marca lo restringen; se usan nombre y color (ver DISENO.md) |
