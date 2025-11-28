# 💱 Conversor de Moneda

Proyecto realizado para el curso Alura Latam.

---

## 📖 Descripción
Aplicación que permite convertir entre diversas monedas utilizando los valores de cotización actual.  
Incluye historial de conversiones con fecha y hora de cada operación.  

El objetivo es que el usuario pueda:

- Elegir entre distintas monedas para convertir.  
- Ingresar un monto a convertir.  
- Ver el resultado de la conversión de manera clara.  
- Contar con un historial de las últimas conversiones realizadas.

---

## 💰 Monedas soportadas
- USD - Dólar estadounidense  
- ARS - Peso argentino  
- BRL - Real brasileño  
- CLP - Peso chileno
  
---

## ▶️ Cómo ejecutar
1. Abrir el proyecto en IntelliJ IDEA o cualquier IDE compatible con Java.  
2. Ejecutar la clase `Principal.java`.  
3. Seleccionar la opción deseada del menú.  
4. Ingresar el monto que se desea convertir.  
5. Visualizar el resultado de la conversión en pantalla.  

---

## ⚙️ Funcionalidades
### 🗂 Menú interactivo
- Permite seleccionar la conversión deseada entre las monedas disponibles.  
- Opción de salir de la aplicación.  

### 💵 Resultado de la conversión
- Muestra el valor convertido con la moneda de destino.  
- Incluye la moneda de origen y el valor ingresado.  

### ⚠️ Manejo de errores
- Detecta cuando el usuario ingresa un valor no válido (como letras o caracteres no numéricos).  
- Muestra un mensaje claro indicando el error.  

### 📝 Historial de conversiones
- Guarda cada conversión realizada en un archivo JSON.  
- Incluye fecha y hora de cada operación.  
- Permite revisar las últimas conversiones realizadas para seguimiento.

---

## 🔧 Posibles mejoras
- Agregar soporte para más monedas de la API.  
- Limitar el historial a las últimas N conversiones.    

---

## 🛠 Tecnologías utilizadas
- Java 17  
- Gson para manejo de JSON  
- API de ExchangeRate para valores de cotización  
