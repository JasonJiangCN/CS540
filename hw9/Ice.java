import java.util.*;
public class Ice{
    private static Map<Integer, Integer> map;
    private static void init(){
        map = new HashMap<Integer,Integer>(){{
            put(1855, 118);put(1856, 151);put(1857, 121);put(1858, 96);put(1859, 110);put(1860, 117);put(1861, 132);put(1862, 104);put(1863, 125);put(1864, 118);put(1865, 125);put(1866, 123);put(1867, 110);put(1868, 127);put(1869, 131);put(1870, 99);put(1871, 126);put(1872, 144);put(1873, 136);put(1874, 126);put(1875, 91);put(1876, 130);put(1877, 62);put(1878, 112);put(1879, 99);put(1880, 161);put(1881, 78);put(1882, 124);put(1883, 119);put(1884, 124);put(1885, 128);put(1886, 131);put(1887, 113);put(1888, 88);put(1889, 75);put(1890, 111);put(1891, 97);put(1892, 112);put(1893, 101);put(1894, 101);put(1895, 91);put(1896, 110);put(1897, 100);put(1898, 130);put(1899, 111);put(1900, 107);put(1901, 105);put(1902, 89);put(1903, 126);put(1904, 108);put(1905, 97);put(1906, 94);put(1907, 83);put(1908, 106);put(1909, 98);put(1910, 101);put(1911, 108);put(1912, 99);put(1913, 88);put(1914, 115);put(1915, 102);put(1916, 116);put(1917, 115);put(1918, 82);put(1919, 110);put(1920, 81);put(1921, 96);put(1922, 125);put(1923, 104);put(1924, 105);put(1925, 124);put(1926, 103);put(1927, 106);put(1928, 96);put(1929, 107);put(1930, 98);put(1931, 65);put(1932, 115);put(1933, 91);put(1934, 94);put(1935, 101);put(1936, 121);put(1937, 105);put(1938, 97);put(1939, 105);put(1940, 96);put(1941, 82);put(1942, 116);put(1943, 114);put(1944, 92);put(1945, 98);put(1946, 101);put(1947, 104);put(1948, 96);put(1949, 109);put(1950, 122);put(1951, 114);put(1952, 81);put(1953, 85);put(1954, 92);put(1955, 114);put(1956, 111);put(1957, 95);put(1958, 126);put(1959, 105);put(1960, 108);put(1961, 117);put(1962, 112);put(1963, 113);put(1964, 120);put(1965, 65);put(1966, 98);put(1967, 91);put(1968, 108);put(1969, 113);put(1970, 110);put(1971, 105);put(1972, 97);put(1973, 105);put(1974, 107);put(1975, 88);put(1976, 115);put(1977, 123);put(1978, 118);put(1979, 99);put(1980, 93);put(1981, 96);put(1982, 54);put(1983, 111);put(1984, 85);put(1985, 107);put(1986, 89);put(1987, 87);put(1988, 97);put(1989, 93);put(1990, 88);put(1991, 99);put(1992, 108);put(1993, 94);put(1994, 74);put(1995, 119);put(1996, 102);put(1997, 47);put(1998, 82);put(1999, 53);put(2000, 115);put(2001, 21);put(2002, 89);put(2003, 80);put(2004, 101);put(2005, 95);put(2006, 66);put(2007, 106);put(2008, 97);put(2009, 87);put(2010, 109);put(2011, 57);put(2012, 87);put(2013, 117);put(2014, 91);put(2015, 62);put(2016, 65);}};

    }
    private static double MSE_0_N(double b0, double b1, Map<Integer, Double> m){

        double sum0 = 0.0;
        for (int i = 1855; i <= 2016; i++){
            sum0 += b0 + b1*m.get(i) - map.get(i);
        }
        return 2*sum0/m.size();
    }
    private static double MSE_0(double b0, double b1){

        double sum0 = 0.0;
        for (int i = 1855; i <= 2016; i++){
            sum0 += b0 + b1*i - map.get(i);
        }
        return 2*sum0/map.size();
    }
    private static double MSE_1(double b0, double b1){

        double sum1 = 0.0;
        for (int i = 1855; i <= 2016; i++){
            sum1 += (b0 + b1*i - map.get(i))*i;
        }
        return 2*sum1/map.size();
    }

    private static double MSE_1_N(double b0, double b1, Map<Integer, Double> m){

        double sum1 = 0.0;
        for (int i = 1855; i <= 2016; i++){
            sum1 += (b0 + b1*m.get(i) - map.get(i))*m.get(i);
        }
        return 2*sum1/map.size();
    }
    private static double MSE_1_R(double b0, double b1, Map<Integer, Double> m, int r){
                return 2*(b0 + b1*m.get(r) - map.get(r))*m.get(r);
    }
    private static double MSE(double b0, double b1){
        double sum = 0.0;
        for (int i = 1855; i <= 2016; i++){
            sum += Math.pow(b0 + b1*i - map.get(i), 2);
        }
        return sum/map.size();
    }
    private static double MSE_N(double b0, double b1,Map<Integer, Double> m ){
        double sum = 0.0;
        for (int i = 1855; i <= 2016; i++){
            sum += Math.pow(b0 + b1*m.get(i) - map.get(i), 2);
        }
        return sum/map.size();
    }
    private static double MSE_0_R(double b0, double b1, Map<Integer, Double> m, int r){
        
        return 2*(b0 + b1*m.get(r) - map.get(r));
    }

    public static void main(String[] args){
        init();
        int option = Integer.valueOf(args[0]) / 100;
        if (option == 1){
            for(int i = 1855; i <= 2016; i++){
                System.out.println(i + " " + map.get(i));
            } 
        }
        if (option == 2){
            int n = map.size();
            int total = 0;
            for (int i = 1855; i <= 2016; i++){
                total += map.get(i);
            }
            double y = (double) total/n;
            double temp = 0;
            for (int i = 1855; i <= 2016; i++){
                temp += Math.pow(map.get(i) - y, 2);
            }
            double sd = Math.sqrt(temp/(n-1));
            System.out.println(n + "\n" + String.format("%.2f",y) + "\n" + String.format("%.2f",sd));
        }
        if (option == 3){
            double b0 = Double.valueOf(args[1]);
            double b1 = Double.valueOf(args[2]);
            double sum = 0.0;
            for (int i = 1855; i <= 2016; i++){
                sum += Math.pow(b0 + b1*i - map.get(i), 2);
            }
            System.out.println(String.format("%.2f",sum/map.size()));
        }
        if (option == 4){
            double b0 = Double.valueOf(args[1]);
            double b1 = Double.valueOf(args[2]);
            double sum0 = 0.0;
            for (int i = 1855; i <= 2016; i++){
                sum0 += b0 + b1*i - map.get(i);
            }
            double sum1 = 0.0;
            for (int i = 1855; i <= 2016; i++){
                sum1 += (b0 + b1*i - map.get(i))*i;
            }
            System.out.println(String.format("%.2f",2*sum0/map.size()));
            System.out.println(String.format("%.2f",2*sum1/map.size()));
        }
        if (option == 5){
            double n = Double.valueOf(args[1]);
            int T = Integer.valueOf(args[2]);
            double b0 = 0.0;
            double b1 = 0.0;
            double last_b0 = 0.0;
            double last_b1 = 0.0;
            double mse;
            for (int in = 1; in <= T;in++){
                b0 = last_b0 - n*MSE_0(last_b0, last_b1);
                b1 = last_b1 - n*MSE_1(last_b0, last_b1);
                mse = MSE(b0,b1);
                System.out.println(in + " " + 
                        String.format("%.2f",b0) + " "+ 
                        String.format("%.2f",b1) + " "+ 
                        String.format("%.2f", mse));
                last_b0 = b0;
                last_b1 = b1;
            }
        }
        if (option == 6 || option == 7){
            double total = 0.0;
            double x = 0.0;
            for (int i = 1855; i <= 2016; i++){
                total += map.get(i);
                x += i;
            }
            x = x/map.size();
            double y = total/map.size();
            double temp1 = 0.0;
            double temp2 = 0.0;
            for (int i = 1855; i <= 2016; i++){
                temp1 += (i - x)*(map.get(i) - y);
                temp2 += Math.pow((i - x), 2);
            } 
            double b1 = temp1/temp2;
            double b0 = y - x*b1;
            if (option == 6)
                System.out.println(String.format("%.2f", b0) + " " + 
                        String.format("%.2f", b1) + " " + 
                        String.format("%.2f", MSE(b0, b1))
                        );
            if (option == 7){
                int year = Integer.valueOf(args[1]);
                System.out.println(String.format("%.2f", b0 + b1*year));
            }
        }
        if (option == 8 || option == 9) {
            double x = 0.0;
            for (int i = 1855; i <= 2016; i++){
                x += i; 
            } 
            x = x/map.size();

            double temp = 0.0;
            for (int i = 1855; i <= 2016; i++){
                temp += Math.pow((i - x), 2);
            }
            double std = Math.sqrt(temp / (map.size() - 1));

            double n = Double.valueOf(args[1]);
            int T = Integer.valueOf(args[2]);

            double b0 = 0.0;
            double b1 = 0.0;
            double last_b0 = 0.0;
            double last_b1 = 0.0;
            double mse;
            Map<Integer, Double> newMap = new HashMap<Integer, Double>();
            for (int i = 1855; i <= 2016; i++){
                double xi = (i - x)/std;

                newMap.put(i, xi);
            }
            if (option == 8){
                for (int in = 1; in <= T;in++){
                    b0 = last_b0 - n*MSE_0_N(last_b0, last_b1, newMap);
                    b1 = last_b1 - n*MSE_1_N(last_b0, last_b1, newMap);
                    mse = MSE_N(b0,b1, newMap);
                    System.out.println(in + " " + 
                            String.format("%.2f",b0) + " "+ 
                            String.format("%.2f",b1) + " "+ 
                            String.format("%.2f", mse));
                    last_b0 = b0;
                    last_b1 = b1;
                }
            }
            if (option == 9){
                for (int in = 1; in <= T;in++){
                    Random rand = new Random();
                    int r = rand.nextInt(map.size())+1855;
                    b0 = last_b0 - n*MSE_0_R(last_b0, last_b1, newMap, r);
                    b1 = last_b1 - n*MSE_1_R(last_b0, last_b1, newMap, r);
                    mse = MSE_N(b0,b1, newMap);
                    System.out.println(in + " " + 
                            String.format("%.2f",b0) + " "+ 
                            String.format("%.2f",b1) + " "+ 
                            String.format("%.2f", mse));
                    last_b0 = b0;
                    last_b1 = b1;
                }
            }

        }
    }
}
