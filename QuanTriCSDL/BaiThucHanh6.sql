/* 
a. Viết thủ tục dùng để hiển thị các thông tin gồm oID, oDate, oPrice của tất cả các hóa đơn
trong bảng Order, danh sách phải sắp xếp theo thứ tự ngày tháng, hóa đơn mới hơn nằm
trên như hình sau:
*/
CREATE PROCEDURE CauA
AS
	SELECT *
	FROM [Order]
	ORDER BY oDate DESC
CauA
/* 
b. Viết thủ tục dùng để hiển thị danh sách các khách hàng đã mua hàng, và danh sách sản
phẩm được mua bởi các khách đó như sau:
*/
CREATE PROCEDURE CauB
AS
	SELECT cName , pName
	FROM Customer as C join [Order] as O on C.cID = O.cID
		join OrderDetail as OD on O.oID = OD.oID
		join Product as P on OD.pID = P.pID
CauB
/*
c.  Viết thủ tục dùng để hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào
như sau:
*/
CREATE PROCEDURE CauC
AS
	SELECT DISTINCT cName
	FROM Customer as C  left join [Order] as O on C.cID = O.cID
	WHERE O.oID is NULL
CauC
/*
d. Viết thủ tục dùng để hiển thị các mặt hàng chưa được mua lần nào.
*/
CREATE PROCEDURE CauD
AS
	SELECT pName
	FROM [Order] as O join OrderDetail as OD on O.oID = OD.oID
		right join Product as P on OD.pID = P.pID 
	WHERE O.oID is NULL
CauD
/*
e. Viết thủ tục với tham số truyền vào là tháng, năm. Thủ tục dùng để hiển thị các hóa đơn
được lập và số tiền bán được trong tháng, năm truyền vào.
*/
CREATE PROCEDURE CauE
	@Thang INT ,
	@Nam INT
AS
	SELECT O.oID ,SUM(pPrice * odQTY) AS Gia
	FROM [Order] AS O JOIN OrderDetail AS OD ON O.oID = OD.oID
		JOIN Product ON OD.pID = Product.pID
	WHERE YEAR(oDate) = @Nam and MONTH(oDate) = @Thang
	GROUP BY  O.oID 
CauE 3 , 2006
/*
f. Viết thủ tục với tham số truyền vào là năm. Thủ tục dùng để hiển thị doanh thu của mỗi
tháng trong năm truyền vào
*/
CREATE PROCEDURE CauF
	@Nam INT
AS
	SELECT MONTH(oDate) AS Thang, SUM(odQTY * pPrice) As Tong
	FROM [Order] as O join OrderDetail as OD on O.oID = OD.oID
		join Product as P on OD.pID = P.pID 
	WHERE YEAR(oDate) = @Nam
	GROUP BY MONTH(oDate)
CauF 2006
/* 
g. Viết thủ tục dùng để thêm mới một sản phẩm. Thủ tục có các tham số là các thông tin của
sản phẩm và một tham số @ketqua sẽ trả về chuỗi rỗng nếu thêm mới sản phẩm thành
công, ngược lại tham số này trả về chuỗi cho biết lý do không thêm mới được.
*/
alter PROCEDURE CauG
	@pID int , 
	@pName varchar(25) ,
	@pPrice int ,
	@ketqua nvarchar(25) output
AS 
	if (not exists(SELECT pID FROM Product WHERE pID = @pID))
		BEGIN 
			set @ketqua = ''
			insert into Product
			values (@pID, @pName, @pPrice)
		END
	else set @ketqua = 'Trung ma'

DECLARE @ketqua nvarchar(25)
execute CauG 1 , 'TiVi mong' , 100 , @ketqua output
SELECT @ketqua
/*
h. 
Viết thủ tục dùng để cập nhật một sản phẩm. Thủ tục có các tham số là các thông tin của
sản phẩm và một tham số @ketqua sẽ trả về chuỗi rỗng nếu Cập nhật sản phẩm thành
công, ngược lại tham số này trả về chuỗi cho biết lý do không cập nhật được.
*/
CREATE PROCEDURE CauH
	@pID int , 
	@pName varchar(25) ,
	@pPrice int ,
	@ketqua nvarchar(25) output
AS 
	if (not exists(SELECT pID FROM Product WHERE pID = @pID))
		set @ketqua = 'Ko Co Ma do'
	else
		BEGIN  
			set @ketqua = ''
			UPDATE Product
			SET 
				pName = @pName ,
				pPrice = @pPrice
			WHERE pID = @pID		
		END

DECLARE @ketqua nvarchar(25)
execute CauH 1 , 'TiVi mong' , 100 , @ketqua output
SELECT @ketqua
/*
i. Viết thủ tục dùng để xóa một sản phẩm. Thủ tục có các tham số là mã của sản phẩm và
một tham số @ketqua sẽ trả về chuỗi rỗng nếu xóa sản phẩm thành công, ngược lại tham
số này trả về chuỗi cho biết lý do không xóa sản phẩm được.
*/
CREATE PROC CauI
	@pID int ,
	@ketqua nvarchar(25) output
AS 
	if (not exists(SELECT * FROM Product WHERE pID = @pID ) )
		set @ketqua = 'khong tim thay ma'
	else 
		BEGIN 
			set @ketqua = ''
			DELETE Product 
			WHERE pID = @pID
		END
DECLARE @ketqua nvarchar(25)
execute CauI 1 , @ketqua output
SELECT @ketqua
/*
j. Viết thủ tục dùng để hiển thị các khách hàng đã đến mua bao nhiêu lần.
*/
CREATE PROC CauJ
AS 
	SELECT COUNT(C.cID)
	FROM Customer AS C LEFT JOIN [Order] AS O on C.cID = O.cID
	GROUP BY C.cID
CauJ
/*
k. Viết thủ tục dùng để hiển thị chi tiết của từng hóa đơn như sau :
*/
CREATE PROCEDURE CauK
AS
	SELECT O.oID , oDate , odQTY , pName , pPrice
	FROM [Order] as O 
		join OrderDetail as OD on O.oID = OD.oID
		join Product as P on OD.pID = P.pID
CauK
/*
l. Viết thủ tục dùng để hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn (giá một
hóa đơn được tính bằng tổng giá bán của từng loại mặt hàng xuất hiện trong hóa đơn. Giá
bán của từng loại được tính = odQTY*pPrice) như sau:
*/
CREATE PROCEDURE CauI
AS
	
	UPDATE O
	SET 
		oTotalPrice = (
			SELECT SUM(OD.odQTY * P.pPrice)
			FROM OrderDetail AS OD
			JOIN Product AS P ON P.pID = OD.pID
			WHERE OD.oID = O.oID
			GROUP BY OD.oID
		)
	FROM 
		[Order] AS O;
	
CauI
/* m. Viết thủ tục dùng để hiển thị tên và giá của các sản phẩm có giá cao nhất như sau:*/
CREATE PROCEDURE CauM
AS
	SELECT pName , pPrice
	FROM Product
	WHERE pPrice >= ALL 
		(
		SELECT pPrice
		FROM Product
		)
CauM
/*
n. Viết thủ tục với tham số truyền vào là số tiền. Thủ tục dùng để hiển thị những hóa đơn có
tổng thành tiền trên số tiền truyền vào.
*/
CREATE PROCEDURE CauN
	@Tien int
AS
	SELECT oID 
	FROM [Order]
	WHERE oTotalPrice >= @Tien
CauN 3248244
/* o. Viết thủ tục dùng để hiển thị những hóa đơn có tổng thành tiền là cao nhất.*/
CREATE PROCEDURE CauO
AS
	SELECT *
	FROM [Order]
	WHERE oTotalPrice >= ALL
		(
		SELECT oTotalPrice
		FROM [Order]
		)
CauO
/* p. Viết thủ tục dùng để hiển thị ra các khách hàng tới mua hàng với số lần họ đã tới mua
hàng. Nếu khách hàng nào chưa mua hàng lần nào thì số lần họ tới mua là 0.
*/
CREATE PROCEDURE CauP
AS
	SELECT c.cID , c.cName,COUNT(O.oID) AS SOLANMUA
	FROM Customer AS C LEFT JOIN [Order] AS O on C.cID = O.cID
	GROUP BY C.cID , c.cName
CauP
/*q. Viết thủ tục với tham số truyền vào là @nam. Thủ tục dùng để thống kê mỗi tháng trong
năm truyền vào có tổng doanh thu là bao nhiêu. (Nếu tháng nào không hoạt động thì ghi
tổng doanh thu là 0).
*/
ALTER PROCEDURE CauQ
	@Nam INT
AS	
	BEGIN
		IF OBJECT_ID('ThongKe') IS NOT NULL 
			DROP TABLE ThongKe
		BEGIN 
			CREATE TABLE ThongKe (Thang int, DoanhThu int)
			DECLARE @T  int
			SET @T = 1
			WHILE (@T < 13)
				BEGIN
					if (not exists (SELECT * FROM [Order] WHERE MONTH(oDate) = @T AND YEAR(oDate) = @Nam))
						 INSERT INTO ThongKe VALUES (@T , 0)
					SET @T = @T + 1
				END
		END
		SELECT *
		FROM ThongKe
		UNION ALL
		SELECT MONTH(oDate) AS Thang , SUM (oTotalPrice) AS DoanhThu
		FROM [Order]
		WHERE YEAR(oDate) = @Nam
		GROUP BY MONTH(oDate)
		ORDER BY Thang
	END
CauQ 2024
