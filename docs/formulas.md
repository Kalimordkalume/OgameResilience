# Fórmulas del juego

Recogidas de la documentación de la comunidad (2026-10-23). No existe documentación oficial. Cada fórmula tiene un
estado:

- **Reproducida:** se comprobó con un número que aparece en otra fuente.
- **Leída:** aparece escrita en una o dos fuentes, sin comprobar con ningún número.
- **Conflicto:** las fuentes se contradicen.
- **Medida:** coincide con un valor de mi cuenta (ver `valores-de-oro.md`, cuando exista). Ninguna lo está todavía.

El redondeo es siempre hacia abajo (se queda con la parte entera).

## Coste de construcción

Coste del nivel *n* = `floor(base × factor^(n − 1))`.

| Edificio | Metal | Cristal | Deuterio | Factor | Estado |
| --- | --- | --- | --- | --- | --- |
| Mina de metal | 60 | 15 | 0 | 1,5 | Metal reproducido (nivel 39 → 294.862.195). El cristal de partida (15) **sin confirmar** |
| Mina de cristal | 48 | 24 | 0 | 1,6 | Reproducido contra la tabla de la wiki en el nivel 2 (76 y 38) |
| Sintetizador de deuterio | 225 | 75 | 0 | 1,5 | Leído |
| Planta solar | 75 | 30 | 0 | 1,5 | Reproducido contra la tabla de la wiki en el nivel 2 (112 y 45) |
| Reactor de fusión | sin encontrar | sin encontrar | sin encontrar | 1,8 | Solo el factor está leído |

## Producción por hora

| Edificio | Fórmula | Estado |
| --- | --- | --- |
| Mina de metal | `30 × nivel × 1,1^nivel × velocidad` | Reproducida (nivel 40, velocidad 1 → 54.311) |
| Mina de cristal | `20 × nivel × 1,1^nivel × velocidad` | Leída en dos fuentes |
| Sintetizador de deuterio | `10 × nivel × 1,1^nivel × velocidad × T` | **Conflicto** en el término de temperatura `T` |

### El conflicto del deuterio

| Fuente | Término `T` |
| --- | --- |
| Foro de la comunidad | `1,28 − 0,002 × temperatura máxima` |
| Mi memoria (no verificada en ninguna fuente) | `1,44 − 0,004 × temperatura máxima` |

Dan resultados distintos: a 0 °C, 1,28 contra 1,44; solo coinciden a 80 °C. Se resuelve con un valor de oro: la
temperatura máxima de un planeta y su producción de deuterio por hora con un nivel concreto.

## Energía por hora

| Edificio | Fórmula | Estado |
| --- | --- | --- |
| Planta solar (produce) | `20 × nivel × 1,1^nivel` | Leída en dos fuentes |
| Mina de metal (consume) | `10 × nivel × 1,1^nivel` | Leída en dos fuentes |
| Mina de cristal (consume) | `10 × nivel × 1,1^nivel` | Leída en dos fuentes |
| Sintetizador de deuterio (consume) | `20 × nivel × 1,1^nivel` | Leída en dos fuentes |
| Reactor de fusión (produce) | `30 × nivel × (1,05 + 0,01 × tecnología de energía)^nivel` | Leída en una sola fuente, válida según esa fuente desde la versión 0.78a |

## Tiempo de construcción

`(metal + cristal) / 2500 × 1 / (robótica + 1) × 0,5^nanita`, en horas, dividido entre la velocidad del universo.

| Estado |
| --- |
| **Sin confirmar.** Coincide entre el foro y el clon que cita la guía, pero el autor del clon avisa de que no coincide exactamente con las calculadoras, y la wiki indica que los universos rediseñados tienen reducciones extra |

## Fuentes

- [Calculadora de recursos de OGame (west-games)](https://west-games.com/ogame-resource-calculator/): producción y energía.
- [Fórmulas de OGame en un foro de la comunidad](https://punisher.forumotion.com/t13-ogame-formulas): costes, factores, producción, energía y tiempo.
- La wiki de Fandom y el foro oficial aparecen citados en resultados de búsqueda; la wiki devolvió un error (402) y no pude abrirla.

Todas son no oficiales, y las versiones de cada universo pueden diferir.
