-- phpMyAdmin SQL Dump
-- version 5.1.0-dev
-- https://www.phpmyadmin.net/
--
-- Servidor: 192.168.30.23
-- Tiempo de generación: 09-11-2019 a las 13:28:31
-- Versión del servidor: 8.0.18
-- Versión de PHP: 7.2.24-1+0~20191026.31+debian9~1.gbpbbacde

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `Cliente`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Cliente`
--

CREATE TABLE `Cliente` (
  `Login` varchar(20) COLLATE utf16_spanish_ci NOT NULL,
  `Password` varchar(20) COLLATE utf16_spanish_ci NOT NULL,
  `Email` varchar(40) COLLATE utf16_spanish_ci NOT NULL,
  `Dni` varchar(9) COLLATE utf16_spanish_ci NOT NULL,
  `Nombre` text COLLATE utf16_spanish_ci NOT NULL,
  `Apellidos` text COLLATE utf16_spanish_ci NOT NULL,
  `FechaNacimiento` date NOT NULL,
  `NumTarjeta` varchar(20) COLLATE utf16_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf16 COLLATE=utf16_spanish_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `Cliente`
--
ALTER TABLE `Cliente`
  ADD PRIMARY KEY (`Dni`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

