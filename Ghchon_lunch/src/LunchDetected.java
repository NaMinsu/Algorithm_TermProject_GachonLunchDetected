import java.util.Arrays;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class LunchDetected {
	
	public static void main(String[] args) {

		UserInput user = new UserInput(); //User Input
		Food[] food = new Food[100]; //음식 DataSet
		int recommendedCnt =10; // 10가지를 뽑겠다.
		int food_count=0;
		Food[] recommended = new Food[recommendedCnt]; //10가지 음식 뽑아서 추천	
		int[] corrNum_arr = new int[recommendedCnt]; //일치하는 갯수가 가장 많은 것 중에서 랜덤으로 뽑기 위함
		
		/*************************DB작업***********************************************/		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/gachon_lunch";
			String dbuser = "root", passwd = "12345";
			con = (Connection) DriverManager.getConnection(url, dbuser, passwd);
			stmt = (Statement) con.createStatement();
			//DB 연결부분
		

			String sql ="Select * from food";  //SQL문장 나중에 Store id와 join해서 가져오기
			rs = stmt.executeQuery(sql); //food table tuple 불러오기
			
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
			
		
		//User Input 받기
		String userinput = user.getUserInput();
		System.out.println("UserInput:" + userinput);
		
		
		/************************ 공통부분 ****************************/
		//각 Food Object에 일치수 몇갠지 넣기  + 선택안함 -> 처리하기
		for(int input =0; input<food_count;input++)
		{			
			String data = food[input].getOption();
			System.out.println(food[input].getOption());
					
			for(int i=0; i<userinput.length(); i++)
			{
				//일치할경우 또는 선택안함일 경우!  (User input은 대문자로 받기****)
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
		
		
		/******************  메뉴1: 추천음식 뽑기 (Greedy) ***********************/
		//음식 뽑아줌 -> 정렬된거에서의 index번호!
		int[] index = new int[recommendedCnt];
		index= Food.RecommendIndex(recommendedCnt, corrNum_arr);
		//추천메뉴 배열에 넣기
		for(int input=0; input<recommendedCnt;input++)
		{
			recommended[input] = food[index[input]];
		}
		/******************************************************************/
		
		//추천으로 뽑은 recommended 배열 출력
		for(int input=0; input<recommendedCnt;input++)
		{			
			System.out.println(recommended[input].getFood_name()+":"+recommended[input].getCorrespond()+" \t kcal:"+recommended[input].getKcal());
		}
				
		/******************  메뉴2: 식단 추천 (Back tracking) ***********************/		
		PlanDiet diet = new PlanDiet(recommended, recommendedCnt, user.getRecommendIntake());
		diet.printDiet();		
		/**********************************************************************/

		
	}
	
}

/*정렬을 한 후  correspond의 개수만 보고 
 * corrNum_arr[0] = 최대치는 1개	--> 무조건 뽑고
 * corrNum_arr[1] = 다음껀 3개		--> 무조건 뽑고
 * corrNum_arr[2] = 다음껀 5개		--> 무조건 뽑고
 * corrNum_arr[3] = 다음꺼 10개		--> 이중에서 랜덤하게 나머지를 뽑을 예정
 * 목적: 
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



/******************  메뉴2: 식단 뽑기  *************************

for(int i=0; i<corrNum_arr.length; i++)
{
	System.out.println(corrNum_arr[i]);
}


int kcal = user.getRecommendIntake();
Food.RecommendDiet(diet,food,corrNum_arr,0, kcal ,When.DIN.when, 0);
//food들 list에서  corrNum_arr를 보고 선택-> Kcal 빼줌,
//diet배열에 넣어줌
for(int i=0; i<3; i++)
{
	System.out.println(diet[i].getFood_name());
	System.out.println(diet[i].getCorrespond());
	System.out.println(diet[i].getKcal());
}

*********************************************************/