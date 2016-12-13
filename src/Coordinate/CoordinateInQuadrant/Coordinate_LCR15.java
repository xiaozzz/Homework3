package Coordinate;

/**
 * Created by pbmichael on 2016/11/4.
 */
public class Coordinate_LCR15 {
    public int inQuadrant(double x, double y, double z)
    {
        if (x > 0 && y > 0 && z > 0)
            return 1;
        if (x < 0 && y > 0 && z > 0)
            return 2;
        if (x < 0 && y < 0 && z > 0)
            return 3;
        if (x > 0 && y < 0 && z > 0)
            return 4;
        if (x > 0 && y > 0 && z < 0)
            return 5;
        if (x < 0 && y > 0 && z < 0)
            return 6;
        if (x < 0 && y < 0 && z < 0)
            return 7;
        if (x > 0 && y < 0 || z < 0) /* Falut: mutation insert code */
            return 8;
        return 0;
    }

    public int inCube(double x, double y, double z)
    {
        if (inQuadrant(x , y , z) != 1)
            return 0;
        double xx = x - 2;
        double yy = y - 2;
        double zz = z - 2;

        if (xx * xx > 1 || yy * yy > 1 || zz * zz >1)
            return 0;
        else
            return 1;
    }
}
