using System;
using System.Diagnostics;
using System.Collections.Generic;

namespace Lab
{
    
    
    class Program
    {
        static void Main(string[] args)
        {
            Student s1= new Student();
            Console.WriteLine(s1.ToString());
            //KeySelector<string> keySelector = delegate (Student student)
            //{
            //    return student.GetHashCode().ToString();
            //};
            //StudentCollection<string> firstColl = new StudentCollection<string>(keySelector);
            //StudentCollection<string> secondColl = new StudentCollection<string>(keySelector);
            //firstColl.CollectionName = "First student collection";
            //secondColl.CollectionName = "Second student sollection";
            //Journal journal = new Journal();

            //firstColl.StudentChanged += journal.StudentsChanged;
            //secondColl.StudentChanged += journal.StudentsChanged;


            //Person person1 = new Person("Марк", "Поло", new DateTime(2003, 4, 12));
            //Person person2 = new Person("Павел", "Павлов", new DateTime(2004, 5, 5));
            //Student student1 = new Student(person1, Enums.Bachelor, 22);
            //Student student2 = new Student(person2, Enums.SecondEducation, 3);

            //firstColl.AddStudents(student1);
            //secondColl.AddStudents(student2);

            //student1.Group = 504;
            //student2.Group = 106;
            //student1.Education = Enums.SecondEducation;
            //student2.Education= Enums.Specialist;

            //firstColl.Remove(student1);
            //student1.Group = 400;

            //Console.WriteLine(journal);
            /////////////////////////////////////////////////////////////
            //Console.WriteLine("1----------------");
            //Person person1 = new Person("Марк", "Твен", new DateTime(2020, 4, 12));
            //Student student1 = new Student(person1, Enums.Bachelor, 22);
            //Exam[] exams1 = new Exam[] { new Exam("e", 2, new DateTime(2020, 4, 12)), new Exam("f", 4, new DateTime(2020, 7, 15)), 
            //    new Exam("d", 4, new DateTime(2020, 5, 13)), new Exam("c", 5, new DateTime(2020, 8, 16)), 
            //    new Exam("a", 5, new DateTime(2020, 6, 14)), new Exam("b", 2, new DateTime(2020, 9, 17)) };
            //student1.AddExams(exams1);

            //#region 2
            //Console.WriteLine("2----------------");


            //StudentCollection<string> studentCollection = new StudentCollection<string>(keySelector);
            //studentCollection.AddDefaults();
            //studentCollection.AddStudents(student1);
            //Console.WriteLine(studentCollection);
            //#endregion

            //#region 4
            //Console.WriteLine("4----------------");
            //int num = -1;
            //Console.Write("Число элементов коллекции: ");
            //while (!int.TryParse(Console.ReadLine(), out num) || num < 0)
            //{
            //    Console.Write("Введите положительное целое число: ");
            //}

            //GenerateElement<Person, Student> stud = delegate (int j)
            //{
            //    Person key = new Person($"Mark{j}", $"Twen{j}", new DateTime(2000 + j % 30, 1 + j % 12, 1 + j % 30));
            //    Student value = new Student(key, Enums.Bachelor, j*5);
            //    return new KeyValuePair<Person, Student>(key, value);
            //};

            //#endregion
        }
    }
}
