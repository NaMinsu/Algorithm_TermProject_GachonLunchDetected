
public class PlanDiet {

	private int recommendedCnt;
	private Food[] recommended = new Food[recommendedCnt]; //대상
	
	private Food[][] diet = new Food[200][3]; // 나중에 마지막에 return 해줄 식단 배열!
	private int dietCount;
	private final int kcal;
	
	public PlanDiet(Food[] recommended, int recommendedCnt, int recommendIntake) {		
		this.recommendedCnt = recommendedCnt;
		this.recommended = recommended;
		this.kcal = recommendIntake;
		dietCount=0;
		
		int[] Pos = new int[3];   //Pos[0]: 0Level숫자     Pos[1]: 1Level숫자   Pos[2]: 2Level숫자
		
		
		for(int i=0; i<recommendedCnt; i++)
		{
			Pos[0] = i;  
			BackTracking(Pos, 0, (kcal-recommended[i].getKcal()));  //Pos배열, 0level, 180kcal!
		}
	}
	
	private int C_count; 
	private void BackTracking(int[] Pos, int depth, int kcal) {
		int[] C = new int[100]; //Candidate
		int candidate_count=0;
		
		if (depth==2)  // isSolution 
		{
			//System.out.println("-->"+ Pos[0]+" "+Pos[1]+" "+Pos[2]);
			for(int i=0; i<3; i++)
			{
				diet[dietCount][i] = recommended[Pos[i]];	//수정하기
			}		
			dietCount++;
			return;
		}

		depth++;
		
		MakeCandidate(Pos, C, depth, kcal); 
		
		
		candidate_count = C_count;
		C_count=0;
		

		for(int i=0; i<candidate_count; i++)
		{
			//System.out.println("i:"+i +" candidate_count: "+ candidate_count);
			Pos[depth] = C[i];
			//System.out.println("Pos["+depth+"] : " + Pos[depth]);
			//System.out.println("kcal: "+ (kcal-recommended[C[i]].getKcal()));
			BackTracking(Pos, depth, kcal-recommended[C[i]].getKcal());

		}
		
	}

	private void MakeCandidate(int[] Pos, int[]C, int depth, int kcal) {
		
		int lastPos = Pos[depth-1]; //0
		
		//System.out.println("LastPos: "+lastPos);
		for(int i=0; i<recommendedCnt; i++) //8번
		{
			if(lastPos>=i) continue; 
			
			if(kcal<recommended[i].getKcal())
			{
				// 음식이 지정 칼로리보다 높다면!
				continue;
			}
			else
			{
				//System.out.println("Count++");
				C[C_count]= i;
				C_count++;
			}
		}		
	}
	
	public Food[][] getDiet() {
		return diet;
	}
	
	public void printDiet() {
		
		for(int i=0; i<dietCount; i++)
		{
			System.out.print("->");
			for(int j=0; j<3; j++)
			{
				switch(j) {
				case 0:
					System.out.print("\t아침: ");
					break;
				case 1:
					System.out.print("\t점심: ");
					break;
				case 2:
					System.out.print("\t저녁: ");
					break;
				}
				System.out.print(diet[i][j].getFood_name());
			}
			System.out.println();
		}
	}

	public int getDietCount() {
		return dietCount;
	}

	
	
	
}
