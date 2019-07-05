-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: db
-- Generation Time: Jan 20, 2019 at 12:48 AM
-- Server version: 5.7.24
-- PHP Version: 7.2.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";

--
-- Database: `test_db`
--
CREATE DATABASE IF NOT EXISTS `test_db` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `test_db`;

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE `account` (
  `number` varchar(32) NOT NULL,
  `name` varchar(32) NOT NULL,
  `number_code` varchar(10) NOT NULL,
  `type` int(11) DEFAULT NULL,
  `address` varchar(128) NOT NULL,
  `full_name` varchar(128) NOT NULL,
  `bank_id` int(11) NOT NULL,
  `bank_id_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`number`, `name`, `number_code`, `type`, `address`, `full_name`, `bank_id`, `bank_id_id`) VALUES
('31926819', 'W Owens', 'BBAN', 0, '1 The Beneficiary Localtown SE2', 'Wilfred Jeremiah Owens', 403000, NULL),
('56781234', 'Tomislav Landeka', 'BBAN', 0, 'London ASAP', 'Tomo Landeka Tom', 123123, NULL),
('GB29XABC10161234567801', '403000', 'IBAN', 0, '10 Debtor Crescent Sourcetown NE1', 'Emelia Jane Brown', 203301, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `bank`
--

CREATE TABLE `bank` (
  `id` int(11) NOT NULL,
  `code` varchar(10) NOT NULL,
  `name` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bank`
--

INSERT INTO `bank` (`id`, `code`, `name`) VALUES
(123123, 'GBDSC', 'Mostar Bank'),
(203301, 'GBDSC', 'Zagreb Bank'),
(403000, 'GBDSC', 'London Bank');

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE `payment` (
  `id` varchar(64) NOT NULL,
  `type` varchar(64) NOT NULL,
  `version` smallint(6) NOT NULL,
  `amount` decimal(20,6) NOT NULL,
  `currency` varchar(3) NOT NULL,
  `end_to_end_reference` varchar(64) NOT NULL,
  `numeric_reference` varchar(64) NOT NULL,
  `reference` varchar(64) NOT NULL,
  `payment_id` varchar(64) NOT NULL,
  `payment_purpose` varchar(64) NOT NULL,
  `payment_scheme` varchar(64) NOT NULL,
  `payment_type` varchar(64) NOT NULL,
  `processing_date` date NOT NULL,
  `scheme_payment_type` varchar(64) NOT NULL,
  `fx_contract_reference` varchar(64) NOT NULL,
  `fx_exchange_rate` decimal(20,6) NOT NULL,
  `fx_original_currency` varchar(64) NOT NULL,
  `beneficiary_account_number` varchar(64) NOT NULL,
  `debtor_account_number` varchar(64) NOT NULL,
  `sponsor_account_number` varchar(64) NOT NULL,
  `bearer_code` varchar(64) NOT NULL,
  `sender_charge_amount` decimal(20,6) NOT NULL DEFAULT '0.000000',
  `receiver_charge_amount` decimal(20,6) NOT NULL DEFAULT '0.000000',
  `organisation_id` varchar(255) DEFAULT NULL,
  `scheme_payment_sub_type` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`number`),
  ADD KEY `bank_id_fk` (`bank_id`);

--
-- Indexes for table `bank`
--
ALTER TABLE `bank`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`id`),
  ADD KEY `beneficiary_account_number_fk` (`beneficiary_account_number`),
  ADD KEY `debtor_account_number_fk` (`debtor_account_number`),
  ADD KEY `sponsor_account_number_fk` (`sponsor_account_number`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `account`
--
ALTER TABLE `account`
  ADD CONSTRAINT `bank_id_fk` FOREIGN KEY (`bank_id`) REFERENCES `bank` (`id`);

--
-- Constraints for table `payment`
--
ALTER TABLE `payment`
  ADD CONSTRAINT `beneficiary_account_number_fk` FOREIGN KEY (`beneficiary_account_number`) REFERENCES `account` (`number`),
  ADD CONSTRAINT `debtor_account_number_fk` FOREIGN KEY (`debtor_account_number`) REFERENCES `account` (`number`),
  ADD CONSTRAINT `sponsor_account_number_fk` FOREIGN KEY (`sponsor_account_number`) REFERENCES `account` (`number`);
COMMIT;
