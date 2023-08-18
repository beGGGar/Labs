using System;
using System.Diagnostics;
using System.Collections.Generic;
using System.IO;

namespace Lab
{
    
    
    class Program
    {
        static void Main(string[] args)
        {
            #region 1
            Console.WriteLine("///1///\n");
            Person person = new Person("Ivan", "Urgant", new DateTime());
            Student s1 = new Student(person, Enums.Specialist, 115);

            Exam[] exams1 = new Exam[] { new Exam("e", 2, new DateTime(2020, 4, 12)), new Exam("f", 4, new DateTime(2020, 7, 15))};
            s1.AddExams(exams1);

            
            Student s2 = s1.DeepCopy();
            Console.WriteLine(s1);
            Console.WriteLine(s2);
            #endregion
            Student s3 = new Student();

            #region 2, 3e
            Console.WriteLine("///2///\n");
            Console.WriteLine("Введите желаемое имя файла сохранения:");
            string filename;
            filename = Console.ReadLine();
            if (File.Exists(filename))
            {
                s3.Load(filename);
            }
            else
            {
                Console.WriteLine("Файла с таким именем нет! (но не теперь:3)");
                File.Create(filename);
            }
            Console.WriteLine("///3///\n");
            Console.WriteLine(s3);
            #endregion

            #region 4
            Console.WriteLine("///4///\n");
            Console.WriteLine("Добавьте экзаменов");
            s1.AddFromConsole();
            s1.Save(filename);
            Console.WriteLine(s1);
            #endregion

            #region 5
            Console.WriteLine("///5///\n");
            Student.Load(filename, s1);
            s1.AddFromConsole();
            Student.Save(filename, s1);
            #endregion 
            Console.Read();
            Console.WriteLine(s1);
        }
    }
}
