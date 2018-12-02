import java.io.*;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Vector;

public class RoadMap {
	public static final int nodeNum = 19;
	private static final int maxValue = 3600;
	private String[] nodes; // 각 노드의 이름
	private int[][] links; // 연결된 path
	private int[] distances; // 각 번호 노드의 최단거리
	private int[] prevNode; // 전임자 노드
	private boolean[] checks; // 방문 여부 체크 변수
	private int startingPoint; // 시작점
	private int destination; // 도착점
	private int shortestTime; // 최단시간 변수
	// 경로 데이터 저장 변수
	static Vector<Integer> steps = new Vector<Integer>();
	enum Nodes { // 지도 정보를 위한 enumeration
		A("기숙사"), B("학생회관"), C("중도"), D("교대"), E("바나대"),
		F("대학원"), G("예대1"), H("공대1"), I("글센"), J("IT대"),
		K("가천관"), L("산학"), M("공대2"), N("바나연"), O("법대"),
		P("비타"), Q("스타덤"), R("식당가"), S("학군단");
		
		private final String place;
		
		private Nodes(String placeName) {
			place = placeName;
		}
		
		public String getPlace() {
			return place;
		}
	}
	
	public RoadMap() {
		// initialization
		nodes = new String[nodeNum];
		for (int i = 0; i < nodeNum; i++)
			nodes[i] = Nodes.values()[i].getPlace();
		links = new int[nodeNum][nodeNum];
		for (int i = 0; i < nodeNum; i++)
			Arrays.fill(links[i], maxValue);
		distances = new int[nodeNum];
		Arrays.fill(distances, maxValue);
		checks = new boolean[nodeNum];
		Arrays.fill(checks, false);
		prevNode = new int[nodeNum];
		Arrays.fill(prevNode, 0);
		
		String fileName = "datalist.txt";
		Scanner fis = null;
		try {
			fis = new Scanner(new File(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		int value;
		String start, end;
		while (fis.hasNextLine()) {
			value = fis.nextInt();
			start = fis.next();
			end = fis.next();
			int startI = 0, endI = 0;
			
			boolean sflag = false, eflag = false;
			for (int i = 0; i < nodeNum; i++) {
				if (sflag && eflag)
					break;
				if (nodes[i].equals(start)) {
					startI = i;
					sflag = true;
				}
				if (nodes[i].equals(end)) {
					endI = i;
					eflag = true;
				}
			}
			
			links[startI][endI] = value;
			links[endI][startI] = value;
		}
	}
	
	public int getShortestTime() {
		return shortestTime;
	}
	
	public void setStartAndEnd(String start, String end) {
		for (int i = 0; i < nodeNum; i++) {
			if (start.equals(nodes[i])) {
				startingPoint = i;
			}
			if (end.equals(nodes[i])) {
				destination = i;
			}
		}
		
		distances[startingPoint] = 0;
	}
	
	private int shortestPath(int start, int end) {
		if (start == end)
			return distances[end];
		
		checks[start] = true;
		
		int min = maxValue;
		for (int i = 0; i < nodeNum; i++) {
			if (distances[i] > distances[start] + links[start][i]) {
				distances[i] = distances[start] + links[start][i];
				prevNode[i] = start;
			}
			
			if (checks[i] == false) {
				if (min == maxValue || distances[min] > distances[i])
					min = i;
			}
		}
		
		return shortestPath(min, end);
	}
	
	private void makingPath(int start, int end, int node) {
		if (node == start) {
			steps.add(node);
			return;
		}
		
		makingPath(start, end, prevNode[node]);
		steps.add(node);
	}
	
	public String[] dijkstra() {
		String[] pathNodes;
		
		shortestPath(startingPoint, destination);
		makingPath(startingPoint, destination, destination);
		
		pathNodes = new String[steps.size()];
		for (int i = 0; i < steps.size(); i++)
			pathNodes[i] = nodes[steps.elementAt(i)];
		
		return pathNodes;
	}
}
