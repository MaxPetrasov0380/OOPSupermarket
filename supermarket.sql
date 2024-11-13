-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 13, 2024 at 09:11 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `supermarket`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `adminID` int(11) NOT NULL,
  `adminUsername` varchar(50) NOT NULL,
  `adminPass` varchar(50) NOT NULL,
  `adminEmail` varchar(50) NOT NULL,
  `adminBT` varchar(20) NOT NULL,
  `adminAdresa` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`adminID`, `adminUsername`, `adminPass`, `adminEmail`, `adminBT`, `adminAdresa`) VALUES
(1, 'maxpetrasov', 'strilamzy03', 'mzvara9@gmail.com', '0640643000', 'Marsala Tita 88, Aradac');

-- --------------------------------------------------------

--
-- Table structure for table `artikal`
--

CREATE TABLE `artikal` (
  `artikalID` int(11) NOT NULL,
  `artikalNaziv` varchar(100) NOT NULL,
  `artikalVrsta` varchar(50) NOT NULL,
  `artikalCena` float NOT NULL,
  `artikalKolicina` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `kasir`
--

CREATE TABLE `kasir` (
  `kasirID` int(11) NOT NULL,
  `kasirIme` varchar(50) NOT NULL,
  `kasirPrezime` varchar(50) NOT NULL,
  `kasirUsername` varchar(50) NOT NULL,
  `kasirPassword` varchar(50) NOT NULL,
  `kasirEmail` varchar(50) DEFAULT NULL,
  `kasirBT` varchar(50) NOT NULL,
  `kasirAdresa` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `nabavka`
--

CREATE TABLE `nabavka` (
  `nabavkaID` int(11) NOT NULL,
  `artikalID` int(11) NOT NULL,
  `nabavljenaKolicina` int(11) NOT NULL,
  `nabavkaDatum` date NOT NULL,
  `nabavkaCena` float NOT NULL,
  `sefID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `racun`
--

CREATE TABLE `racun` (
  `racunID` int(11) NOT NULL,
  `ukupnaCena` float NOT NULL,
  `datumVreme` datetime NOT NULL,
  `kasirID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `sefnabavke`
--

CREATE TABLE `sefnabavke` (
  `sefID` int(11) NOT NULL,
  `sefUsername` varchar(50) NOT NULL,
  `sefPassword` varchar(50) NOT NULL,
  `sefEmail` varchar(50) NOT NULL,
  `sefBT` varchar(50) NOT NULL,
  `sefAdresa` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`adminID`);

--
-- Indexes for table `artikal`
--
ALTER TABLE `artikal`
  ADD PRIMARY KEY (`artikalID`);

--
-- Indexes for table `kasir`
--
ALTER TABLE `kasir`
  ADD PRIMARY KEY (`kasirID`);

--
-- Indexes for table `nabavka`
--
ALTER TABLE `nabavka`
  ADD PRIMARY KEY (`nabavkaID`),
  ADD KEY `artikalNabavkaFK` (`artikalID`),
  ADD KEY `sefNabavkaFK` (`sefID`);

--
-- Indexes for table `racun`
--
ALTER TABLE `racun`
  ADD PRIMARY KEY (`racunID`),
  ADD KEY `kasirRacunFK` (`kasirID`);

--
-- Indexes for table `sefnabavke`
--
ALTER TABLE `sefnabavke`
  ADD PRIMARY KEY (`sefID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `adminID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `artikal`
--
ALTER TABLE `artikal`
  MODIFY `artikalID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `kasir`
--
ALTER TABLE `kasir`
  MODIFY `kasirID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `nabavka`
--
ALTER TABLE `nabavka`
  MODIFY `nabavkaID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `racun`
--
ALTER TABLE `racun`
  MODIFY `racunID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `sefnabavke`
--
ALTER TABLE `sefnabavke`
  MODIFY `sefID` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `nabavka`
--
ALTER TABLE `nabavka`
  ADD CONSTRAINT `artikalNabavkaFK` FOREIGN KEY (`artikalID`) REFERENCES `artikal` (`artikalID`),
  ADD CONSTRAINT `sefNabavkaFK` FOREIGN KEY (`sefID`) REFERENCES `sefnabavke` (`sefID`);

--
-- Constraints for table `racun`
--
ALTER TABLE `racun`
  ADD CONSTRAINT `kasirRacunFK` FOREIGN KEY (`kasirID`) REFERENCES `kasir` (`kasirID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
