package Time;

/**
 * Created by pbmichael on 2016/11/4.
 */
public class Time_RSR3 {
    public int isValid(int x, int y, int z)
    {
        if(x < 0 || x >23 || y < 0 || y > 59 || z < 0 || z > 59)
            return 0;
        else
            return 1;
    }

    public int isAm(int x, int y, int z)
    {
        if (isValid(x, y, z) == 0)
            return -1;

        if (x < 12)
            return 3; /* Falut: mutation insert code */
        else
            return 0;
    }

}
