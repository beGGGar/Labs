using System;
using System.Diagnostics;

namespace lab1
{
    class Program
    {
        static void Main(string[] args)
        {
            Student student = new Student();
            Console.WriteLine(student.ToShortString());
            student.StudName.Name = "Вовчик";
            student.StudName.Fname = "Синичкин";
            student.Education = Education.SecondEducation;
            student.Group = 15;
            student.AddExams(new Exam("Math", 8, DateTime.Today));
            
            Console.WriteLine(student.ToString());
            student.AddExams(new Exam("Chemistry", 10, new DateTime(2000, 12, 3)));
            Console.WriteLine(student.ToString());
            //Console.WriteLine(student.Exams);


            Stopwatch sw = new Stopwatch();
            
            
            Exam[] ex1 = new Exam[12000000];
            for(int i = 0; i<12; i++)
            {
                ex1[i] = new Exam("Exam Name", 999, DateTime.Today);
            }
            sw.Start();
            for (int i = 0; i < 12; i++)
            {
                ex1[i].Name = "New name for exam";
            }
            sw.Stop();
            Console.WriteLine("odnomerniy: " + sw.ElapsedMilliseconds);

            Exam[,] ex2 = new Exam[3000, 4000];
            for (int i = 0; i < 3; i++)
            {
                for (int j = 0; j < 40; j++)
                {
                    ex2[i, j] = new Exam("Exam Name", 999, DateTime.Today);
                }
            }
            sw.Start();
            for (int i = 0; i < 3; i++)
            {
                for (int j = 0; j < 40; j++)
                {
                    ex2[i, j].Name = "New name for exam";
                }
            }
            sw.Stop();
            Console.WriteLine("dvumerniy: " + sw.ElapsedMilliseconds);

            Exam[][] ex3 = new Exam[3][];
            ex3[0] = new Exam[4000000];
            ex3[1] = new Exam[3000000];
            ex3[2] = new Exam[5000000];


            for (int j = 0; j < 4000000; j++)
            {
                ex3[0][j] = new Exam("Exam Name", 999, DateTime.Today);
            }
            for (int j = 0; j < 3000000; j++)
            {
                ex3[1][j] = new Exam("Exam Name", 999, DateTime.Today);
            }
            for (int j = 0; j < 5000000; j++)
            {
                ex3[2][j] = new Exam("Exam Name", 999, DateTime.Today);
            }

            sw.Start();
            for (int j = 0; j < 4000000; j++)
            {
                ex3[0][j].Name = "New name for exam";
            }
            for (int j = 0; j < 3000000; j++)
            {
                ex3[1][j].Name = "New name for exam";
            }
            for (int j = 0; j < 5000000; j++)
            {
                ex3[2][j].Name = "New name for exam";
            }
            sw.Stop();
            Console.WriteLine("Ctupenchatiy: " + sw.ElapsedMilliseconds);
        }
    }
}
