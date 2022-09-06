package _02.messages;

public class OutMessage  {
	private String no;
    private String name;
    private Double sum;
    private Double max;
    private Double min;

    public OutMessage() {
    }
    
	public OutMessage(String no, String name, Double sum, Double max, Double min) {
		super();
		this.no = no;
		this.name = name;
		this.sum = sum;
		this.max = max;
		this.min = min;
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

	public Double getSum() {
		return sum;
	}

	public void setSum(Double sum) {
		this.sum = sum;
	}

	public Double getMax() {
		return max;
	}

	public void setMax(Double max) {
		this.max = max;
	}

	public Double getMin() {
		return min;
	}

	public void setMin(Double min) {
		this.min = min;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OutMessage [no=");
		builder.append(no);
		builder.append(", name=");
		builder.append(name);
		builder.append(", sum=");
		builder.append(sum);
		builder.append(", max=");
		builder.append(max);
		builder.append(", min=");
		builder.append(min);
		builder.append("]");
		return builder.toString();
	}

}
