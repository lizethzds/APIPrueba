CREATE DEFINER=`adminCS`@`localhost` PROCEDURE `editarSucursal`(
    IN _id INT,
    IN _nombre VARCHAR(100),
    IN _nombre_comercial VARCHAR(100),
    IN _nombre_representante VARCHAR(100),
    IN _email VARCHAR(40),
    IN _telefono VARCHAR(20),
    IN _logo LONGBLOB,
    IN _pagina_web VARCHAR(100),
    IN _calle VARCHAR(50),
    IN _numero INT,
    IN _colonia VARCHAR(55),
    IN _codigo_postal INT,
    IN _id_ciudad INT,
    
    INOUT _filasAfectadas INT,
    INOUT _error VARCHAR(255)
)
BEGIN
    SET @filasDomicilio = 0;
    SET @filasEmpresa = 0;
    SET _filasAfectadas = 0;
    SET _error = '';

    START TRANSACTION;

    -- Verificar si la empresa existe
    IF EXISTS(SELECT * FROM empresa WHERE id = _id) THEN
        -- Obtener el direccion_id asociado a la empresa
        SET @direccion_id = (SELECT direccion_id FROM empresa WHERE id = _id);

        -- Actualizar domicilio asociado
        IF EXISTS(SELECT * FROM domicilio WHERE id = @direccion_id) THEN
            UPDATE domicilio SET 
                calle = IFNULL(_calle, calle),
                codigo_postal = IFNULL(_codigo_postal, codigo_postal),
                colonia = IFNULL(_colonia, colonia),
                numero = IFNULL(_numero, numero),
                id_ciudad = IFNULL(_id_ciudad, id_ciudad)
            WHERE id = @direccion_id;

            SET @filasDomicilio = ROW_COUNT();
        ELSE
            ROLLBACK;
            SET _error = CONCAT(_error, 'El domicilio asociado no se encuentra en la base de datos.');
            -- Ya no es necesario LEAVE, se detiene por el ROLLBACK
        END IF;

        -- Validar que el nombre de la empresa y la página web no se repitan
        IF NOT EXISTS(SELECT * FROM empresa WHERE nombre = _nombre AND id != _id) THEN
            IF NOT EXISTS(SELECT * FROM empresa WHERE pagina_web = _pagina_web AND id != _id) THEN
                -- Actualizar los datos de la empresa
                UPDATE empresa SET 
                    nombre = IFNULL(_nombre, nombre),
                    nombre_comercial = IFNULL(_nombre_comercial, nombre_comercial),
                    nombre_representante = IFNULL(_nombre_representante, nombre_representante),
                    email = IFNULL(_email, email),
                    telefono = IFNULL(_telefono, telefono),
                    logo = IFNULL(_logo, logo),
                    pagina_web = IFNULL(_pagina_web, pagina_web)
                WHERE id = _id;

                SET @filasEmpresa = ROW_COUNT();
            ELSE
                ROLLBACK;
                SET _error = CONCAT(_error, 'El sitio web ya está registrado.');
            END IF;
        ELSE
            ROLLBACK;
            SET _error = CONCAT(_error, 'El nombre de la empresa ya está registrado.');
        END IF;

        SET _filasAfectadas = @filasDomicilio + @filasEmpresa;
        COMMIT;
    ELSE
        ROLLBACK;
        SET _error = 'La empresa no se encuentra registrada en la base de datos.';
    END IF;
END