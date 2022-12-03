import java.util.Scanner;

public class AlgorytmNevillea {
    public static void Neville() throws Exception {
        int n;
        int wezly;
        System.out.println("Wprowadz liczbe wezlow: ");
        Scanner liczbaWezlow = new Scanner(System.in);
        wezly = liczbaWezlow.nextInt();
        if(wezly<=1){throw new Exception("Wprowadzono niepoprawna liczbe wezlow, potrzebne sa co najmniej dwa wezly, wprowadz poprawna liczbe wezlow i sprobuj ponownie");}
        n = wezly - 1;

        double tablicaWezlow[] = new double[wezly];
        for (int i = 0; i < wezly; i++) {
            System.out.println("Wprowadz wartosc wezla " + i + " :");
            Scanner wartoscWezla = new Scanner(System.in);
            tablicaWezlow[i] = wartoscWezla.nextDouble();

        }

        //Sprawdzenie czy wezly sa rozne miedzy soba
        for (int i = 1; i < wezly; i++)
            if (tablicaWezlow[i] == tablicaWezlow[i - 1])
            {
                throw new Exception("Wezly interpolacji nie sa rozne miedzy soba. Wprowadz prawidlowe wartosci");
            }
        double wartosciFunkcji[]= new double[wezly];
        //Wprowadzenie wartosci funkcji w kolejnych wezlach
        for(int i=0;i<wezly;i++)
        {
            System.out.println("Wprowadz wartosc funkcji w wezle x["+i+"]:");
            Scanner wartosc = new Scanner(System.in);
            wartosciFunkcji[i]=wartosc.nextDouble();
        }
        //Wprowadzenie wartosci punktu p i sprawdzenie czy nalezy do przedzialu
        double najmniejszy= tablicaWezlow[0];
        double najwiekszy=tablicaWezlow[0];
        for(int i=0;i<wezly;i++)
        {
            if(tablicaWezlow[i]<najmniejszy)
            {
                najmniejszy=tablicaWezlow[i];
            }
        }
        System.out.println("Najmniejszy: "+najmniejszy);
        for(int i=0;i<wezly;i++)
        {
            if(tablicaWezlow[i]>najwiekszy)
            {
                najwiekszy=tablicaWezlow[i];
            }
        }
        System.out.println("Najwiekszy: "+najwiekszy);

        double p;
        System.out.println("Wprowadz wartosc punktu p: ");
        Scanner punkt = new Scanner(System.in);
        p=punkt.nextDouble();

        if(p<najmniejszy || p>najwiekszy)
        {
            throw new Exception("Punkt nie nalezy do przedzialu wyznaczonego przez wartosci x, wprowadz poprawna wartosc punktu p i sprobuj ponownie");
        }

        System.out.println("Wezly");
        for(double t: tablicaWezlow )
        {
            System.out.println(t);
        }
        System.out.println("Wartosci funkcji w wezlach");
        for(double m: wartosciFunkcji)
        {
            System.out.println(m);
        }
        //Obliczanie wartosci
        double pjk[][]= new double[wezly][wezly];



            for(int k=0;k<=n;k++)
            {
                pjk[k][0]=wartosciFunkcji[k];
            }


        for(int k=1;k<=n;k++)
        {
            for(int j=0;j<=n-1;j++)
            {
                if((j+k)>n){pjk[j][k]=0;break;}
                pjk[j][k]=(((p-tablicaWezlow[j])*pjk[j+1][k-1])-((p-tablicaWezlow[j+k])*pjk[j][k-1]))/(tablicaWezlow[j+k]-tablicaWezlow[j]);

            }
        }

        System.out.println();
        //Wyswietlenie tabeli wielomianow czastkowych
        for(int j=0;j<=n;j++)
        {
            for(int k=0;k<=n;k++)
            {

                System.out.print(pjk[j][k] +"    ");

            }
            System.out.println();
        }
        double wynik = pjk[0][n];
        System.out.println("Przyblizona wartosc funkcji w punkcie "+p+" obliczona algorytmem Neville'a wynosi: ");
        System.out.println(wynik);






    }
}
