package crm._init.mssql;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Blob;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.serial.SerialException;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import crm.model.Category;
import crm.model.Hobby;
import crm.model.Member;

/**
 * 
 */
public class CreateMemberExampleTablesMsSQL {
	public static void main(String[] args) throws FileNotFoundException, IOException, SerialException, SQLException {
		Session session = HibernateUtil_MsSQL.getSessionFactory().openSession();
		Transaction tx = null;
		int count = 0;
		List<Hobby> hobbyList = new ArrayList<>();
		List<Category> list = new ArrayList<>();
		// -------------讀取Category資料，寫入資料庫----------------
				// 定義儲存Category的List物件，當讀入每筆Category資料後，不立即
				// 寫入資料庫而是等到讀入Member時，將對應的Category存入Member，
				// 再寫入Member(當然同時寫入Category)
		        
				try (
					// data/Category.dat存放要新增的n筆資料
					InputStreamReader isr0 = new InputStreamReader(
							new FileInputStream("data/Category.txt"), "UTF-8");
					BufferedReader br = new BufferedReader(isr0);) {
					String line = "";
					tx = session.beginTransaction();
					while ((line = br.readLine()) != null) {
						
						String[] sa = line.split("\\|");
						Category cate = new Category();
						//cate.setId(null);
						cate.setId(Integer.parseInt(sa[0]));
						cate.setName(sa[1]);
						cate.setShortName(sa[2]);
						session.save(cate);
						list.add(cate);
						count++;
						System.out.println("新增" + count + "筆記錄:" + sa[1]);
					}
					tx.commit();
				} catch (Exception e) {
					e.printStackTrace();
					tx.rollback();
				}
				System.out.println("Category List==>" + list);
				// -------------讀取Hobby資料，寫入資料庫----------------
				// 定義儲存Hobby的List物件，當讀入每筆Hobby資料後，不立即
				// 寫入資料庫而是等到讀入Member時，將對應的Hobby存入Member，
				// 再寫入Member(當然同時寫入Hobby)
				
				try (
					// data/Category.dat存放要新增的n筆資料
					InputStreamReader isr0 = new InputStreamReader(
							new FileInputStream("data/Hobby.txt"), "UTF-8");
					BufferedReader br = new BufferedReader(isr0);) {
					String line = "";
					tx = session.beginTransaction();
					while ((line = br.readLine()) != null) {
						String[] sa = line.split("\\|");
						Hobby hobby = new Hobby();
						hobby.setId(null);
						hobby.setName(sa[1]);
						session.save(hobby);
						hobby.setId(Integer.parseInt(sa[0]));
						hobbyList.add(hobby);

						count++;
						System.out.println("新增" + count + "筆記錄:" + sa[1]);
					}
					tx.commit();
					} catch (Exception e) {
						e.printStackTrace();
						tx.rollback();
					}
				System.out.println("hobbyList==>" + hobbyList);
		try (
				// Input.txt存放要新增的多筆資料
				InputStreamReader isr0 = new InputStreamReader(new FileInputStream("data/MemberCRUD.txt"), "UTF-8");

				BufferedReader br = new BufferedReader(isr0);)
		// 由檔案("data/Input.txt")讀入Member的資料，然後寫入資料庫
		{
			String line = "";
			while ((line = br.readLine()) != null) {
				// 未處理BOM字元，若有需要，請自行加入
				String[] sa = line.split("\\|");
				try {
					tx = session.beginTransaction();
					Member member = new Member();
					member.setAccount(sa[0]);
					member.setName(sa[1]);
					member.setEmail(sa[2]);
					member.setBirthday(Date.valueOf(sa[3]));
					member.setWeight(Double.parseDouble(sa[4]));
					member.setHobby(hobbyList.get(Integer.parseInt(sa[5])));
					member.setCategory(list.get(Integer.parseInt(sa[6])));
					member.setGender(sa[7]);
					// --------------處理Blob(圖片)欄位----------------
					File f = new File(sa[8]);
					System.out.println(f.getAbsolutePath());
					long size = f.length();
					InputStream is = new FileInputStream(f);
					Blob sb = Hibernate.getLobCreator(session).createBlob(is, size);
					member.setImage(sb);
					String imageFileName = sa[8].substring(sa[8].lastIndexOf("/") + 1);
					member.setFileName(imageFileName);
					Timestamp adminTime = new Timestamp(System.currentTimeMillis());
					member.setAdmissionTime(adminTime);
					session.save(member);
					session.flush();
					tx.commit();
					count++;
					System.out.println("新增" + count + "筆記錄:" + sa[1]);
					//break;
				} catch (Exception e) {
					e.printStackTrace();
					if (tx != null) {
						tx.rollback();
					}
				} finally {

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		HibernateUtil_MsSQL.close();
	}

	// 計算一個文字檔的字元數
//	private static long meteringReader(File f10) {
//		long total = 0;
//		int len = 0;
//		try (FileReader reader = new FileReader(f10);) {
//			char[] ca = new char[8192];
//			while ((len = reader.read(ca)) != -1) {
//				total += len;
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return total;
//	}
}
