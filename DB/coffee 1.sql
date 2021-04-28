-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th4 27, 2021 lúc 06:33 AM
-- Phiên bản máy phục vụ: 10.4.17-MariaDB
-- Phiên bản PHP: 7.3.27

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
-- Cấu trúc bảng cho bảng `chitietphieunhap`
--

CREATE TABLE `chitietphieunhap` (
  `MaPhieuNhap` varchar(10) NOT NULL,
  `MaNguyenLieu` varchar(10) NOT NULL,
  `TenNguyenLieu` varchar(50) NOT NULL,
  `SoLuong` int(11) NOT NULL,
  `DonGia` double NOT NULL,
  `ThanhTien` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `chitietphieunhap`
--

INSERT INTO `chitietphieunhap` (`MaPhieuNhap`, `MaNguyenLieu`, `TenNguyenLieu`, `SoLuong`, `DonGia`, `ThanhTien`) VALUES
('m1', 'nl1', 'trà', 10, 20000, 200000),
('m2', 'nl3', 'cà phê', 5, 30000, 150000),
('m3', 'nl2', 'cà phê', 5, 30000, 150000),
('m2', 'nl3', 'cà phê', 5, 30000, 150000),
('m2', 'nl3', 'cà phê', 5, 30000, 150000),
('m1', 'nl1', 'trà', 10, 20000, 200000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nguyenlieu`
--

CREATE TABLE `nguyenlieu` (
  `MaNguyenLieu` varchar(10) NOT NULL,
  `KhoiLuong` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhacungcap`
--

CREATE TABLE `nhacungcap` (
  `MaNhaCungCap` varchar(10) NOT NULL,
  `TenNhaCungCap` varchar(50) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `SoDienThoai` varchar(10) NOT NULL,
  `DiaChi` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `nhacungcap`
--

INSERT INTO `nhacungcap` (`MaNhaCungCap`, `TenNhaCungCap`, `Email`, `SoDienThoai`, `DiaChi`) VALUES
('NCC01', 'Trung Nguyên', 'caphetrungnguyen@gmail.com', '0351234561', 'Quảng Ngãi'),
('NCC02', 'Davinci', 'davinci@gmail.com', '0356987412', 'tp Hồ Chí Minh');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhanvien`
--

CREATE TABLE `nhanvien` (
  `MaNhanVien` varchar(10) NOT NULL,
  `Ho` varchar(20) NOT NULL,
  `Ten` varchar(10) NOT NULL,
  `Email` varchar(20) NOT NULL,
  `SoDienThoai` varchar(10) NOT NULL,
  `GioiTinh` varchar(3) NOT NULL,
  `ChucVu` varchar(10) NOT NULL,
  `lamviec` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `nhanvien`
--

INSERT INTO `nhanvien` (`MaNhanVien`, `Ho`, `Ten`, `Email`, `SoDienThoai`, `GioiTinh`, `ChucVu`, `lamviec`) VALUES
('3119410182', 'Châu Ngọc', 'Khanh', 'ngockhanh@gmail.com', '0356987412', 'Nam', 'Thu Ngân', 1),
('3119410195', 'Trần Đăng', 'Khoa', 'dangkhoa@gmail.com', '0351234561', 'Nam', 'Thu Ngân', 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phieunhaphang`
--

CREATE TABLE `phieunhaphang` (
  `MaPhieuNhap` varchar(10) NOT NULL,
  `MaNhanVien` varchar(10) NOT NULL,
  `MaNhaCungCap` varchar(10) NOT NULL,
  `NgayNhap` date NOT NULL,
  `TongCong` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `phieunhaphang`
--

INSERT INTO `phieunhaphang` (`MaPhieuNhap`, `MaNhanVien`, `MaNhaCungCap`, `NgayNhap`, `TongCong`) VALUES
('m1', '3119410195', 'NCC01', '2021-04-21', 500000),
('m3', '3119410182', 'NCC02', '2021-06-26', 1000000);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `nguyenlieu`
--
ALTER TABLE `nguyenlieu`
  ADD PRIMARY KEY (`MaNguyenLieu`);

--
-- Chỉ mục cho bảng `nhacungcap`
--
ALTER TABLE `nhacungcap`
  ADD PRIMARY KEY (`MaNhaCungCap`);

--
-- Chỉ mục cho bảng `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`MaNhanVien`);

--
-- Chỉ mục cho bảng `phieunhaphang`
--
ALTER TABLE `phieunhaphang`
  ADD PRIMARY KEY (`MaPhieuNhap`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
