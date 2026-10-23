# 0001. Fuente de datos del juego

**Fecha:** 2026-10-23
**Estado:** propuesta (pasa a aceptada cuando haya al menos un valor de oro comprobado)

## Contexto

El planificador necesita tres tipos de datos: las reglas del juego (costes, producción, tiempos), el estado de cada
jugador (niveles de sus edificios) y datos del universo (velocidad, jugadores). No hay documentación oficial de las
fórmulas; solo existe lo que documenta la comunidad.

## Decisión

- **Reglas del juego:** fórmulas tomadas de la documentación de la comunidad (wikis, calculadoras y código de clones),
  comprobadas después con valores de mi propia cuenta ("valores de oro").
- **Estado del jugador:** lo introduce el usuario a través del CRUD.
- **Datos del universo:** API estadística pública, solo lectura. No es esencial en la primera versión.

## Fuentes consultadas

| Qué | Fórmula o dato | Estado |
| --- | --- | --- |
| Coste en metal de la mina de metal | 60 × 1,5^(nivel − 1) | Reproducido: da 294.862.195 en el nivel 39, igual que la wiki |
| Producción por hora de la mina de metal | 30 × nivel × 1,1^nivel × velocidad del universo | Reproducido: nivel 40 a velocidad 1 da 54.311, igual que la wiki |
| Tiempo de construcción | (metal + cristal) / (2500 × (1 + robótica) × 2^nanita × velocidad), en horas | **No confirmado.** El autor del clon avisa de que no coincide exactamente con las calculadoras |
| API estadística | `serverData.xml`, `players.xml`, `universe.xml`, `highscore.xml` y otros | No oficial; sin comprobar las condiciones de uso |

## Valores de oro

Un valor de oro es un número que se ve en el juego y que el código tiene que reproducir. Tres casos distintos: una mina
de metal, una de cristal, y algo que tarde más de un día para que se note el efecto de la robótica.

| Edificio | Nivel que se sube | Coste de metal | Coste de cristal | Coste de deuterio | Tiempo que muestra | Robótica | Nanita | Velocidad del universo |
| --- | --- | --- | --- | --- | --- | --- | --- | --- |
|  |  |  |  |  |  |  |  |  |
|  |  |  |  |  |  |  |  |  |
|  |  |  |  |  |  |  |  |  |

## Lo que no sé todavía

- La fórmula exacta del tiempo de construcción en mi universo.
- El coste en cristal de la mina de metal (el valor de partida, 15, está sin confirmar).
- El término de temperatura de la producción de deuterio: dos fuentes se contradicen (ver `docs/formulas.md`).
- Las condiciones de uso de la API.

Las fórmulas recogidas y su estado están en `docs/formulas.md`.

## Consecuencias

- Las fórmulas se pueden equivocar sin avisar: un planificador con una fórmula errónea da consejos malos en silencio. Por
  eso cada fórmula se acompaña de un test con un valor comprobado, y lo no confirmado queda como test desactivado con el
  motivo escrito.
- Cada universo puede tener reglas distintas (velocidad, rediseño). Lo que valga para el mío podría no valer para otro.

## Revisar cuando

Un valor de oro no coincida con la fórmula, o cuando entre otro jugador a usar el servicio.
