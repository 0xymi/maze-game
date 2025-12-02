package mazegamegui;

public class Coord {
	private static int x = 0;
	private static int y = 0;

	//counts start- and sets player- position
	public Coord(Map map) {
		for (int i = 0; i < map.map.length; i++) {
			for (int j = 0; j < map.map[i].length(); j++) {
				if (map.map[i].charAt(j) == 'S' && Coord.x == 0) {
					Coord.y = i;
					Coord.x = j;
					break;
				} else if (map.map[i].charAt(j) == 'S' && Coord.x != 0) {
					System.out.println("More than one Start pos");
					while (true) {
					}
				}
			}
		}
	}

	//getter and setter
	public int getX() {
		return x;
	}

	public void setX(int x) {
		Coord.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		Coord.y = y;
	}

}
