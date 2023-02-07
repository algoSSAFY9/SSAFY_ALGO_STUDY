package algorithm_study.구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BS9_20546 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int jun = Integer.parseInt(br.readLine());
		int sung=jun;
		
		int jun_stock = 0;
		int sung_stock = 0;
		
		int up_cnt = 0, down_cnt=0;
		int pre=0;
		int stock_price=0;
		
		String arr = br.readLine();
		
		String[] str = arr.split(" ");
		for(String s : str) {
			stock_price = Integer.parseInt(s);
			
			if(jun!=0 && jun/stock_price>0) {
				jun_stock = jun/stock_price;
				jun = jun%stock_price;
			}
			if(pre<stock_price) {
				down_cnt=0;
				up_cnt++;
				if(up_cnt==3) {
					sung+=(stock_price*sung_stock);
					sung_stock=0;
				}
			}
			else if(pre>stock_price) {
				up_cnt=0;
				down_cnt++;
				if(down_cnt>=3) {
					if(sung!=0 && sung/stock_price>0) {
						sung_stock+=sung/stock_price;
						sung=sung%stock_price;
					}
				}
			}
			else {
				down_cnt=0;
				up_cnt=0;
			}
			pre=stock_price;
		}
		jun+=(jun_stock*Integer.parseInt(str[str.length-1]));
		sung+=(sung_stock*Integer.parseInt(str[str.length-1]));
		if(jun>sung) System.out.println("BNP");
		else if(jun<sung) System.out.println("TIMING");
		else System.out.println("SAMESAME");
	}
}

