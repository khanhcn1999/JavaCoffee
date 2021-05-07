-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 07, 2021 at 03:38 PM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 7.3.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `coffee`
--

-- --------------------------------------------------------

--
-- Table structure for table `chitietchuongtrinh`
--

CREATE TABLE `chitietchuongtrinh` (
  `MaKM` varchar(10) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `MaMon` varchar(10) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `GG` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

--
-- Dumping data for table `chitietchuongtrinh`
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
-- Table structure for table `chitiethoadon`
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
-- Table structure for table `chitietphieunhap`
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
-- Dumping data for table `chitietphieunhap`
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
-- Table structure for table `chitietsanpham`
--

CREATE TABLE `chitietsanpham` (
  `MaMon` varchar(10) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `MaNL` varchar(10) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `KhoiLuong` double NOT NULL,
  `DonViTinh` varchar(10) COLLATE utf8mb4_vietnamese_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

--
-- Dumping data for table `chitietsanpham`
--

INSERT INTO `chitietsanpham` (`MaMon`, `MaNL`, `KhoiLuong`, `DonViTinh`) VALUES
('SP1', '001', 20, 'g');

-- --------------------------------------------------------

--
-- Table structure for table `hoadon`
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
-- Table structure for table `khuyenmai`
--

CREATE TABLE `khuyenmai` (
  `MaKM` varchar(10) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `TenCT` varchar(50) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `NgayBD` date NOT NULL,
  `NgayKT` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

--
-- Dumping data for table `khuyenmai`
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
-- Table structure for table `nguyenlieu`
--

CREATE TABLE `nguyenlieu` (
  `MaNguyenLieu` varchar(10) NOT NULL,
  `KhoiLuong` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `nhacungcap`
--

CREATE TABLE `nhacungcap` (
  `MaNhaCungCap` varchar(10) NOT NULL,
  `TenNhaCungCap` varchar(50) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `SoDienThoai` varchar(10) NOT NULL,
  `DiaChi` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `nhacungcap`
--

INSERT INTO `nhacungcap` (`MaNhaCungCap`, `TenNhaCungCap`, `Email`, `SoDienThoai`, `DiaChi`) VALUES
('NCC01', 'Trung Nguyên', 'caphetrungnguyen@gmail.com', '0351234561', 'Quảng Ngãi'),
('NCC02', 'Davinci', 'davinci@gmail.com', '0356987412', 'tp Hồ Chí Minh');

-- --------------------------------------------------------

--
-- Table structure for table `nhanvien`
--

CREATE TABLE `nhanvien` (
  `MaNV` varchar(10) COLLATE utf8_vietnamese_ci NOT NULL,
  `HoNV` varchar(30) COLLATE utf8_vietnamese_ci NOT NULL,
  `TenNV` varchar(10) COLLATE utf8_vietnamese_ci NOT NULL,
  `Email` varchar(30) COLLATE utf8_vietnamese_ci DEFAULT NULL,
  `SDT` varchar(10) COLLATE utf8_vietnamese_ci NOT NULL,
  `GioiTinh` varchar(10) COLLATE utf8_vietnamese_ci NOT NULL,
  `ChucVu` varchar(15) COLLATE utf8_vietnamese_ci NOT NULL,
  `TTLamViec` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Dumping data for table `nhanvien`
--

INSERT INTO `nhanvien` (`MaNV`, `HoNV`, `TenNV`, `Email`, `SDT`, `GioiTinh`, `ChucVu`, `TTLamViec`) VALUES
('NV01', 'Ngô', 'Hoàng', 'hoangngo@gmail.com', '0394288833', 'Nam', 'trưởng ca', 1),
('NV02', 'Hoàng ', 'Thy', 'hthchi11@gmail.com', '0832432922', 'Nữ', 'nhân viên', 1),
('NV04', 'Huỳnh Hồng', 'Chi ', 'hthchi@gmail.com', '0123456789', 'Nữ', 'nhân viên', 1),
('NV05', 'Hồ Thị Lâm', 'Như', 'nhu@gmail.com', '09972621', 'Nữ', 'nhân viên', 1),
('NV06', 'Võ Huyền ', 'Trân', 'huyentran201@gmail.com', '0389475277', 'Nữ', 'nhân viên', 1),
('NV07', 'Lý Hoàng', 'Danh', 'hdanh039@gmail.com', '0394829032', 'Nam', 'nhân viên', 1),
('NV08', 'Nguyễn Ngọc', 'Hoài', 'nnhoai@gmail.com', '0837629207', 'Nữ', 'nhân viên', 1),
('QL01', 'Nguyễn ', 'Khuê', 'ngkhue32@gmail.com', '0323438323', 'Nam', 'quản lí', 1);

-- --------------------------------------------------------

--
-- Table structure for table `sanpham`
--

CREATE TABLE `sanpham` (
  `MaMon` varchar(10) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `MaLoai` varchar(10) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `TenMon` varchar(50) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `DonGia` double NOT NULL,
  `SoLuongDT` double NOT NULL,
  `DonViTinh` varchar(10) COLLATE utf8mb4_vietnamese_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

-- --------------------------------------------------------

--
-- Table structure for table `taikhoannd`
--

CREATE TABLE `taikhoannd` (
  `username` varchar(10) COLLATE utf8_vietnamese_ci NOT NULL,
  `password` varchar(20) COLLATE utf8_vietnamese_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Dumping data for table `taikhoannd`
--

INSERT INTO `taikhoannd` (`username`, `password`) VALUES
('cachieu', 'abc'),
('casang', 'abc');

-- --------------------------------------------------------

--
-- Table structure for table `thethanhvien`
--

CREATE TABLE `thethanhvien` (
  `MaTV` varchar(10) COLLATE utf8_vietnamese_ci NOT NULL,
  `HoTen` varchar(30) COLLATE utf8_vietnamese_ci NOT NULL,
  `SDT` varchar(10) COLLATE utf8_vietnamese_ci NOT NULL,
  `Diem` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_vietnamese_ci;

--
-- Dumping data for table `thethanhvien`
--

INSERT INTO `thethanhvien` (`MaTV`, `HoTen`, `SDT`, `Diem`) VALUES
('1', 'Huỳnh Thị Hồng Chi', '0123456789', 100),
('2', 'Châu Ngọc Khanh', '0987654321', 1300),
('3', 'Trần Đăng Khoa', '0987654456', 10),
('4', 'Lao Gia Hào', '0123454321', 5000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `chitietchuongtrinh`
--
ALTER TABLE `chitietchuongtrinh`
  ADD PRIMARY KEY (`MaKM`,`MaMon`);

--
-- Indexes for table `chitiethoadon`
--
ALTER TABLE `chitiethoadon`
  ADD PRIMARY KEY (`MaHD`,`MaMon`);

--
-- Indexes for table `chitietsanpham`
--
ALTER TABLE `chitietsanpham`
  ADD PRIMARY KEY (`MaMon`,`MaNL`);

--
-- Indexes for table `hoadon`
--
ALTER TABLE `hoadon`
  ADD PRIMARY KEY (`MaHD`);

--
-- Indexes for table `khuyenmai`
--
ALTER TABLE `khuyenmai`
  ADD PRIMARY KEY (`MaKM`);

--
-- Indexes for table `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`MaNV`);

--
-- Indexes for table `sanpham`
--
ALTER TABLE `sanpham`
  ADD PRIMARY KEY (`MaMon`);

--
-- Indexes for table `taikhoannd`
--
ALTER TABLE `taikhoannd`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `thethanhvien`
--
ALTER TABLE `thethanhvien`
  ADD PRIMARY KEY (`MaTV`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
