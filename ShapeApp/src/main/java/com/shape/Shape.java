package com.shape;

/**
 * 
 * @author xdi
 * @since Aug 31, 2016
 */
public interface Shape {

	/**
	 * Check if provided parameters can build a valid shape or not
	 * 
	 * @return
	 * @throws ShapeNotValidException
	 */
	public boolean isValidShape() throws ShapeNotValidException;

	/**
	 * Get area value of shape
	 * 
	 * @return
	 */
	public Double getArea();

	/**
	 * Update shape attributes
	 */
	public void updateAttributes();

}
