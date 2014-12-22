package main;

import java.awt.List;
import java.util.ArrayList;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Inicio");
		ArrayList param = new ArrayList<WebHelper.Parameter>();
		param.add(new WebHelper.Parameter("user[email]","shopping@shoppin.me"));
		param.add(new WebHelper.Parameter("user[password]","shoppin@2014"));
		
		try {
			String data = WebHelper.sendPost("http://www.shoppin.me/users/sign_in", param);
			
			System.out.println("retorno");
			System.out.println(data);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
