package com.endava.day1;

public class BasicCalculator {

    public int add(Integer...numbers)
    {
        int s=0;
        for(Integer i: numbers)  s += i;
        return s;
    }

    public int multiply(Integer...numbers)
    {
        int p=1;
        for(Integer i: numbers)  p *= i;
        return p;
    }

    public int subtract(Integer...numbers)
    {
        int diff=numbers[0];
        for(int i=1;i<numbers.length;i++)  diff-=numbers[i];
        return diff;
    }

    public int divide(Integer...numbers)
    {
        int result=numbers[0];
        for(int i=1;i<numbers.length;i++)  result/=numbers[i];
        return result;
    }

    public int pow(int a, int b)
    {
        if(a==0) return 0;
        else if (b==0) return 1;
        else if (b<0) throw new IllegalArgumentException("Argumentul trebuie sa fie pozitiv ! ");
        else{
            int result =1;
            for(int i=1;i<=b;i++) result*=a;
            return result;
        }
    }
}
