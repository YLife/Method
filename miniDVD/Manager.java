package miniDVD;

import java.util.Date;
import java.util.Scanner;

public class Manager {
	DVD[] dvdArr;

	/**
	 * 查看
	 */
	public void view() {
		// 遍历数组, 输出其中的非空元素
		for (DVD element : dvdArr) {
			if (element!=null) {
				System.out.println(element);
			}
		}
	}

	/**
	 * 添加/创建
	 */
	public void create() {
		// 接受用户输入的新DVD的名称
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入要添加的书籍名称:");
		String name=sc.nextLine();
		// 实例化新的DVD对象, 设置三个属性值: 名称, 状态, 借出日期
		DVD book=new DVD();
		book.name=name;
		book.state=false;
		book.lendDate=null;
		// 遍历数组, 找到其中第一个空位, 存入
		for (int i = 0; i < dvdArr.length; i++) {
			if (dvdArr[i]==null) {
				dvdArr[i]=book;
				break;
			}
		}
	}

	/**
	 * 删除
	 */
	public void delete() {
		// 接受用户输入的新DVD的名称
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入要删除的书籍名称:");
		String name=sc.nextLine();
		// 遍历数组, 找到这个DVD, 把它置为null
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
	 * 借出
	 */
	public void lend() {
		// 接受用户输入的DVD名称
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入书名:");
		String name=sc.nextLine();
		// 调用find方法, 找到这部DVD
		// 修改其state=true和lendDate=new java.util.Date()
		// 注意必要的逻辑判断
		if (this.find(name)==null) {
			System.out.println("抱歉,暂时还没有上架此书!");
		}else {
			if (this.find(name).state==false&&this.find(name).lendDate==null) {
				System.out.println("此书闲置，可以借阅！");
				this.find(name).state=true;
				this.find(name).lendDate=new java.util.Date();
			}
		}
	}

	/**
	 * 归还
	 */
	public void giveBack() {
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入书名:");
		String name=sc.nextLine();
		// 主要逻辑和借出相反: state=false, lendDate=null
		// [可选]: 计算租金 = 单价 * (当前系统时间.getTime()-借出日期.getTime())/1000/60/60/24
		/*int price=2,count;
		if (this.find(name).state==true&&this.find(name).lendDate!=null) {			
			Date date=new java.util.Date();
			count=price*((int)((date.getTime()-this.find(name).lendDate.getTime())/1000/60/60/24)+1);
			System.out.println("租金为:"+count+"元");
			this.find(name).state=false;
			this.find(name).lendDate=null;
			System.out.println("书已成功归还！欢迎下次光临！");
		}*/
		for (int i = 0; i < dvdArr.length; i++) {
			if (dvdArr[i]!=null) {
				continue;
			}
			if (name.equals(dvdArr[i].name)&&dvdArr[i].state==false&&dvdArr[i].lendDate!=null) {
				dvdArr[i].state=false;
				dvdArr[i].lendDate=null;
				System.out.println("书已成功归还！欢迎下次光临！");
				break;
			}
		}
	}

	/**
	 * 查找指定的DVD
	 * 
	 * @param name
	 *            DVD名称
	 * @return 如果没有找到, 返回null
	 */
	private DVD find(String name) {
		// 遍历数组, 找到与name匹配的元素, 返回
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
		// 注意元素的非空判断, 否则容易产生空指针异常
		if (contain) {
			return dvdArr[i];			
		}
		return null;
	}

	/**
	 * 菜单
	 */
	public void menu() {
		// 显示菜单: 1? 2? 3? ...
		System.out.println("---------------------------------------- ");
		System.out.println("                  菜单                                                   ");
		System.out.println("   1.查看                                                                4.查找       ");
		System.out.println("   2.创建                                                                5.借出       ");
		System.out.println("   3.删除                                                                6.归还       ");
		System.out.println("                 7.退出                                                 ");
		System.out.println("----------------------------------------- ");
		// 接受输入的数字
		// 调用相应的方法
		Scanner sc=new Scanner(System.in);
		System.out.println("请选择需要进行的操作:");
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
			System.out.println("请输入想搜索的书名:");
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
			System.out.println("退出");
			break;
		default:
			break;
		}
	}
	
	/**
	 * 初始化数据 
	 */
	public void init() {
		// 实例化数组dvdArr
		dvdArr = new DVD[5];
		// 实例化3个DVD对象, 存到数组的0,1,2位置
		DVD a = new DVD();
		a.name = "杀破狼";
		a.state = false;
		a.lendDate = null;
		dvdArr[0] = a;
		
	}
}
