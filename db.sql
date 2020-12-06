-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Anamakine: 127.0.0.1
-- Üretim Zamanı: 06 Ara 2020, 09:30:58
-- Sunucu sürümü: 10.4.14-MariaDB
-- PHP Sürümü: 7.2.34

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `spring-project`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `logins`
--

CREATE TABLE `logins` (
  `username` varchar(50) NOT NULL,
  `series` varchar(64) NOT NULL,
  `token` varchar(64) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `persistent_logins`
--

CREATE TABLE `persistent_logins` (
  `username` varchar(50) NOT NULL,
  `series` varchar(64) NOT NULL,
  `token` varchar(64) NOT NULL,
  `last_used` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `product`
--

CREATE TABLE `product` (
  `id` int(11) NOT NULL COMMENT 'product_id',
  `name` varchar(100) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `detail_description` varchar(500) DEFAULT NULL,
  `price` double NOT NULL DEFAULT 0,
  `stock` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `product`
--

INSERT INTO `product` (`id`, `name`, `description`, `detail_description`, `price`, `stock`) VALUES
(1, 'Jet Ski', 'description of Jet Ski', 'detail description of Jet Ski', 10, 2),
(2, 'Bubble Wrap', 'description of Bubble Wrap', 'detail description of Bubble Wrap', 20, 3),
(3, 'Onesies', 'description of Onesies', 'detail description of Onesies', 20, 3),
(4, 'Jacuzzi', 'description of Jacuzzi', 'detail description of Jacuzzi', 20, 3),
(5, 'Crock', 'description of Crock', 'detail description of Crock', 20, 3),
(6, 'Fluffernutter', 'description of Fluffernutter', 'detail description of Fluffernutter', 20, 3),
(7, 'Seeing Eye Dog', 'description of Seeing Eye Dog', 'detail description of Seeing Eye Dog', 20, 3),
(8, 'Breathalyzer', 'description of Breathalyzer', 'detail description of Breathalyzer', 20, 3),
(9, 'Zamboni', 'description of Zamboni', 'detail description of Zamboni', 10, 2),
(10, 'Chapstick ', 'description of Chapstick ', 'detail description of Chapstick ', 20, 3),
(11, 'Kleenex', 'description of Kleenex', 'detail description of Kleenex', 10, 2),
(12, 'Ping-Pong', 'description of Ping-Pong', 'detail description of Ping-Pong', 10, 2),
(13, 'Popsicle ', 'description of Popsicle ', 'detail description of Popsicle ', 10, 2),
(14, 'Q-Tips', 'description of Q-Tips', 'detail description of Q-Tips', 10, 2),
(15, 'Rollerblades', 'description of Rollerblades', 'detail description of Rollerblades', 10, 2),
(16, 'Scotch Tape', 'description of Scotch Tape', 'detail description of Scotch Tape', 20, 3),
(17, 'Sharpie', 'description of Sharpie', 'detail description of Sharpie', 20, 3),
(18, 'Realtor', 'description of Realtor', 'detail description of Realtor', 20, 3),
(19, 'Tupperware', 'description of Tupperware', 'detail description of Tupperware', 20, 3),
(20, 'Velcro', 'description of Velcro', 'detail description of Velcro', 20, 3),
(21, 'Weed Eater', 'description of Weed Eater', 'detail description of Weed Eater', 20, 3),
(22, 'Wite-Out', 'description of Wite-Out', 'detail description of Wite-Out', 20, 3),
(23, 'Band-Aids', 'description of Band-Aids', 'detail description of Band-Aids', 10, 2),
(24, 'TASER ', 'description of TASER ', 'detail description of TASER ', 20, 3);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `role`
--

CREATE TABLE `role` (
  `id` int(11) NOT NULL,
  `name` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `surname` varchar(50) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(200) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  `is_active` varchar(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `user`
--

INSERT INTO `user` (`id`, `name`, `surname`, `username`, `password`, `email`, `role_id`, `is_active`) VALUES
(1, 'Öznur', 'KÜTÜKÇÜ', 'znrktkc', '$2y$12$EEHxFilXBCO93Us05U8jKO5nrTUvmIKxU2Kb5ZOH67Pw8QQKrX01e', '1', 1, '1'),
(2, 'Öznur', 'KÜTÜKÇÜ', 'znrktkc11', '$2y$12$EEHxFilXBCO93Us05U8jKO5nrTUvmIKxU2Kb5ZOH67Pw8QQKrX01e', '1', 1, '1');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `user-role`
--

CREATE TABLE `user-role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `logins`
--
ALTER TABLE `logins`
  ADD PRIMARY KEY (`series`);

--
-- Tablo için indeksler `persistent_logins`
--
ALTER TABLE `persistent_logins`
  ADD PRIMARY KEY (`series`);

--
-- Tablo için indeksler `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id` (`id`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `role`
--
ALTER TABLE `role`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Tablo için AUTO_INCREMENT değeri `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
