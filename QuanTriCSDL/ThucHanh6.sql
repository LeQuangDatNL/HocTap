-- Tạo cơ sở dữ liệu
CREATE DATABASE BaiThucHanh6;
GO

-- Sử dụng cơ sở dữ liệu vừa tạo
USE BaiThucHanh6;
GO

-- Tạo bảng Customer (Khách hàng)
CREATE TABLE Customer (
    cID INT PRIMARY KEY,   -- Mã khách hàng
    cName VARCHAR(25),      -- Tên khách hàng
    cAge TINYINT            -- Tuổi của khách hàng
);

-- Tạo bảng Order (Hóa đơn)
CREATE TABLE [Order] (
    oID INT PRIMARY KEY,    -- Mã hóa đơn
    cID INT,                -- Khóa ngoại, tham chiếu đến Customer (Mã khách hàng)
    oDate DATETIME,         -- Ngày mua hàng
    oTotalPrice INT,        -- Tổng giá trị hóa đơn
    CONSTRAINT FK_Order_Customer FOREIGN KEY (cID) REFERENCES Customer(cID)
);

-- Tạo bảng Product (Sản phẩm)
CREATE TABLE Product (
    pID INT PRIMARY KEY,    -- Mã sản phẩm
    pName VARCHAR(25),      -- Tên sản phẩm
    pPrice INT              -- Giá sản phẩm
);

-- Tạo bảng OrderDetail (Chi tiết hóa đơn)
CREATE TABLE OrderDetail (
    oID INT,                -- Khóa ngoại, tham chiếu đến Order (Mã hóa đơn)
    pID INT,                -- Khóa ngoại, tham chiếu đến Product (Mã sản phẩm)
    odQTY INT,              -- Số lượng sản phẩm trong hóa đơn
    PRIMARY KEY (oID, pID), -- Đặt khóa chính trên cả oID và pID
    CONSTRAINT FK_OrderDetail_Order FOREIGN KEY (oID) REFERENCES [Order](oID),
    CONSTRAINT FK_OrderDetail_Product FOREIGN KEY (pID) REFERENCES Product(pID)
);

-- Chèn dữ liệu mẫu vào bảng Customer
INSERT INTO Customer (cID, cName, cAge) VALUES
(1, 'Minh Quan', 30),
(2, 'Ngoc Anh', 20),
(3, 'Hong Ha', 25),
(4, 'An Trom' , 25);
-- Chèn dữ liệu mẫu vào bảng Order
INSERT INTO [Order] (oID, cID, oDate, oTotalPrice) VALUES
(1, 1, '2006-03-21', NULL),
(2, 2, '2006-03-22', NULL),
(3, 3, '2006-03-23', NULL),
(4, 1, '2006-03-16', NULL);

-- Chèn dữ liệu mẫu vào bảng Product
INSERT INTO Product (pID, pName, pPrice) VALUES
(1, 'May Giat', 3),
(2, 'Tu Lanh', 5),
(3, 'Dieu Hoa', 7),
(4, 'Quat', 2),
(5, 'Bep Dien', 4);

-- Chèn dữ liệu mẫu vào bảng OrderDetail
INSERT INTO OrderDetail (oID, pID, odQTY) VALUES
(1, 1, 3),
(2, 3, 7),
(3, 1, 5),
(4, 1, 8);
