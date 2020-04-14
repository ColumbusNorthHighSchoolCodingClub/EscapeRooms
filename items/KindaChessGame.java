 package items;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.Arrays;

import gameObjects.Item;
import gameObjects.Player;
import util.chessGame.Board;
import util.chessGame.Chariot;
import util.chessGame.Elephant;
import util.chessGame.FootSoldier;
import util.chessGame.KeyPiece;
import util.chessGame.Location;
import util.chessGame.Move;
import util.chessGame.Piece;

/**
 * 
 * @author 22raor
 * @author 22wangj
 * @author 22banerjeea
 */

public class KindaChessGame extends Item {

	private static final Rectangle OUTLINE = new Rectangle(10, 20, 420, 420);
	private static final int BOX_SIDE = 70;
	private static final int PIECE_SIDE = 60;
	private static Board gameBoard;
	private Rectangle[][] gridSpaces = new Rectangle[Board.NUM_ROWS][Board.NUM_COLS];

	private int moveNumber = 0;
	public Piece key;
	public KindaChessGame() {
		super("KindaChessGame", new Rectangle(300, 250, 100, 230));
		
		key = new KeyPiece(0, 2, Color.red);
		Piece[] pieces = new Piece[] { new Chariot(4, 0, Color.blue), new Elephant(5, 1, Color.blue),
				new FootSoldier(5, 2, Color.blue),new KeyPiece(5, 3, Color.blue), new Elephant(5, 4, Color.blue),
				new Chariot(4, 5, Color.blue), new FootSoldier(4, 1, Color.blue), new FootSoldier(4, 2, Color.blue),
				new FootSoldier(4, 3, Color.blue), new FootSoldier(4, 4, Color.blue),

				new Chariot(1, 0, Color.red), new Elephant(0, 1, Color.red), new FootSoldier(0, 3, Color.red),
				key, new Elephant(0, 4, Color.red), new Chariot(1, 5, Color.red),
				new FootSoldier(1, 1, Color.red), new FootSoldier(1, 2, Color.red), new FootSoldier(1, 3, Color.red),
				new FootSoldier(1, 4, Color.red) };

		for (int a = 0; a < gridSpaces.length; a++) {
			for (int b = 0; b < gridSpaces[0].length; b++) {
				gridSpaces[a][b] = new Rectangle(10 + 70 * a, 20 + 70 * b, 70, 70);
			}
		}
		gameBoard = new Board(pieces);
	}

	private Point lastMouse;
	private Piece lastMoved;
	private Point origLoc;
	
	public void reactToDrag(Point p, Player player) {
		boolean canMove = true;
		for (Piece r[] : gameBoard.grid) {
			for (Piece j : r) {
				if (j != null) {
					if (origLoc == null) {
						origLoc = new Point(j.x, j.y);
						lastMoved = null;
					}
					Rectangle piece = new Rectangle(j.x, j.y, BOX_SIDE - 10, BOX_SIDE - 10);

					if (piece.contains(p)) {
						if (lastMouse == null) {
							lastMouse = p;
						}

						Point toMove = new Point(j.x + (p.x - lastMouse.x), j.y + (p.y - lastMouse.y));
						Rectangle toMoveRect = new Rectangle(toMove.x, toMove.y, piece.width, piece.height);
						if (OUTLINE.contains(toMoveRect) == false) {
							canMove = false;
						}

						if (canMove) {

							if (lastMoved == null) {
								lastMoved = j;
								j.x = toMove.x;

								j.y = toMove.y;
							} else if (j == lastMoved) {
								j.x = toMove.x;

								j.y = toMove.y;
							}

						}

					}
				}
			}
		}
		lastMouse = p;

	}


	public void reactToMouseRelease(Point p, Player player) {
		lastMouse = null;

		if (lastMoved != null) {
			for (int i = 0; i < gridSpaces.length; i++) {
				for (int j = 0; j < gridSpaces[0].length; j++) {
					if (gridSpaces[j][i].contains(p)) {

						if (gameBoard.isValidMove(lastMoved, new Location(i, j))
								&& lastMoved.getColor().equals(Color.blue)) {
							movePiece(lastMoved, new Location(i, j));
							moveNumber++;
						} else {
							// System.out.println("Sending " + lastMoved.getLocation() + " back to its
							// original location: "
							// + lastMoved.getLocation());
							// System.out.println(gameBoard.grid[1][1]);
							lastMoved.update(lastMoved.getRow(), lastMoved.getCol());
							movePiece(lastMoved, lastMoved.getLocation());
						}

					}

				}

			}
			origLoc = null;
			lastMoved = null;
		}
	}
	
	public void movePiece(Piece n, Location c) {

		if(n!=null) {
		n.update(c.getRow(), c.getCol());
		
		if(gameBoard.grid[c.getRow()][c.getCol()] !=null && !gameBoard.grid[c.getRow()][c.getCol()].getColor().equals(n.getColor())) {
			gameBoard.grid[c.getRow()][c.getCol()].setDead(true); 
			if(gameBoard.grid[c.getRow()][c.getCol()].isDead() && (gameBoard.grid[c.getRow()][c.getCol()].getColor().equals(Color.red))){
				redPieces--;
			}
			else 
				bluePieces--;
			
		}
		
		gameBoard.update();
		}

	}

	public Piece[] deepClone(Piece[] piece) {
		Piece[] copy = Arrays.copyOf(piece, piece.length);

		for (int i = 0; i < piece.length; i++) {
			copy[i] = piece[i].clone();
		}

		return copy;
	}

	public boolean isFinished() {
		return gameBoard.isGameOver();
	}

	public Piece lastAImove;
	
	public int redPieces = 10; 
	public int bluePieces = 10; 

	public void runAI() {

		minimax(gameBoard, firstDepth, false);
		//System.out.println(currentBest);
		movePiece(gameBoard.grid[currentBest.piece.getRow()][currentBest.piece.getCol()], currentBest.finalLoc);
	}

	public int firstDepth = 3;

	public ArrayList<Move> calcPossibleRedMoves(Board j) {
		ArrayList<Move> possibleMoves = new ArrayList<Move>();
		for (int row = 0; row < 6; row++) {
			for (int col = 0; col < 6; col++) {
				Location loc = new Location(row, col);
				for (Piece[] arr : j.grid) {
					for (Piece p : arr) {
						if (p != null && p.getColor().equals(Color.red) && j.isValidMove(p, loc)) {
							possibleMoves.add(new Move(p, p.getLocation(), loc, 0));
						}
					}
				}
			}
		}
		return possibleMoves;
	}

	public ArrayList<Move> calcPossibleBlueMoves(Board j) {
		ArrayList<Move> possibleMoves = new ArrayList<Move>();
		for (int row = 0; row < 6; row++) {
			for (int col = 0; col < 6; col++) {
				Location loc = new Location(row, col);
				for (Piece[] arr : j.grid) {
					for (Piece p : arr) {
						if (p != null && p.getColor().equals(Color.blue) && j.isValidMove(p, loc)) {
							possibleMoves.add(new Move(p, p.getLocation(), loc, 0));
						}
					}
				}
			}
		}
		return possibleMoves;
	}

	public int evaluateBoard(Board a) {
		// if it is red piece, add piece value, else subtract
		int value = 0;
		for (int i = 0; i < a.grid.length; i++) {
			for (int j = 0; j < a.grid[0].length; j++) {
				if (a.grid[i][j] != null) {
					value += (a.grid[i][j].getColor().equals(Color.red) ? 1: -1) * a.grid[i][j].getWorth();			
					}
		}
	}
		return value;
	}

	public final int INFINITY = 1000000000;

	public Move currentBest;


	
	
	public int minimax(Board game, int depth, boolean isMaximizingPlayer) {
		if (depth == 0 || gameBoard.isGameOver()) {
			return evaluateBoard(game);

		}
		int eval;
		if (isMaximizingPlayer == true) {
			int maxEval = -INFINITY;
			for (Move child : calcPossibleBlueMoves(game)) {

				eval = minimax(getBoardAfterMove(child, game), depth - 1, false);

				if (maxEval < eval) {
					maxEval = eval;
					currentBest = child;
					//System.out.println("point value: "+ eval);
					//System.out.println("child: " + child);
				}
				// maxEval = (maxEval > eval) ? maxEval : eval;

			}
			return maxEval;

		} else {
			int minEval = INFINITY;
			for (Move otherChild : calcPossibleRedMoves(game)) {
				eval = minimax(getBoardAfterMove(otherChild, game), depth - 1, true);
				
				//System.out.println("point value: "+ eval);
				//System.out.println("child: " + otherChild);
				//
				if (minEval > eval) {
					minEval = eval;
					//System.out.println("best value: "+ eval);
					currentBest = otherChild;
				}

				// minEval = (minEval < eval) ? minEval : eval;
			}
			return minEval;

		}

	}

	public Board getBoardAfterMove(Move b, Board a) {
		// deep clone board
		// do the mov
		// return the board
		Piece[][] initialGrid = a.grid;
		Piece[][] finalGrid = new Piece[initialGrid.length][initialGrid[0].length];

		for (int i = 0; i < initialGrid.length; i++) {

			for (int j = 0; j < initialGrid[0].length; j++) {

				if (initialGrid[i][j] != null) {

					finalGrid[i][j] = initialGrid[i][j].clone();
				}

			}

		}

		Piece pieceInCopy = finalGrid[b.piece.getRow()][b.piece.getCol()];
		pieceInCopy.update(b.finalLoc.getRow(), b.finalLoc.getCol());

		Board j = new Board();
		j.grid = finalGrid;
		j.update();
		return j;
	}

	public boolean moveNotMade = true;

	public void draw(Graphics g, ImageObserver io) {

		if (moveNumber % 2 == 1 && moveNotMade) {
			
			runAI();

			gameBoard.update();
		//	System.out.println(bluePieces);
			moveNotMade = false;
			//System.out.println("made ai move");
			moveNumber++;
		//	System.out.println(moveNumber);
		} else if (moveNumber % 2 == 0) {
			moveNotMade = true;
		}

		// Chess Board Outline and boxes
		g.fillRect(OUTLINE.x, OUTLINE.y, OUTLINE.width, OUTLINE.height);

		g.setColor(Color.white);

		g.fillRect(10, 20, BOX_SIDE, BOX_SIDE);
		g.fillRect(150, 20, BOX_SIDE, BOX_SIDE);
		g.fillRect(290, 20, BOX_SIDE, BOX_SIDE);

		g.fillRect(80, 90, BOX_SIDE, BOX_SIDE);
		g.fillRect(220, 90, BOX_SIDE, BOX_SIDE);
		g.fillRect(360, 90, BOX_SIDE, BOX_SIDE);

		g.fillRect(10, 160, BOX_SIDE, BOX_SIDE);
		g.fillRect(150, 160, BOX_SIDE, BOX_SIDE);
		g.fillRect(290, 160, BOX_SIDE, BOX_SIDE);

		g.fillRect(80, 230, BOX_SIDE, BOX_SIDE);
		g.fillRect(220, 230, BOX_SIDE, BOX_SIDE);
		g.fillRect(360, 230, BOX_SIDE, BOX_SIDE);

		g.fillRect(10, 300, BOX_SIDE, BOX_SIDE);
		g.fillRect(150, 300, BOX_SIDE, BOX_SIDE);
		g.fillRect(290, 300, BOX_SIDE, BOX_SIDE);

		g.fillRect(80, 370, BOX_SIDE, BOX_SIDE);
		g.fillRect(220, 370, BOX_SIDE, BOX_SIDE);
		g.fillRect(360, 370, BOX_SIDE, BOX_SIDE);
		g.setColor(Color.red);

		if (lastAImove != null) {
			g.setColor(Color.yellow);
			g.fillRect(lastAImove.x - 5, lastAImove.y - 5, BOX_SIDE, BOX_SIDE);
		}

		for (Piece[] z : gameBoard.grid) {
			for (Piece l : z) {
				if (l != null) {
					g.setColor(l.getColor());
					//g.fillRect(l.x, l.y, BOX_SIDE - 10, BOX_SIDE - 10);
					

					String type = l.getClass().getName();
					if (l.getColor().equals(Color.red)) {
						if (type.contains("FootSoldier")) {
							g.drawImage(redFootSoldierImage, l.x, l.y, PIECE_SIDE, PIECE_SIDE, io);
						} else if (type.contains("Elephant")) {
							g.drawImage(redElephantImage, l.x, l.y, PIECE_SIDE, PIECE_SIDE, io);
						} else if (type.contains("Chariot")) {
							g.drawImage(redChariotImage, l.x, l.y, PIECE_SIDE, PIECE_SIDE, io);
						} else {
							g.drawImage(redKeyImage, l.x, l.y, PIECE_SIDE, PIECE_SIDE, io);
						}
					} else {
						if (type.contains("FootSoldier")) {
							g.drawImage(blueFootSoldierImage, l.x, l.y, PIECE_SIDE, PIECE_SIDE, io);
						} else if (type.contains("Elephant")) {
							g.drawImage(blueElephantImage, l.x, l.y, PIECE_SIDE, PIECE_SIDE, io);
						} else if (type.contains("Chariot")) {
							g.drawImage(blueChariotImage, l.x, l.y, PIECE_SIDE, PIECE_SIDE, io);
						} else {
							g.drawImage(blueKeyImage, l.x, l.y, PIECE_SIDE, PIECE_SIDE, io);
						}
					}
				}
			
		

		if (lastMoved != null) {
			// draw last moved
			String type = lastMoved.getClass().getName();
			
			if (lastMoved.getColor().equals(Color.red)) {
				if (type.contains("FootSoldier")) {
					g.drawImage(redFootSoldierImage, lastMoved.x, lastMoved.y, PIECE_SIDE, PIECE_SIDE, io);
				} else if (type.contains("Elephant")) {
					g.drawImage(redElephantImage, lastMoved.x, lastMoved.y, PIECE_SIDE, PIECE_SIDE, io);
				} else if (type.contains("Chariot")) {
					g.drawImage(redChariotImage, lastMoved.x, lastMoved.y, PIECE_SIDE, PIECE_SIDE, io);
				} else {
					g.drawImage(redKeyImage, lastMoved.x, lastMoved.y, PIECE_SIDE, PIECE_SIDE, io);
				}
			} else {
				if (type.contains("FootSoldier")) {
					g.drawImage(blueFootSoldierImage, lastMoved.x, lastMoved.y, PIECE_SIDE, PIECE_SIDE, io);
				} else if (type.contains("Elephant")) {
					g.drawImage(blueElephantImage, lastMoved.x, lastMoved.y, PIECE_SIDE, PIECE_SIDE, io);
				} else if (type.contains("Chariot")) {
					g.drawImage(blueChariotImage, lastMoved.x, lastMoved.y, PIECE_SIDE, PIECE_SIDE, io);
				} else {
					g.drawImage(blueKeyImage, lastMoved.x, lastMoved.y, PIECE_SIDE, PIECE_SIDE, io);
				}
			}
		}
	}
	}
	}

}