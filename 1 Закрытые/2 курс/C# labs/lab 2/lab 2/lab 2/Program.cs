using System;
using System.Diagnostics;

namespace lab_2
{
    class Program
    {
        static void Main(string[] args)
        {
            //1
            Person person1 = new Person("Mark", "Twen", new DateTime(2020, 4, 12));
            Person person2 = new Person("Mark", "Twen", new DateTime(2020, 4, 12));  

            Console.WriteLine("Hash code equal: " + (person1.GetHashCode() == person2.GetHashCode()));
            Console.WriteLine("Links on obj equal: " + object.ReferenceEquals(person1, person2));
            //2
            Student student = new Student(person1, Education.Bachelor, 22);
            System.Collections.ArrayList exams =  new System.Collections.ArrayList { new Exam("Матан", 2, new DateTime(2020, 4, 12)), new Exam("Инглиш", 5, new DateTime(2020, 4, 14)) };
            System.Collections.ArrayList tests = new System.Collections.ArrayList { new Test("Матан", true), new Test("Физика", false) };
            student.Exams = exams;
            student.Tests = tests;
            Console.WriteLine(student);
            //3
            Console.WriteLine(student.StudName);
            //4
            Student student_copy = new Student();
            student_copy = (Student)student.DeepCopy();
            student.Name = "New Name";
            Console.WriteLine("\nИзмененный\n" + student.StudName.ToString() + student.ToString());
            Console.WriteLine("\nКопия\n" + student_copy.StudName.ToString() + student_copy.ToString());
            //5
            try
            {
                student.Group = -1;
            }
            catch (Exception e)
            {
                Console.WriteLine(e);
            }
            //6
            foreach (Object obj in student)
            {
                Console.WriteLine("\n" + obj);
            }
            //7
            Console.WriteLine("C оценкой выше з:");
            foreach (Object obj in student.PassedExams(3))
            {
                Console.WriteLine(obj);
            }
        }
    }
}
