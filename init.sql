-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 26-08-2024 a las 00:48:30
-- Versión del servidor: 8.3.0
-- Versión de PHP: 8.2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `matriculacionfinal`
--

--
-- Volcado de datos para la tabla `agencia`
--

INSERT INTO `agencia` (`id`, `descripcion`, `direccion`, `telefono`, `horainicio`, `horafin`, `foto`) VALUES
(1, 'Los Chillos', 'Los Chillos, Gnral. Rumiñahui', '099 980 7371', '09:00:00', '16:30:00', 'chillos.webp'),
(2, 'Cotocollao', 'Bicentenario, Parque Bicentenario', '023952300', '08:30:00', '15:30:00', 'bicentenario.jpg'),
(3, 'Quitumbe', 'Florida Alta,  Calle Alcantaras', '022254151', '09:00:00', '16:30:00', 'guajalo.jpg'),
(4, 'Florida', 'Guajalo, Av Pucará y Mariscal Sucre', '022254151', '08:00:00', '16:00:00', 'floridaAlta.jpg'),
(5, 'Carapungo', 'San Isidro del Inca, De los Guayabos ', '022402436', '07:00:00', '15:00:00', 'inca.jpg');

--
-- Volcado de datos para la tabla `color`
--

INSERT INTO `color` (`id`, `descripcion`) VALUES
(2, 'Negro'),
(3, 'Rojo'),
(4, 'Azul'),
(5, 'Plomo'),
(6, 'Verde'),
(7, 'Negro'),
(8, 'Plata'),
(9, 'Morado'),
(10, 'Naranja');

--
-- Volcado de datos para la tabla `marca`
--

INSERT INTO `marca` (`id`, `descripcion`, `pais`, `direccion`, `foto`) VALUES
(1, 'Chévrolet', 'USA', 'Michigan', 'chevrolet.jpg'),
(2, 'Fiat', 'Italia', 'Turin', 'fiat.jpg'),
(4, 'Great Wall', 'China', 'Baoding', 'GreatWall.jpg'),
(5, 'Toyota', 'Japón', 'Aichi', 'toyota.jpg'),
(6, 'Volkswagen', 'Alemania', 'Stadtmitte', 'volkswagen.jpg'),
(7, 'Honda', 'Japón', 'Tokio', 'honda.jpg'),
(8, 'Ford', 'USA', 'Michigan', 'ford.jpg'),
(9, 'Nissan', 'Japón', 'Yakohama', 'nissan.jpg'),
(10, 'Renault', 'Francia', 'Billancourt', 'renault.jpg'),
(11, 'Hyundai', 'Corea del Sur', 'Seul', 'hyundai.jpg'),
(12, 'BMW', 'Alemania', 'Munich', 'bmw.jpg'),
(13, 'Mercedes-Benz', 'Alemania', 'Stuttgart', 'mercedes.jpg'),
(14, 'Audi', 'Alemania', 'Ingolstadt', 'audi.jpg'),
(15, 'Kia', 'Corea del Sur', 'Seul', 'kia.jpg'),
(16, 'Mazda', 'Japón', 'Hiroshima', 'mazda.jpg'),
(17, 'Volvo', 'Suecia', 'Gotemburgo', 'volvo.jpg'),
(18, 'Peugeot', 'Francia', 'Malmaison', 'peugeot.jpg'),
(19, 'Subaru', 'Japón', 'Tokio', 'subaru.jpg'),
(20, 'Jeep', 'USA', 'Hills', 'jeep.jpg'),
(47, 'CHANGAN', 'EEUU', 'CHANGAN', 'changan.jpg');

--
-- Volcado de datos para la tabla `matricula`
--

INSERT INTO `matricula` (`id`, `fecha`, `vehiculo`, `agencia`, `anio`) VALUES
(2, '2023-05-19', 5, 1, 2018),
(3, '2023-05-19', 5, 1, 2019),
(4, '2023-05-19', 5, 1, 2000),
(6, '2023-05-26', 5, 5, 2023),
(8, '2024-08-13', 5, 3, 2020);

--
-- Volcado de datos para la tabla `vehiculo`
--

INSERT INTO `vehiculo` (`id`, `placa`, `marca`, `motor`, `chasis`, `combustible`, `anio`, `color`, `foto`, `avaluo`) VALUES
(5, 'PCH3465', 5, 'dededeprueba', 'Dede', 'Eléctrico', 2017, 3, 'toyota_celeste.jpg', 25415.00),
(7, 'CHH3465', 10, 'edcdede', 'Dedede', 'Gasolina', 2017, 9, 'Ferrari_negro.jpg', 25412.00),
(8, 'HGF1235', 12, 'abcd', '1234', 'Eléctrico', 2020, 8, 'Honda_Rojo.jpg', 30000.00);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
