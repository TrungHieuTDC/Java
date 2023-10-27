-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1:3306
-- Thời gian đã tạo: Th6 06, 2023 lúc 04:27 PM
-- Phiên bản máy phục vụ: 5.7.31
-- Phiên bản PHP: 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `ql_showroom`
--
CREATE DATABASE IF NOT EXISTS `ql_showroom` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
USE `ql_showroom`;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chinhanh`
--

DROP TABLE IF EXISTS `chinhanh`;
CREATE TABLE IF NOT EXISTS `chinhanh` (
  `TenChiNhanh` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `DiaChi` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `NhanVienQuanLy` varchar(200) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `chinhanh`
--

INSERT INTO `chinhanh` (`TenChiNhanh`, `DiaChi`, `NhanVienQuanLy`) VALUES
('Bình Dương', 'Thành phố Thủ Dầu Một', 'Trung Hiếu'),
('Thử Đức', 'Thành phố Thủ Dầu Một', 'Xuân Oanh'),
('Ninh Bình', 'Thành phố Ninh Bình', 'Ngọc Yến');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `giaodich`
--

DROP TABLE IF EXISTS `giaodich`;
CREATE TABLE IF NOT EXISTS `giaodich` (
  `MaGiaoDich` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `ThoiGian` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `TenKhachHang` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `TenNhanVien` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `TrangThai` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `GiaBan` int(11) NOT NULL,
  `SoLuong` int(11) NOT NULL,
  `TenOto` varchar(200) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `giaodich`
--

INSERT INTO `giaodich` (`MaGiaoDich`, `ThoiGian`, `TenKhachHang`, `TenNhanVien`, `TrangThai`, `GiaBan`, `SoLuong`, `TenOto`) VALUES
('0011', '2023', 'Trung Hiếu', 'Xuân Oanh', 'Đang giao hàng', 500000000, 5, 'faDSAXAXAs'),
('000', '2022', 'Ngọc Yến', 'Trung Hiếu', 'Đang giao hàng', 32323232, 5, 'MEcSCis'),
('003', '2012', 'Hieu', 'Oanh', 'Chưa giao hàng', 555555, 4, 'LuxuV'),
('004', '2019', 'LInh', 'Cương', 'Đã giao hàng', 555555, 4, 'LuxuV');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `oto`
--

DROP TABLE IF EXISTS `oto`;
CREATE TABLE IF NOT EXISTS `oto` (
  `MaXe` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `TenXe` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `MauSacNoiThat` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `XuatXu` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `DongCo` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `MoTa` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `Gia` float NOT NULL,
  `SoGhe` int(11) NOT NULL,
  `TrangThai` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `ChieuDai` int(11) NOT NULL,
  `ChieuCao` int(11) NOT NULL,
  `SoLuong` int(11) NOT NULL,
  `HinhAnh` text COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`MaXe`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `oto`
--

INSERT INTO `oto` (`MaXe`, `TenXe`, `MauSacNoiThat`, `XuatXu`, `DongCo`, `MoTa`, `Gia`, `SoGhe`, `TrangThai`, `ChieuDai`, `ChieuCao`, `SoLuong`, `HinhAnh`) VALUES
('X001', 'Toyota Camry', 'Đen', 'Nhật Bản', '2.5L', 'Xe sedan hạng D', 500000000, 5, 'Còn hàng', 4850, 1450, 10, 'camry.jpg'),
('XC01', 'Suziki', 'đen trắng', 'Việt Nam', 'DCC322', 'Xe rất đẹp và thời trang', 5000000000, 5, 'Mới', 50, 30, 5, 'E:\\cún\\car.jpg'),
('X002', 'Honda Civic', 'Trắng', 'Nhật Bản', '1.8L', 'Xe sedan hạng C', 400000000, 5, 'Còn hàng', 4680, 1416, 8, 'civic.jpg'),
('X003', 'Ford Ranger', 'Xám', 'Mỹ', '2.2L', 'Xe bán tải', 600000000, 5, 'Còn hàng', 5351, 1848, 15, 'ranger.jpg'),
('X004', 'Mazda CX-5', 'Nâu', 'Nhật Bản', '2.0L', 'Xe SUV', 550000000, 5, 'Còn hàng', 4550, 1675, 12, 'cx5.jpg'),
('X005', 'Hyundai Sonata', 'Bạc', 'Hàn Quốc', '2.0L', 'Xe sedan hạng D', 450000000, 5, 'Còn hàng', 4855, 1475, 7, 'sonata.jpg'),
('X006', 'Chevrolet Cruze', 'Xanh', 'Mỹ', '1.8L', 'Xe sedan hạng C', 380000000, 5, 'Còn hàng', 4666, 1484, 9, 'cruze.jpg'),
('X007', 'Kia Seltos', 'Đỏ', 'Hàn Quốc', '1.4L', 'Xe SUV', 430000000, 5, 'Còn hàng', 4315, 1615, 11, 'seltos.jpg'),
('X008', 'Nissan Navara', 'Trắng', 'Nhật Bản', '2.5L', 'Xe bán tải', 650000000, 5, 'Còn hàng', 5255, 1850, 14, 'navara.jpg'),
('X009', 'Volkswagen Tiguan', 'Xanh', 'Đức', '2.0L', 'Xe SUV', 580000000, 5, 'Còn hàng', 4701, 1674, 13, 'tiguan.jpg'),
('X010', 'Lexus RX 350', 'Bạc', 'Nhật Bản', '3.5L', 'Xe SUV', 900000000, 5, 'Còn hàng', 4890, 1685, 6, 'rx350.jpg');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `maNV` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `tenNV` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `matKhau` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`maNV`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `users`
--

INSERT INTO `users` (`maNV`, `tenNV`, `matKhau`) VALUES
('admin', 'admin', '111111'),
('nv001', 'Trung Hiếu', '111111');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
