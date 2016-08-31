package com.shape;

import static java.util.stream.Collectors.groupingBy;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 
 * @author xdi
 * @since Aug 31, 2016
 */
public class Triangle implements Shape {

	public enum TRAINGLE_TYPE {
		EQUILATERAL, // All edges are equal
		ISOSCELES, // Only 2 equal edges
		SCALENE;// Non of the edges are equal
	}

	private List<Double> sides;
	private TRAINGLE_TYPE type;

	/**
	 * 
	 * @param sides
	 */
	public Triangle(List<Double> sides) {
		this.sides = sides;
	}

	/**
	 * Get type
	 * 
	 * @return
	 */
	public TRAINGLE_TYPE getType() {
		return type;
	}

	/**
	 * Set type
	 * 
	 * @param type
	 */
	public void setType(TRAINGLE_TYPE type) {
		this.type = type;
	}

	/**
	 * Check if provided parameters can build a valid shape or not
	 * 
	 * @return
	 * @throws ShapeNotValidException
	 */
	public boolean isValidShape() throws ShapeNotValidException {
		double sumSides = sides.stream().collect(
				Collectors.summingDouble(Double::doubleValue));

		if (sides.stream().anyMatch(l -> l <= 0.0)) {
			throw new ShapeNotValidException(
					"Triangle sides can't contain negative or zero sides.");
		} else if (sides.stream().anyMatch(l -> l >= (sumSides - l))) {
			throw new ShapeNotValidException(
					"Sum of 2 sides for triangle must be greater than any of the sides.");
		}
		return true;
	}

	/**
	 * Get area value of shape
	 */
	public Double getArea() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Update shape attributes
	 */
	public void updateAttributes() {
		int countOfSidesByGrouping = sides
				.stream()
				.collect(groupingBy(Double::doubleValue, Collectors.counting()))
				.values().size();

		// Print triangle side
		if (countOfSidesByGrouping == 3) {
			this.type = TRAINGLE_TYPE.SCALENE;
		} else if (countOfSidesByGrouping == 2) {
			this.type = TRAINGLE_TYPE.ISOSCELES;
		} else {
			this.type = TRAINGLE_TYPE.EQUILATERAL;
		}
	}

}
