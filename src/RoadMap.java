package main;

import java.io.*;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Vector;

public class RoadMap {
	public static final int nodeNum = 19;
	private String[] nodes; // �� ����� �̸�
	private int[][] links; // ����� path
	private int[] distances; // �� ��ȣ ����� �ִܰŸ�
	private int[] prevNode; // ������ ���
	private boolean[] checks; // �湮 ���� üũ ����
	private int startingPoint; // ������
	private int destination; // ������
	// ��� ������ ���� ����
	static Vector<Integer> steps = new Vector<Integer>();
	enum Nodes { // ���� ������ ���� enumeration
		A("�����"), B("�л�ȸ��"), C("�ߵ�"), D("����"), E("�ٳ���"),
		F("���п�"), G("����1"), H("����1"), I("�ۼ�"), J("IT��"),
		K("��õ��"), L("����"), M("����2"), N("�ٳ���"), O("����"),
		P("��Ÿ"), Q("��Ÿ��"), R("�Ĵ簡"), S("�б���");
		
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
			Arrays.fill(links[i], Integer.MAX_VALUE);
		distances = new int[nodeNum];
		Arrays.fill(distances, Integer.MAX_VALUE);
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
				if (nodes[i].equalsIgnoreCase(start)) {
					startI = i;
					sflag = true;
				}
				if (nodes[i].equalsIgnoreCase(end)) {
					endI = i;
					eflag = true;
				}
			}
			
			links[startI][endI] = value;
			links[endI][startI] = value;
		}
	}
	
	public void setStartAndEnd(String start, String end) {
		for (int i = 0; i < nodeNum; i++) {
			if (start.equalsIgnoreCase(nodes[i])) {
				startingPoint = i;
			}
			if (end.equalsIgnoreCase(nodes[i])) {
				destination = i;
			}
		}
	}
	
	private int shortestPath(int start, int end) {
		if (start == end)
			return distances[end];
		
		checks[start] = true;
		
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < nodeNum; i++) {
			if (distances[i] > distances[start] + links[start][i]) {
				distances[i] = distances[start] + links[start][i];
				prevNode[i] = start;
			}
			
			if (min == Integer.MAX_VALUE || distances[min] > distances[i])
				min = i;
		}
		
		shortestPath(min, end);
		
		return 0;
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
