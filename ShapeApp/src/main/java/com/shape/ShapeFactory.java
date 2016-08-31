package com.shape;

import java.util.List;

/**
 * 
 * @author xdi
 * @since Aug 31, 2016
 */
public class ShapeFactory {

	/**
	 * Create triangle
	 * 
	 * @param sides
	 * @return
	 * @throws ShapeNotValidException
	 */
	public static Shape createTriangle(List<Double> sides)
			throws ShapeNotValidException {
		Shape triangle = new Triangle(sides);
		triangle.isValidShape();
		triangle.updateAttributes();
		return triangle;
	}

}
