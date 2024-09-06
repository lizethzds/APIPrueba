CREATE DEFINER=`admin`@`localhost` PROCEDURE `registrarEmpresa`(
    IN _nombre VARCHAR(100),
    IN _nombre_comercial VARCHAR(100),
    IN _nombre_representante VARCHAR(100),
    IN _email VARCHAR(40),
    IN _telefono VARCHAR(20),
    IN _pagina_web VARCHAR(100),
    IN _rfc VARCHAR(13),
    IN _calle VARCHAR(50),
    IN _numero INT,
    IN _colonia VARCHAR(55),
    IN _codigo_postal INT,
    IN _id_ciudad INT,

    INOUT _filasAfectadas INT,
    INOUT _error VARCHAR(255)
)
BEGIN 
    DECLARE _idDomicilio INT DEFAULT 0;
    DECLARE _filasDomicilio INT DEFAULT 0;
    DECLARE _filasEmpresa INT DEFAULT 0;
    SET _filasAfectadas = 0;
    SET _error = '';

    START TRANSACTION;

    -- Validar si ya existe una empresa con el mismo RFC o nombre
    IF EXISTS (SELECT 1 FROM empresa WHERE rfc = _rfc OR nombre = _nombre) THEN
        SET _error = 'RFC o Nombre de la Empresa ya existe en la base de datos';
        ROLLBACK;
    ELSE
        -- Insertar el domicilio
        INSERT INTO domicilio(calle, numero, colonia, codigo_postal, id_ciudad)
        VALUES (_calle, _numero, _colonia, _codigo_postal, _id_ciudad);

        SET _idDomicilio = LAST_INSERT_ID();
        SET _filasDomicilio = ROW_COUNT();

        -- Verificar que se haya insertado el domicilio correctamente
        IF _filasDomicilio = 0 THEN
            SET _error = 'Error al insertar el domicilio';
            ROLLBACK;
        ELSE
            -- Insertar la empresa
            INSERT INTO empresa(nombre, nombre_comercial, nombre_representante, email, telefono, pagina_web, rfc, estatus_id,direccion_id)
            VALUES (_nombre, _nombre_comercial, _nombre_representante, _email, _telefono, _pagina_web, _rfc, 1,_idDomicilio);

            SET _filasEmpresa = ROW_COUNT();

            -- Verificar que se haya insertado la empresa correctamente
            IF _filasEmpresa = 0 THEN
                SET _error = 'Error al insertar la empresa';
                ROLLBACK;
            ELSE
                SET _filasAfectadas = _filasDomicilio + _filasEmpresa;
                COMMIT;
            END IF;
        END IF;
    END IF;
END