package proGrammers_KaKao_1;

import java.util.*;
import java.util.stream.*;

/*      프로그래머스 link : https://programmers.co.kr/learn/courses/30/lessons/67256
 * 		-이클립스 버젼-
 * 
 * */

public class Kakao {

   static int[][] phone = {{1,2,3},{4,5,6},{7,8,9},{-1,0,-1}};   
   static int[] righthand = {3,2};
   static int[] lefthand = {3,0};
   public static void main(String[] args) {
         Scanner input =new Scanner(System.in);
         int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
         String hand ="right";
         for(int i=0;i<numbers.length;i++)
         {   
            if(numbers[i]==1||numbers[i]==4||numbers[i]==7)
            {
               lefthand[1]=0; //옆
               lefthand[0]=numbers[i]/3; //밑
               System.out.print("L");
               continue;
            }
            else if(numbers[i]==3||numbers[i]==6||numbers[i]==9)
            {
               righthand[1]=2;
               righthand[0]=numbers[i]/3-1;
               System.out.print("R");   
               continue;
            }
            
            int tag = find(numbers[i]);
            
            int right = width(lefthand,tag);
            int left =width(righthand,tag);
            
            if(right == left) {
               if(hand =="right") {

                  righthand[1]=1;
                  righthand[0]=tag;
                  System.out.print("R");
                  continue;
               }
               else {
                  lefthand[1]=1;
                  lefthand[0]=tag;
                  System.out.print("L");
                  continue;
               }
            }
            else
            {
               if(right>left) {
                  righthand[1]=1;
                  righthand[0]=tag;
                  System.out.print("R");
               }
               else{
                  lefthand[1]=1;
                  lefthand[0]=tag;
                  System.out.print("L");
               }
            }
         }
         
   
   }
   public static int find(int key)
   {
      for(int i=0;i<4;i++)
         if(phone[i][1]==key)   
            return i;
      return 0;
   }
   
   public static int width(int[] hand,int tag)
   {
      int cnt=hand[0]-tag;
      if(cnt<0) cnt*=-1;
      if(hand[1]!=1) cnt += 1;
      
      return cnt;
   }

}


/*
 * 		프로그래머스 버젼
 * 		100/100
 * 
 * 
 * */


class Solution {
	static int[][] phone = {{1,2,3},{4,5,6},{7,8,9},{-1,0,-1}};   

	public String solution(int[] numbers, String hand) {

		String answer = "";

		 int[] righthand = {3,2};
		 int[] lefthand = {3,0};
		 
	for(int i=0;i<numbers.length;i++)
	{   
		if(numbers[i]==1||numbers[i]==4||numbers[i]==7)
		{
			lefthand[1]=0; //옆
			lefthand[0]=numbers[i]/3; //밑
		    answer += "L";
		    continue;
		}
	    else if(numbers[i]==3||numbers[i]==6||numbers[i]==9)
	    {
	    	righthand[1]=2;
	    	righthand[0]=numbers[i]/3-1;
	    	answer += "R";  
	    	continue;
	    }
		    
		int tag = find(numbers[i]);
	    int right = width(lefthand,tag);
	    int left =width(righthand,tag);

	    if(right == left) { 
	    	if(hand.equals("right")) {
	    		righthand[1]=1;
	    		righthand[0]=tag;
	    		answer += "R";
	    		continue;
		       }
			  else {
				  lefthand[1]=1;
				  lefthand[0]=tag;
				  answer += "L";
		          continue;
			  }         
		  }
		  else {
			  if(right>left) {
				  righthand[1]=1;
				  righthand[0]=tag;
	              answer += "R";
	              continue;
			  }
			  else{
				  lefthand[1]=1;
				  lefthand[0]=tag;
				  answer += "L";
		          continue;
			 }
		 }
	}
 
	return answer;

}

	public static int width(int[] hand,int tag){
		int cnt=hand[0]-tag;
		if(cnt<0) cnt*=-1;
		if(hand[1]!=1) cnt += 1;
	
		return cnt;
	}
	
	public static int find(int key)
	{
		for(int i=0;i<4;i++)
			if(phone[i][1]==key)   
				return i;
		
		return 0;
	}

}




