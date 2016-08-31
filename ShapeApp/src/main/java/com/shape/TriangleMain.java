package com.shape;

import java.util.Arrays;

public class TriangleMain {

	public static void main(String[] args) {

		Double firstArg = 0.0;
		Double secondArg = 0.0;
		Double thirdArg = 0.0;
		if (args.length > 0 && args.length == 3) {
			try {
				firstArg = Double.parseDouble(args[0]);
				secondArg = Double.parseDouble(args[1]);
				thirdArg = Double.parseDouble(args[2]);
				Triangle.TRAINGLE_TYPE type = getTriangleType(firstArg,
						secondArg, thirdArg);
				System.out.println("Triangle type is " + type);
			} catch (NumberFormatException e) {
				System.err.println("Argument must be an double.");
				System.exit(1);
			}
		} else {
			System.err.println("Please enter three double arguments to check triangle shape.");
			System.exit(1);
		}
	}

	/**
	 * Get triangle type based on parameters
	 * @param firstArg
	 * @param secondArg
	 * @param thirdArg
	 * @return
	 */
	public static Triangle.TRAINGLE_TYPE getTriangleType(Double firstArg,
			Double secondArg, Double thirdArg) {
		try {
			Triangle triangle = (Triangle) ShapeFactory.createTriangle(Arrays
					.asList(firstArg, secondArg, thirdArg));
			return triangle.getType();

		} catch (ShapeNotValidException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
