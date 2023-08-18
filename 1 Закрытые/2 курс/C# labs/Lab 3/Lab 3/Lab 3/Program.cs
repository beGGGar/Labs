using System;
using System.Diagnostics;
using System.Collections.Generic;

namespace Lab
{
    delegate KeyValuePair<TKey, TValue> GenerateElement<TKey, TValue>(int i);
    delegate TKey KeySelector<TKey>(Student st);
    class Program
    {
        static void Main(string[] args)
        {
            #region 1
            Console.WriteLine("1----------------");
            Person person1 = new Person("Марк", "Твен", new DateTime(2020, 4, 12));
            Student student1 = new Student(person1, Education.Bachelor, 22);
            Exam[] exams1 = new Exam[] { new Exam("e", 2, new DateTime(2020, 4, 12)), new Exam("f", 4, new DateTime(2020, 7, 15)), 
                new Exam("d", 4, new DateTime(2020, 5, 13)), new Exam("c", 5, new DateTime(2020, 8, 16)), 
                new Exam("a", 5, new DateTime(2020, 6, 14)), new Exam("b", 2, new DateTime(2020, 9, 17)) };
            student1.AddExams(exams1);


            Console.WriteLine("Без сортировки\n" + student1.ToString());
            student1.SortExamToName();
            Console.WriteLine("сортировка по названию экзамена \n" + student1.ToString());
            student1.SortExamToMark();
            Console.WriteLine("сортировка по оценке \n" + student1.ToString());
            student1.SortExamToDate();
            Console.WriteLine("сортировка по дате экзамена \n" + student1.ToString());
            #endregion

            #region 2
            Console.WriteLine("2----------------");
            KeySelector<string> keySelector = delegate (Student student)
            {
                return student.GetHashCode().ToString();
            };

            StudentCollection<string> studentCollection = new StudentCollection<string>(keySelector);
            studentCollection.AddDefaults();
            studentCollection.AddStudents(student1);
            Console.WriteLine(studentCollection);
            #endregion

            #region 3
            Console.WriteLine("3----------------");
            Console.WriteLine("Максимальный средний балл: " + studentCollection.MaxMidleMark + "\n");
            Console.WriteLine("Бакалавры\n");
            var bachelors = studentCollection.EducationForm(Education.Bachelor);
            foreach (var st in bachelors)   
            {
                Console.WriteLine(st.Value + "\n");
            }

            foreach (var item in studentCollection.groupStudentsByEducation)
            {
                Console.WriteLine(item.Key);
                Console.WriteLine();
                foreach (var name in item)
                {
                    Console.WriteLine(name);
                }
            }
            #endregion

            #region 4
            Console.WriteLine("4----------------");
            int num = -1;
            Console.Write("Число элементов коллекции: ");
            while (!int.TryParse(Console.ReadLine(), out num) || num < 0)
            {
                Console.Write("Введите положительное целое число: ");
            }

            GenerateElement<Person, Student> stud = delegate (int j)
            {
                Person key = new Person($"Mark{j}", $"Twen{j}", new DateTime(2000 + j % 30, 1 + j % 12, 1 + j % 30));
                Student value = new Student(key, Education.Bachelor, j*5);
                return new KeyValuePair<Person, Student>(key, value);
            };

            var searchTest = new TestCollections<Person, Student>(num, stud);
            searchTest.searchKeyList();
            searchTest.searchStringList();
            searchTest.searchDictionaryTKeyKey();
            searchTest.searchDictionaryStringKey();
            searchTest.searchDictionaryTKeyValue();
            #endregion
        }
    }
}
