package mazegamegui;

import javax.swing.JLabel;

public class Map {
	String[] map = new String[17];

	public Map() {
		map[0]  = "#########################################################";
		map[1]  = "# S #               #                                   #";
		map[2]  = "#   #             X #                                   #";
		map[3]  = "#   #               #                                   #";
		map[4]  = "#   #   #############@###############################   #";
		map[5]  = "#   #   #E              #c                              #";
		map[6]  = "#   #   #               ################                #";
		map[7]  = "#   #DDD#               #                               #";
		map[8]  = "#   #+  #################                      #        #";
		map[9]  = "#                                              ####     #";
		map[10] = "#                                     ##       #        #";
		map[11] = "#                                     #        #c       #";
		map[12] = "#   ###################################        #        #";
		map[13] = "#   #   o  #       #   @   #   @               ####     #";
		map[14] = "#   #c     #       #   #   #   #               #        #";
		map[15] = "# c #              @   #   @   #                        #";
		map[16] = "#########################################################";
	}

	public void drawBord(Coord coord, JLabel[] l, Event event) {
		for (int i = 0; i < this.map.length; i++) {
			if (i == coord.getY()) {
				l[i].setText(this.map[i].substring(0, coord.getX()) + 'P' + this.map[i].substring(coord.getX() + 1));
				l[i - 1].setText(this.map[i - 1]);
				l[i + 1].setText(this.map[i + 1]);
				if (Event.gotCoin) {
					l[17].setText(" Coins: " + Event.coins + " / " + event.requirement);
					Event.gotCoin = false;
				}
			}
		}
	}

	public void drawBord(Coord coord, JLabel[] l, int drawCounter) {
		if (drawCounter > 0)
			drawCounter = drawCounter * -1;
		for (int i = 0; i < this.map.length; i++) {
			if (i == coord.getY()) {
				for (int j = drawCounter; j < (drawCounter * -1); j++) {
					if (coord.getY() + j < this.map.length && coord.getY() + j >= 0) {
						l[coord.getY() + j].setText(this.map[coord.getY() + j]);
					}
				}
				l[i].setText(this.map[i].substring(0, coord.getX()) + 'P' + this.map[i].substring(coord.getX() + 1));
			}
		}
	}
}
