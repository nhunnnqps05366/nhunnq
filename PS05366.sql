use master
GO
if exists (select name from sysdatabases where name='QuanLyDT')
drop Database QuanLyDT
GO
Create Database QuanLyDT
GO
use QuanLyDT
GO

IF OBJECT_ID('Users') IS NOT NULL
DROP TABLE Users
GO
CREATE TABLE Users(
	MaUser		int NOT NULL identity(1,1) PRIMARY KEY,
	Ten			nvarchar(50) NOT NULL,
	Username	varchar(50) NOT NULL UNIQUE,
	Password	varchar(50) NOT NULL,
	Quyen       varchar(20) NOT NULL
	)
GO
IF OBJECT_ID('SinhVien') IS NOT NULL
DROP TABLE SinhVien
GO
CREATE TABLE SinhVien(
	MaSV varchar(7) NOT NULL PRIMARY KEY,
	TenSV nvarchar(50) NULL,
	NgaySinh date NULL,
	Lop varchar(7) NULL,
	DiemJava float NULL,
	Diemsql float NULL,
	DiemAV float NULL,
	DiemTB float NULL
)
GO

IF OBJECT_ID('tr_Diemtb') IS NOT NULL
DROP TRIGGER tr_Diemtb
GO
CREATE TRIGGER tr_Diemtb on SinhVien
for insert,update
as
BEGIN 
	DECLARE @diemTB decimal(4,2)
	SET @diemTB = (SELECT DiemTB= (Diemsql+DiemJava+DiemAV)/3 from SinhVien where MASV IN (select MASV from inserted)) 
	UPDATE SinhVien SET DiemTB=@diemTB Where MASV IN (select MASV from inserted)
END



GO
/*
IF OBJECT_ID('func_maSV') IS NOT NULL
DROP FUNCTION func_maSV
GO
CREATE FUNCTION func_maSV(@lastMasv varchar(7),@prefix varchar(3),@size int)
returns varchar(7)
as 
BEGIN
IF(@lastMasv='')
	set @lastMasv= @prefix + REPLICATE(0,@size - LEN(@prefix))
	declare @num_nextmasv int,@nextmasv varchar(7)
	set @lastMasv=LTRIM(RTRIM(@lastMasv))
	set @num_nextmasv= replace(@lastMasv,@prefix,'')+1
	set @size = @size - len(@prefix)
	set @nextmasv=@prefix + REPLICATE(0,@size-LEN(@prefix))
	set @nextmasv= @prefix + RIGHT(REPLICATE(0,@size) + CONVERT 	(VARCHAR(MAX), @num_nextmasv), @size)
	return @nextmasv
END

GO
IF OBJECT_ID('tr_maSV') IS NOT NULL
DROP TRIGGER tr_maSV
GO
CREATE TRIGGER tr_maSV on SinhVien
for insert
as
BEGIN 
	DECLARE @lastMasv varchar(7)
	SET @lastMasv = (SELECT TOP 1 MaSV from SinhVien order by MaSV desc)
	UPDATE SinhVien SET MaSV = dbo.func_maSV(@lastMasv,'PS0',7)where MaSV=''
END
*/
GO

SELECT TOP 3 WITH TIES * FROM SinhVien ORDER BY DiemTB DESC
GO
Select CONVERT(varchar,NgaySinh,103) AS ngaysinh from SinhVien
GO
SET DATEFORMAT dmy
GO
select * from SinhVien 
GO

SET IDENTITY_INSERT Users ON
SET IDENTITY_INSERT Users OFF

GO
select * from Users

