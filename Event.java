package mazegamegui;

import javax.swing.JLabel;
import java.io.IOException;

public class Event {
  public static int drawCounter = 0;
  private Map map;
  private Coord coord;
  public static int coins = 0;
  public int requirement = 0;
  boolean canType = true;
  public static boolean gotCoin = true;

  //counts coins and sets level goal
  public Event(Map mapOrig, Coord coordOrig, JLabel[] l) {
    map = mapOrig;
    coord = coordOrig;
    for (int i = 0; i < map.map.length; i++) {
      for (int j = 0; j < map.map[i].length(); j++) {
        if (map.map[i].charAt(j) == 'c') {
          requirement++;
        }
      }
    }
    map.drawBord(coord, l, this);
  }

  public void EventChecker(JLabel[] l) {
    if (map.map[coord.getY()].charAt(coord.getX()) == 'c') {
      coins++;
      gotCoin = true;
      map.map[coord.getY()] = map.map[coord.getY()].substring(0, coord.getX()) + ' '
          + map.map[coord.getY()].substring(coord.getX() + 1);
      map.drawBord(coord, l, this);
    } else if (map.map[coord.getY()].charAt(coord.getX()) == 'E' && requirement == coins) {
      map.drawBord(coord, l, this);
      System.out.println("win");
    } else
      map.drawBord(coord, l, this);
  }

  public void atEventChecker(JLabel[] l) {
    if (map.map[coord.getY()].charAt(coord.getX()) == 'c') {
      coins++;
      map.map[coord.getY()] = map.map[coord.getY()].substring(0, coord.getX()) + ' '
          + map.map[coord.getY()].substring(coord.getX() + 1);
      map.drawBord(coord, l, drawCounter);
    } else if (map.map[coord.getY()].charAt(coord.getX()) == 'E' && requirement == coins) {
      map.drawBord(coord, l, drawCounter);
      System.out.println("win");
    } else {
      map.drawBord(coord, l, drawCounter);
    }
    drawCounter = 0;
  }

  public void atChecker(int decision, int x, Map map, Coord coord) {
    drawCounter++;
    switch (decision) {
    case 1:
      if (map.map[x - 2].charAt(coord.getX()) == '@') {
        atChecker(decision, x - 1, map, coord);
      } else if (map.map[x - 2].charAt(coord.getX()) != ' ' && map.map[x - 2].charAt(coord.getX()) != '@') {
        coord.setY(coord.getY() + 1);
        return;
      } else if (map.map[x - 2].charAt(coord.getX()) == ' ') {
        map.map[x - 2] = map.map[x - 2].substring(0, coord.getX()) + map.map[x - 1].charAt(coord.getX())
            + map.map[x - 2].substring(coord.getX() + 1);
        map.map[x - 1] = map.map[x - 1].substring(0, coord.getX()) + " "
            + map.map[x - 1].substring(coord.getX() + 1);
        if (x != coord.getY())
          atChecker(decision, x + 1, map, coord);
      }
      break;
    case 2:
      if (map.map[coord.getY()].charAt(x - 2) == '@') {
        atChecker(decision, x - 1, map, coord);
      } else if (map.map[coord.getY()].charAt(x - 2) != ' ' && map.map[coord.getY()].charAt(x - 2) != '@') {
        coord.setX(coord.getX() + 1);
        return;
      } else if (map.map[coord.getY()].charAt(x - 2) == ' ') {
        map.map[coord.getY()] = map.map[coord.getY()].substring(0, x - 2) + map.map[coord.getY()].charAt(x - 1)
            + " " + map.map[coord.getY()].substring(x);
        if (x != coord.getX())
          atChecker(decision, x + 1, map, coord);
      }
      break;
    case 3:
      if (map.map[x + 2].charAt(coord.getX()) == '@') {
        atChecker(decision, x + 1, map, coord);
      } else if (map.map[x + 2].charAt(coord.getX()) != ' ' && map.map[x + 2].charAt(coord.getX()) != '@') {
        coord.setY(coord.getY() - 1);
        return;
      } else if (map.map[x + 2].charAt(coord.getX()) == ' ') {
        map.map[x + 2] = map.map[x + 2].substring(0, coord.getX()) + map.map[x + 1].charAt(coord.getX())
            + map.map[x + 2].substring(coord.getX() + 1);
        map.map[x + 1] = map.map[x + 1].substring(0, coord.getX()) + " "
            + map.map[x + 1].substring(coord.getX() + 1);
        if (x != coord.getY())
          atChecker(decision, x - 1, map, coord);
      }
      break;
    case 4:
      if (map.map[coord.getY()].charAt(x + 2) == '@') {
        atChecker(decision, x + 1, map, coord);
      } else if (map.map[coord.getY()].charAt(x + 2) != ' ' && map.map[coord.getY()].charAt(x + 2) != '@') {
        coord.setX(coord.getX() - 1);
        return;
      } else if (map.map[coord.getY()].charAt(x + 2) == ' ') {
        map.map[coord.getY()] = map.map[coord.getY()].substring(0, x + 1) + " "
            + map.map[coord.getY()].charAt(x + 1) + map.map[coord.getY()].substring(x + 3);
        if (x != coord.getX())
          atChecker(decision, x - 1, map, coord);
      }
      break;

    }

  }

  public void w(Map map, Coord coord, Event event, JLabel[] l) throws IOException, InterruptedException {
    if (map.map[coord.getY() - 1].charAt(coord.getX()) != '#') {
      if (map.map[coord.getY() - 1].charAt(coord.getX()) != '@') {
        coord.setY(coord.getY() - 1);
        this.EventChecker(l);
      } else if (map.map[coord.getY() - 1].charAt(coord.getX()) == '@'
          && map.map[coord.getY() - 2].charAt(coord.getX()) == ' ') {
        map.map[coord.getY() - 2] = map.map[coord.getY() - 2].substring(0, coord.getX())
            + map.map[coord.getY() - 1].charAt(coord.getX())
            + map.map[coord.getY() - 2].substring(coord.getX() + 1);
        map.map[coord.getY() - 1] = map.map[coord.getY() - 1].substring(0, coord.getX())
            + map.map[coord.getY()].charAt(coord.getX())
            + map.map[coord.getY() - 1].substring(coord.getX() + 1);
        coord.setY(coord.getY() - 1);
        this.EventChecker(l);
      } else if (map.map[coord.getY() - 1].charAt(coord.getX()) == '@'
          && map.map[coord.getY() - 2].charAt(coord.getX()) == '@') {
        this.atChecker(1, coord.getY(), map, coord);
        coord.setY(coord.getY() - 1);
        this.atEventChecker(l);
      }
    }
  }

  public void a(Map map, Coord coord, Event event, JLabel[] l) throws IOException, InterruptedException {
    if (map.map[coord.getY()].charAt(coord.getX() - 1) != '#') {
      if (map.map[coord.getY()].charAt(coord.getX() - 1) != '@') {
        coord.setX(coord.getX() - 1);
        this.EventChecker(l);
      } else if (map.map[coord.getY()].charAt(coord.getX() - 1) == '@'
          && map.map[coord.getY()].charAt(coord.getX() - 2) == ' ') {
        map.map[coord.getY()] = map.map[coord.getY()].substring(0, coord.getX() - 2)
            + map.map[coord.getY()].charAt(coord.getX() - 1) + " "
            + map.map[coord.getY()].substring(coord.getX());
        coord.setX(coord.getX() - 1);
        this.EventChecker(l);
      } else if (map.map[coord.getY()].charAt(coord.getX() - 1) == '@'
          && map.map[coord.getY()].charAt(coord.getX() - 2) == '@') {
        this.atChecker(2, coord.getX(), map, coord);
        coord.setX(coord.getX() - 1);
        this.atEventChecker(l);
      }
    }
  }

  public void s(Map map, Coord coord, Event event, JLabel[] l) throws IOException, InterruptedException {
    if (map.map[coord.getY() + 1].charAt(coord.getX()) != '#') {
      if (map.map[coord.getY() + 1].charAt(coord.getX()) != '@') {
        coord.setY(coord.getY() + 1);
        this.EventChecker(l);
      } else if (map.map[coord.getY() + 1].charAt(coord.getX()) == '@'
          && map.map[coord.getY() + 2].charAt(coord.getX()) == ' ') {
        map.map[coord.getY() + 2] = map.map[coord.getY() + 2].substring(0, coord.getX())
            + map.map[coord.getY() + 1].charAt(coord.getX())
            + map.map[coord.getY() + 2].substring(coord.getX() + 1);
        map.map[coord.getY() + 1] = map.map[coord.getY() + 1].substring(0, coord.getX())
            + map.map[coord.getY()].charAt(coord.getX())
            + map.map[coord.getY() + 1].substring(coord.getX() + 1);
        coord.setY(coord.getY() + 1);
        this.EventChecker(l);
      } else if (map.map[coord.getY() + 1].charAt(coord.getX()) == '@'
          && map.map[coord.getY() + 2].charAt(coord.getX()) == '@') {
        this.atChecker(3, coord.getY(), map, coord);
        coord.setY(coord.getY() + 1);
        this.atEventChecker(l);
      }
    }
  }

  public void d(Map map, Coord coord, Event event, JLabel[] l) throws IOException, InterruptedException {
    if (map.map[coord.getY()].charAt(coord.getX() + 1) != '#') {
      if (map.map[coord.getY()].charAt(coord.getX() + 1) != '@') {
        coord.setX(coord.getX() + 1);
        this.EventChecker(l);
      } else if (map.map[coord.getY()].charAt(coord.getX() + 1) == '@'
          && map.map[coord.getY()].charAt(coord.getX() + 2) == ' ') {
        map.map[coord.getY()] = map.map[coord.getY()].substring(0, coord.getX() + 1) + " "
            + map.map[coord.getY()].charAt(coord.getX() + 1)
            + map.map[coord.getY()].substring(coord.getX() + 3);
        coord.setX(coord.getX() + 1);
        this.EventChecker(l);
      } else if (map.map[coord.getY()].charAt(coord.getX() + 1) == '@'
          && map.map[coord.getY()].charAt(coord.getX() + 2) == '@') {
        this.atChecker(4, coord.getX(), map, coord);
        coord.setX(coord.getX() + 1);
        this.atEventChecker(l);
      }
    }
  }

}