package leets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class P752OTL {
	public int openLock(String[] deadends, String target) {
		HashSet<String> visited = new HashSet<String>(Arrays.asList(deadends));
		if (visited.contains("0000"))
			return -1;
		Queue<String> pending = new LinkedList<String>();
		pending.add("0000");
		int turns = 0;
		while (!pending.isEmpty()) {
			int size = pending.size();
			for (int i = 0; i < size; i++) {
				String current = pending.poll();
				if (visited.contains(current))
					continue;
				visited.add(current);
				if (current.equals(target))
					return turns;

				pending.addAll(generateAllCombinations(current));
			}
			turns++;
		}
		return -1;
	}

	public char getNext(char c) {
		if (c == '9')
			return '0';
		return (char) (c + 1);
	}

	public char getPrev(char c) {
		if (c == '0')
			return '9';
		return (char) (c - 1);
	}

	public ArrayList<String> generateAllCombinations(String currentCombination) {
		ArrayList<String> combinations = new ArrayList<String>();
		for (int i = 0; i < 4; i++) {
			combinations.add(currentCombination.substring(0, i) + getNext(currentCombination.charAt(i))
					+ currentCombination.substring(i + 1));
			combinations.add(currentCombination.substring(0, i) + getPrev(currentCombination.charAt(i))
					+ currentCombination.substring(i + 1));
		}
		return combinations;
	}

	public static void main(String[] args) {
		P752OTL s = new P752OTL();
		String target = "0202";
		String deadends[] = { "0201", "0101", "0102", "1212", "2002" };
		int turns = s.openLock(deadends, target);
		System.out.println(turns);

	}
}
