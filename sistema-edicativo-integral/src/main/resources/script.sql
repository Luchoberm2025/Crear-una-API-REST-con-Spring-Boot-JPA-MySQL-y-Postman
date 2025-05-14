INSERT INTO `programa` (`id`, `nombre`) VALUES (NULL, 'Analisis y Desarrollo de Software');

INSERT INTO `programa` (`id`, `nombre`) VALUES (NULL, 'Kotlin');

INSERT INTO `programa` (`id`, `nombre`) VALUES (NULL, 'Javascript');

INSERT INTO `programa` (`id`, `nombre`) VALUES (NULL, 'Html');



INSERT INTO `profesor` (`id`, `apellido`, `especializacion`, `fecha_contratacion`, `nombre`, `programa_id`) VALUES (NULL, 'Gonzalez', 'Software', '2025-05-08', 'Andres', '2');

INSERT INTO `profesor` (`id`, `apellido`, `especializacion`, `fecha_contratacion`, `nombre`, `programa_id`) VALUES (NULL, 'Herrera', 'Software', '2025-04-08', 'Gabriel', '3');

INSERT INTO `profesor` (`id`, `apellido`, `especializacion`, `fecha_contratacion`, `nombre`, `programa_id`) VALUES (NULL, 'Jimenez', 'Software', '2025-05-05', 'Santiago', '4');


INSERT INTO `estudiante` (`id`, `apellido`, `email`, `fecha_ingreso`, `nombre`, `semestre`, `programa_id`) VALUES (NULL, 'Vanegas', 'vanegmail@gmail.com', '2025-05-07', 'Edgar', '3', '2');

INSERT INTO `estudiante` (`id`, `apellido`, `email`, `fecha_ingreso`, `nombre`, `semestre`, `programa_id`) VALUES (NULL, 'Tovar', 'tovargmail@gmail.com', '2025-05-07', 'Edgar', '2', '3');

INSERT INTO `estudiante` (`id`, `apellido`, `email`, `fecha_ingreso`, `nombre`, `semestre`, `programa_id`) VALUES (NULL, 'Vanegas', 'vanegam@gmail.com', '2025-05-07', 'Albeiro', '4', '4');