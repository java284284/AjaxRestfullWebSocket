package _00.utils;


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
		// 定義刪除MemberRest表格的SQL命令
		dropStringMySQL = "DROP TABLE IF EXISTS MemberRest ";
		dropStringMsSQL = "IF OBJECT_ID('dbo.MemberRest', 'U') IS NOT NULL " + " DROP TABLE dbo.MemberRest; ";
		// 定義新建MemberRest表格的SQL命令
		createStringMsSQL = "Create Table MemberRest (" 
				+ "  pk    	 	int  Identity  primary  key, "
				+ "  id    	 	VARCHAR(30),  " 
				+ "  name		VARCHAR(50),  " 
				+ "  balance   	Numeric,  "
				+ "  Birthday  	Date" 
				+ " )";

		createStringMySQL = "Create Table MemberRest (" 
				+ "  pk    	 	int  auto_increment  primary  key, "
				+ "  id    	 	VARCHAR(30),  " 
				+ "  name		VARCHAR(50),  " 
				+ "  balance   	Numeric,  "
				+ "  Birthday  	Date" 
				+ " ) DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;  ";

		if (GlobalService.DB_TYPE == GlobalService.DB_TYPE_MYSQL) {
			dropString = dropStringMySQL;
			createString = createStringMySQL;
		} else if (GlobalService.DB_TYPE == GlobalService.DB_TYPE_SQLSERVER) {
			dropString = dropStringMsSQL;
			createString = createStringMsSQL;
		}

		try {
			// 執行刪除MemberRest表格的SQL命令
			stmt.executeUpdate(dropString);
			// 執行新建MemberRest表格的SQL命令
			stmt.executeUpdate(createString);
			// 印出執行成功的訊息
			System.out.println("新建MemberRest表格成功");

			System.out.println("===============MemberRest資料新增成功 ===============");
		} catch (SQLException e) {
			System.err.println("新建MemberRest表格時發生SQL例外: " + e.getMessage());
			e.printStackTrace();
		}

		// -------------------------------------
		// 定義刪除Book表格的SQL命令
		dropStringMySQL = "DROP TABLE IF EXISTS BookRest";
		dropStringMsSQL = "IF OBJECT_ID('dbo.BookRest', 'U') IS NOT NULL " 
					    + " DROP TABLE dbo.BookRest; ";
		// 定義新建Book表格的SQL命令
		createStringMsSQL = "Create Table BookRest " 
				+ "(bookID int NOT NULL IDENTITY Primary Key , "
				+ " title			varchar(50), " 
				+ " author    		varchar(28), " 
				+ " price			Numeric, "
				+ " discount		Numeric, " 
				+ " companyID		int, " 
				+ " fileName		varchar(20), "
				+ " bookNo 			varchar(20), " 
				+ " CoverImage   	IMAGE " 
				+ " )";

		createStringMySQL = "Create Table BookRest " 
				+ "(bookID int NOT NULL AUTO_INCREMENT Primary Key , "
				+ " title			varchar(50), " 
				+ " author    		varchar(28), " 
				+ " price			Numeric, "
				+ " discount		Numeric(7,2), " 
				+ " companyID		int, " 
				+ " fileName		varchar(20), "
				+ " bookNo 			varchar(20), " 
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
			System.out.println("新建BookRest表格成功");
			// 定義新增書籍記錄的SQL命令
			sql = "insert into BookRest " + " (title,  author,  price, discount, companyID, fileName, bookNo, CoverImage) "
					+ " values (?, ?, ?, ?, ?, ?, ?, ?)";
			// 建立新增書籍記錄的PreparedStatement物件
			pstmt = con.prepareStatement(sql);
			// 讀取Book表格的初始資料，準備新增到Book表格內
			try (BufferedReader br = new BufferedReader(new FileReader("src/main/Webapp/data/book.dat"));) {
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
					System.out.println("新增一筆BookRest紀錄是否成功=" + r);
				}
			}
			// 印出資料新增成功的訊息
			System.out.println("===============BookRest資料新增成功 ===============");
		} catch (SQLException e) {
			System.err.println("新建Book表格時發生SQL例外: " + e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("新建Book表格時發生IO例外: " + e.getMessage());
		}
		// 定義刪除PublisherRest表格的SQL命令
		dropStringMySQL = "DROP TABLE IF EXISTS PublisherRest; ";
		dropStringMsSQL = "IF OBJECT_ID('dbo.PublisherRest', 'U') IS NOT NULL " + " DROP TABLE dbo.PublisherRest; ";
		// 定義新建PublisherRest表格的SQL命令
		createStringMySQL = "Create Table PublisherRest " + "(id  int NOT NULL AUTO_INCREMENT Primary Key , "
				+ " name		    varchar(60), " + " address    	varchar(60), " + " url  		varchar(120) "
				+ " ) DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci; ";
		createStringMsSQL = "Create Table PublisherRest " + "(id  int NOT NULL IDENTITY Primary Key , "
				+ " name		    varchar(60), " + " address    	varchar(60), " + " url  		varchar(120) "
				+ " );";

		if (GlobalService.DB_TYPE == GlobalService.DB_TYPE_MYSQL) {
			dropString = dropStringMySQL;
			createString = createStringMySQL;
		} else if (GlobalService.DB_TYPE == GlobalService.DB_TYPE_SQLSERVER) {
			dropString = dropStringMsSQL;
			createString = createStringMsSQL;
		}

		try {
			// 執行新建PublisherRest表格的SQL命令
			stmt.executeUpdate(dropString);
			stmt.executeUpdate(createString);
			// 印出表格產生成功的訊息
			System.out.println("新建PublisherRest表格成功");
			// 讀取PublisherRest表格的初始資料，準備新增到Book表格內
			BufferedReader br = new BufferedReader(new FileReader("src/main/Webapp/data/bookCompany.dat"));
			while ((line = br.readLine()) != null) {
				if (line.startsWith(UTF8_BOM)) {
					line = line.substring(1);
				}
				String[] token = line.split("\\|");
				sql = "insert into PublisherRest (name,  address,  url ) " + "values ('" + token[0] + "','" + token[1]
						+ "','" + token[2] + "')";
				// 執行新增PublisherRest表格之紀錄的SQL命令
				stmt.executeUpdate(sql);
			}
			// 印出資料新增成功的訊息
			System.out.println("PublisherRest 資料新增成功");
			br.close();
		} catch (SQLException e) {
			System.err.println("新建PublisherRest表格時發生SQL例外: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("新建PublisherRest表格時發生IO例外: " + e.getMessage());
		}
		// 定義刪除PlaceRest表格的SQL命令
		dropStringMySQL = "DROP Table IF EXISTS PlaceRest";
		dropStringMsSQL = "IF OBJECT_ID('dbo.PlaceRest', 'U') IS NOT NULL " + " DROP TABLE dbo.PlaceRest; ";

		// 定義新建PlaceRest表格的SQL命令
		createStringMySQL = "Create Table PlaceRest " + "(PlaceRestId int NOT NULL AUTO_INCREMENT Primary Key , "
				+ " typeId		int, " + " name    	    varchar(32), " + " phone		varchar(50), "
				+ " address		varchar(50), " + " longitude	float, " + " latitude		float, "
				+ " link 		varchar(200) " + " ) DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci; ";

		createStringMsSQL = "Create Table PlaceRest " + "(PlaceRestId int NOT NULL IDENTITY Primary Key , "
				+ " typeId		int, " + " name    	    varchar(32), " + " phone		varchar(50), "
				+ " address		varchar(50), " + " longitude	float, " + " latitude		float, "
				+ " link 		varchar(200) " + " )";

		if (GlobalService.DB_TYPE == GlobalService.DB_TYPE_MYSQL) {
			dropString = dropStringMySQL;
			createString = createStringMySQL;
		} else if (GlobalService.DB_TYPE == GlobalService.DB_TYPE_SQLSERVER) {
			dropString = dropStringMsSQL;
			createString = createStringMsSQL;
		}

		try {
			// 執行刪除PlaceRest表格的SQL命令
			stmt.executeUpdate(dropString);
			// 印出執行成功的訊息
			System.out.println("PlaceRest表格刪除成功");
			// 執行新建PlaceRest表格的SQL命令
			stmt.executeUpdate(createString);
			// 印出執行成功的訊息
			System.out.println("PlaceRest表格產生成功");
			// 定義新增PlaceRest記錄的SQL命令
			sql = "insert into PlaceRest " + " (typeId,  name,  phone, address, longitude, latitude, link) "
					+ " values (?, ?, ?, ?, ?, ?, ?)";
			// 建立新增書籍記錄的PreparedStatement物件
			pstmt = con.prepareStatement(sql);
			// 讀取PlaceRest表格的初始資料，準備新增到PlaceRest表格內
			BufferedReader br = new BufferedReader(new FileReader("src/main/Webapp/data/place.csv"));
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
				System.out.println("新增一筆PlaceRest紀錄是否成功=" + r);
			}
			br.close();
			// 印出資料新增成功的訊息
			System.out.println("PlaceRest資料新增成功");
		} catch (SQLException e) {
			System.err.println("新建PlaceRest表格時發生SQL例外: " + e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("新建PlaceRest表格時發生IO例外: " + e.getMessage());
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
				if (con != null)
					try {
					   con.close();
					} catch (Exception e) {
						;
					}
			} catch (Exception e) {
				System.err.println("關閉相關物件時發生例外: " + e);
			}
		}
	}
}