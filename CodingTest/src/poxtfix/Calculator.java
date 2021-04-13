package poxtfix;

import java.util.*;
/*
 *    후위연산자로 변환후 계산 하기
 *    괄호는 현재 구현 하지 않음
 *    num 값에는 띄워쓰기로 구분 
 * 
 *    시간나면 추가예정 * () 구분 / 띄워쓰기 없이도 가능하게
 * 
 * */

public class Calculator {
   public static void main(String[] args)
   {
      String num = new String("10 * 5 + 5 * 2 / 2");
      
      ArrayList<String> list = new ArrayList(postfix(num)); // 후위 연산자로 변환시켜줌
      
      System.out.println("원본값 :"+num);
      while(list.size() != 1) {
         for(int i = 0 ;i< list.size(); i++)
         {
            String s = list.get(i);
            if(s.equals("*") || s.equals("/") || s.equals("+") || s.equals("-")) {  // 만약에 연산자 라면 계산시작
               System.out.println(list);
               int a = Integer.parseInt(list.get(i-2));       //연산자보다 2칸뒤
               int b = Integer.parseInt(list.get(i-1));      //연산자보다 1칸뒤
               int sum = calc(a,b,s);  // a "s연산" b 결과값 반환
               
               for(int j  = 0 ; j < 3; j++)    list.remove(i-2); // 3번 삭제     // 1 3* 5 4 + -> 3 * 5 4 -> * 5 4 -> 5 4
               list.add(i-2,Integer.toString(sum));
               break;
            }
         }
      }
      
      System.out.println("계산 결과값 :" + list );
   }
   
   public static int calc(int a , int b,String s)
   {
      int sum = 0;
      if(s.equals("*")) sum = a * b;
      else if(s.equals("/")) sum = a / b;
      else if(s.equals("+")) sum = a + b;
      else if(s.equals("-")) sum = a - b; 
      
      return sum;
   }
   
   public static ArrayList<String> postfix(String num) {
      ArrayList<String> list = new ArrayList<>();
      StringTokenizer st = new StringTokenizer(num);
      Stack<String> stack = new Stack<>();
      
      while(st.hasMoreTokens()) {
         String val = st.nextToken();
         if(val.equals("*") || val.equals("/")) // */ 일경우 앞에 뒤에있는 숫자를 list에 넣고 뒤따라 list 입력
         {
            String tmp = val;
            String cnt = st.nextToken();
            list.add(cnt);
            list.add(tmp);
         }
         else if(val.equals("+") ||val.equals("-"))
         {
            stack.add(val); // +-일경우 스택에 추가
         }
         else
         {
            list.add(val);  // 숫자 일경우 list에 바로 추가
         }
      }   
      while(!stack.isEmpty()) {
         String cnt2 = stack.pop();  // 마지막 +- 연산자들 list에 추가 
         list.add(cnt2);  //
      }
      return list;
   }
}