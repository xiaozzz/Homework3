package test;

import java.io.File;
import java.lang.reflect.InvocationTargetException;

public class TestTimeIsAm {

	public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException {
		String path = "src/Time/TimeIsAm";
		
		File file=new File(path);
        File [] files = file.listFiles();
//		int [][] testCases = {
//				{5,2,2},{2,5,2},
//				{-1,1,1},{1,-1,1},{1,1,-1},
//				{1,0,1},{0,1,-1},{23,30,39}
//		};
		int [][] testCases = {
				{-1,1,1},{1,0,1},{23,30,39}
		};

        String [] classArray = new String[100];
        int [] isValidResult = new int[100];
        int [] isAlive = new int[100];
        for(int i=0;i<100;++i)
        	isAlive[i]=-1;
        
        int objectCount = 0;
        for(int i=0;i<files.length;++i){
     	   String [] strs = files[i].getName().split("\\.");
     	   String str = strs[0];
     	   //System.out.println(str);
     	   classArray[i] = str;
     	   ++objectCount;
        }

        int aliveMutantCount = objectCount-1;
        
        for(int level=0;level<testCases.length;++level){
        	//execute a test case
        	for(int i=0;i<objectCount;++i){
           	    Class a = Class.forName("Time."+classArray[i]);
				isValidResult[i] = (int) a.getMethod("isAm", int.class, int.class, int.class).invoke(a.newInstance(), testCases[level][0],testCases[level][1],testCases[level][2]);
           	    //System.out.println(classArray[i] +" " +  inQuadrantResult[i]);
            }
        	//check result
            for(int i=1;i<objectCount;++i){
            	if(isAlive[i]!=-1)
            		continue;
            	if(isValidResult[i]!=isValidResult[0]){
            		--aliveMutantCount;
            		isAlive[i] = level;
            	}
            } 
//            System.out.println("There are totally "+(objectCount-1)+" mutants");
//            System.out.println(""+aliveMutantCount+ " mutant still alive");
//            System.out.println("In the "+level+"th test, the following mutants are killed");
//			System.out.println("result of original function" + "\t" + inQuadrantResult[0]);
//            for(int i=0;i<objectCount;++i){
//            	if(isAlive[i]==level)
//            		System.out.println(classArray[i] + "\t" + i + "\t" + inQuadrantResult[i]);
//            }
//            System.out.println("by testCase " + level + "("+testCases[level][0]+", "+testCases[level][1]+", "+testCases[level][2]+")");
//            System.out.println("The following mutant are still alive:");
//            for(int i=1;i<objectCount;++i){
//            	if(isAlive[i]==0)
//            		System.out.println(classArray[i] + "\t" + i);
//            }


			System.out.println("输入值" + "\t" + testCases[level][0] + "\t" + testCases[level][1] + "\t" + testCases[level][2] + "\t" + (level+1));
			System.out.println("原始函数结果" + "\t" + isValidResult[0]);
			System.out.println("本例杀死的变异体");
			for(int i=0;i<objectCount;++i){
				if(isAlive[i]==level)
					System.out.println(classArray[i]+"(No."+i+")" + "\t" + isValidResult[i]);
			}

            System.out.println("仍存活的变异体");
            for(int i=1;i<objectCount;++i){
            	if(isAlive[i]==-1)
            		System.out.println(classArray[i]+"(No."+i+")");
            }

			System.out.println("");
        }
	}

}
