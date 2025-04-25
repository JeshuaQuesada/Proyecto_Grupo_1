-- Eliminación y Creación de la Base de Datos de la Librería
DROP SCHEMA IF EXISTS libreria;
DROP USER IF EXISTS usuario_libreria;
CREATE SCHEMA libreria;
CREATE USER 'usuario_libreria'@'%' IDENTIFIED BY 'Libreria_Clave.';
GRANT ALL PRIVILEGES ON libreria.* TO 'usuario_libreria'@'%';
FLUSH PRIVILEGES;
USE libreria;

-- Creación de las Tablas de la Librería con el campo 'activo'
CREATE TABLE categoria (
    id_categoria INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    ruta_imagen VARCHAR(200),
    activo BOOLEAN DEFAULT TRUE
);

CREATE TABLE libro (
    id_libro INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL,
    autor VARCHAR(100) NOT NULL,
    editorial VARCHAR(100),
    isbn VARCHAR(20),
    año_publicacion INT,
    precio DECIMAL(10,2) NOT NULL,
    stock INT NOT NULL,
    descripcion TEXT,
    ruta_imagen VARCHAR(200),
    id_categoria INT NOT NULL,
    activo BOOLEAN DEFAULT TRUE,
    FOREIGN KEY (id_categoria) REFERENCES categoria(id_categoria)
);

CREATE TABLE venta (
    id_venta INT AUTO_INCREMENT PRIMARY KEY,
    fecha DATETIME DEFAULT CURRENT_TIMESTAMP,
    cliente_nombre VARCHAR(100),
    cliente_email VARCHAR(100),
    total DECIMAL(10,2) NOT NULL,
    activo BOOLEAN DEFAULT TRUE
);

CREATE TABLE detalle_venta (
    id_detalle INT AUTO_INCREMENT PRIMARY KEY,
    id_venta INT NOT NULL,
    id_libro INT NOT NULL,
    cantidad INT NOT NULL,
    precio_unitario DECIMAL(10,2) NOT NULL,
    subtotal DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (id_venta) REFERENCES venta(id_venta),
    FOREIGN KEY (id_libro) REFERENCES libro(id_libro)
);

-- SISTEMA DE SEGURIDAD - TABLAS
/* Tabla de usuarios */
CREATE TABLE usuario (
  id_usuario INT NOT NULL AUTO_INCREMENT,
  username VARCHAR(20) NOT NULL,
  password VARCHAR(512) NOT NULL,
  nombre VARCHAR(50) NOT NULL,
  apellido VARCHAR(50) NOT NULL,
  correo VARCHAR(100) NULL,
  telefono VARCHAR(20) NULL,
  activo BOOLEAN DEFAULT TRUE,
  PRIMARY KEY (id_usuario)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

/* Tabla de roles disponibles */
CREATE TABLE role (  
  rol VARCHAR(20),
  PRIMARY KEY (rol)  
);

INSERT INTO role (rol) VALUES ('ADMIN'), ('USER'), ('EMPLEADO');

/* Asignación de roles a los usuarios */
CREATE TABLE rol (
  id_rol INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(20),
  id_usuario INT,
  PRIMARY KEY (id_rol),
  FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4;

-- Inserción de Datos de Ejemplo - Categorías
INSERT INTO categoria (nombre, ruta_imagen, activo) VALUES
('Ficción', 'ficcion.jpg', TRUE),
('Fantasía', 'fantasia.jpg', TRUE),
('Drama', 'drama.jpg', TRUE),
('Ciencia Ficción', 'ciencia_ficcion.jpg', TRUE),
('Romance', 'romance.jpg', TRUE),
('Misterio', 'misterio.jpg', TRUE);

-- Inserción de Datos de Ejemplo - Libros
INSERT INTO libro (titulo, autor, editorial, isbn, año_publicacion, precio, stock, descripcion, ruta_imagen, id_categoria, activo) VALUES
('Dune', 'Frank Herbert', 'Ace Books', '9780441172719', 1965, 24.99, 15, 'Una epopeya de aventuras y misticismo en un planeta desértico.', 'dune-cover.jpg', 1, TRUE),
('Harry Potter y la piedra filosofal', 'J.K. Rowling', 'Salamandra', '9788478884459', 1997, 19.99, 25, 'La primera aventura del joven mago en Hogwarts.', 'harry-potter-cover.jpg', 2, TRUE),
('Apocalipsis', 'Stephen King', 'Doubleday', '9788401499586', 1978, 22.50, 10, 'Una historia post-apocalíptica sobre la lucha entre el bien y el mal.', 'apocalipsis-cover.jpg', 3, TRUE),
('Cien años de soledad', 'Gabriel García Márquez', 'Sudamericana', '9780307474728', 1967, 18.75, 20, 'La historia de la familia Buendía a lo largo de siete generaciones en Macondo.', 'cien-años-cover.jpg', 1, TRUE),
('El nombre del viento', 'Patrick Rothfuss', 'DAW Books', '9788401352836', 2007, 27.50, 12, 'La historia del músico, ladrón y mago Kvothe.', 'nombre-viento-cover.jpg', 2, TRUE),
('1984', 'George Orwell', 'Secker & Warburg', '9780451524935', 1949, 15.99, 18, 'Una novela distópica sobre un régimen totalitario.', '1984-cover.jpg', 4, TRUE),
('Orgullo y prejuicio', 'Jane Austen', 'T. Egerton', '9780141439518', 1813, 14.95, 22, 'La historia de la familia Bennet y la búsqueda de matrimonio de sus cinco hijas.', 'orgullo-cover.jpg', 5, TRUE),
('El código Da Vinci', 'Dan Brown', 'Doubleday', '9780307474278', 2003, 20.50, 15, 'Un thriller que combina símbolos, arte y religión.', 'davinci-cover.jpg', 6, TRUE);

-- Inserción de Datos de Ejemplo - Ventas
INSERT INTO venta (fecha, cliente_nombre, cliente_email, total, activo) VALUES
('2025-04-10 14:35:10', 'Ana Martínez', 'ana.martinez@email.com', 44.98, TRUE),
('2025-04-15 10:20:45', 'Carlos Rodríguez', 'carlos.rodriguez@email.com', 27.50, TRUE),
('2025-04-18 16:50:30', 'Elena Gómez', 'elena.gomez@email.com', 55.49, TRUE),
('2025-04-20 11:15:22', 'Miguel Torres', 'miguel.torres@email.com', 18.75, TRUE);

-- Inserción de Datos de Ejemplo - Detalles de Venta
INSERT INTO detalle_venta (id_venta, id_libro, cantidad, precio_unitario, subtotal) VALUES
(1, 1, 1, 24.99, 24.99),
(1, 7, 1, 19.99, 19.99),
(2, 5, 1, 27.50, 27.50),
(3, 2, 1, 19.99, 19.99),
(3, 6, 1, 15.99, 15.99),
(3, 4, 1, 18.75, 18.75),
(4, 4, 1, 18.75, 18.75);

/* Inserción de usuarios (con contraseñas cifradas) */
INSERT INTO usuario (username, password, nombre, apellido, correo, telefono, activo) VALUES 
('admin', '$2a$10$P1.w58XvnaYQUQgZUCk4aO/RTRl8EValluCqB3S2VMLTbRt.tlre.', 'Administrador', 'Sistema', 'admin@libreria.com', '555-123-4567', true),
('maria', '$2a$10$GkEj.ZzmQa/aEfDmtLIh3udIH5fMphx/35d0EYeqZL5uzgCJ0lQRi', 'María', 'López Vega', 'maria@email.com', '555-987-6543', true),
('juan', '$2a$10$GkEj.ZzmQa/aEfDmtLIh3udIH5fMphx/35d0EYeqZL5uzgCJ0lQRi', 'Juan', 'Pérez Mora', 'juan@email.com', '555-456-7890', true);

/* Asignación de roles a usuarios */
INSERT INTO rol (nombre, id_usuario) VALUES
('ADMIN', 1),
('USER', 1),
('EMPLEADO', 2),
('USER', 2),
('USER', 3);

