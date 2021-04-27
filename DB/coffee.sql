-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th4 27, 2021 lúc 05:20 AM
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
-- Cấu trúc bảng cho bảng `chitietchuongtrinh`
--

CREATE TABLE `chitietchuongtrinh` (
  `MaKM` varchar(10) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `MaMon` varchar(10) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `GG` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `chitietchuongtrinh`
--

INSERT INTO `chitietchuongtrinh` (`MaKM`, `MaMon`, `GG`) VALUES
('KM1', '01', 10),
('KM1', '02', 10),
('KM1', '03', 25),
('KM2', '04', 10),
('KM2', '05', 15),
('KM2', '06', 5),
('KM3', '02', 10),
('KM3', '04', 20),
('KM3', '06', 20),
('KM4', '01', 20),
('KM4', '02', 10),
('KM4', '03', 10),
('KM5', '03', 10),
('KM5', '06', 20);

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
-- Cấu trúc bảng cho bảng `chitietsanpham`
--

CREATE TABLE `chitietsanpham` (
  `MaMon` varchar(10) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `MaNL` varchar(10) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `KhoiLuong` double NOT NULL,
  `DonViTinh` varchar(10) COLLATE utf8mb4_vietnamese_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `chitietsanpham`
--

INSERT INTO `chitietsanpham` (`MaMon`, `MaNL`, `KhoiLuong`, `DonViTinh`) VALUES
('SP1', '001', 20, 'g');

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
  `NgayBD` date NOT NULL,
  `NgayKT` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

--
-- Đang đổ dữ liệu cho bảng `khuyenmai`
--

INSERT INTO `khuyenmai` (`MaKM`, `TenCT`, `NgayBD`, `NgayKT`) VALUES
('KM1', 'Happy Hours', '2020-01-20', '2020-01-25'),
('KM2', 'Hallowen', '2020-10-20', '2020-10-28'),
('KM3', 'Back To School', '2020-08-20', '2020-09-25'),
('KM4', 'Sugar Rush', '2020-05-01', '2020-05-20'),
('KM5', 'Free For All', '2020-12-20', '2020-12-24'),
('KM6', '...', '2020-06-12', '2020-12-06');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sanpham`
--

CREATE TABLE `sanpham` (
  `MaMon` varchar(10) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `MaLoai` varchar(10) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `TenMon` varchar(50) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `DonGia` double NOT NULL,
  `SoLuongDT` double NOT NULL,
  `DonViTinh` varchar(10) COLLATE utf8mb4_vietnamese_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `chitietchuongtrinh`
--
ALTER TABLE `chitietchuongtrinh`
  ADD PRIMARY KEY (`MaKM`,`MaMon`);

--
-- Chỉ mục cho bảng `chitiethoadon`
--
ALTER TABLE `chitiethoadon`
  ADD PRIMARY KEY (`MaHD`,`MaMon`);

--
-- Chỉ mục cho bảng `chitietsanpham`
--
ALTER TABLE `chitietsanpham`
  ADD PRIMARY KEY (`MaMon`,`MaNL`);

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

--
-- Chỉ mục cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  ADD PRIMARY KEY (`MaMon`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
