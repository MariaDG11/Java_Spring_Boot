-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 18-06-2020 a las 14:57:01
-- Versión del servidor: 10.4.11-MariaDB
-- Versión de PHP: 7.4.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `finalproject`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `answer`
--

CREATE TABLE `answer` (
  `id_answer` int(11) NOT NULL,
  `body_answer` varchar(255) DEFAULT NULL,
  `id_multi_answer` int(11) NOT NULL,
  `id_container` int(11) NOT NULL,
  `id_question` int(11) NOT NULL,
  `id_survey` int(11) NOT NULL,
  `id_user` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `container`
--

CREATE TABLE `container` (
  `id_container` int(11) NOT NULL,
  `title` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `container`
--

INSERT INTO `container` (`id_container`, `title`) VALUES
(1, 'Datos Personales'),
(2, 'Introducción a la Programación'),
(3, 'Proposición');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `multiple_answer`
--

CREATE TABLE `multiple_answer` (
  `id_multi_answer` int(11) NOT NULL,
  `bodyq` varchar(255) DEFAULT NULL,
  `optiona` varchar(255) DEFAULT NULL,
  `optionb` varchar(255) DEFAULT NULL,
  `optionc` varchar(255) DEFAULT NULL,
  `optiond` varchar(255) DEFAULT NULL,
  `id_container` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `multiple_answer`
--

INSERT INTO `multiple_answer` (`id_multi_answer`, `bodyq`, `optiona`, `optionb`, `optionc`, `optiond`, `id_container`) VALUES
(1, '¿Cuantos hermanos tienes?', '6', '8', '3', '1', 1),
(2, '¿Con que lo meneas mejor?', 'Salsa ', 'Bachata', 'Reggaeton', 'Python', 2),
(3, '¿Que notas pondrías al grupo 2?', '10', '9.9', '10', '', 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `question`
--

CREATE TABLE `question` (
  `id_question` int(11) NOT NULL,
  `bodyq` varchar(255) NOT NULL,
  `id_container` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `question`
--

INSERT INTO `question` (`id_question`, `bodyq`, `id_container`) VALUES
(1, '¿Cual es tu nombre?', 1),
(2, '¿Cual es tu Edad?', 1),
(3, '¿Donde vives?', 1),
(4, '¿Cual es tu número de teléfono?', 1),
(5, '¿Te gusta la informática?', 2),
(6, '¿Que piensas de la IA?', 2),
(7, '¿Que opinas del OpenSource?', 2),
(8, '¿Que lenguajes manejas?', 2),
(9, '¿Que opinas del mundo IT?', 3),
(10, '¿En que crees que pueda mejorar?', 3),
(11, '¿Cuéntanos brevemente sobre una experiencia?', 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `survey`
--

CREATE TABLE `survey` (
  `id_survey` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `title` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `survey`
--

INSERT INTO `survey` (`id_survey`, `description`, `title`) VALUES
(12, 'Solucionar problemas a través de la tecnología infomática', 'Programación');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `survey_id_container`
--

CREATE TABLE `survey_id_container` (
  `id_survey_id_survey` int(11) NOT NULL,
  `id_container_id_container` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `survey_id_user`
--

CREATE TABLE `survey_id_user` (
  `surveys_id_user` int(11) NOT NULL,
  `surveys_id_survey` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user`
--

CREATE TABLE `user` (
  `id_user` int(11) NOT NULL,
  `age` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `surname` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `user`
--

INSERT INTO `user` (`id_user`, `age`, `name`, `surname`) VALUES
(1, 34, 'Franklin', 'Alarza');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `answer`
--
ALTER TABLE `answer`
  ADD PRIMARY KEY (`id_answer`),
  ADD KEY `FKse8mdr7lmt9xq6ad6e3fc5und` (`id_multi_answer`),
  ADD KEY `FKa3pp7cdkt364ac1dsbrk8x6pc` (`id_container`),
  ADD KEY `FKco1pkchpedfpv4r4v3nkyxsx3` (`id_question`),
  ADD KEY `FKe447sg18fm3770hkue9o7lkln` (`id_survey`),
  ADD KEY `FK8ddy56hrr3tsqi29o3i5q48al` (`id_user`);

--
-- Indices de la tabla `container`
--
ALTER TABLE `container`
  ADD PRIMARY KEY (`id_container`);

--
-- Indices de la tabla `multiple_answer`
--
ALTER TABLE `multiple_answer`
  ADD PRIMARY KEY (`id_multi_answer`),
  ADD KEY `FKcgjrhucx78kjl8rclr3ohoy8b` (`id_container`);

--
-- Indices de la tabla `question`
--
ALTER TABLE `question`
  ADD PRIMARY KEY (`id_question`),
  ADD KEY `FKi87gb3s4lvuebluxdjeb3hpko` (`id_container`);

--
-- Indices de la tabla `survey`
--
ALTER TABLE `survey`
  ADD PRIMARY KEY (`id_survey`);

--
-- Indices de la tabla `survey_id_container`
--
ALTER TABLE `survey_id_container`
  ADD PRIMARY KEY (`id_survey_id_survey`,`id_container_id_container`),
  ADD KEY `FK43ebusgppabvow3fh5ga17llu` (`id_container_id_container`);

--
-- Indices de la tabla `survey_id_user`
--
ALTER TABLE `survey_id_user`
  ADD PRIMARY KEY (`surveys_id_user`,`surveys_id_survey`),
  ADD KEY `FKi47lwiylet9648fa951gny7nx` (`surveys_id_survey`);

--
-- Indices de la tabla `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `answer`
--
ALTER TABLE `answer`
  MODIFY `id_answer` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `container`
--
ALTER TABLE `container`
  MODIFY `id_container` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `multiple_answer`
--
ALTER TABLE `multiple_answer`
  MODIFY `id_multi_answer` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `question`
--
ALTER TABLE `question`
  MODIFY `id_question` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `survey`
--
ALTER TABLE `survey`
  MODIFY `id_survey` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `user`
--
ALTER TABLE `user`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `answer`
--
ALTER TABLE `answer`
  ADD CONSTRAINT `FK8ddy56hrr3tsqi29o3i5q48al` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`),
  ADD CONSTRAINT `FKa3pp7cdkt364ac1dsbrk8x6pc` FOREIGN KEY (`id_container`) REFERENCES `container` (`id_container`),
  ADD CONSTRAINT `FKco1pkchpedfpv4r4v3nkyxsx3` FOREIGN KEY (`id_question`) REFERENCES `question` (`id_question`),
  ADD CONSTRAINT `FKe447sg18fm3770hkue9o7lkln` FOREIGN KEY (`id_survey`) REFERENCES `survey` (`id_survey`),
  ADD CONSTRAINT `FKse8mdr7lmt9xq6ad6e3fc5und` FOREIGN KEY (`id_multi_answer`) REFERENCES `multiple_answer` (`id_multi_answer`);

--
-- Filtros para la tabla `multiple_answer`
--
ALTER TABLE `multiple_answer`
  ADD CONSTRAINT `FKcgjrhucx78kjl8rclr3ohoy8b` FOREIGN KEY (`id_container`) REFERENCES `container` (`id_container`);

--
-- Filtros para la tabla `question`
--
ALTER TABLE `question`
  ADD CONSTRAINT `FKi87gb3s4lvuebluxdjeb3hpko` FOREIGN KEY (`id_container`) REFERENCES `container` (`id_container`);

--
-- Filtros para la tabla `survey_id_container`
--
ALTER TABLE `survey_id_container`
  ADD CONSTRAINT `FK43ebusgppabvow3fh5ga17llu` FOREIGN KEY (`id_container_id_container`) REFERENCES `container` (`id_container`),
  ADD CONSTRAINT `FK4h7jquogf3pp1yfqjqse4ai6t` FOREIGN KEY (`id_survey_id_survey`) REFERENCES `survey` (`id_survey`);

--
-- Filtros para la tabla `survey_id_user`
--
ALTER TABLE `survey_id_user`
  ADD CONSTRAINT `FK278txpf75nveuq086qn3ppyr7` FOREIGN KEY (`surveys_id_user`) REFERENCES `user` (`id_user`),
  ADD CONSTRAINT `FKi47lwiylet9648fa951gny7nx` FOREIGN KEY (`surveys_id_survey`) REFERENCES `survey` (`id_survey`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
