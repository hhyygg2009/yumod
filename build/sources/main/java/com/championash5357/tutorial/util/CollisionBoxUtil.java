package com.championash5357.tutorial.util;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.util.math.AxisAlignedBB;

public class CollisionBoxUtil {
	
	private static final double CENTER = 0.5;
	private static final double NINETY_DEGREES = Math.toRadians(90);
	private static final double ONE_HUNDRED_EIGHTY_DEGREES = Math.toRadians(180);
	private static final double TWO_HUNDRED_SEVENTY_DEGREES = Math.toRadians(270);
	
	public static AxisAlignedBB setCollisionBasic(double x1, double y1, double z1, double x2, double y2, double z2) {
		return new AxisAlignedBB(x1/16, y1/16, z1/16, x2/16, y2/16, z2/16);
	}
	
	public static AxisAlignedBB rotateCollisionAroundY90Degrees(double x1, double y1, double z1, double x2, double y2, double z2) {
		List<Double> min = rotatePointAroundY(x1, z1, NINETY_DEGREES);
		List<Double> max = rotatePointAroundY(x2, z2, NINETY_DEGREES);
		return new AxisAlignedBB(min.get(0), y1, min.get(1), max.get(0), y2, max.get(1));
	}
	
	public static AxisAlignedBB rotateCollisionAroundY180Degrees(double x1, double y1, double z1, double x2, double y2, double z2) {
		List<Double> min = rotatePointAroundY(x1, z1, ONE_HUNDRED_EIGHTY_DEGREES);
		List<Double> max = rotatePointAroundY(x2, z2, ONE_HUNDRED_EIGHTY_DEGREES);
		return new AxisAlignedBB(min.get(0), y1, min.get(1), max.get(0), y2, max.get(1));
	}
	
	public static AxisAlignedBB rotateCollisionAroundY270Degrees(double x1, double y1, double z1, double x2, double y2, double z2) {
		List<Double> min = rotatePointAroundY(x1, z1, TWO_HUNDRED_SEVENTY_DEGREES);
		List<Double> max = rotatePointAroundY(x2, z2, TWO_HUNDRED_SEVENTY_DEGREES);
		return new AxisAlignedBB(min.get(0), y1, min.get(1), max.get(0), y2, max.get(1));
	}
	
	public static AxisAlignedBB rotateCollisionAroundY90Degrees(AxisAlignedBB box) {
		List<Double> min = rotatePointAroundY(box.minX, box.minZ, NINETY_DEGREES);
		List<Double> max = rotatePointAroundY(box.maxX, box.maxZ, NINETY_DEGREES);
		return new AxisAlignedBB(min.get(0), box.minY, min.get(1), max.get(0), box.maxY, max.get(1));
	}
	
	public static AxisAlignedBB rotateCollisionAroundY180Degrees(AxisAlignedBB box) {
		List<Double> min = rotatePointAroundY(box.minX, box.minZ, ONE_HUNDRED_EIGHTY_DEGREES);
		List<Double> max = rotatePointAroundY(box.maxX, box.maxZ, ONE_HUNDRED_EIGHTY_DEGREES);
		return new AxisAlignedBB(min.get(0), box.minY, min.get(1), max.get(0), box.maxY, max.get(1));
	}
	
	public static AxisAlignedBB rotateCollisionAroundY270Degrees(AxisAlignedBB box) {
		List<Double> min = rotatePointAroundY(box.minX, box.minZ, TWO_HUNDRED_SEVENTY_DEGREES);
		List<Double> max = rotatePointAroundY(box.maxX, box.maxZ, TWO_HUNDRED_SEVENTY_DEGREES);
		return new AxisAlignedBB(min.get(0), box.minY, min.get(1), max.get(0), box.maxY, max.get(1));
	}
	
	public static List<Double> rotatePointAroundY(double x, double z, double rotation) {
		double xp = ((x-CENTER)*Math.cos(rotation))-((z-CENTER)*Math.sin(rotation))+CENTER;
		double zp = ((z-CENTER)*Math.cos(rotation))+((x-CENTER)*Math.sin(rotation))+CENTER;
		List<Double> point = new ArrayList<Double>();
		point.add(0, xp);
		point.add(1, zp);
		return point;
	}
}
