import java.util.Arrays;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class LunchDetected {
	
	public static void main(String[] args) {

		UserInput user = new UserInput(); //User Input
		Food[] food = new Food[100]; //���� DataSet
		int recommendedCnt =10; // 10������ �̰ڴ�.
		int food_count=0;
		Food[] recommended = new Food[recommendedCnt]; //10���� ���� �̾Ƽ� ��õ	
		int[] corrNum_arr = new int[recommendedCnt]; //��ġ�ϴ� ������ ���� ���� �� �߿��� �������� �̱� ����
		
		/*************************DB�۾�***********************************************/		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/gachon_lunch";
			String dbuser = "root", passwd = "12345";
			con = (Connection) DriverManager.getConnection(url, dbuser, passwd);
			stmt = (Statement) con.createStatement();
			//DB ����κ�
		

			String sql ="Select * from food";  //SQL���� ���߿� Store id�� join�ؼ� ��������
			rs = stmt.executeQuery(sql); //food table tuple �ҷ�����
			
			while (rs.next()) {
				food[food_count] = new Food();
				food[food_count].setFood_no(Integer.parseInt(rs.getString("food_no")));
				food[food_count].setFood_name(rs.getString("food_name"));
				
				String option="";			
				option += rs.getString("option1");
				option += rs.getString("option2");
				option += rs.getString("option3");
				option += rs.getString("option4");
				option += rs.getString("option5");					
				food[food_count].setOption(option);
				
				food[food_count].setKcal(Integer.parseInt(rs.getString("kcal")));
				food[food_count].setPrice(Integer.parseInt(rs.getString("price")));
				food_count++;
			} 

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			if (con != null && !con.isClosed())
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		/********************************************************************************/
			
		
		//User Input �ޱ�
		String userinput = user.getUserInput();
		System.out.println("UserInput:" + userinput);
		
		
		/************************ ����κ� ****************************/
		//�� Food Object�� ��ġ�� ��� �ֱ�  + ���þ��� -> ó���ϱ�
		for(int input =0; input<food_count;input++)
		{			
			String data = food[input].getOption();
			System.out.println(food[input].getOption());
					
			for(int i=0; i<userinput.length(); i++)
			{
				//��ġ�Ұ�� �Ǵ� ���þ����� ���!  (User input�� �빮�ڷ� �ޱ�****)
				if(data.indexOf(userinput.charAt(i))!=-1)
				{
					food[input].addCorresspond();
				}
			}
		
			System.out.println(food[input].getCorrespond());
		}
		
		Arrays.sort(food,0,food_count);
		
		int max = food[0].getCorrespond();
		int arr_count=0;
		for(int i=0; i<food_count; i++)
		{
			if(max == food[i].getCorrespond()) 
			{
				corrNum_arr[arr_count]++;
			}
			else 
			{	
				if(i>recommendedCnt) 
				{
					break; 
				}				
				max = food[i].getCorrespond();
				corrNum_arr[++arr_count]++;
			}		
		}		
		/***********************************************************/
		
		
		System.out.println("-------------------------------------");
		
		
		/******************  �޴�1: ��õ���� �̱� (Greedy) ***********************/
		//���� �̾��� -> ���ĵȰſ����� index��ȣ!
		int[] index = new int[recommendedCnt];
		index= Food.RecommendIndex(recommendedCnt, corrNum_arr);
		//��õ�޴� �迭�� �ֱ�
		for(int input=0; input<recommendedCnt;input++)
		{
			recommended[input] = food[index[input]];
		}
		/******************************************************************/
		
		//��õ���� ���� recommended �迭 ���
		for(int input=0; input<recommendedCnt;input++)
		{			
			System.out.println(recommended[input].getFood_name()+":"+recommended[input].getCorrespond()+" \t kcal:"+recommended[input].getKcal());
		}
				
		/******************  �޴�2: �Ĵ� ��õ (Back tracking) ***********************/		
		PlanDiet diet = new PlanDiet(recommended, recommendedCnt, user.getRecommendIntake());
		diet.printDiet();		
		/**********************************************************************/

		
	}
	
}

/*������ �� ��  correspond�� ������ ���� 
 * corrNum_arr[0] = �ִ�ġ�� 1��	--> ������ �̰�
 * corrNum_arr[1] = ������ 3��		--> ������ �̰�
 * corrNum_arr[2] = ������ 5��		--> ������ �̰�
 * corrNum_arr[3] = ������ 10��		--> ���߿��� �����ϰ� �������� ���� ����
 * ����: 
 */

/*
 * for(int input=0; input<recommendedCnt;input++)
		{			
			System.out.println(recommended[input].getFood_name()+":"+recommended[input].getCorrespond());
		}
		
System.out.println(arr_count);
System.out.println(recommendedCnt);
System.out.println();
System.out.println(corrNum_arr[0]);
System.out.println(corrNum_arr[1]);
System.out.println(corrNum_arr[2]);
 */



/******************  �޴�2: �Ĵ� �̱�  *************************

for(int i=0; i<corrNum_arr.length; i++)
{
	System.out.println(corrNum_arr[i]);
}


int kcal = user.getRecommendIntake();
Food.RecommendDiet(diet,food,corrNum_arr,0, kcal ,When.DIN.when, 0);
//food�� list����  corrNum_arr�� ���� ����-> Kcal ����,
//diet�迭�� �־���
for(int i=0; i<3; i++)
{
	System.out.println(diet[i].getFood_name());
	System.out.println(diet[i].getCorrespond());
	System.out.println(diet[i].getKcal());
}

*********************************************************/