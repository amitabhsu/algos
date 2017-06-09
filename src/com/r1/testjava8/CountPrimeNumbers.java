package com.r1.testjava8;

public class CountPrimeNumbers {
    public int countPrimes(int n) {
        boolean [] primes = new boolean[n+1];
        for(int j=0;j<=n;j++)
            primes[j]=true;
        for(int p=2;p<=n*n;p++)
        {
            if(primes[p])
            {
                for(int i=2*p;i<=n;i=i+p)
                {
                    primes[i]=false;
                }
            }
        }
        int sum=0;
        for(int j=0;j<=n;j++)
        {
            if(primes[j])
            {
                sum++;
            }
        }
        return sum;
    }
}