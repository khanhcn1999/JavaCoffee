-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th5 09, 2021 lúc 03:19 PM
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
('m2', 'nl3', 'nước ngọt', 10, 30000, 300000),
('m3', 'nl2', 'cà phê', 5, 30000, 150000),
('m2', 'nl3', 'nước ngọt', 10, 30000, 300000),
('m2', 'nl3', 'nước ngọt', 10, 30000, 300000),
('m4', 'nl1', 'cà phê', 10, 20000, 200000),
('m10', 'nl3', 'nước ', 10, 30000, 300000),
('werth', 'sdfg', 'sdfsdf', 12, 123, 1476),
('werth', 'sdfg', 'sdfsdf', 12, 123, 1476),
('werth', 'sdfg', 'sdfsdf', 12, 123, 1476),
('m123', 'nl1', 'khoa', 12, 123, 1476),
('m123', 'nl2', 'khanh', 12, 123, 1476),
('m123', 'nl2', 'khanh', 12, 123, 1476),
('m123', 'nl2', 'khanh', 12, 123, 1476),
('m123', 'nl2', 'khanh', 12, 123, 1476),
('m123', 'nl3', 'khanh cho', 12, 123, 1476),
('m123', 'nl1', 'khoa', 10, 123, 1230),
('m123', 'nl3', 'khanh cho', 12, 123, 1476),
('m123', 'nl3', 'khanh cho', 12, 123, 1476),
('m123', 'nl3', 'khanh cho', 12, 123, 1476),
('m123', 'nl3', 'khanh cho', 12, 123, 1476),
('m123', 'nl3', 'khanh cho', 12, 123, 1476),
('m123', 'nl1', 'khoa', 10, 123, 1230),
('m123', 'nl3', 'khanh cho', 12, 123, 1476),
('m123', 'nl3', 'khanh cho', 12, 123, 1476),
('m123', 'nl3', 'khanh cho', 12, 123, 1476),
('m123', 'nl1', 'khoa', 10, 123, 1230),
('m123', 'nl1', 'khoa', 10, 123, 1230),
('m123', 'nl3', 'khanh cho', 12, 123, 1476);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhacungcap`
--

CREATE TABLE `nhacungcap` (
  `MaNhaCungCap` varchar(10) NOT NULL,
  `TenNhaCungCap` varchar(50) NOT NULL,
  `SoDienThoai` varchar(10) NOT NULL,
  `DiaChi` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `nhacungcap`
--

INSERT INTO `nhacungcap` (`MaNhaCungCap`, `TenNhaCungCap`, `SoDienThoai`, `DiaChi`) VALUES
('NCC1', 'Davinci', '0351234567', 'tp Hồ Chí Minh'),
('NCC2', 'Vinamilk', '0354175058', 'tp Hồ Chí Minh'),
('NCC3', 'Trung Nguyên', '0351234458', 'tp Hồ Chí Minh'),
('NCC4', 'NutriFood', '0961845279', 'tp Hồ Chí Minh'),
('NCC5', 'DaLatmilk', '039456', 'Đà Lạt'),
('NCC6', 'NutriFood', '0961845897', 'tp Hồ Chí Minh');

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
-- Cấu trúc bảng cho bảng `nl`
--

CREATE TABLE `nl` (
  `maNL` varchar(300) CHARACTER SET utf8mb4 NOT NULL,
  `tenNL` varchar(300) CHARACTER SET utf8mb4 NOT NULL,
  `soluong` double NOT NULL,
  `dongia` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `nl`
--

INSERT INTO `nl` (`maNL`, `tenNL`, `soluong`, `dongia`) VALUES
('nl1', 'khoa', 20, 123);

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
('', '3119410195', 'NCC2', '2021-12-21', 13435),
('m10', '3119410195', 'NCC2', '2021-12-21', 300000),
('m123', '3119410182', 'NCC2', '2021-05-09', 27060),
('m2', '3119410195', 'NCC01', '2021-05-06', 900000),
('m3', '3119410182', 'NCC01', '2021-12-05', 150000),
('m4', '3119410195', 'NCC3', '2021-05-07', 200000),
('m5', '3119410195', 'NCC01', '2021-04-07', 900000);

--
-- Chỉ mục cho các bảng đã đổ
--

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
-- Chỉ mục cho bảng `nl`
--
ALTER TABLE `nl`
  ADD PRIMARY KEY (`maNL`);

--
-- Chỉ mục cho bảng `phieunhaphang`
--
ALTER TABLE `phieunhaphang`
  ADD PRIMARY KEY (`MaPhieuNhap`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
