package miniDVD;

import java.text.SimpleDateFormat;

public class DVD {
	/**
	 * DVD����
	 */
	public String name;
	/**
	 * ״̬: true��ʾ�ѽ��  false��ʾδ���
	 */
	public boolean state;
	/**
	 * �������
	 */
	public java.util.Date lendDate;
	
	// { ���� = ?, ״̬ = �ѽ��|δ���, ������� = yyyy��MM��dd��|�� }
	public String toString() {
		StringBuffer buf = new StringBuffer();
		buf.append("{ ");
		buf.append("���� = ");
		buf.append(this.name);
		buf.append(", ");
		buf.append("״̬ = ");
		buf.append(this.state ? "�ѽ��" : "δ���");
		buf.append(", ");
		buf.append("������� = ");
		if(this.lendDate == null)
			buf.append("��");
		else{
			SimpleDateFormat fmt = new SimpleDateFormat("yyyy��MM��dd��");
			buf.append(fmt.format(this.lendDate));
		}
		buf.append(" }");
		return buf.toString();
	}
}
