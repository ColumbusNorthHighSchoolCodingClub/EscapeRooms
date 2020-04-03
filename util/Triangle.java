package util;

import java.awt.Color;
import java.awt.Point;
import java.awt.Polygon;
import java.util.ArrayList;

/**
 * Triangle object that also can have a color. Color is black if not supplied
 *
 * @author 22raor
 * @author 22wangj
 * @author 22banerjeea
 */
public class Triangle {

	private Color color;
	private final Point[] vertices;
	private final Polygon self;

	/* Constructors */

	public Triangle(Point[] vertices, Color b) {

		this.vertices = new Point[3];
		for (int i = 0; i < 3; i++) {
			this.vertices[i] = new Point(vertices[i]);
		}
		color = new Color(b.getRGB());
		self = new Polygon(this.getXPoints(), this.getYPoints(), 3);
	}
	/*
	 * public Triangle(int x1, int x2, int x3, int y1, int y2, int y3, Color b) {
	 * this(new Point[] { new Point(x1, y1), new Point(x2, y2), new Point(x3, y3) },
	 * b); }
	 */

	public Triangle(int x1, int y1, int x2, int y2, int x3, int y3, Color b) {
		this(new Point[] { new Point(x1, y1), new Point(x2, y2), new Point(x3, y3) }, b);
	}

	public Triangle(int x1, int y1, int x2, int y2, int x3, int y3) {
		this(new Point[] { new Point(x1, y1), new Point(x2, y2), new Point(x3, y3) }, Color.black);
	}

	public Triangle(Point one, Point two, Point three) {
		this(new Point[] { new Point(one), new Point(two), new Point(three) }, Color.black);
	}

	public Triangle(Point one, Point two, Point three, Color c) {
		this(new Point[] { new Point(one), new Point(two), new Point(three) }, c);
	}

	public Triangle(Point[] vertices) {
		this(vertices, Color.black);
	}

	public Triangle(Triangle t) {
		this(t.getVertices(), t.getColor());
	}

	/* Getters and Setters */

	public Point[] getVertices() {
		return vertices;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color c) {
		this.color = new Color(c.getRGB());
	}

// Returns an ArrayList of the three triangles that could be adjacent
	public ArrayList<Triangle> getAdjacents() {
		final Triangle a = new Triangle(vertices[0], vertices[1], new Point(
				vertices[0].x + vertices[1].x - vertices[2].x, vertices[0].y + vertices[1].y - vertices[2].y));

		final Triangle b = new Triangle(vertices[1], vertices[2], new Point(
				vertices[1].x + vertices[2].x - vertices[0].x, vertices[1].y + vertices[2].y - vertices[0].y));

		final Triangle c = new Triangle(vertices[0], vertices[2], new Point(
				vertices[0].x + vertices[2].x - vertices[1].x, vertices[0].y + vertices[2].y - vertices[1].y));

		final ArrayList<Triangle> adjacents = new ArrayList<Triangle>();
		adjacents.add(a);
		adjacents.add(b);
		adjacents.add(c);

		return adjacents;
	}

	public int[] getXPoints() {
		final int[] xPoints = new int[3];
		for (int i = 0; i < 3; i++) {
			xPoints[i] = vertices[i].x;
		}
		return xPoints;
	}

	public int[] getYPoints() {
		final int[] yPoints = new int[3];
		for (int i = 0; i < 3; i++) {
			yPoints[i] = vertices[i].y;
		}
		return yPoints;
	}

	/* Methods */

	@Override
	public Triangle clone() {
		return new Triangle(this);
	}

	private static Point averagePoint(Point a, Point b) {
		return new Point((a.x + b.x) / 2, (a.y + b.y) / 2);
	}

	public boolean contains(Point p) {
		return self.contains(p);
	}

	public boolean contains(int x, int y) {
		return self.contains(x, y);
	}
	

	public boolean equals(Triangle t) {
		final Point[] compareVertices = t.getVertices();
		boolean hasPointOne = false, hasPointTwo = false, hasPointThree = false;

		for (final Point compareVertex : compareVertices) {
			if (vertices[0].equals(compareVertex) && hasPointOne == false) {
				hasPointOne = true;
			}
			if (vertices[1].equals(compareVertex) && hasPointTwo == false) {
				hasPointTwo = true;
			}
			if (vertices[2].equals(compareVertex) && hasPointThree == false) {
				hasPointThree = true;
			}
		}
		if (hasPointOne && hasPointTwo && hasPointThree && t.getColor().equals(this.getColor())) {
			return true;
		}
		return false;
	}

	public boolean equalsIgnoreColor(Triangle t) {
		final Point[] compareVertices = t.getVertices();
		boolean hasPointOne = false, hasPointTwo = false, hasPointThree = false;

		for (final Point compareVertex : compareVertices) {
			if (vertices[0].equals(compareVertex) && hasPointOne == false) {
				hasPointOne = true;
			}
			if (vertices[1].equals(compareVertex) && hasPointTwo == false) {
				hasPointTwo = true;
			}
			if (vertices[2].equals(compareVertex) && hasPointThree == false) {
				hasPointThree = true;
			}
		}
		if (hasPointOne && hasPointTwo && hasPointThree) {
			return true;
		}
		return false;
	}

	public boolean isAdjacent(Triangle t) {
		final Point[] verticesA = t.getVertices();
		final Point[] midA = new Point[] { averagePoint(verticesA[0], verticesA[1]),
				averagePoint(verticesA[1], verticesA[2]), averagePoint(verticesA[0], verticesA[2]) };

		final Point mid1b = averagePoint(vertices[0], vertices[1]);
		final Point mid2b = averagePoint(vertices[1], vertices[2]);
		final Point mid3b = averagePoint(vertices[0], vertices[2]);

		for (final Point mid : midA) {
			if (mid.equals(mid1b) || mid.equals(mid2b) || mid.equals(mid3b)) {
				return true;
			}
		}
		return false;
	}

	public Polygon toPolygon() {
		return self;
	}

}
