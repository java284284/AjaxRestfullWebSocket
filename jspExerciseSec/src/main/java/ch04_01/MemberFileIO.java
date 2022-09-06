package ch04_01;
 
import java.io.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberFileIO {
	String filePath;
	
	public MemberFileIO(String filePath) {
		this.filePath = filePath;
		String dir = filePath.substring(0, filePath.lastIndexOf("\\"));
		File f = new File(dir);
		if ( !f.exists() ) {
			f.mkdirs();
		}
	}
	public MemberFileIO() {
		super();
	}	
	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public MemberBean getMemberById(int id) throws IOException {
		FileReader fr = null;
		BufferedReader br = null;
		MemberBean mb = null;
		try {
			fr = new FileReader(filePath);
			br = new BufferedReader(fr);
			String line = null;
			while ((line = br.readLine()) != null) {
				try {
					String[] dataArray = line.split("\\|");
					String key = dataArray[0];
					if (key.equals(id)) {
						mb = new MemberBean();
						mb.setMemberId(key);
						mb.setPassword(dataArray[1]);
						mb.setName(dataArray[2]);
						mb.setAddress(dataArray[3]);
						mb.setPhone(dataArray[4]);
						java.sql.Date d = java.sql.Date.valueOf(dataArray[5]);
						mb.setBirthday(d);
						java.sql.Timestamp ts = java.sql.Timestamp.valueOf(dataArray[6]);
						mb.setRegisterDate(ts);
						double weight = Double.parseDouble(dataArray[7].trim());
						mb.setWeight(weight);
					}
				} catch (NumberFormatException e) {
					;
				}
			}
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fr != null) {
				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
		return mb;
	}

	public List<MemberBean> getAllMembers() throws SQLException, IOException {
		List<MemberBean> result = null;
		FileReader fr = null;
		BufferedReader br = null;
		MemberBean mb = null;
		try {
			fr = new FileReader(filePath);
			br = new BufferedReader(fr);
			String line = null;
			result = new ArrayList<MemberBean>();
			while ((line = br.readLine()) != null) {
				try {
					String[] dataArray = line.split("\\|");
					String key = dataArray[0];
					mb = new MemberBean();
					mb.setMemberId(key);
					mb.setPassword(dataArray[1]);
					mb.setName(dataArray[2]);
					mb.setAddress(dataArray[3]);
					mb.setPhone(dataArray[4]);
					java.sql.Date d = java.sql.Date.valueOf(dataArray[5]);
					mb.setBirthday(d);
					java.sql.Timestamp ts = java.sql.Timestamp.valueOf(dataArray[6]);
					mb.setRegisterDate(ts);
					double weight = Double.parseDouble(dataArray[7].trim());
					mb.setWeight(weight);
					result.add(mb);
					
				} catch (NumberFormatException e) {
					;
				}
			}
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fr != null) {
				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	public void insertMember(MemberBean mb) throws IOException {
		FileWriter fw = null;
		PrintWriter pw = null;

		try {
			fw = new FileWriter(filePath, true);
			pw = new PrintWriter(fw);
			pw.println(mb.getMemberId() + "|" + mb.getPassword() + "|" +mb.getName() + "|"
					+ mb.getAddress() + "|" + mb.getPhone() + "|" + mb.getBirthday() + "|"
					+ mb.getRegisterDate() + "|" + mb.getWeight());

		} finally {
			if (pw != null) {
				pw.close();
			}
			if (fw != null) {
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}