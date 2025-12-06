# 🍰 Milo Pastelería – API REST + Frontend

El Proyecto consiste en una **API REST desarrollada con Spring Boot** para gestionar los productos de un ecommerce “Milo Pastelería”, junto con un **frontend en HTML + CSS + JS** que consume dicha API para:

- Listar productos  
- Filtrar por nombre, categoría y rango de precios  
- Ver detalles individuales  
- Agregar productos al carrito (localStorage)  
- Mostrar modal de confirmación y contador en el navbar  

El frontend está desplegado en Vercel.

---

## 🚀 DEMO ONLINE (Frontend)

🔗 **https://milo-pasteleria.netlify.app**

> Acá se puede visualizar el listado, probar filtros, entrar al detalle y usar el carrito.

---

# 🛠 Tecnologías utilizadas

### **Backend**
- Java 21  
- Spring Boot  
- Spring Web  
- Spring Data JPA  
- H2 Database  
- SQL Scripts (productos.sql)  
- Lombok  

### **Frontend**
- HTML5  
- CSS3 (Bootstrap + estilos personalizados)  
- JavaScript (Fetch API + LocalStorage)  
- React 19 — Librería principal para construir la interfaz de usuario.
- React DOM — Renderizado de componentes React en el DOM.
- React Router DOM 7 — Navegación y ruteo entre páginas.
- React Bootstrap — Componentes UI listos basados en Bootstrap.
- Bootstrap 5.3 — Framework CSS para estilos y grillas responsivas.
- Styled Components — CSS-in-JS para estilos personalizados por componente.
- React Toastify — Notificaciones visuales de fácil uso.
- React Helmet — Gestión del <head> y SEO (títulos, meta tags).
- React Icons — Íconos listos para usar en componentes.
- Vercel (deployment)

---

# 📦 Estructura del proyecto (Backend)
```
│
├── controller/
│ └── ProductoController.java
│
├── model/
│ └── Productos.java 
│
├── repository/
│ └── ProductoRepository.java
│
├── service/
│ └── ProductoService.java 
│
└── utils/
└── ProductoUtils.java
```

## 📂 Base de datos H2 con carga automática

El proyecto incluye:
src/main/resources/productos.sql 

H2 detecta el archivo `productos.sql` y carga automáticamente los registros al iniciar.

Esto permite tener **datos pre-cargados**.

---

# 🌐 Endpoints disponibles

### 🟦 Base URL
http://localhost:8080/ecommerce/api/productos

---

### 📌 GET – Listar todos los productos
GET /ecommerce/api/productos

---

### 📌 GET – Obtener producto por ID
GET /ecommerce/api/productos/{id}

---

### 📌 GET – Filtrar productos
GET /ecommerce/api/productos/filtrar

### Parámetros:
| Nombre      | Tipo     | Ejemplo |
|-------------|----------|---------|
| nombre      | String   | nombre=chocolate |
| categoria   | String   | categoria=tortas |
| precioMin   | Double   | precioMin=1000 |
| precioMax   | Double   | precioMax=5000 |

### Ejemplo:
GET /ecommerce/api/productos/filtrar?categoria=panificados&precioMin=200&precioMax=2000

---

### 📌 POST – Crear un producto
POST /ecommerce/api/productos

```JSON
{
  "nombre": "Lemon Pie XL",
  "descripcion": "Tarta grande para 12 personas",
  "precio": 8000,
  "categoria": "Tartas",
  "imagen": "https://...jpg",
  "stock": 5
}
```
---

### 📌 PUT – Actualizar un producto
PUT /ecommerce/api/productos/{id}

---

### 📌 DELETE – Eliminar un producto
DELETE /ecommerce/api/productos/{id}

---

# ▶️ Cómo ejecutar el backend
1. Clonar el repositorio
   ```
   git clone https://github.com/tu-repo/milo-pasteleria.git
   ```
2. Ingresar al proyecto
   ```
   cd milo-pasteleria
   ```
3. Ejecutar con Maven
   ```
   mvn spring-boot:run
   ```
4. O ejecutar directamente la clase:
   ```
   TpFinalApplication.java
   ```
5. Abrir Postman/Insomia para realizar pruebas de los endpoints
6. Dirigirse a https://milo-pasteleria.netlify.app/ para comprobar el consumo de la api desde el Front

---

# 📎 Próximas mejoras sugeridas

- Panel de administración

- Carrito persistido (en backend)

- Login y roles (en backend)

- Gestión de pedidos (en backend)

---

# 📄 Licencia

Proyecto de ejemplo educativo para el curso BACKEND JAVA - TALENTO TECH.

