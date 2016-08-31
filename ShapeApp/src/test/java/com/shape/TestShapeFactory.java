package com.shape;
import junit.framework.Assert;
import org.junit.Test;

import java.util.Arrays;


public class TestShapeFactory {

    @Test(expected = ShapeNotValidException.class)
    public void testTriangleInequalityException() throws ShapeNotValidException {
        ShapeFactory.createTriangle(Arrays.asList(1.0, 4.0,2.0));
    }

    @Test(expected = ShapeNotValidException.class)
    public void testTriangleZeroSideException() throws ShapeNotValidException {
        ShapeFactory.createTriangle(Arrays.asList(0.0, 4.0,2.0));
    }

    @Test
    public void testEquilateralTriangle() throws ShapeNotValidException {
        Triangle triangle = ((Triangle) ShapeFactory.createTriangle(Arrays.asList(2.0, 2.0, 2.0)));
    	Assert.assertTrue(triangle.getType().equals(Triangle.TRAINGLE_TYPE.EQUILATERAL));
    }
    
    @Test
    public void testIsoscelesTriangle() throws ShapeNotValidException{
        Triangle triangle = ((Triangle) ShapeFactory.createTriangle(Arrays.asList(3.0, 3.0, 5.0)));
    	Assert.assertTrue(triangle.getType().equals(Triangle.TRAINGLE_TYPE.ISOSCELES));
    }
    
    @Test
    public void testScaleneTriangle() throws ShapeNotValidException{
        Triangle triangle = ((Triangle) ShapeFactory.createTriangle(Arrays.asList(4.0, 3.0, 6.0)));
    	Assert.assertTrue(triangle.getType().equals(Triangle.TRAINGLE_TYPE.SCALENE));
    }

}
