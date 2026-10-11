# Guía de diseño: "Síntesis"

*Dirección visual de IAtlas. Se decide aquí antes de programar la UI y Claude Code debe seguirla. Si algo cambia, se cambia primero aquí.*

Boceto de referencia: lienzo "IAtlas · Diseño síntesis", artboards **Síntesis · Mi mapa** y **Síntesis · Noticias**.

## Concepto

Una app actual y limpia con un punto de personalidad. Es un neobrutalismo suave: bordes en tinta, sombras sólidas pequeñas y fichas blancas. **La interfaz es sobria y el color lo ponen las IAs**, igual que en Letterboxd los pósters dan color a una interfaz neutra.

Reglas:
- **Lo memorable es la barra de reparto**: de un vistazo ves cuánto tienes en cada IA. Explica para qué sirve la app sin decirlo.
- El color identifica la IA (franja lateral de la ficha, etiqueta con su nombre, punto del filtro, tramo de la barra, etiqueta de categoría) y nada más. Todo lo demás es tinta y blanco.
- Nada de degradados, sombras difuminadas ni tarjetas giradas.
- **Sin logos oficiales de las IAs.** Las marcas (OpenAI, Anthropic, Google…) tienen guías que restringen usar sus logos sin permiso. Cada IA se identifica por **su nombre escrito completo** sobre su color: es lo más claro para el usuario y sirve igual para cualquier IA que añada él.
- Textos en minúsculas normales (nada de etiquetas en MAYÚSCULAS).
- Vocabulario coherente: "entrada", "Nueva entrada", "Guardar". El botón que dice "Guardar" muestra después "Entrada guardada".

## Paleta

| Nombre | Claro | Oscuro | Uso |
|---|---|---|---|
| Fondo | `#F3F1FA` | `#16141E` | Fondo de la app |
| Superficie | `#FFFFFF` | `#221F2D` | Fichas, buscador, resumen, chips |
| Tinta | `#15131F` | `#EDEBF5` | Texto principal, bordes, sombras sólidas |
| Tinta suave | `#55516A` | `#A9A4BE` | Textos secundarios, títulos de sección |
| Acento | `#2F5FE0` | `#7B9BFF` | Sombra del botón principal, foco, enlaces |

En modo oscuro, las sombras sólidas pasan a negro puro (`#000000`) y los bordes usan Tinta oscura al 70 %.

### Colores por IA (editables por el usuario)
| IA | Color |
|---|---|
| ChatGPT | `#17805E` |
| Claude | `#C4501F` |
| Gemini | `#2F5FE0` |
| Perplexity | `#0B7F8A` |
| Otra (por defecto) | `#5E5A72` |

- **Etiqueta de IA:** su nombre en blanco, peso 700, sobre su color. El blanco cumple el contraste mínimo (4,5:1) con todos estos colores. Si el usuario elige un color propio, la app decide si el texto va en blanco o en tinta según la luminancia (`Color.luminance()`).
- **Franja lateral:** 8 dp de ancho en el borde izquierdo de cada ficha, separada del contenido por una línea de tinta.
- **Etiqueta de categoría:** fondo = mezcla del color de la IA con blanco al 18 % (`lerp(Color.White, aiColor, 0.18f)`), texto en Tinta.

## Tipografía

**Bricolage Grotesque** (Google Fonts), una sola familia:

| Estilo | Peso | Tamaño | Uso |
|---|---|---|---|
| Marca | 800 | 26 sp | "IAtlas" en la cabecera |
| Resumen | 700 | 22 sp | "7 cosas repartidas entre 4 IAs" |
| Titular de noticia | 700 | 17 sp | Título en cada noticia |
| Título de entrada | 700 | 16 sp | Título en cada ficha |
| Título de sección | 700 | 15 sp | "Recientes", nombre de IA al agrupar (Tinta suave) |
| Cuerpo | 400 | 16 sp | Descripciones, buscador |
| Etiqueta | 600 | 13–14 sp | Chips de filtro, categoría |

En Compose se añade en `res/font/` y se define en `Type.kt`. Interletrado ligeramente negativo (-0,02 em) solo en marca y resumen.

## Forma y espaciado

- **Bordes:** 1,5 dp en Tinta en todos los elementos con superficie.
- **Sombras sólidas** (un `Box` desplazado, sin difuminar): 3×3 dp en fichas y resumen, 2×2 dp en botones pequeños, 4×4 dp en Acento para el botón "Nueva entrada".
- **Esquinas:** resumen 18 dp, fichas y noticias 16 dp, buscador 14 dp, etiquetas 8 dp, botón principal 18 dp, chips completamente redondeados.
- **Barra de reparto:** 18 dp de alto, borde 1,5 dp, tramos separados por una línea de tinta y ancho proporcional al número de entradas (`Modifier.weight`).
- Espaciado en múltiplos de 4 dp: 20 dp de margen lateral, 10 dp entre fichas, 16 dp entre bloques.
- Zonas táctiles de al menos 48 dp.

## Navegación

Barra inferior con dos secciones: **Mi mapa** (icono de mapa plegado) y **Noticias** (icono de periódico). Fondo Superficie, borde superior de 1,5 dp en Tinta. La sección activa lleva su icono dentro de una cápsula en Tinta (60×32 dp) con el icono en blanco. El botón "Nueva entrada" flota por encima de la barra y solo aparece en Mi mapa.

## Pantallas

### 1. Lista principal
```
┌──────────────────────────────┐
│ IAtlas                   [⚙] │
│ ┌──────────────────────────┐ │
│ │ 7 cosas repartidas       │ │  ← resumen
│ │ entre 4 IAs              │ │
│ │ [███████|████|██|██]     │ │  ← barra de reparto
│ │ (Todas)(●ChatGPT 3)(●Cl… │ │  ← chips de filtro con contador
│ └──────────────────────────┘ │
│ ┌ 🔍 ¿Dónde tenía…?        ┐ │
│ Recientes                    │
│ ┌──────────────────────────┐ │
│ ▌ Publicidad de Insta ★  ↗ │ │  ← franja de color, título, enlace
│ ▌ (Claude) (E-commerce)    │ │  ← etiqueta de IA + categoría teñida
│ └──────────────────────────┘ │
│ ┌──────────────────────────┐ │
│ ▌ Fotos de producto      ↗ │ │
│                        [ + ] │  ← botón principal
│ ─────────────────────────────│
│     (▣ Mi mapa)  Noticias    │  ← barra inferior
└──────────────────────────────┘
```
Al pulsar un chip o un tramo de la barra se filtra por esa IA. Con "Agrupar por IA" activado (Ajustes), "Recientes" se sustituye por un título por cada IA.

### 2. Nueva entrada / editar
Campos con el estilo del buscador (superficie, borde, 14 dp). La IA se elige con los mismos chips de filtro; la categoría, con etiquetas seleccionables. Campo de enlace opcional, relleno automáticamente si se llega desde "Compartir". Botón "Guardar" ancho, en Tinta con sombra en Acento.

### 3. Detalle
La ficha a tamaño completo: franja de color en todo el alto, etiqueta de IA grande, título, categoría, descripción y fechas. Botón "Abrir chat" si tiene enlace, y acciones editar y borrar (con opción de deshacer en un `Snackbar`).

### 4. Estado vacío
El resumen con la barra en gris punteado y el texto "Aún no tienes nada guardado. Apunta dónde tienes cada cosa." con el botón "Nueva entrada".

### 5. Noticias
```
┌──────────────────────────────┐
│ Noticias                 [↻] │
│ Novedades de los blogs       │
│ oficiales · hace 5 min       │
│ (Todas)(●ChatGPT)(●Claude)…  │  ← mismos chips de filtro
│ Hoy                          │
│ ┌──────────────────────────┐ │
│ │ (Claude)         hace 2 h│ │  ← fuente como etiqueta de IA
│ │ Titular de la noticia    │ │
│ │ Resumen de 3 líneas…     │ │
│ │ Leer en el blog oficial ↗│ │
│ └──────────────────────────┘ │
│     Mi mapa  (▣ Noticias)    │
└──────────────────────────────┘
```
- Agrupadas por día ("Hoy", "Ayer", fecha). Resumen recortado a 3 líneas; el artículo se lee siempre en la web original (nunca se copia entero en la app).
- Deslizar hacia abajo para actualizar.
- **Cargando:** tres fichas "fantasma" en Superficie sin texto. **Sin conexión:** se muestran las últimas noticias guardadas con un aviso arriba ("Sin conexión · mostrando lo último que se descargó"). **Error:** ficha con el mensaje y botón "Reintentar".

## Componentes reutilizables

| Componente | Qué aprendes al hacerlo |
|---|---|
| `SolidShadowBox` | La base de todo: dos `Box` superpuestos con `offset`, parámetros con valores por defecto |
| `SummaryCard` | Composición de componentes, textos que dependen del estado (plurales) |
| `DistributionBar` | `Row` con `Modifier.weight` proporcional, `clickable` por tramo |
| `AiFilterChip` | Estado seleccionado/no seleccionado, `LazyRow` o `FlowRow` |
| `AiLabel` | Etiqueta con el nombre de la IA; elegir color de texto con `luminance()` |
| `EntryCard` | Franja lateral con `IntrinsicSize`, `Row`/`Column`, iconos condicionales (favorito, enlace) |
| `CategoryPill` | `lerp` de colores |
| `SearchField` | `TextField` personalizado con `BasicTextField` |
| `NewEntryButton` | Reutilizar `SolidShadowBox` con otro color |
| `EmptyState` | Estados vacíos |
| `AppNavigationBar` | `NavigationBar` personalizada, saber qué ruta está activa |
| `NewsCard` | `maxLines` y `TextOverflow.Ellipsis`, abrir un enlace externo |
| `LoadingPlaceholder` | Estados de carga |

Cada uno con su `@Preview` en claro y oscuro.
