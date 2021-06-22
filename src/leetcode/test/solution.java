package leetcode.test;

import java.util.*;

public class solution {
    public static void main(String[] args) {
        Student student1 = new Student("myself", 45);
        Student student2 = new Student("xx1",30);
        Student student3 = new Student("xx2",40);
        Student student4 = new Student("myself",50);
        Student student5 = new Student("xx4",60);
        PriorityQueue<Student> pq = new PriorityQueue<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if(o1.getName().equals(o2.getName()))
                    return o2.getScore()-o1.getScore();
                else if(o1.getName() == "myself")
                    return  1;
                else if(o2.getName() == "myself")
                    return 1;

                return o2.getScore()-o1.getScore();
            }
        });
        pq.add(student1);
        pq.add(student2);
        pq.add(student3);
        pq.add(student4);
        pq.add(student5);
        while(!pq.isEmpty())
        {
            System.out.println(pq.poll());
        }
    }
}
