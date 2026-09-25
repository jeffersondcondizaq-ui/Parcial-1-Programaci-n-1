0. Datos de la empresa

┌────────────┬────────────────────────┐
│   Campo    │         Valor          │
├────────────┼────────────────────────┤
│ Nombre     │ DevPlus SAS            │
├────────────┼────────────────────────┤
│ NIT        │ 900123456-7            │
├────────────┼────────────────────────┤
│ Dirección  │ Calle 10 # 20-30       │
├────────────┼────────────────────────┤
│ Teléfono   │ 6013456789             │
├────────────┼────────────────────────┤
│ Página web │ http://www.devplus.com │
└────────────┴────────────────────────┘

1. Clientes

┌──────┬─────────────┬──────────────────────────┬─────────────────┬──────────┬───────────┐
│  ID  │   Nombre    │         Teléfono         │     Correo      │   País   │ Frecuente │
├──────┼─────────────┼──────────────────────────┼─────────────────┼──────────┼───────────┤
│ 1001 │ Juan Perez  │ 28 (perfecto)            │ juan@mail.com   │ Colombia │ S         │
├──────┼─────────────┼──────────────────────────┼─────────────────┼──────────┼───────────┤
│ 1002 │ Maria Gomez │ 3001234567 (no perfecto) │ maria@mail.com  │ Mexico   │ N         │
├──────┼─────────────┼──────────────────────────┼─────────────────┼──────────┼───────────┤
│ 1003 │ Carlos Ruiz │ 496 (perfecto)           │ carlos@mail.com │ Colombia │ S         │
└──────┴─────────────┴──────────────────────────┴─────────────────┴──────────┴───────────┘

Prueba "Buscar Cliente por Teléfono" con 28 y 3001234567 para ver la diferencia en "número perfecto".

2. Desarrolladores

┌────────┬──────────┬────────────┬────────────────┬────────────┬─────────────────────────────────────────────────────┐
│ Código │  Equipo  │   Nivel    │ Máx. proyectos │ Tarifa/día │                       Estado                        │
├────────┼──────────┼────────────┼────────────────┼────────────┼─────────────────────────────────────────────────────┤
│ DEV01  │ Backend  │ Senior     │ 3              │ 150000     │ Disponible                                          │
├────────┼──────────┼────────────┼────────────────┼────────────┼─────────────────────────────────────────────────────┤
│ DEV02  │ Frontend │ Junior     │ 2              │ 80000      │ Disponible                                          │
├────────┼──────────┼────────────┼────────────────┼────────────┼─────────────────────────────────────────────────────┤
│ DEV03  │ QA       │ Semisenior │ 2              │ 100000     │ En capacitación ← para probar el rechazo por estado │
└────────┴──────────┴────────────┴────────────────┴────────────┴─────────────────────────────────────────────────────┘

3. Servicios Adicionales

┌────────┬───────────────────────┬───────────────────────────┬────────┬────────────┐
│ Código │        Nombre         │        Descripción        │ Precio │ Disponible │
├────────┼───────────────────────┼───────────────────────────┼────────┼────────────┤
│ SERV01 │ Soporte Tecnico       │ Soporte post-entrega 24/7 │ 500000 │ S          │
├────────┼───────────────────────┼───────────────────────────┼────────┼────────────┤
│ SERV02 │ Capacitacion Usuarios │ Capacitacion de 4 horas   │ 300000 │ S          │
└────────┴───────────────────────┴───────────────────────────┴────────┴────────────┘

4. Proyectos

Todas las fechas en dd/mm/aaaa (formato que pide Registrar Proyecto).

┌────────┬──────────────┬────────────┬────────────┬───────────┬────────────────────────┬─────────┐
│ Código │ F. Solicitud │ F. Inicio  │ F. Entrega │  Estado   │      Método pago       │ Cliente │
├────────┼──────────────┼────────────┼────────────┼───────────┼────────────────────────┼─────────┤
│ PROY01 │ 01/09/2026   │ 05/09/2026 │ 20/09/2026 │ Pendiente │ transferencia bancaria │ 1001    │
├────────┼──────────────┼────────────┼────────────┼───────────┼────────────────────────┼─────────┤
│ PROY02 │ 03/09/2026   │ 22/09/2026 │ 30/09/2026 │ Pendiente │ tarjeta de credito     │ 1002    │
├────────┼──────────────┼────────────┼────────────┼───────────┼────────────────────────┼─────────┤
│ PROY03 │ 05/09/2026   │ 10/09/2026 │ 25/09/2026 │ Pendiente │ efectivo               │ 1003    │
└────────┴──────────────┴────────────┴────────────┴───────────┴────────────────────────┴─────────┘

PROY03 (10/09–25/09) se cruza con PROY01 (05/09–20/09) a propósito. PROY02 (22/09–30/09) no se cruza con ninguno.

5. Secuencia para probar "Agregar Desarrollador a un proyecto" (opción 14)

Haz los pasos en este orden exacto:

1. DEV01 → PROY01: debe decir "Desarrollador disponible" y agregarse (PROY01 sigue Pendiente, así que DEV01 no cambia a Ocupado).
2. Cambiar Estado de un proyecto (opción 13) → PROY01 → Confirmado.
3. DEV02 → PROY01: debe agregarse y, como ahora PROY01 ya está Confirmado, DEV02 pasa automáticamente a estado Ocupado.
4. DEV03 → PROY01: debe rechazarse con "El desarrollador no está disponible" (porque su estado es "En capacitación", no "Disponible").
5. DEV01 → PROY03: debe rechazarse con "El desarrollador no está disponible en las fechas solicitadas" (porque DEV01 ya está en PROY01 y las fechas se cruzan).
6. DEV01 → PROY02: debe aceptarse (mismas fechas que PROY01 no se cruzan con PROY02).

6. Cálculos sobre PROY01

1. Agregar Servicio Adicional a Proyecto → PROY01 + SERV01
2. Agregar Servicio Adicional a Proyecto → PROY01 + SERV02
3. Calcular Valor Servicios Adicionales → PROY01 → 800000
4. Calcular Cantidad de Dias de Desarrollo → PROY01 → 15
5. Calcular Tarifa Desarrolladores → DEV01, 15 días → 2250000
6. Calcular Descuento Cliente Frecuente → 1001, subtotal 3050000 → 305000
7. Calcular Valor Total del Proyecto → PROY01 + DEV01 → 2745000