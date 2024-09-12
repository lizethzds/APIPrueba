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



-- Crear el trigger para manejar la eliminación de empresas y domicilio
DELIMITER //

CREATE TRIGGER before_delete_empresa
BEFORE DELETE ON empresa
FOR EACH ROW
BEGIN
    -- Borrar la persona asociada
    DELETE FROM domicilio WHERE id = OLD.domicilio;
END //

DELIMITER ;
