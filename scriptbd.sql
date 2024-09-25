-- Crear el usuario 'admin' con la contraseña 'cuponsmart123'
CREATE USER 'adminCS'@'localhost' IDENTIFIED BY 'cuponsmart123';
-- Otorgar todos los permisos en la base de datos correspondiente al esquema
GRANT ALL PRIVILEGES ON cuponsmart.* TO 'adminCS'@'localhost';
-- Aplicar los cambios
FLUSH PRIVILEGES;


-- Crear la tabla 'estado'
CREATE TABLE estado (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL
);


CREATE TABLE rol (
	id INT AUTO_INCREMENT PRIMARY KEY,
    nombreRol VARCHAR(40)
);

-- Crear la tabla 'ciudad'
CREATE TABLE ciudad (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    estado_id INT NOT NULL,
    FOREIGN KEY (estado_id) REFERENCES estado(id)
);

-- Crear la tabla 'estatus'
CREATE TABLE estatus (
    id INT AUTO_INCREMENT PRIMARY KEY,
    estado_estatus VARCHAR(12) NOT NULL
);

CREATE TABLE categoria(
	id_categoria INT AUTO_INCREMENT PRIMARY KEY,
    nombre_categoria VARCHAR(40)
);

-- Crear la tabla 'domicilio'
CREATE TABLE domicilio (
    id INT AUTO_INCREMENT PRIMARY KEY,
    calle VARCHAR(50) NOT NULL,
    numero INT NOT NULL,
    colonia VARCHAR(55) NOT NULL,
    codigo_postal INT NOT NULL,
    id_ciudad INT NOT NULL,
    FOREIGN KEY (id_ciudad) REFERENCES ciudad(id)
);

CREATE TABLE usuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellido_paterno VARCHAR(50) NOT NULL,
    apellido_materno VARCHAR(50) NOT NULL,
    curp VARCHAR(18) NOT NULL UNIQUE,
    correo VARCHAR(100) NOT NULL UNIQUE,
    username VARCHAR(35) NOT NULL UNIQUE,
    contrasena VARCHAR(255) NOT NULL,
   rol_id INT NOT NULL,
    empresa_id INT,
    FOREIGN KEY (empresa_id) REFERENCES empresa(id),
    FOREIGN KEY (rol_id) REFERENCES rol(id)
);


-- Crear la tabla 'empresa'
CREATE TABLE empresa (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    nombre_comercial VARCHAR(100) NOT NULL,
    logo LONGBLOB,
    nombre_representante VARCHAR(100) NOT NULL,
    email VARCHAR(40) UNIQUE NOT NULL,
    telefono VARCHAR(20) NOT NULL,
    pagina_web VARCHAR(100),
    rfc VARCHAR(13) UNIQUE NOT NULL,
    estatus_id INT NOT NULL,
    direccion_id INT NOT NULL,
    FOREIGN KEY (direccion_id) REFERENCES domicilio(id),
    FOREIGN KEY (estatus_id) REFERENCES estatus(id)
);

CREATE TABLE sucursal (
id INT AUTO_INCREMENT PRIMARY KEY,
nombre VARCHAR(100) NOT NULL,
direccion_id INT NOT NULL,
empresa_id INT NOT NULL,
telefono VARCHAR(15) NOT NULL,
latitud VARCHAR(30) NOT NULL,
longitud VARCHAR(30) NOT NULL,
nombre_encargado VARCHAR(100) NOT NULL,
FOREIGN KEY (direccion_id) 	REFERENCES domicilio(id),
FOREIGN KEY (empresa_id)references empresa(id)
);

CREATE TABLE cliente(
id INT AUTO_INCREMENT PRIMARY KEY,
nombre VARCHAR(30) NOT NULL,
apellido_paterno VARCHAR(30) NOT NULL,
apellido_materno VARCHAR(30) NOT NULL,
telefono VARCHAR(15) NOT NULL,
fecha_nacimiento VARCHAR(30) NOT NULL,
contrasena VARCHAR(18) NOT NULL,
direccion_id INT NOT NULL,
FOREIGN KEY (direccion_id) REFERENCES domicilio(id)
);

CREATE TABLE promocion(
	id_promocion INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(45) NOT NULL,
    descripcion VARCHAR(255),
    imagen LONGBLOB,
    fecha_inicio VARCHAR(10) NOT NULL,
    fecha_termino VARCHAR(10) NOT NULL,
    restricciones VARCHAR(255),
    tipo VARCHAR(10),
    descuento FLOAT,
    categoria_id INT,
    numero_cupones INT,
    estatus TINYINT,
    empresa_id INT,
    codigo_promocion VARCHAR(8),
    FOREIGN KEY (categoria_id) REFERENCES categoria(id_categoria),
    FOREIGN KEY (empresa_id) REFERENCES empresa(id)
);



-- Crear el trigger para manejar la eliminación de empresas y domicilio
DELIMITER $$

CREATE TRIGGER after_empresa_delete
AFTER DELETE ON empresa
FOR EACH ROW
BEGIN
  -- Eliminar la dirección asociada a la empresa eliminada
  DELETE FROM domicilio
  WHERE domicilio.id = OLD.direccion_id;
END$$

DELIMITER ;

DELIMITER $$

CREATE TRIGGER after_sucursal_delete
AFTER DELETE ON empresa
FOR EACH ROW
BEGIN
  -- Eliminar la dirección asociada a la empresa eliminada
  DELETE FROM domicilio
  WHERE domicilio.id = OLD.direccion_id;
END$$

DELIMITER ;


-- Consultas con Join


-- Sucursales de una empresa por ID
SELECT 
    sucursal.nombre AS nombre_sucursal,
    sucursal.latitud,
    sucursal.longitud,
    sucursal.nombre_encargado,
    empresa.nombre AS nombre_empresa
FROM 
    sucursal
INNER JOIN 
    empresa ON sucursal.empresa_id = empresa.id
WHERE empresa.id = 2;


SELECT 
    e.nombre AS 'empresa.nombre',
    e.nombre_comercial AS 'empresa.nombre_comercial',
    e.logo AS 'empresa.logo',
    e.nombre_representante AS 'empresa.nombre_representante',
    e.email AS 'empresa.email',
    e.telefono AS 'empresa.telefono',
    e.pagina_web AS 'empresa.pagina_web',
    e.rfc AS 'empresa.rfc',
    e.estatus_id AS 'empresa.estatus_id',
    
    d.calle AS 'domicilio.calle',
    d.numero AS 'domicilio.numero',
    d.colonia AS 'domicilio.colonia',
    d.codigo_postal AS 'domicilio.codigo_postal',
    d.id_ciudad AS 'domicilio.id_ciudad'
    
FROM 
    empresa e
INNER JOIN 
    domicilio d ON e.direccion_id = d.id
WHERE 
    e.id = 9;


-- Promociones de una sucursal 

-- Promociones de una empresa

-- Empleados asociados a una empresa

