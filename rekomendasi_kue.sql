-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 04 Agu 2024 pada 17.53
-- Versi Server: 10.1.28-MariaDB
-- PHP Version: 7.1.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `rekomendasi_kue`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `admin`
--

CREATE TABLE `admin` (
  `id` char(3) NOT NULL,
  `namalengkap` varchar(20) DEFAULT NULL,
  `user` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `admin`
--

INSERT INTO `admin` (`id`, `namalengkap`, `user`, `password`) VALUES
('001', 'Naufal Sholahuddin', 'admin', 'admin');

-- --------------------------------------------------------

--
-- Struktur dari tabel `data_kue`
--

CREATE TABLE `data_kue` (
  `id_kue` varchar(5) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `ukuran_kue` varchar(30) NOT NULL,
  `tampilan` varchar(20) NOT NULL,
  `pengemasan` varchar(18) NOT NULL,
  `deskripsi_kue` varchar(100) NOT NULL,
  `harga` int(3) NOT NULL,
  `kualitas` varchar(20) NOT NULL,
  `varian_rasa` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `data_kue`
--

INSERT INTO `data_kue` (`id_kue`, `nama`, `ukuran_kue`, `tampilan`, `pengemasan`, `deskripsi_kue`, `harga`, `kualitas`, `varian_rasa`) VALUES
('01', 'Bolu Keju', 'Besar', 'Bentuk', 'box', 'ini kue', 85000, 'Biasa Saja', 'Creamy'),
('02', 'black forest', 'Besar', 'Warna', 'mika plastik', 'kue ckolat premium', 120000, 'Sangat Baik', 'Sweety'),
('03', 'Sifon Strawberry', 'Besar', 'Warna', 'box kardus', 'bolu lembut', 95000, 'Baik', 'Creamy'),
('04', 'Brownie Sekat', 'Besar', 'Toping', 'Box Pizza', 'dengan toping masam2', 110000, 'Baik', 'Sweety');

-- --------------------------------------------------------

--
-- Struktur dari tabel `kriteria`
--

CREATE TABLE `kriteria` (
  `kd_kriteria` char(3) NOT NULL,
  `nama_kriteria` varchar(30) NOT NULL,
  `prioritas_kepentingan` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `kriteria`
--

INSERT INTO `kriteria` (`kd_kriteria`, `nama_kriteria`, `prioritas_kepentingan`) VALUES
('K1', 'Varian Rasa', 'Sangat Penting ke-1'),
('K2', 'Kualitas', 'Penting ke-2'),
('K3', 'Harga', 'Cukup Penting ke-3'),
('K4', 'Tampilan', 'Biasa ke-4');

-- --------------------------------------------------------

--
-- Struktur dari tabel `register`
--

CREATE TABLE `register` (
  `id` int(3) NOT NULL,
  `email` varchar(50) NOT NULL,
  `user` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `register`
--

INSERT INTO `register` (`id`, `email`, `user`, `password`) VALUES
(1, 'mail@gmail.com', 'admin', 'admin'),
(2, '', '', ''),
(3, '12qwq', 'mff', '1234');

-- --------------------------------------------------------

--
-- Struktur dari tabel `seleksi`
--

CREATE TABLE `seleksi` (
  `id_kue` char(3) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `pengemasan` varchar(18) NOT NULL,
  `hasil_penilaian` decimal(4,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `seleksi`
--

INSERT INTO `seleksi` (`id_kue`, `nama`, `pengemasan`, `hasil_penilaian`) VALUES
('01', 'Bolu Keju', 'box', '0.35'),
('02', 'black forest', 'mika plastik', '0.96'),
('03', 'Sifon Strawberry', 'box kardus', '0.40'),
('04', 'Brownie Sekat', 'Box Pizza', '0.84');

-- --------------------------------------------------------

--
-- Struktur dari tabel `sub_kriteria`
--

CREATE TABLE `sub_kriteria` (
  `no_sub` int(3) NOT NULL,
  `kd_kriteria` char(3) NOT NULL,
  `nama_kriteria` varchar(30) NOT NULL,
  `nama_sub_kriteria` varchar(30) NOT NULL,
  `prioritas_kepentingan` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `sub_kriteria`
--

INSERT INTO `sub_kriteria` (`no_sub`, `kd_kriteria`, `nama_kriteria`, `nama_sub_kriteria`, `prioritas_kepentingan`) VALUES
(1, 'K4', 'Tampilan', 'Toping', 'Sangat Penting ke-1'),
(2, 'K4', 'Tampilan', 'Dekorasi', 'Penting ke-2'),
(3, 'K4', 'Tampilan', 'Bentuk', 'Cukup Penting ke-3'),
(4, 'K4', 'Tampilan', 'Warna', 'Biasa ke-4'),
(5, 'K3', 'Harga', 'Lebih dari 80000', 'Sangat Penting ke-1'),
(6, 'K3', 'Harga', 'Lebih dari 60000', 'Cukup Penting ke-2'),
(7, 'K3', 'Harga', 'Kurang atau Sama Dengan 60000', 'Biasa ke-3'),
(8, 'K2', 'Kualitas', 'Sangat Baik', 'Sangat Penting ke-1'),
(9, 'K2', 'Kualitas', 'Baik', 'Cukup Penting ke-2'),
(10, 'K2', 'Kualitas', 'Biasa Saja', 'Biasa ke-3'),
(11, 'K1', 'Varian Rasa', 'Sweety', 'Sangat Penting ke-1'),
(12, 'K1', 'Varian Rasa', 'Creamy', 'Penting ke-2'),
(13, 'K1', 'Varian Rasa', 'Milky', 'Cukup Penting ke-3'),
(14, 'K1', 'Varian Rasa', 'Savory', 'Biasa ke-4');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `data_kue`
--
ALTER TABLE `data_kue`
  ADD PRIMARY KEY (`id_kue`);

--
-- Indexes for table `kriteria`
--
ALTER TABLE `kriteria`
  ADD PRIMARY KEY (`kd_kriteria`);

--
-- Indexes for table `register`
--
ALTER TABLE `register`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `seleksi`
--
ALTER TABLE `seleksi`
  ADD UNIQUE KEY `no_id` (`id_kue`);

--
-- Indexes for table `sub_kriteria`
--
ALTER TABLE `sub_kriteria`
  ADD PRIMARY KEY (`no_sub`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `register`
--
ALTER TABLE `register`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
