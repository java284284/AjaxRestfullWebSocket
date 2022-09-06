package ch00.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class InitialDataSetup {
	public static final String UTF8_BOM = "\uFEFF"; // 定義 UTF-8的BOM字元

	@SuppressWarnings("unused")
	public static void main(String args[]) {
		Connection con;
		PreparedStatement pstmt;
		PreparedStatement pstmt1;
		Statement stmt;
		String dropStringMySQL = "";
		String createStringMySQL = "";

		String dropStringMsSQL = "";
		String createStringMsSQL = "";

		String dropString = "";
		String createString = "";

		String line = "";
		String sql = "";
		System.out.println("URL: " + GlobalService.DB_URL);
		System.out.println("帳號: " + GlobalService.USERID);
		System.out.println("密碼: " + GlobalService.PASSWORD);
		try {
			// 連上後端的資料庫
			con = DriverManager.getConnection(GlobalService.DB_URL, GlobalService.USERID, GlobalService.PASSWORD);
			// 建立Statement物件，以便傳送SQL命令到後端的資料庫
			stmt = con.createStatement();

		} catch (SQLException e) {
			System.err.println("存取資料庫有關的例外：" + e.getMessage());
			e.printStackTrace();
			return;
		}
		// 定義刪除Members表格的SQL命令
		dropStringMySQL = "DROP TABLE IF EXISTS MembersAjax ";
		dropStringMsSQL = "IF OBJECT_ID('dbo.MembersAjax', 'U') IS NOT NULL " 
						+ " DROP TABLE dbo.MembersAjax; ";
		// 定義新建Members表格的SQL命令
		createStringMsSQL = "Create Table MembersAjax (" 
							+ "  pk    	 	int  Identity  primary  key, "
							+ "  id    	 	VARCHAR(30),  " 
							+ "  name		VARCHAR(50),  " 
							+ "  balance	Numeric,  "
							+ "  Birthday	Date" 
							+ " )";

		createStringMySQL = "Create Table MembersAjax (" 
							+ "  pk			int  auto_increment  primary  key, "
							+ "  id			VARCHAR(30),  " 
							+ "  name		VARCHAR(50),  " 
							+ "  balance   	Numeric,  "
							+ "  Birthday  	Date" 
							+ " ) DEFAULT 	CHARACTER SET utf8 COLLATE utf8_general_ci;  ";

		if (GlobalService.DB_TYPE == GlobalService.DB_TYPE_MYSQL) {
			dropString = dropStringMySQL;
			createString = createStringMySQL;
		} else if (GlobalService.DB_TYPE == GlobalService.DB_TYPE_SQLSERVER) {
			dropString = dropStringMsSQL;
			createString = createStringMsSQL;
		}

		try {
			// 執行刪除Members表格的SQL命令
			stmt.executeUpdate(dropString);
			// 執行新建MembersAjax表格的SQL命令
			stmt.executeUpdate(createString);
			// 印出執行成功的訊息
			System.out.println("新建MembersAjax表格成功");

			System.out.println("===============MembersAjax資料新增成功 ===============");
		} catch (SQLException e) {
			System.err.println("新建MembersAjax表格時發生SQL例外: " + e.getMessage());
			e.printStackTrace();
		}

		// -------------------------------------
		// 定義刪除Book表格的SQL命令
		dropStringMySQL = "DROP TABLE IF EXISTS BookAjax";
		dropStringMsSQL = "IF OBJECT_ID('dbo.BookAjax', 'U') IS NOT NULL " 
						+ " DROP TABLE dbo.BookAjax; ";
		// 定義新建Book表格的SQL命令
		createStringMsSQL = "Create Table BookAjax " 
							+ "(bookID int NOT NULL IDENTITY Primary Key , "
							+ " title			varchar(50), " 
							+ " author    		varchar(28), "
							+ " price			Numeric(10,2), " 
							+ " discount		Numeric(7,2), " 
							+ " companyID		int, "
							+ " fileName		varchar(20), " 
							+ " bookNo 			varchar(20), "
							+ " priceStr		varchar(20), " 
							+ " CoverImage   	IMAGE "
							+ " )";

		createStringMySQL = "Create Table BookAjax " 
							+ "(bookID int NOT NULL AUTO_INCREMENT Primary Key , "
							+ " title			varchar(50), " 
							+ " author    		varchar(28), " 
							+ " price			Numeric, "
							+ " discount		Numeric(7,2), " 
							+ " companyID		int, " 
							+ " fileName		varchar(20), "
							+ " bookNo 			varchar(20), " 
							+ " priceStr		varchar(20), "
							+ " CoverImage   	longBlob "
							+ " ) DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci; ";

		if (GlobalService.DB_TYPE == GlobalService.DB_TYPE_MYSQL) {
			dropString = dropStringMySQL;
			createString = createStringMySQL;
		} else if (GlobalService.DB_TYPE == GlobalService.DB_TYPE_SQLSERVER) {
			dropString = dropStringMsSQL;
			createString = createStringMsSQL;
		}

		try {
			// 執行刪除Book表格的SQL命令
			stmt.executeUpdate(dropString);
			// 執行新建Book表格的SQL命令
			stmt.executeUpdate(createString);
			// 印出執行成功的訊息
			System.out.println("新建BookAjax表格成功");
			// 定義新增書籍記錄的SQL命令
			sql = "insert into BookAjax "
					+ " (title,  author,  price, discount, companyID, fileName, bookNo, CoverImage) "
					+ " values (?, ?, ?, ?, ?, ?, ?, ?)";
			// 建立新增書籍記錄的PreparedStatement物件
			pstmt = con.prepareStatement(sql);
			// 讀取Book表格的初始資料，準備新增到Book表格內
			try (
				BufferedReader br = new BufferedReader(new FileReader("src/main/Webapp/data/book.dat"));
			) {
				while ((line = br.readLine()) != null) {
					// 去除 UTF8_BOM
					if (line.startsWith(UTF8_BOM)) {
						line = line.substring(1);
					}
					String[] token = line.split("\\|");
					pstmt.setString(1, token[0]);
					pstmt.setString(2, token[1]);
					pstmt.setInt(3, Integer.parseInt(token[2].trim()));
					double d = Double.parseDouble(token[3].trim());
					pstmt.setDouble(4, d);
					pstmt.setString(5, token[4].trim());
					pstmt.setString(6, token[5].trim());
					pstmt.setString(7, token[6].trim());
					// 讀取圖片檔
					File aFile = new File("src/main/Webapp/images/smallPic/" + token[5].trim());
					long size = aFile.length();
					InputStream is = new FileInputStream(aFile);
					// 設定Image欄位
					pstmt.setBlob(8, is, size);
					// 執行新增Book表格之紀錄的SQL命令
					int r = pstmt.executeUpdate();
					System.out.println("新增一筆BookAjax紀錄是否成功=" + r);
				}
			}
			// 印出資料新增成功的訊息
			System.out.println("===============Book資料新增成功 ===============");
		} catch (SQLException e) {
			System.err.println("新建BookAjax表格時發生SQL例外: " + e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("新建BookAjax表格時發生IO例外: " + e.getMessage());
		}
		// 定義刪除Publisher表格的SQL命令
		dropStringMySQL = "DROP TABLE IF EXISTS PublisherAjax; ";
		dropStringMsSQL = "IF OBJECT_ID('dbo.PublisherAjax', 'U') IS NOT NULL " + " DROP TABLE dbo.PublisherAjax; ";
		// 定義新建Publisher表格的SQL命令
		createStringMySQL = "Create Table PublisherAjax " 
							+ "(id  int NOT NULL AUTO_INCREMENT Primary Key , "
							+ " name		    varchar(60), " 
							+ " address    	varchar(60), " 
							+ " url  		varchar(120) "
							+ " ) DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci; ";
		createStringMsSQL = "Create Table PublisherAjax " 
							+ "(id  int NOT NULL IDENTITY Primary Key , "
							+ " name		    varchar(60), " 
							+ " address    	varchar(60), "
							+ " url  		varchar(120) "
							+ " );";

		if (GlobalService.DB_TYPE == GlobalService.DB_TYPE_MYSQL) {
			dropString = dropStringMySQL;
			createString = createStringMySQL;
		} else if (GlobalService.DB_TYPE == GlobalService.DB_TYPE_SQLSERVER) {
			dropString = dropStringMsSQL;
			createString = createStringMsSQL;
		}

		try {
			// 執行新建Publisher表格的SQL命令
			stmt.executeUpdate(dropString);
			stmt.executeUpdate(createString);
			// 印出表格產生成功的訊息
			System.out.println("新建PublisherAjax表格成功");
			// 讀取Publisher表格的初始資料，準備新增到Book表格內
			try (
				BufferedReader br = new BufferedReader(new FileReader("src/main/Webapp/data/bookCompany.dat"));
			) {
				while ((line = br.readLine()) != null) {
					if (line.startsWith(UTF8_BOM)) {
						line = line.substring(1);
					}
					String[] token = line.split("\\|");
					sql = "insert into PublisherAjax (name,  address,  url ) " 
							+ "values ('" 
							+ token[0] + "','"
							+ token[1] + "','" 
							+ token[2] + "')";
					// 執行新增Publisher表格之紀錄的SQL命令
					stmt.executeUpdate(sql);
				}
			}
			// 印出資料新增成功的訊息
			System.out.println("PublisherAjax 資料新增成功");
		} catch (SQLException e) {
			System.err.println("新建PublisherAjax表格時發生SQL例外: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("新建PublisherAjax表格時發生IO例外: " + e.getMessage());
		}
		// 定義刪除place表格的SQL命令
		dropStringMySQL = "DROP Table IF EXISTS place";
		dropStringMsSQL = "IF OBJECT_ID('dbo.place', 'U') IS NOT NULL " + " DROP TABLE dbo.place; ";

		// 定義新建place表格的SQL命令
		createStringMySQL = "Create Table place " 
							+ "(placeId int NOT NULL AUTO_INCREMENT Primary Key , "
							+ " typeId		int, " 
							+ " name    	    varchar(32), " 
							+ " phone		varchar(50), "
							+ " address		varchar(50), " 
							+ " longitude	float, " 
							+ " latitude		float, "
							+ " link 		varchar(200) " 
							+ " ) DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci; ";

		createStringMsSQL = "Create Table place " 
							+ "(placeId int NOT NULL IDENTITY Primary Key , "
							+ " typeId		int, " 
							+ " name    	    varchar(32), " 
							+ " phone		varchar(50), "
							+ " address		varchar(50), " 
							+ " longitude	float, " 
							+ " latitude		float, "
							+ " link 		varchar(200) " 
							+ " )";

		if (GlobalService.DB_TYPE == GlobalService.DB_TYPE_MYSQL) {
			dropString = dropStringMySQL;
			createString = createStringMySQL;
		} else if (GlobalService.DB_TYPE == GlobalService.DB_TYPE_SQLSERVER) {
			dropString = dropStringMsSQL;
			createString = createStringMsSQL;
		}

		try {
			// 執行刪除place表格的SQL命令
			stmt.executeUpdate(dropString);
			// 印出執行成功的訊息
			System.out.println("place表格刪除成功");
			// 執行新建place表格的SQL命令
			stmt.executeUpdate(createString);
			// 印出執行成功的訊息
			System.out.println("place表格產生成功");
			// 定義新增place記錄的SQL命令
			sql = "insert into place " 
					+ " (typeId,  name,  phone, address, longitude, latitude, link) "
					+ " values (?, ?, ?, ?, ?, ?, ?)";
			// 建立新增書籍記錄的PreparedStatement物件
			pstmt = con.prepareStatement(sql);
			// 讀取place表格的初始資料，準備新增到place表格內
			try (
				BufferedReader br = new BufferedReader(new FileReader("src/main/Webapp/data/place.csv"));
			) {
				while ((line = br.readLine()) != null) {
					// 去除 UTF8_BOM
					if (line.startsWith(UTF8_BOM)) {
						line = line.substring(1);
					}
					String[] token = line.split(",");
					pstmt.setString(1, token[0]);
					pstmt.setString(2, token[1]);
					pstmt.setString(3, token[2].trim());
					pstmt.setString(4, token[3].trim());
					pstmt.setDouble(5, Double.parseDouble(token[4].trim()));
					pstmt.setDouble(6, Double.parseDouble(token[5].trim()));

					pstmt.setString(7, token[6].trim());
					// 執行新增Book表格之紀錄的SQL命令
					int r = pstmt.executeUpdate();
					System.out.println("新增一筆place紀錄是否成功=" + r);
				}
			}
			// 印出資料新增成功的訊息
			System.out.println("place資料新增成功");
		} catch (SQLException e) {
			System.err.println("新建place表格時發生SQL例外: " + e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("新建place表格時發生IO例外: " + e.getMessage());
		}

		// 關閉相關的物件
		finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (Exception e) {
				System.err.println("關閉相關物件時發生例外: " + e);
			}
			try {
				if (stmt != null)
					con.close();
			} catch (Exception e) {
				System.err.println("關閉相關物件時發生例外: " + e);
			}
		}
	}
}