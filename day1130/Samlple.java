package day1130;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Samlple {
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat fmt=new SimpleDateFormat("yyyy-mm-dd");
		Date date=new Date();
		String str=fmt.format(date);
		System.out.println(str);
		String str1="2016-5-5";
		Date str2=fmt.parse(str1);
		System.out.println(str2);
	}
}
