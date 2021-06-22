package leetcode.Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class choices{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.valueOf(s[0]);
        if(N<3){System.out.println();return;}
        int D = Integer.valueOf(s[1]);
        String []buidings = br.readLine().split(" ");
        int arr[] = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = Integer.valueOf(buidings[i]);
        }//for
        long result = 0;
        int j=0;
        for(int i=2;i<N;i++){
            while(arr[i]-arr[j]>D){
                j++;
            }
            result+=(long)(i-j)*(long)(i-j-1)/2%99997867;
        }//
        System.out.println(result%99997867);
    }//main
}