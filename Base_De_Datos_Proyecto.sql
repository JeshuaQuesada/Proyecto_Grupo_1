drop schema if exists libreria;
drop user if exists usuario_prueba;
CREATE SCHEMA libreria ;

/*Se crea un usuario para la base de datos llamado "usuario_prueba" y tiene la contraseña "Usuario_Clave."*/
create user 'usuario_prueba'@'%' identified by 'Usuar1o_Clave.';

/*Se asignan los prvilegios sobr ela base de datos TechShop al usuario creado */
grant all privileges on libreria.* to 'usuario_prueba'@'%';
flush privileges;

use libreria;

-- Crear tabla Categoria
create table categoria (
  id_categoria INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(1024) NOT NULL,
  descripcion varchar(1024),
  precio varchar(1024),
  ruta_imagen varchar (1024),
  activo bool,
  PRIMARY KEY (id_categoria))
  ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- Insertar registros en Categoria
INSERT INTO categoria (id_categoria,nombre,  descripcion,precio, ruta_imagen,activo) VALUES 
('1', 'Analgesicos',' ',' ',' ',false),
('2', 'Suplementos',' ',' ',' ',true),
('3', 'Medicamentos',' ',' ',' ',false);