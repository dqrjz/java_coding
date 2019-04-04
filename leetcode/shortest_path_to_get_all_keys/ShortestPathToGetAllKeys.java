package com.leetcode.shortest_path_to_get_all_keys;

import java.util.*;

class ShortestPathToGetAllKeys {
	int INF = Integer.MAX_VALUE;
	String[] grid;
	int R, C;
	Map<Character, Point> location;
	int[] dr = new int[]{-1, 0, 1, 0};
	int[] dc = new int[]{0, -1, 0, 1};
	
	/**
	 * grid1:
	 * "@.a.#"
	 * "###.#"
	 * "b.A.B"
	 * <p>
	 * grid2:
	 * "@..aA"
	 * "..B#."
	 * "....b"
	 */
	public static void main(String[] args) {
		ShortestPathToGetAllKeys shortestPathToGetAllKeys = new ShortestPathToGetAllKeys();
//		String[] grid1 = {"@.a.#", "###.#", "b.A.B"};
		String[] grid2 = {"@..aA", "..B#.", "....b"};
//		System.out.println(shortestPathToGetAllKeys.shortestPathAllKeys(grid1));
		System.out.println(shortestPathToGetAllKeys.shortestPathAllKeys(grid2));
	}
	
	public int shortestPathAllKeys(String[] grid) {
		this.grid = grid;
		R = grid.length;
		C = grid[0].length();
		
		//location['a'] = the coordinates of 'a' on the grid, etc.
		location = new HashMap<>();
		for (int r = 0; r < R; ++r)
			for (int c = 0; c < C; ++c) {
				char v = grid[r].charAt(c);
				if (v != '.' && v != '#')
					location.put(v, new Point(r, c));
			}
		
		int ans = INF;
		int num_keys = location.size() / 2;
		String[] alphabet = new String[num_keys];
		for (int i = 0; i < num_keys; ++i)
			alphabet[i] = Character.toString((char) ('a' + i));
		//alphabet = ["a", "b", "c"], if there were 3 keys
		
		System.out.println("num_keys = " + num_keys);
		System.out.println("permutations = " + permutations(alphabet, 0, num_keys));
		search:
		for (String cand : permutations(alphabet, 0, num_keys)) {
			//bns : the built candidate answer, consisting of the sum
			//of distances of the segments from '@' to cand[0] to cand[1] etc.
			int bns = 0;
			for (int i = 0; i < num_keys; ++i) {
				char source = i > 0 ? cand.charAt(i - 1) : '@';
				char target = cand.charAt(i);
				
				//keymask : an integer with the 0-th bit set if we picked up
				// key 'a', the 1-th bit set if we picked up key 'b', etc.
				int keymask = 0;
				for (int j = 0; j < i; ++j)
					keymask |= 1 << (cand.charAt(j) - 'a');
				System.out.println("i = " + i);
				int d = bfs(source, target, keymask);
				if (d == INF) continue search;
				bns += d;
				if (bns >= ans) continue search;
			}
			ans = bns;
		}
		
		return ans < INF ? ans : -1;
	}
	
	public int bfs(char source, char target, int keymask) {
		System.out.println("bfs: source = " + source + ", target = " + target + ", keymask = " + Integer.toBinaryString(keymask));
		int sr = location.get(source).x;
		int sc = location.get(source).y;
		int tr = location.get(target).x;
		int tc = location.get(target).y;
		boolean[][] seen = new boolean[R][C];
		seen[sr][sc] = true;
		int curDepth = 0;
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(sr, sc));
		queue.offer(null);
		
		while (!queue.isEmpty()) {
			System.out.println(queue);
			Point p = queue.poll();
			if (p == null) {
				curDepth++;
				if (!queue.isEmpty())
					queue.offer(null);
				continue;
			}
			int r = p.x, c = p.y;
			if (r == tr && c == tc) return curDepth;
			for (int i = 0; i < 4; ++i) {
				int cr = r + dr[i];
				int cc = c + dc[i];
				if (0 <= cr && cr < R && 0 <= cc && cc < C && !seen[cr][cc]) {
					char cur = grid[cr].charAt(cc);
					if (cur != '#') {
						if (Character.isUpperCase(cur) && (((1 << (cur - 'A')) & keymask) <= 0))
							continue; // at lock and don't have key
						
						queue.offer(new Point(cr, cc));
						seen[cr][cc] = true;
					}
				}
			}
		}
		
		return INF;
	}
	
	public List<String> permutations(String[] alphabet, int used, int size) {
		List<String> ans = new ArrayList<>();
		if (size == 0) {
			ans.add("");
			return ans;
		}
		
		for (int b = 0; b < alphabet.length; ++b)
			if (((used >> b) & 1) == 0)
				for (String rest : permutations(alphabet, used | (1 << b), size - 1))
					ans.add(alphabet[b] + rest);
		return ans;
	}
	
	class Point extends java.awt.Point {
		public Point(java.awt.Point p) {
			super(p);
		}
		
		public Point(int x, int y) {
			super(x, y);
		}
		
		@Override
		public String toString() {
			return "(" + x + ", " + y + ')';
		}
	}
}