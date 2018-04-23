import java.util.*;
public class Ice{
    private static Map<Integer, Integer> map;
    private static void init(){
        map = new HashMap<Integer,Integer>(){{
            put(1855, 11);put(1856, 15);put(1857, 12);put(1858, 96);put(1859, 11);put(1860, 11);put(1861, 13);put(1862, 10);put(1863, 12);put(1864, 11);put(1865, 12);put(1866, 12);put(1867, 11);put(1868, 12);put(1869, 13);put(1870, 99);put(1871, 12);put(1872, 14);put(1873, 13);put(1874, 12);put(1875, 91);put(1876, 13);put(1877, 62);put(1878, 11);put(1879, 99);put(1880, 16);put(1881, 78);put(1882, 12);put(1883, 11);put(1884, 12);put(1885, 12);put(1886, 13);put(1887, 11);put(1888, 88);put(1889, 75);put(1890, 11);put(1891, 97);put(1892, 11);put(1893, 10);put(1894, 10);put(1895, 91);put(1896, 11);put(1897, 10);put(1898, 13);put(1899, 11);put(1900, 10);put(1901, 10);put(1902, 89);put(1903, 12);put(1904, 10);put(1905, 97);put(1906, 94);put(1907, 83);put(1908, 10);put(1909, 98);put(1910, 10);put(1911, 10);put(1912, 99);put(1913, 88);put(1914, 11);put(1915, 10);put(1916, 11);put(1917, 11);put(1918, 82);put(1919, 11);put(1920, 81);put(1921, 96);put(1922, 12);put(1923, 10);put(1924, 10);put(1925, 12);put(1926, 10);put(1927, 10);put(1928, 96);put(1929, 10);put(1930, 98);put(1931, 65);put(1932, 11);put(1933, 91);put(1934, 94);put(1935, 10);put(1936, 12);put(1937, 10);put(1938, 97);put(1939, 10);put(1940, 96);put(1941, 82);put(1942, 11);put(1943, 11);put(1944, 92);put(1945, 98);put(1946, 10);put(1947, 10);put(1948, 96);put(1949, 10);put(1950, 12);put(1951, 11);put(1952, 81);put(1953, 85);put(1954, 92);put(1955, 11);put(1956, 11);put(1957, 95);put(1958, 12);put(1959, 10);put(1960, 10);put(1961, 11);put(1962, 11);put(1963, 11);put(1964, 12);put(1965, 65);put(1966, 98);put(1967, 91);put(1968, 10);put(1969, 11);put(1970, 11);put(1971, 10);put(1972, 97);put(1973, 10);put(1974, 10);put(1975, 88);put(1976, 11);put(1977, 12);put(1978, 11);put(1979, 99);put(1980, 93);put(1981, 96);put(1982, 54);put(1983, 11);put(1984, 85);put(1985, 10);put(1986, 89);put(1987, 87);put(1988, 97);put(1989, 93);put(1990, 88);put(1991, 99);put(1992, 10);put(1993, 94);put(1994, 74);put(1995, 11);put(1996, 10);put(1997, 47);put(1998, 82);put(1999, 53);put(2000, 11);put(2001, 21);put(2002, 89);put(2003, 80);put(2004, 10);put(2005, 95);put(2006, 66);put(2007, 10);put(2008, 97);put(2009, 87);put(2010, 10);put(2011, 57);put(2012, 87);put(2013, 11);put(2014, 91);put(2015, 62);put(2016, 65);}};
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
            double y = total/n;
            int temp = 0;
            for (int i = 1855; i <= 2016; i++){
                temp += Math.pow(map.get(i) - y, 2);
            }
            double sd = Math.sqrt(temp/(n-1));
            System.out.println(n + "\n" + y + "\n" + sd+total);
        }
    }

}
