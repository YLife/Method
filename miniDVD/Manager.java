package miniDVD;

import java.util.Date;
import java.util.Scanner;

public class Manager {
	DVD[] dvdArr;

	/**
	 * �鿴
	 */
	public void view() {
		// ��������, ������еķǿ�Ԫ��
		for (DVD element : dvdArr) {
			if (element!=null) {
				System.out.println(element);
			}
		}
	}

	/**
	 * ���/����
	 */
	public void create() {
		// �����û��������DVD������
		Scanner sc=new Scanner(System.in);
		System.out.println("������Ҫ��ӵ��鼮����:");
		String name=sc.nextLine();
		// ʵ�����µ�DVD����, ������������ֵ: ����, ״̬, �������
		DVD book=new DVD();
		book.name=name;
		book.state=false;
		book.lendDate=null;
		// ��������, �ҵ����е�һ����λ, ����
		for (int i = 0; i < dvdArr.length; i++) {
			if (dvdArr[i]==null) {
				dvdArr[i]=book;
				break;
			}
		}
	}

	/**
	 * ɾ��
	 */
	public void delete() {
		// �����û��������DVD������
		Scanner sc=new Scanner(System.in);
		System.out.println("������Ҫɾ�����鼮����:");
		String name=sc.nextLine();
		// ��������, �ҵ����DVD, ������Ϊnull
		for (int i = 0; i < dvdArr.length; i++) {
			if (dvdArr[i]==null) {
				continue;
			}
			if (name.equals(dvdArr[i].name)) {
				dvdArr[i]=null;
				break;
			}
		}
	}

	/**
	 * ���
	 */
	public void lend() {
		// �����û������DVD����
		Scanner sc=new Scanner(System.in);
		System.out.println("����������:");
		String name=sc.nextLine();
		// ����find����, �ҵ��ⲿDVD
		// �޸���state=true��lendDate=new java.util.Date()
		// ע���Ҫ���߼��ж�
		if (this.find(name)==null) {
			System.out.println("��Ǹ,��ʱ��û���ϼܴ���!");
		}else {
			if (this.find(name).state==false&&this.find(name).lendDate==null) {
				System.out.println("�������ã����Խ��ģ�");
				this.find(name).state=true;
				this.find(name).lendDate=new java.util.Date();
			}
		}
	}

	/**
	 * �黹
	 */
	public void giveBack() {
		Scanner sc=new Scanner(System.in);
		System.out.println("����������:");
		String name=sc.nextLine();
		// ��Ҫ�߼��ͽ���෴: state=false, lendDate=null
		// [��ѡ]: ������� = ���� * (��ǰϵͳʱ��.getTime()-�������.getTime())/1000/60/60/24
		/*int price=2,count;
		if (this.find(name).state==true&&this.find(name).lendDate!=null) {			
			Date date=new java.util.Date();
			count=price*((int)((date.getTime()-this.find(name).lendDate.getTime())/1000/60/60/24)+1);
			System.out.println("���Ϊ:"+count+"Ԫ");
			this.find(name).state=false;
			this.find(name).lendDate=null;
			System.out.println("���ѳɹ��黹����ӭ�´ι��٣�");
		}*/
		for (int i = 0; i < dvdArr.length; i++) {
			if (dvdArr[i]!=null) {
				continue;
			}
			if (name.equals(dvdArr[i].name)&&dvdArr[i].state==false&&dvdArr[i].lendDate!=null) {
				dvdArr[i].state=false;
				dvdArr[i].lendDate=null;
				System.out.println("���ѳɹ��黹����ӭ�´ι��٣�");
				break;
			}
		}
	}

	/**
	 * ����ָ����DVD
	 * 
	 * @param name
	 *            DVD����
	 * @return ���û���ҵ�, ����null
	 */
	private DVD find(String name) {
		// ��������, �ҵ���nameƥ���Ԫ��, ����
		int i;
		boolean contain=false;
		for (i = 0; i < dvdArr.length; i++) {
			if (dvdArr[i]==null) {
				continue;
			}
			if (name.equals(dvdArr[i].name)) {
				contain=true;
				break;
			}
		}		
		// ע��Ԫ�صķǿ��ж�, �������ײ�����ָ���쳣
		if (contain) {
			return dvdArr[i];			
		}
		return null;
	}

	/**
	 * �˵�
	 */
	public void menu() {
		// ��ʾ�˵�: 1? 2? 3? ...
		System.out.println("---------------------------------------- ");
		System.out.println("                  �˵�                                                   ");
		System.out.println("   1.�鿴                                                                4.����       ");
		System.out.println("   2.����                                                                5.���       ");
		System.out.println("   3.ɾ��                                                                6.�黹       ");
		System.out.println("                 7.�˳�                                                 ");
		System.out.println("----------------------------------------- ");
		// �������������
		// ������Ӧ�ķ���
		Scanner sc=new Scanner(System.in);
		System.out.println("��ѡ����Ҫ���еĲ���:");
		int input=sc.nextInt();
		switch (input) {
		case 1:
			view();
			menu();
			break;
		case 2:
			create();
			menu();
			break;
		case 3:
			delete();
			menu();
			break;
		case 4:
			System.out.println("������������������:");
			String name=sc.nextLine();
			find(name);
			menu();
			break;
		case 5:
			lend();
			menu();
			break;
		case 6:
			giveBack();
			menu();
			break;
		case 7:
			System.out.println("�˳�");
			break;
		default:
			break;
		}
	}
	
	/**
	 * ��ʼ������ 
	 */
	public void init() {
		// ʵ��������dvdArr
		dvdArr = new DVD[5];
		// ʵ����3��DVD����, �浽�����0,1,2λ��
		DVD a = new DVD();
		a.name = "ɱ����";
		a.state = false;
		a.lendDate = null;
		dvdArr[0] = a;
		
	}
}
