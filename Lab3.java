import java.util.Scanner;

public class Lab3
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Эта программа симулирует спор Незнайки со своим другом.");
        System.out.print("Введите количество дневных дней, в течении которых будет проходить симуляция: ");
        int length = in.nextInt();
        in.close();

        Simulation simulation = new Simulation(length);
        System.out.println("---Симуляция начнается---");
        simulation.run();
        System.out.println("---Симуляция закончилась---");
    }
}