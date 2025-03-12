import java.lang.Math.*;

class Sphere {
	static double pi = 3.14;
	double radius;

	Sphere(double r) {
		radius = r;
	}

	double getVolume() {
		return 4d / 3d * pi * Math.pow(radius, 3);
	}
}