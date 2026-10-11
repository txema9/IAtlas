# Análisis de mercado

*Revisión hecha en octubre de 2026. Objetivo: saber qué existe, qué podemos aprovechar y en qué se diferencia IAtlas.*

## Qué existe

### 1. Organización dentro de cada IA
Cada asistente ya tiene su sistema: **Proyectos** en ChatGPT, **Spaces** en Perplexity, **Gems** en Gemini, **Proyectos** en Claude. El problema: no se hablan entre sí. Un Proyecto de ChatGPT no sabe nada de lo que tienes en Claude.

### 2. Extensiones de navegador multi-IA
Es lo que más abunda: herramientas como *AI Chat Organizer*, *ChatTrail*, *KeepChat*, *MindMarks* o *AI Chat Inbox*. Ofrecen carpetas, búsqueda, etiquetas, exportación y biblioteca de prompts para varias IAs a la vez.

- ✅ Muy completas.
- ❌ Casi todas viven en el **navegador de escritorio** y se enganchan a la web de cada IA.
- ❌ Organizan **conversaciones sueltas**, no el "para qué uso cada IA".

### 3. Guardadores de enlaces para móvil
Apps como *LinkMark*, *Link App*, *LinkVault* o *LifeFeed AI*: guardas un enlace desde el menú *Compartir*, lo clasificas en carpetas/etiquetas y lo buscas después.

- ✅ Captura cómoda desde cualquier app.
- ❌ Son genéricas: no entienden el concepto "IA + ámbito de uso".

## El hueco

No hemos encontrado una **app Android nativa** centrada en el **mapa de usos**: "para el e-commerce, las fotos de producto en ChatGPT y la publicidad de Instagram en Claude; los estudios en ChatGPT; el proyecto IAtlas en Claude Code". Es un nicho pequeño, y eso es bueno: lo hace abarcable para un primer proyecto.

## Qué tomamos prestado

| Idea | De dónde | ¿Para v1? |
|---|---|---|
| Guardar desde el menú *Compartir* de Android | Guardadores de enlaces | ✅ Sí (y enseña *Intents*, muy valorado) |
| Carpetas/categorías + etiquetas | Extensiones | ✅ Categorías sí; etiquetas en v1.1 |
| Filtros y búsqueda | Todas | ✅ Sí |
| Color por IA | Link App (colores por carpeta) | ✅ Sí |
| Exportar a JSON | AI Chat Inbox, Linksi | 🟡 Extra |
| Clasificación automática con IA | LifeFeed, LinkVault | ❌ No (requiere API, coste y backend) |
| Importar historial de chats | Echoes | ❌ No (fuera de alcance) |

## Qué cambiamos del concepto original

1. **De "registro de uso" a "mapa de usos".** Cada entrada responde a: *qué hago · en qué IA · para qué ámbito*. Es más claro y más fácil de explicar en una entrevista.
2. **El enlace es opcional pero potente.** No podemos leer las IAs por API, pero sí recibir el enlace de un chat compartido. Es la "automatización" realista.
3. **Todo local, sin cuentas ni servidor.** Menos complejidad y argumento de privacidad. La única conexión es para leer las noticias públicas de los blogs oficiales; los datos del usuario nunca salen del móvil.
4. **Alcance cerrado.** Primero una v1.0 terminada y publicada; las ideas nuevas van a la sección *Ideas futuras* del roadmap, no al código.

## Referencia técnica útil
*Linksi* es un proyecto open source en Kotlin + Compose + Material 3 para guardar enlaces. Útil para ver cómo otros resuelven el *share intent*, **no para copiar**.
