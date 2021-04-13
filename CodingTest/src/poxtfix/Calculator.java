package poxtfix;

import java.util.*;
/*
 *    ���������ڷ� ��ȯ�� ��� �ϱ�
 *    ��ȣ�� ���� ���� ���� ����
 *    num ������ �������� ���� 
 * 
 *    �ð����� �߰����� * () ���� / ������� ���̵� �����ϰ�
 * 
 * */

public class Calculator {
   public static void main(String[] args)
   {
      String num = new String("10 * 5 + 5 * 2 / 2");
      
      ArrayList<String> list = new ArrayList(postfix(num)); // ���� �����ڷ� ��ȯ������
      
      System.out.println("������ :"+num);
      while(list.size() != 1) {
         for(int i = 0 ;i< list.size(); i++)
         {
            String s = list.get(i);
            if(s.equals("*") || s.equals("/") || s.equals("+") || s.equals("-")) {  // ���࿡ ������ ��� ������
               System.out.println(list);
               int a = Integer.parseInt(list.get(i-2));       //�����ں��� 2ĭ��
               int b = Integer.parseInt(list.get(i-1));      //�����ں��� 1ĭ��
               int sum = calc(a,b,s);  // a "s����" b ����� ��ȯ
               
               for(int j  = 0 ; j < 3; j++)    list.remove(i-2); // 3�� ����     // 1 3* 5 4 + -> 3 * 5 4 -> * 5 4 -> 5 4
               list.add(i-2,Integer.toString(sum));
               break;
            }
         }
      }
      
      System.out.println("��� ����� :" + list );
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
         if(val.equals("*") || val.equals("/")) // */ �ϰ�� �տ� �ڿ��ִ� ���ڸ� list�� �ְ� �ڵ��� list �Է�
         {
            String tmp = val;
            String cnt = st.nextToken();
            list.add(cnt);
            list.add(tmp);
         }
         else if(val.equals("+") ||val.equals("-"))
         {
            stack.add(val); // +-�ϰ�� ���ÿ� �߰�
         }
         else
         {
            list.add(val);  // ���� �ϰ�� list�� �ٷ� �߰�
         }
      }   
      while(!stack.isEmpty()) {
         String cnt2 = stack.pop();  // ������ +- �����ڵ� list�� �߰� 
         list.add(cnt2);  //
      }
      return list;
   }
}