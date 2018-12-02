
public class Food implements Comparable<Food>{

	private int food_no;
	private String food_name;
	private String option;
	private int correspond;
	private int kcal;
	private int price;
	private int store_id;
	
	public Food() {
		this.correspond = 0;
		this.store_id = 0;
	}
	public Food(int food_no, String food_name,int kcal, int price, int store_id)
	{
		this.food_no = food_no;
		this.food_name = food_name;
		this.setKcal(kcal);
		this.price=price;
		this.store_id = store_id;
		this.option ="";
		this.correspond=0;
	}
	
	public Food(int food_no, String food_name, String option, int kcal, int price, int store_id)
	{
		this.food_no = food_no;
		this.food_name = food_name;
		this.setKcal(kcal);
		this.price=price;
		this.store_id = store_id;
		this.option =option;
		this.correspond=0;
	}
	
	
	public void testInsert(int food_no, String food_name, String option,int kcal, int price, int store_id) 
	{
		this.food_no = food_no;
		this.food_name = food_name;
		this.option =option;
		this.correspond=0;
		this.price=price;
		this.store_id=store_id;			
		this.setKcal(kcal);
	}
	
	public void addCorresspond()
	{
		correspond++;
	}
	
	
	
	
	public int getFood_no() {
		return food_no;
	}
	public void setFood_no(int food_no) {
		this.food_no = food_no;
	}
	public String getFood_name() {
		return food_name;
	}
	public void setFood_name(String food_name) {
		this.food_name = food_name;
	}
	public String getOption() {
		return option;
	}
	public void setOption(String option) {
		this.option = option;
	}
	public int getCorrespond() {
		return correspond;
	}
	public void setCorrespond(int correspond) {
		this.correspond = correspond;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getStore_id() {
		return store_id;
	}
	public void setStore_id(int store_id) {
		this.store_id = store_id;
	}
	public int getKcal() {
		return kcal;
	}
	public void setKcal(int kcal) {
		this.kcal = kcal;
	}

	@Override
	public int compareTo(Food o) {
		// TODO Auto-generated method stub
		if(o.correspond < correspond ) {
			return -1;
		}
		else if(o.correspond== correspond)
		{
			return 0;
		}
		return 1;
	}
	

	public static int[] RecommendIndex(int recommendedCnt, int[] corrNum_arr) 
	{
		int[] index = new int[recommendedCnt];
		int count = recommendedCnt;
		int temp =0, tempLength=0;
						
		for(int i=0; i<recommendedCnt&& count!=0; i++)
		{
			//��õ�Ҿ� >=�ִ�ġ	
			if(count>=corrNum_arr[i])
			{
				for(int j=0; j<corrNum_arr[i]; j++)
				{
					//System.out.println("["+temp+"]"+ temp);
					index[temp]=temp++;
				}
				count -= corrNum_arr[i];
			}
			else
			{
				int[] tempIndex = new int[count];
				tempLength = temp;
				//�������� �������� ����
				for(int k=0; k<count;  k++)
				{
					int random= RandomValue(corrNum_arr[i])+1;
									
					while(isRedundant(random, tempIndex))
					{
						random= RandomValue(corrNum_arr[i])+1;
						break;
					}
	
					tempIndex[k] = random;
					
					index[temp]= tempLength + tempIndex[k]-1; temp++;
					
				}

				count-= corrNum_arr[i];

				break;				
			}	
		}		
		return index;	
	}
	
	private static int[]index = new int[3];
	
	// Į�θ���...���.....����
	
	
	

	private static boolean isRedundant(int num, int[] arr)
	{
		boolean isRedundant = false;
		
		for(int i=0; i<arr.length; i++)
			{
			//System.out.println(arr.length);
				if(num==arr[i])
				{
					isRedundant=true;
				}
			}						
		return isRedundant;
	}
	
	
	private static int RandomValue(int num)
	{
		return (int) (Math.random()*num);	
	}
	
}


/*
 * ����:
 * ��õ - 10��
 * arr[0] = 3
 * arr[1] = 4
 * arr[2] = 20
 * ó���� (temp)10 �̶� (arr[0]) 3 ��!  3���� 10�̴�ũ�ϱ�  ��δټ��� 
 * 3���� ���������  { 0,1,2}
 * temp = 7�� ���̱�!
 * 
 * (temp) 7 �̶� (arr[1])4 ��!  4���� 7�̴� ũ�ϱ� ��� �� ����
 * 4�� ���� {3,4,5,6}
 * temp = 3���� ��
 * 
 * ��õ�ؾ��Ұ� 3����  arr[2]�� 20��
 * 20���� 3�� ���� �̱� -> ��
 * 
 * 	System.out.println("["+7+"]"+ index[7]);
	System.out.println("["+8+"]"+ index[8]);
	System.out.println("["+9+"]"+ index[9]);
 */




/*
while(isRedundant)
{
	isRedundant=false;
	random =RandomValue(corrNum_arr[i])+1;
	
	for(int t=0; t<count; t++)
	{
		if(tempIndex[t]==random)
		{
			isRedundant=true;
		}
	}				
}	
*/




/*
public static void RecommendDiet(Food[] diet, Food[] food, int[] corrNum_arr, int arr_i,  int kcal, int when, int add) 
{		
	
	if (corrNum_arr[arr_i]>when)
	{		
		int random = RandomValue(corrNum_arr[arr_i])+1;
			
		if(when!=0)
		{
			while(isRedundant(random, index)) 
			{
				random = RandomValue(corrNum_arr[arr_i])+1;
			}			
		}			
		diet[when] = food[add+random-1];
		index[when] = add+random-1;
		System.out.println();
		System.out.println("When:"+when);
		System.out.println("Random:"+ (random-1));
		
		if(when == 2)
		{
			System.out.println("Index[0]: "+ index[0]);
			System.out.println("Index[1]: "+ index[1]);
			System.out.println("Index[2]: "+ index[2]);
			return;
		}
	
		RecommendDiet(diet, food, corrNum_arr, arr_i, kcal, when+1, add);

	}
	else
	{
		System.out.println();
		System.out.println(when+"�ε�   "+ corrNum_arr[arr_i] +"��... " + arr_i);
		//�ٽ� ������
		System.out.println("�ٽ�");
		RecommendDiet(diet, food, corrNum_arr, arr_i+1, kcal ,when, add+corrNum_arr[arr_i]);
	}	
}	

*/