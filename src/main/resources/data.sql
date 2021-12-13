INSERT INTO `usuario` (
    `id`,
    `apellido`,
    `email`,
    `nombre`,
    `nombre_usuario`,
    `num_doc`,
    `password`,
    `telefono`,
    `tipo_doc`,
    `token_password`
  )
VALUES
  (
    '1',
    'ADMIN',
    'ADMIN@ADMIN.COM',
    'ADMIN',
    'ADMIN',
    '111111',
    '$2a$10$Kh1wAmamgeEIJvIPZECRkOSlrdyIZRukiwWqLp1lBgog/5Ukvdzce',
    '11111',
    'CC',
    NULL
  );

INSERT INTO `estado_inmueble` (
    `id`, 
    `estado`, 
    `fecha`) 
VALUES ('1', 'NO ASIGNADO', '2021-12-13 02:30:17.000000' );

INSERT INTO `rol` (`id`, `rol_nombre`) VALUES ('1', 'ROLE_ADMIN');
INSERT INTO `rol` (`id`, `rol_nombre`) VALUES ('2', 'ROLE_USER');

INSERT INTO `usuario_rol` (`usuario_id`, `rol_id`) VALUES ('1', '1');