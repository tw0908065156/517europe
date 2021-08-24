package cn.tedu.aeurope;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestJavaOther {

	public static void main(String[] args) {
		List<String> listOtherMail =new ArrayList<>();
		listOtherMail.add("aa");
		listOtherMail.add("bb");
		listOtherMail.add("aa");
		listOtherMail.add("b");
		listOtherMail.add("cc");
		
		Map mapOtherMail = new HashMap();
		for (String temp : listOtherMail) {
			Integer count = (Integer) mapOtherMail.get(temp);
			mapOtherMail.put(temp, (count == null) ? 1 : count + 1);
		}
		System.out.println(mapOtherMail);
	}

}
