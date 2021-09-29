package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    private static int N, M;
    private static List<Circle> circleList = new ArrayList<Circle>();
    private static List<Cone> coneList = new ArrayList<Cone>();
    private static Random random = new Random();

    public static void main(String[] args) {

        System.out.println("Enter N value");
        N = readInteger();
        System.out.println("Enter M value");
        M = readInteger();

        double averageCircle = 0;
        for(int i = 0; i < M; i++){
            Circle cr = getRandomCircle();
            System.out.println(i + 1 + cr.getInfo());
            averageCircle += cr.getArea();
            circleList.add(cr);
        }

        averageCircle /= M;
        System.out.print("Average circle equals " + averageCircle + "\nThe amount of Triangles with lower square values equals ");

        int lowerCircleValuesCount = 0;
        for(Circle cr : circleList)
        {
            if(cr.getArea() < averageCircle)
                lowerCircleValuesCount++;
        }
        System.out.println(lowerCircleValuesCount + "\n");

        double maxConeValume = 0;
        int coneNumber = 0;
        for(int i = 0; i < M; i++){
            Cone cn = getRandomCone();
            System.out.println(i + 1 + cn.getInfo());
            if(maxConeValume < cn.GetVolume()) {
                maxConeValume = cn.GetVolume();
                coneNumber = i + 1;
            }
            circleList.add(cn);
        }
        System.out.println("Cone numbered " + coneNumber + " has the largest area: " + maxConeValume);
    }

    public static Circle getRandomCircle()
    {
        return new Circle((double)random.nextInt(20) + 1);
    }

    public static Cone getRandomCone()
    {
        return new Cone((float)random.nextInt(20) + 1, (float)random.nextInt(20) + 1);
    }

    public static int readInteger() {
        Scanner input = new Scanner(System.in);
        while (true)
        {
            try
            {
                int result = Integer.parseInt(input.next());

                if (result > 0)
                    return result;
                else
                    System.out.println("Value must be > 0");

            }
            catch (Exception e)
            {
                System.out.println("Enter a number, please");
            }
        }
    }
}
