package _02.messages;

// 所有Message的祖先
public class InMessage {
    String no;	
    String name;
    Double chi;
    Double eng;
    Double mat;
    
	public InMessage() {
	}

	public InMessage(String no, String name, Double chi, Double eng, Double mat) {
		this.no = no;
		this.name = name;
		this.chi = chi;
		this.eng = eng;
		this.mat = mat;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getChi() {
		return chi;
	}

	public void setChi(Double chi) {
		this.chi = chi;
	}

	public Double getEng() {
		return eng;
	}

	public void setEng(Double eng) {
		this.eng = eng;
	}

	public Double getMat() {
		return mat;
	}

	public void setMat(Double mat) {
		this.mat = mat;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("InMessage [no=");
		builder.append(no);
		builder.append(", name=");
		builder.append(name);
		builder.append(", chi=");
		builder.append(chi);
		builder.append(", eng=");
		builder.append(eng);
		builder.append(", mat=");
		builder.append(mat);
		builder.append("]");
		return builder.toString();
	}
	
    
}
