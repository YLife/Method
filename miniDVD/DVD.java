package miniDVD;

import java.text.SimpleDateFormat;

public class DVD {
	/**
	 * DVD名称
	 */
	public String name;
	/**
	 * 状态: true表示已借出  false表示未借出
	 */
	public boolean state;
	/**
	 * 借出日期
	 */
	public java.util.Date lendDate;
	
	// { 名称 = ?, 状态 = 已借出|未借出, 借出日期 = yyyy年MM月dd日|无 }
	public String toString() {
		StringBuffer buf = new StringBuffer();
		buf.append("{ ");
		buf.append("名称 = ");
		buf.append(this.name);
		buf.append(", ");
		buf.append("状态 = ");
		buf.append(this.state ? "已借出" : "未借出");
		buf.append(", ");
		buf.append("借出日期 = ");
		if(this.lendDate == null)
			buf.append("无");
		else{
			SimpleDateFormat fmt = new SimpleDateFormat("yyyy年MM月dd日");
			buf.append(fmt.format(this.lendDate));
		}
		buf.append(" }");
		return buf.toString();
	}
}
