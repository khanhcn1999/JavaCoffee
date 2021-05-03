-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th5 03, 2021 lúc 04:52 PM
-- Phiên bản máy phục vụ: 10.4.17-MariaDB
-- Phiên bản PHP: 8.0.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `coffee`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitiethoadon`
--

CREATE TABLE `chitiethoadon` (
  `MaHD` varchar(10) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `MaMon` varchar(10) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `SoLuong` double NOT NULL,
  `DonGia` double NOT NULL,
  `ThanhTien` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hoadon`
--

CREATE TABLE `hoadon` (
  `MaHD` varchar(10) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `MaNV` varchar(10) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `MaTV` varchar(10) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `MaKM` varchar(10) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `NgayLHD` date NOT NULL,
  `TongTien` double NOT NULL,
  `TienKhuyenMai` double NOT NULL,
  `ThanhToan` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khuyenmai`
--

CREATE TABLE `khuyenmai` (
  `MaKM` varchar(10) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `TenCT` varchar(50) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `GG` double NOT NULL,
  `NgayBD` date NOT NULL,
  `NgayKT` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `khuyenmai`
--

INSERT INTO `khuyenmai` (`MaKM`, `TenCT`, `GG`, `NgayBD`, `NgayKT`) VALUES
('KM1', 'HappyDay', 20, '2020-10-20', '2020-10-25'),
('KM2', 'HappyHour', 50, '2020-12-20', '2020-12-20'),
('KM3', 'Hallowen', 25, '2020-10-01', '2020-10-10'),
('KM4', 'Back To School', 20, '2020-08-20', '2020-08-28'),
('KM5', 'Way Back Home', 20, '2020-01-01', '2020-01-25'),
('KM6', 'HappyDay', 20, '2020-10-20', '2020-10-25');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `chitiethoadon`
--
ALTER TABLE `chitiethoadon`
  ADD PRIMARY KEY (`MaHD`);

--
-- Chỉ mục cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  ADD PRIMARY KEY (`MaHD`);

--
-- Chỉ mục cho bảng `khuyenmai`
--
ALTER TABLE `khuyenmai`
  ADD PRIMARY KEY (`MaKM`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
