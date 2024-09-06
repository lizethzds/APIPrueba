CREATE DEFINER=`admin`@`localhost` PROCEDURE `registrarUsuario`(
    IN _username VARCHAR(50),
    IN _curp VARCHAR(18),
    IN _nombre VARCHAR(100),
    IN _apellido_paterno VARCHAR(50),
    IN _apellido_materno VARCHAR(50),
    IN _email VARCHAR(100),
    IN _telefono VARCHAR(20),
    IN _contrasena VARCHAR(255),

    INOUT _filasAfectadas INT,
    INOUT _error VARCHAR(255)
)
BEGIN
    DECLARE _filasUsuario INT DEFAULT 0;
    SET _filasAfectadas = 0;
    SET _error = '';

    START TRANSACTION;
    
    -- Verificar si el username o la CURP ya existen
    IF EXISTS (SELECT 1 FROM usuarios WHERE username = _username OR curp = _curp) THEN
        SET _error = 'El username o la CURP ya existen';
        ROLLBACK;
    ELSE
        -- Insertar el usuario
        INSERT INTO usuarios(username, curp, nombre, apellido_paterno, apellido_materno, email, telefono, contrasena)
        VALUES (_username, _curp, _nombre, _apellido_paterno, _apellido_materno, _email, _telefono, _contrasena);

        SET _filasUsuario = ROW_COUNT();

        -- Verificar que se haya insertado el usuario correctamente
        IF _filasUsuario = 0 THEN
            SET _error = 'Error al insertar el usuario';
            ROLLBACK;
        ELSE
            SET _filasAfectadas = _filasUsuario;
            COMMIT;
        END IF;
    END IF;
END